package com.improve10x.crud.series;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.improve10x.crud.R;
import com.improve10x.crud.api.Constants;
import com.improve10x.crud.api.CrudApi;
import com.improve10x.crud.api.CrudService;
import com.improve10x.crud.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeriesItemsActivity extends BaseActivity {

    private CrudService crudService;
    private ArrayList<SeriesItem> seriesItems;
    private RecyclerView seriesItemsRv;
    private SeriesItemsAdapter seriesItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_list);
        getSupportActionBar().setTitle("Series");
        setupApiService();
        log("onCreate");
        handleAdd();
        setupData();
        setupSeriesItemsRv();
    }

    private void setupApiService() {
        CrudApi crudApi = new CrudApi();
        crudService = crudApi.createCrudService();
    }

    private void deleteSeriesItem(SeriesItem seriesItem) {
        CrudApi crudApi = new CrudApi();
        CrudService crudService = crudApi.createCrudService();
        Call<Void> call = crudService.deleteSeriesItem(seriesItem.Id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                showToast("Successfully Deleted");
                fetchSeriesItems();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                showToast("Failed to Deleted");

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        log("onResume");
        fetchSeriesItems();
    }

    private void handleAdd() {
        Button addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddSeriesItemActivity.class);
            startActivity(intent);
        });
    }

    private void fetchSeriesItems() {
        CrudApi crudApi = new CrudApi();
        CrudService crudService = crudApi.createCrudService();
        Call<List<SeriesItem>> call = crudService.fetchSeriesItems();
        call.enqueue(new Callback<List<SeriesItem>>() {
            @Override
            public void onResponse(Call<List<SeriesItem>> call, Response<List<SeriesItem>> response) {
                List<SeriesItem> seriesItems = response.body();
                seriesItemsAdapter.setData(seriesItems);
            }

            @Override
            public void onFailure(Call<List<SeriesItem>> call, Throwable t) {
                showToast("Failed");

            }
        });
    }

    private void setupSeriesItemsRv() {
        seriesItemsRv = findViewById(R.id.series_items_rv);
        seriesItemsRv.setLayoutManager(new LinearLayoutManager(this));
        seriesItemsAdapter = new SeriesItemsAdapter();
        seriesItemsAdapter.setData(seriesItems);
        seriesItemsAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onItemClicked(SeriesItem seriesItem) {
                Intent intent = new Intent(SeriesItemsActivity.this, AddSeriesItemActivity.class);
                intent.putExtra(Constants.KEY_SERIES, seriesItem);
                startActivity(intent);
            }

            @Override
            public void onItemDelete(SeriesItem seriesItem) {
                showToast("On Item Delete");
                deleteSeriesItem(seriesItem);

            }

            @Override
            public void onItemEdit(SeriesItem seriesItem) {
                showToast("On Item Edit");

            }
        });
        seriesItemsRv.setAdapter(seriesItemsAdapter);
    }

    private void setupData() {
        seriesItems = new ArrayList<>();
        SeriesItem seriesItem = new SeriesItem();
        seriesItem.Id = "id";
        seriesItem.title = "Horrer Movies";
        seriesItem.imageUrl = "https://wallpaperaccess.com/full/1280586.jpg";
        seriesItems.add(seriesItem);
    }
}