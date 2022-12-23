package com.improve10x.crud.messages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.improve10x.crud.R;
import com.improve10x.crud.databinding.ActivityDashboardBinding;
import com.improve10x.crud.movies.MoviesActivity;
import com.improve10x.crud.quotes.QuotesActivity;
import com.improve10x.crud.series.SeriesItemsActivity;
import com.improve10x.crud.templates.TemplatesActivity;

public class DashboardActivity extends AppCompatActivity {

    private ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Dashboard");
        handleAddMessageButton();
        handleAddTemplateButton();
        handleAddSeriesButton();
        handleAddMoviesButton();
        handleAddQuotesButton();
    }

    private void handleAddQuotesButton() {
        binding.quotesImageBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, QuotesActivity.class);
            startActivity(intent);
        });
    }

    private void handleAddMoviesButton() {
        binding.moviesImageBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, MoviesActivity.class);
            startActivity(intent);
        });
    }

    private void handleAddSeriesButton() {
        binding.seriesImageBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, SeriesItemsActivity.class);
            startActivity(intent);
        });
    }

    private void handleAddTemplateButton() {
        binding.templateImageBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, TemplatesActivity.class);
            startActivity(intent);
        });
    }

    private void handleAddMessageButton() {
        binding.imageBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, MessagesActivity.class);
            startActivity(intent);
        });
    }
}