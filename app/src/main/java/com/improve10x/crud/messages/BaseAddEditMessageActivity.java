package com.improve10x.crud.messages;

import android.content.Intent;
import android.os.Bundle;
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

public class BaseAddEditMessageActivity extends BaseActivity {

    protected CrudService crudService;
    protected EditText nameTxt;
    protected EditText phoneNumberTxt;
    protected EditText messageTxt;
    protected Message message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_messages);
        setupViews();
        setupApiService();
    }

    private void setupViews() {
        nameTxt = findViewById(R.id.name_txt);
        phoneNumberTxt = findViewById(R.id.phone_number_txt);
        messageTxt = findViewById(R.id.message_txt);
    }

    private void setupApiService() {
        CrudApi crudApi = new CrudApi();
        crudService = crudApi.createCrudService();
    }

    protected Message createMessage(String name, String phoneNumber, String message) {
        Message messages = new Message();
        messages.name = name;
        messages.phoneNumber = phoneNumber;
        messages.messageText = message;
        return messages;
    }
}