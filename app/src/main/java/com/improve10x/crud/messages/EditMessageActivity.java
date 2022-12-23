package com.improve10x.crud.messages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.improve10x.crud.R;
import com.improve10x.crud.api.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditMessageActivity extends BaseAddEditMessageActivity{

    private Message message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent.hasExtra(Constants.KEY_MESSAGE)) {
            getSupportActionBar().setTitle("Edit Message");
            message = (Message) intent.getSerializableExtra(Constants.KEY_MESSAGE);
            showData();
            showEditBtn();
            handleEdit();
        }
    }

    private void showData() {
        binding.nameTxt.setText(message.name);
        binding.phoneNumberTxt.setText(message.phoneNumber);
        binding.messageTxt.setText(message.messageText);
        showToast("data");
    }

    private void showEditBtn() {
        binding.editBtn.setVisibility(View.VISIBLE);
    }

    private void handleEdit() {
        binding.editBtn.setOnClickListener(view -> {
            String name = binding.nameTxt.getText().toString();
            String phoneNumber = binding.phoneNumberTxt.getText().toString();
            String messageText = binding.messageTxt.getText().toString();
            Message updatedMessage = createMessage(name, phoneNumber, messageText);
            updateMessage(message.id, updatedMessage);
        });
    }

    private void updateMessage(String id, Message updatedMessage) {
        Call<Void> call = crudService.updatedMessage(id, updatedMessage);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                showToast("Completed");
                finish();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                showToast("Failed");
            }
        });
    }
}
