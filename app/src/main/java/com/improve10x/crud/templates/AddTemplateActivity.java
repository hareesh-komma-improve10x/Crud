package com.improve10x.crud.templates;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.improve10x.crud.R;
import com.improve10x.crud.api.Constants;
import com.improve10x.crud.api.CrudApi;
import com.improve10x.crud.api.CrudService;
import com.improve10x.crud.base.BaseActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddTemplateActivity extends BaseActivity {

    private CrudService crudService;
    private Button addBtn;
    private EditText multilineTxt;
    private Template template;
    private Button editBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_templates);
        setupViews();
        setupApiService();
        Intent intent = getIntent();
        if (intent.hasExtra(Constants.KEY_TEMPLATE)) {
            getSupportActionBar().setTitle("Edit Template");
            template = (Template) intent.getSerializableExtra(Constants.KEY_TEMPLATE);
            showData();
            showEditBtn();
            handleEdit();
        } else {
            getSupportActionBar().setTitle("Add Template");
            showAddBtn();
            handleAdd();
        }
    }

    private void showAddBtn() {
        addBtn.setVisibility(View.VISIBLE);
        editBtn.setVisibility(View.GONE);
    }

    private void showEditBtn() {
        addBtn.setVisibility(View.GONE);
        editBtn.setVisibility(View.VISIBLE);
    }

    private void handleEdit() {
        editBtn.setOnClickListener(view -> {
            String multiline = multilineTxt.getText().toString();
            Template updatedTemplate = createTemplate(multiline);
            updateTemplate(template.id, updatedTemplate);

        });
    }

    private void updateTemplate(String id, Template updatedTemplate) {
        Call<Void> call = crudService.updatedTemplate(id,updatedTemplate);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                showToast("Successfully Completed");
                finish();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                showToast("Failed to Loaded");
            }
        });
    }

    private void showData() {
        multilineTxt.setText(template.messageText);
    }

    private void setupViews() {
        addBtn = findViewById(R.id.add_btn);
        multilineTxt = findViewById(R.id.multiline_txt);
        editBtn = findViewById(R.id.edit_btn);
    }

    private void handleAdd() {
        addBtn.setOnClickListener(view -> {
            String multiline = multilineTxt.getText().toString();
            Template template = createTemplate(multiline);
            saveMessage(template);
        });
    }

    private Template createTemplate(String multiline) {
        Template templates = new Template();
        templates.messageText = multiline;
        return templates;
    }

    private void setupApiService() {
        CrudApi crudApi = new CrudApi();
        crudService = crudApi.createCrudService();
    }

    private void saveMessage(Template template) {
        Call<Template> call = crudService.createTemplate(template);
        call.enqueue(new Callback<Template>() {
            @Override
            public void onResponse(Call<Template> call, Response<Template> response) {
                showToast("Successfully Completed");
                finish();
            }

            @Override
            public void onFailure(Call<Template> call, Throwable t) {
                showToast("Something Went Wrong");
            }
        });

    }
}