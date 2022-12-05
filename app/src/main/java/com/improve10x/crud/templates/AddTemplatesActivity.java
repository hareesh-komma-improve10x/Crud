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

public class AddTemplatesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_templates);
        getSupportActionBar().setTitle("Add Template");
        addBtn();
    }

    private void addBtn() {
        Button addBtn = findViewById(R.id.add1_btn);
        addBtn.setOnClickListener(view -> {
            EditText multilineTxt = findViewById(R.id.multiline_txt);
            String multiline = multilineTxt.getText().toString();
            createData(multiline);
        });
    }

    public void createData(String multiline) {
        Templates templates = new Templates();
        templates.messageTxt = multiline;

        TemplatesApi templatesApi = new TemplatesApi();
        TemplatesService templatesService = templatesApi.createTemplatesService();
        Call<Templates> call = templatesService.createData(templates);
        call.enqueue(new Callback<Templates>() {
            @Override
            public void onResponse(Call<Templates> call, Response<Templates> response) {
                Toast.makeText(AddTemplatesActivity.this, "Successfully Completed", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Templates> call, Throwable t) {
                Toast.makeText(AddTemplatesActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }
}