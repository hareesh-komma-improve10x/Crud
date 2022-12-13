package com.improve10x.crud.templates;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.improve10x.crud.R;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_templates);
        getSupportActionBar().setTitle("Add Template");
        setupViews();
        setupApiService();
        handleAdd();
    }

    private void setupViews() {
        addBtn = findViewById(R.id.add_btn);
        multilineTxt = findViewById(R.id.multiline_txt);
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