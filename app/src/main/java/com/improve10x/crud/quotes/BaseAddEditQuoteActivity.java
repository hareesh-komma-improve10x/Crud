package com.improve10x.crud.quotes;

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

public class BaseAddEditQuoteActivity extends BaseActivity {

    protected CrudService crudService;
    protected EditText quoteTxt;
    protected EditText authorNameTxt;
    protected EditText categoryTxt;
    protected EditText imageUrlTxt;
    protected Quote quote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_quote);
        setupViews();
        setupApiService();
    }

    private void setupViews() {
        quoteTxt = findViewById(R.id.quote_txt);
        authorNameTxt = findViewById(R.id.author_name_txt);
        categoryTxt = findViewById(R.id.category_txt);
        imageUrlTxt = findViewById(R.id.image_url_txt);
    }

    private void setupApiService() {
        CrudApi crudApi = new CrudApi();
        crudService = crudApi.createCrudService();
    }
}