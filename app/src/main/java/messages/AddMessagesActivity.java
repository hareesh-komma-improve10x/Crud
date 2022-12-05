package messages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.improve10x.crud.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddMessagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_messages);
        getSupportActionBar().setTitle("Add Message");
        addBtn();

    }

    private void addBtn() {
        Button addBtn = findViewById(R.id.message_add_btn);
        addBtn.setOnClickListener(view -> {
            EditText nameTxt = findViewById(R.id.name_txt);
            String name = nameTxt.getText().toString();
            EditText phoneNumberTxt = findViewById(R.id.phone_number_txt);
            String phoneNumber = phoneNumberTxt.getText().toString();
            EditText messageTxt = findViewById(R.id.message_txt);
            String message = messageTxt.getText().toString();
            createTasks(name, phoneNumber, message);
        });
    }
    public void createTasks(String name, String phoneNumber, String message) {
        Messages messages = new Messages();
        messages.name = name;
        messages.phoneNumber = phoneNumber;
        messages.message = message;

        MessagesApi messagesApi = new MessagesApi();
        MessagesService messagesService = messagesApi.createMessagesService();
        Call<Messages> call = messagesService.createTasks(messages);
        call.enqueue(new Callback<Messages>() {
            @Override
            public void onResponse(Call<Messages> call, Response<Messages> response) {
                Toast.makeText(AddMessagesActivity.this, "Successfully completed", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Messages> call, Throwable t) {
                Toast.makeText(AddMessagesActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}