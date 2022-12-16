package com.improve10x.crud.messages;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.improve10x.crud.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddMessageActivity extends BaseAddEditMessageActivity{

    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViews();
        getSupportActionBar().setTitle("Add Message");
        showAddBtn();
        handleAdd();
    }

    private void setupViews() {
        addBtn = findViewById(R.id.message_add_btn);
    }

    private void showAddBtn() {
        addBtn.setVisibility(View.VISIBLE);
    }

    private void handleAdd() {
        addBtn.setOnClickListener(view -> {
            String name = nameTxt.getText().toString();
            String phoneNumber = phoneNumberTxt.getText().toString();
            String messageText = messageTxt.getText().toString();
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
