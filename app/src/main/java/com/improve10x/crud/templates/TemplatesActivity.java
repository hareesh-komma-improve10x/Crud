package com.improve10x.crud.templates;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.improve10x.crud.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TemplatesActivity extends AppCompatActivity {

    public ArrayList<Templates> template;
    public RecyclerView templatesRv;
    public TemplatesAdapter templatesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_templates);
        getSupportActionBar().setTitle("Templates");
        addButton();
        setUpDataForTemplates();
        setUpTemplatesList();
    }

    public void deleteMessage(Templates templates) {
        TemplatesApi templatesApi = new TemplatesApi();
        TemplatesService templatesService = templatesApi.createTemplatesService();
        Call<Void> call = templatesService.deleteTemplates(templates.id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(TemplatesActivity.this, "Successfully Deleted", Toast.LENGTH_SHORT).show();
                fetchData();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(TemplatesActivity.this, "Failed to Delete", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void addButton() {
        Button addBtn = findViewById(R.id.add1_btn);
        addBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddTemplatesActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchData();
    }

    private void fetchData() {
        TemplatesApi templatesApi = new TemplatesApi();
        TemplatesService templatesService = templatesApi.createTemplatesService();
        Call<List<Templates>> call = templatesService.fetchData();
        call.enqueue(new Callback<List<Templates>>() {
            @Override
            public void onResponse(Call<List<Templates>> call, Response<List<Templates>> response) {
                List<Templates> templates = response.body();
                templatesAdapter.setTemplatesList(templates);
            }

            @Override
            public void onFailure(Call<List<Templates>> call, Throwable t) {
                Toast.makeText(TemplatesActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setUpTemplatesList() {
        templatesRv = findViewById(R.id.templates_rv);
        templatesRv.setLayoutManager(new LinearLayoutManager(this));
        templatesAdapter = new TemplatesAdapter();
        templatesAdapter.setTemplatesList(template);
        templatesRv.setAdapter(templatesAdapter);
        templatesAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onItemClicked(Templates templates) {
                Toast.makeText(TemplatesActivity.this, "On Clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemDelete(Templates templates) {
                Toast.makeText(TemplatesActivity.this, "Successfully Delete", Toast.LENGTH_SHORT).show();
                deleteMessage(templates);


            }

            @Override
            public void onItemEdit(Templates templates) {
                Toast.makeText(TemplatesActivity.this, "Edited", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setUpDataForTemplates() {
        template = new ArrayList<>();
    }
}