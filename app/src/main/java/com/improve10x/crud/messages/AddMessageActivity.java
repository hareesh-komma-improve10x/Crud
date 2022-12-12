package com.improve10x.crud.messages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.improve10x.crud.R;
import com.improve10x.crud.api.CrudApi;
import com.improve10x.crud.api.CrudService;
import com.improve10x.crud.base.BaseActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddMessageActivity extends BaseActivity {

    public CrudService crudService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_messages);
        getSupportActionBar().setTitle("Add Message");
        handleAdd();
        setupApiService();
    }

    private void setupApiService() {
        CrudApi crudApi = new CrudApi();
        crudService = crudApi.createCrudService();
    }

    private void handleAdd() {
        Button addBtn = findViewById(R.id.message_add_btn);
        addBtn.setOnClickListener(view -> {
            EditText nameTxt = findViewById(R.id.name_txt);
            String name = nameTxt.getText().toString();
            EditText phoneNumberTxt = findViewById(R.id.phone_number_txt);
            String phoneNumber = phoneNumberTxt.getText().toString();
            EditText messageTxt = findViewById(R.id.message_txt);
            String message = messageTxt.getText().toString();
            createMessage(name, phoneNumber, message);
        });
    }

    private void createMessage(String name, String phoneNumber, String message) {
        Message messages = new Message();
        messages.name = name;
        messages.phoneNumber = phoneNumber;
        messages.messageText = message;

        Call<Message> call = crudService.createMessage(messages);
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                showToast("Successfully Completed");
                finish();
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                showToast("Failed to Delete");
            }
        });
    }
}