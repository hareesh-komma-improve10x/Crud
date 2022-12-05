package messages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.improve10x.crud.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MessagesActivity extends AppCompatActivity {
    public ArrayList<Messages> messagesId;
    public RecyclerView messagesRv;
    public MessagesAdapter messagesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        getSupportActionBar().setTitle("Messages");
        addBtn();
        setUpData();
        setUpMessagesList();
    }

    public void deleteMessage(Messages messages) {
        MessagesApi messagesApi = new MessagesApi();
        MessagesService messagesService = messagesApi.createMessagesService();
        Call<Void> call = messagesService.deleteMessage(messages.id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(MessagesActivity.this, "Successfully Deleted", Toast.LENGTH_SHORT).show();
                fetchTasks();

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(MessagesActivity.this, "Failed to Delete", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchTasks();
    }

    private void addBtn() {
        Button addBtn = findViewById(R.id.message_add_btn);
        addBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddMessagesActivity.class);
            startActivity(intent);
        });
    }

    private void fetchTasks() {
        MessagesApi messagesApi = new MessagesApi();
        MessagesService messagesService = messagesApi.createMessagesService();
        Call<List<Messages>> call = messagesService.fetchTasks();
        call.enqueue(new Callback<List<Messages>>() {
            @Override
            public void onResponse(Call<List<Messages>> call, Response<List<Messages>> response) {
                List<Messages> messages = response.body();
                messagesAdapter.setData(messages);
            }

            @Override
            public void onFailure(Call<List<Messages>> call, Throwable t) {
                Toast.makeText(MessagesActivity.this, "Failed", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void setUpMessagesList() {
        messagesRv = findViewById(R.id.messages_rv);
        messagesRv.setLayoutManager(new LinearLayoutManager(this));
        messagesAdapter = new MessagesAdapter();
        messagesAdapter.setData(messagesId);
        messagesAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onItemClicked(Messages messages) {
                Toast.makeText(MessagesActivity.this, "clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemDelete(Messages messages) {
                Toast.makeText(MessagesActivity.this, "Delete Successfully", Toast.LENGTH_SHORT).show();
                deleteMessage(messages);

            }

            @Override
            public void onItemEdit(Messages messages) {
                Toast.makeText(MessagesActivity.this, "On Item Edit", Toast.LENGTH_SHORT).show();

            }
        });
        messagesRv.setAdapter(messagesAdapter);
    }

    private void setUpData() {
        messagesId = new ArrayList<>();
        Messages messages = new Messages();
        messages.name = "Aravind";
        messages.phoneNumber = "+91 9000540052";
        messages.message = "Hi, Welcome to Improve 10X.";
        messagesId.add(messages);

        Messages messages1 = new Messages();
        messages1.name = "Ramesh";
        messages1.phoneNumber = "+91 9999999999";
        messages1.message = "Hi, Welcome to Improve 10X.";
        messagesId.add(messages1);
    }
}