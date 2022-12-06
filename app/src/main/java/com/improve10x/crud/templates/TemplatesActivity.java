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

    public ArrayList<Template> templates;
    public RecyclerView templatesRv;
    public TemplatesAdapter templatesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_templates);
        getSupportActionBar().setTitle("Templates");
        handleAdd();
        setupData();
        setupTemplatesRv();
    }

    public void deleteMessage(Template templates) {
        TemplatesApi templatesApi = new TemplatesApi();
        TemplatesService templatesService = templatesApi.createTemplatesService();
        Call<Void> call = templatesService.deleteTemplate(templates.id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(TemplatesActivity.this, "Successfully Deleted", Toast.LENGTH_SHORT).show();
                fetchTemplates();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(TemplatesActivity.this, "Failed to Delete", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleAdd() {
        Button addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddTemplateActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchTemplates();
    }

    private void fetchTemplates() {
        TemplatesApi templatesApi = new TemplatesApi();
        TemplatesService templatesService = templatesApi.createTemplatesService();
        Call<List<Template>> call = templatesService.fetchTemplates();
        call.enqueue(new Callback<List<Template>>() {
            @Override
            public void onResponse(Call<List<Template>> call, Response<List<Template>> response) {
                List<Template> templates = response.body();
                templatesAdapter.setTemplatesList(templates);
            }

            @Override
            public void onFailure(Call<List<Template>> call, Throwable t) {
                Toast.makeText(TemplatesActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupTemplatesRv() {
        templatesRv = findViewById(R.id.templates_rv);
        templatesRv.setLayoutManager(new LinearLayoutManager(this));
        templatesAdapter = new TemplatesAdapter();
        templatesAdapter.setTemplatesList(templates);
        templatesRv.setAdapter(templatesAdapter);
        templatesAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onItemClicked(Template templates) {
                Toast.makeText(TemplatesActivity.this, "On Clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemDelete(Template templates) {
                Toast.makeText(TemplatesActivity.this, "Successfully Delete", Toast.LENGTH_SHORT).show();
                deleteMessage(templates);
            }

            @Override
            public void onItemEdit(Template templates) {
                Toast.makeText(TemplatesActivity.this, "Edited", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupData() {
        templates = new ArrayList<>();
    }
}