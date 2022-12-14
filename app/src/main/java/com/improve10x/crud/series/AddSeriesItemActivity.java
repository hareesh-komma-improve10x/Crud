package com.improve10x.crud.series;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.improve10x.crud.R;
import com.improve10x.crud.api.CrudApi;
import com.improve10x.crud.api.CrudService;
import com.improve10x.crud.base.BaseActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddSeriesItemActivity extends BaseActivity {

    private CrudService crudService;
    private Button addBtn;
    private EditText seriesItemsIdTxt;
    private EditText seriesItemsNameTxt;
    private EditText seriesItemsImageUrlTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_series_item);
        getSupportActionBar().setTitle("Add Series");
        setupViews();
        setupApiService();
        handleAdd();
    }

    private void setupViews() {
        addBtn = findViewById(R.id.add_btn);
        seriesItemsIdTxt = findViewById(R.id.seriesitems_id_txt);
        seriesItemsNameTxt = findViewById(R.id.seriesitems_name_txt);
        seriesItemsImageUrlTxt = findViewById(R.id.seriesitems_imageurl_txt);
    }

    private void setupApiService() {
        CrudApi crudApi = new CrudApi();
        crudService = crudApi.createCrudService();
    }

    private void handleAdd() {
        addBtn.setOnClickListener(view -> {
            String seriesItemsId = seriesItemsIdTxt.getText().toString();
            String seriesItemsName = seriesItemsNameTxt.getText().toString();
            String seriesItemsImageUrl = seriesItemsImageUrlTxt.getText().toString();
            SeriesItem seriesItem = createSeriesItem(seriesItemsId, seriesItemsName, seriesItemsImageUrl);
            saveSeriesItems(seriesItem);
        });
    }

    private SeriesItem createSeriesItem(String seriesItemsId, String seriesItemsName, String seriesItemsImageUrl) {
        SeriesItem seriesItem = new SeriesItem();
        seriesItem.seriesId = seriesItemsId;
        seriesItem.title = seriesItemsName;
        seriesItem.imageUrl = seriesItemsImageUrl;
        return seriesItem;
    }

    private void saveSeriesItems(SeriesItem seriesItem) {
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