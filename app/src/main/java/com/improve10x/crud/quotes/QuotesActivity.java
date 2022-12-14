package com.improve10x.crud.quotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.improve10x.crud.R;
import com.improve10x.crud.base.BaseActivity;

import java.util.ArrayList;

public class QuotesActivity extends BaseActivity {

    private ArrayList<Quote> quotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
        getSupportActionBar().setTitle("Quotes");
    }
}