package com.improve10x.crud.messages;

import android.os.Bundle;


import com.improve10x.crud.R;
import com.improve10x.crud.api.Constants;
import com.improve10x.crud.api.CrudApi;
import com.improve10x.crud.api.CrudService;
import com.improve10x.crud.base.BaseActivity;
import com.improve10x.crud.databinding.ActivityBaseAddEditMessageBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseAddEditMessageActivity extends BaseActivity {

    protected ActivityBaseAddEditMessageBinding binding;
    protected CrudService crudService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBaseAddEditMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupApiService();
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