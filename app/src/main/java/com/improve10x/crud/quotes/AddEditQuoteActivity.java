package com.improve10x.crud.quotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.improve10x.crud.R;
import com.improve10x.crud.base.BaseActivity;

public class AddEditQuoteActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_quote);
        getSupportActionBar().setTitle("Edit Quote");
    }
}