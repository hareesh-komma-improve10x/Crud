package com.improve10x.crud.series;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.improve10x.crud.R;
import com.improve10x.crud.api.Constants;
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
    private SeriesItem seriesItem;
    private Button editBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_series_item);
        setupViews();
        setupApiService();
        Intent intent = getIntent();
        if (intent.hasExtra(Constants.KEY_SERIES)) {
            getSupportActionBar().setTitle("Edit Series");
            seriesItem = (SeriesItem) intent.getSerializableExtra(Constants.KEY_SERIES);
            showData();
            showEditBtn();
            handleEdit();
        } else {
            getSupportActionBar().setTitle("Add Series");
            showAddBtn();
            handleAdd();
        }
    }

    private void showAddBtn() {
        addBtn.setVisibility(View.VISIBLE);
        editBtn.setVisibility(View.GONE);
    }

    private void showEditBtn() {
        addBtn.setVisibility(View.GONE);
        editBtn.setVisibility(View.VISIBLE);
    }

    private void handleEdit() {
        editBtn.setOnClickListener(view -> {
            String seriesItemsId = seriesItemsIdTxt.getText().toString();
            String seriesItemsName = seriesItemsNameTxt.getText().toString();
            String seriesItemsImage = seriesItemsImageUrlTxt.getText().toString();
            SeriesItem updatedSeries = createSeriesItem(seriesItemsId, seriesItemsName, seriesItemsImage);
            updateSeries(seriesItem.Id, updatedSeries);
        });
    }

    private void updateSeries(String id, SeriesItem updatedSeries) {
        Call<Void> call = crudService.updatedSeriesItem(id, updatedSeries);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                showToast("Successfully");
                finish();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                showToast("Failed to Loaded");
            }
        });
    }

    private void showData() {
        seriesItemsIdTxt.setText(seriesItem.Id);
        seriesItemsNameTxt.setText(seriesItem.title);
        seriesItemsImageUrlTxt.setText(seriesItem.imageUrl);
    }

    private void setupViews() {
        addBtn = findViewById(R.id.add_btn);
        seriesItemsIdTxt = findViewById(R.id.seriesitems_id_txt);
        seriesItemsNameTxt = findViewById(R.id.seriesitems_name_txt);
        seriesItemsImageUrlTxt = findViewById(R.id.seriesitems_imageurl_txt);
        editBtn = findViewById(R.id.edit_btn);
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