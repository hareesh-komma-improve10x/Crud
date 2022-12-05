package com.improve10x.crud.templates;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.improve10x.crud.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddTemplateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_templates);
        getSupportActionBar().setTitle("Add Template");
        handleAdd();
    }

    private void handleAdd() {
        Button addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(view -> {
            EditText multilineTxt = findViewById(R.id.multiline_txt);
            String multiline = multilineTxt.getText().toString();
            createData(multiline);
        });
    }

    public void createData(String multiline) {
        Template templates = new Template();
        templates.messageText = multiline;

        TemplatesApi templatesApi = new TemplatesApi();
        TemplatesService templatesService = templatesApi.createTemplatesService();
        Call<Template> call = templatesService.createData(templates);
        call.enqueue(new Callback<Template>() {
            @Override
            public void onResponse(Call<Template> call, Response<Template> response) {
                Toast.makeText(AddTemplateActivity.this, "Successfully Completed", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Template> call, Throwable t) {
                Toast.makeText(AddTemplateActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }
}