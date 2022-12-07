package com.improve10x.crud.movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Movie;
import android.os.Bundle;

import com.improve10x.crud.R;

import java.util.ArrayList;

public class MoviesActivity extends AppCompatActivity {
    public ArrayList<Movie> movies;
    public RecyclerView moviesRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        getSupportActionBar().setTitle("Movies");
        setupData();
    }

    private void setupData() {
        movies = new ArrayList<>();
    }
}