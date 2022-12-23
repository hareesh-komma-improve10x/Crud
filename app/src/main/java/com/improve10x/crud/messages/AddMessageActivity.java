package com.improve10x.crud.messages;

import android.os.Bundle;
import android.view.View;





import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddMessageActivity extends BaseAddEditMessageActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Add Message");
        showAddBtn();
        handleAdd();
    }


    private void showAddBtn() {
        binding.messageAddBtn.setVisibility(View.VISIBLE);
    }

    private void handleAdd() {
        binding.messageAddBtn.setOnClickListener(view -> {
            String name = binding.nameTxt.getText().toString();
            String phoneNumber = binding.phoneNumberTxt.getText().toString();
            String messageText = binding.messageTxt.getText().toString();
            Message message = createMessage(name, phoneNumber, messageText);
            saveMessage(message);
        });
    }

    private void saveMessage(Message message) {
        Call<Message> call = crudService.createMessage(message);
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
