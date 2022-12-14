package com.improve10x.crud.quotes;

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

public class AddEditQuoteActivity extends BaseActivity {

    private CrudService crudService;
    private Button addBtn;
    private EditText quoteTxt;
    private EditText authorNameTxt;
    private EditText categoryTxt;
    private EditText imageUrlTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_quote);
        getSupportActionBar().setTitle("Edit Quote");
        setupViews();
        setupApiService();
        handleAdd();
    }

    private void setupViews() {
        addBtn = findViewById(R.id.add_btn);
        quoteTxt = findViewById(R.id.quote_txt);
        authorNameTxt = findViewById(R.id.author_name_txt);
        categoryTxt = findViewById(R.id.category_txt);
        imageUrlTxt = findViewById(R.id.image_url_txt);
    }

    private void setupApiService() {
        CrudApi crudApi = new CrudApi();
        crudService = crudApi.createCrudService();
    }

    private void handleAdd() {
        addBtn.setOnClickListener(view -> {
            String quotes = quoteTxt.getText().toString();
            String author = authorNameTxt.getText().toString();
            String category = categoryTxt.getText().toString();
            String imageUrl = imageUrlTxt.getText().toString();
            Quote quote = createQuote(quotes, author, category, imageUrl);
            saveQuote(quote);
        });
    }

    private void saveQuote(Quote quote) {
        Call<Quote> call = crudService.createQuote(quote);
        call.enqueue(new Callback<Quote>() {
            @Override
            public void onResponse(Call<Quote> call, Response<Quote> response) {
                showToast("Successfully");
                finish();
            }

            @Override
            public void onFailure(Call<Quote> call, Throwable t) {
                showToast("Please Try Again");
            }
        });
    }

    private Quote createQuote(String quote, String authorName, String category, String imageUrl) {
        Quote quoteTxt = new Quote();
        quoteTxt.quoteText = quote;
        quoteTxt.authorName = authorName;
        quoteTxt.category = category;
        quoteTxt.imageUrl = imageUrl;
        return quoteTxt;
    }
}