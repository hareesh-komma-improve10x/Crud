package com.improve10x.crud.quotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.improve10x.crud.R;
import com.improve10x.crud.api.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddQuoteActivity extends BaseAddEditQuoteActivity{

    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViews();
        getSupportActionBar().setTitle("Add Quote");
        showAddBtn();
        handleAdd();
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

    private void showAddBtn() {
        addBtn.setVisibility(View.VISIBLE);
    }

    private void setupViews() {
        addBtn = findViewById(R.id.add_btn);
    }



}
