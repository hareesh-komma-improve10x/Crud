package com.improve10x.crud.quotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

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

public class QuotesActivity extends BaseActivity {

    private CrudService crudService;
    private ArrayList<Quote> quotes;
    private QuotesAdapter quotesAdapter;
    private RecyclerView quotesRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
        getSupportActionBar().setTitle("Quotes");
        setupApi();
        handleAdd();
        setupData();
        setupRv();
        setupAdapter();

    }

    private void handleAdd() {
        Button addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddEditQuoteActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchQuotes();
    }

    private void fetchQuotes() {
        Call<List<Quote>> call = crudService.fetchQuotes();
        call.enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                List<Quote> quotes = response.body();
                quotesAdapter.setData(quotes);
            }

            @Override
            public void onFailure(Call<List<Quote>> call, Throwable t) {
                showToast("Failed");

            }
        });
    }

    private void setupApi() {
        CrudApi crudApi = new CrudApi();
        crudService = crudApi.createCrudService();
    }

    private void setupAdapter() {
        quotesAdapter = new QuotesAdapter();
        quotesAdapter.setData(quotes);
        quotesAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onItemClicked(Quote quote) {
                Intent intent = new Intent(QuotesActivity.this, AddEditQuoteActivity.class);
                intent.putExtra(Constants.KEY_QUOTE, quote);
                startActivity(intent);
                //showToast("On item Clicked");
            }

            @Override
            public void onItemDeleted(Quote quote) {
                showToast("On item Deleted");
                deleteQuote(quote);
            }

            @Override
            public void onItemEdited(Quote quote) {
                showToast("ON item Edited");
            }
        });
        quotesRv.setAdapter(quotesAdapter);
    }

    private void deleteQuote(Quote quote) {
        Call<Void> call = crudService.deleteQuote(quote.id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                showToast("Item Deleted");
                fetchQuotes();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                 showToast("Failed to Delete");
            }
        });
    }

    private void setupRv() {
        quotesRv = findViewById(R.id.quotes_rv);
        quotesRv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupData() {
        quotes = new ArrayList<>();

        Quote quoteTxt = new Quote();
        quoteTxt.quoteText = "Hiiii";
        quoteTxt.authorName = "Hari";
        quoteTxt.category = "career";
        quoteTxt.imageUrl = "https://www.kochiesbusinessbuilders.com.au/wp-content/uploads/2022/02/motivational-quote.jpg";
        quotes.add(quoteTxt);

        Quote quoteTxt1 = new Quote();
        quoteTxt1.quoteText = "i will success not immeditly";
        quoteTxt1.authorName = "Hareesh";
        quoteTxt1.category = "career";
        quoteTxt1.imageUrl = "https://emilysquotes.files.wordpress.com/2014/03/emilysquotes-com-mistakes-progress-slow-trying-tony-robbins-inspirational-motivational.jpg?w=788";
        quotes.add(quoteTxt1);
    }
}