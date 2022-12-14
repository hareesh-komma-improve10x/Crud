package com.improve10x.crud.quotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.improve10x.crud.R;
import com.improve10x.crud.base.BaseActivity;

import java.util.ArrayList;

public class QuotesActivity extends BaseActivity {

    private ArrayList<Quote> quotes;
    private QuotesAdapter quotesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
        getSupportActionBar().setTitle("Quotes");
        setupData();
    }

    private void setupData() {
        quotes = new ArrayList<>();

        Quote quoteTxt = new Quote();
        quoteTxt.quoteText = "";
        quoteTxt.authorName = "";
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