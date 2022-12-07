package com.improve10x.crud.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.improve10x.crud.R;

public class MoviesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        getSupportActionBar().setTitle("Movies");
    }
}