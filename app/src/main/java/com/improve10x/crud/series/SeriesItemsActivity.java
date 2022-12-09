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
import com.improve10x.crud.api.CrudApi;
import com.improve10x.crud.api.CrudService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeriesItemsActivity extends AppCompatActivity {
    private ArrayList<SeriesItem> seriesItems;
    private RecyclerView seriesItemsRv;
    private SeriesItemsAdapter seriesItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_list);
        Log.i("SeriesItemsActivity", "onCreate");
        getSupportActionBar().setTitle("Series");
        handleAdd();
        setupData();
        setupSeriesItemsRv();
    }

    private void deleteSeriesItem(SeriesItem seriesItem) {
        CrudApi crudApi = new CrudApi();
        CrudService crudService = crudApi.createCrudService();
        Call<Void> call = crudService.deleteSeriesItem(seriesItem.Id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(SeriesItemsActivity.this, "Successfully Deleted", Toast.LENGTH_SHORT).show();
                fetchSeriesItems();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(SeriesItemsActivity.this, "Failed to Delete", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("SeriesItemsActivity", "onResume");
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
                Toast.makeText(SeriesItemsActivity.this, "Failed", Toast.LENGTH_SHORT).show();

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
                Toast.makeText(SeriesItemsActivity.this, "On Item Clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemDelete(SeriesItem seriesItem) {
                Toast.makeText(SeriesItemsActivity.this, "On Item Delete", Toast.LENGTH_SHORT).show();
                deleteSeriesItem(seriesItem);

            }

            @Override
            public void onItemEdit(SeriesItem seriesItem) {
                Toast.makeText(SeriesItemsActivity.this, "On Item Edit", Toast.LENGTH_SHORT).show();

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