package com.improve10x.crud.series;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.improve10x.crud.R;
import com.improve10x.crud.api.CrudApi;
import com.improve10x.crud.api.CrudService;
import com.improve10x.crud.base.BaseActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddSeriesItemActivity extends BaseActivity {

    private CrudService crudService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_series_item);
        getSupportActionBar().setTitle("Add Series");
        setupApiService();
        handleAdd();
    }

    private void setupApiService() {
        CrudApi crudApi = new CrudApi();
        crudService = crudApi.createCrudService();
    }

    private void handleAdd() {
        Button addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(view -> {
            EditText seriesItemsIdTxt = findViewById(R.id.seriesitems_id_txt);
            String seriesItemsId = seriesItemsIdTxt.getText().toString();
            EditText seriesItemsNameTxt = findViewById(R.id.seriesitems_name_txt);
            String seriesItemsName = seriesItemsNameTxt.getText().toString();
            EditText seriesItemsImageUrlTxt = findViewById(R.id.seriesitems_imageurl_txt);
            String seriesItemsImageUrl = seriesItemsImageUrlTxt.getText().toString();
            createSeriesItem(seriesItemsId, seriesItemsName, seriesItemsImageUrl);
        });
    }

    private void createSeriesItem(String seriesItemsId, String seriesItemsName, String seriesItemsImageUrl) {
        SeriesItem seriesItem = new SeriesItem();
        seriesItem.seriesId = seriesItemsId;
        seriesItem.title = seriesItemsName;
        seriesItem.imageUrl = seriesItemsImageUrl;

        CrudApi crudApi = new CrudApi();
        CrudService crudService = crudApi.createCrudService();
        Call<SeriesItem> call = crudService.createSeriesItem(seriesItem);
        call.enqueue(new Callback<SeriesItem>() {
            @Override
            public void onResponse(Call<SeriesItem> call, Response<SeriesItem> response) {
                showToast("Successfully Completed");
                finish();

            }

            @Override
            public void onFailure(Call<SeriesItem> call, Throwable t) {
                showToast("Something Went Wrong");

            }
        });
    }
}