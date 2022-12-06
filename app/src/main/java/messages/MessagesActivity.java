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
    public ArrayList<Message> messagesId;
    public RecyclerView messagesRv;
    public MessagesAdapter messagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        getSupportActionBar().setTitle("Messages");
        addBtn();
        setUpData();
        setUpMessageList();
    }

    public void deleteMessage(Message messages) {
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
            Intent intent = new Intent(this, AddMessageActivity.class);
            startActivity(intent);
        });
    }

    private void fetchTasks() {
        MessagesApi messagesApi = new MessagesApi();
        MessagesService messagesService = messagesApi.createMessagesService();
        Call<List<Message>> call = messagesService.fetchTasks();
        call.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                List<Message> messages = response.body();
                messagesAdapter.setData(messages);
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                Toast.makeText(MessagesActivity.this, "Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setUpMessageList() {
        messagesRv = findViewById(R.id.messages_rv);
        messagesRv.setLayoutManager(new LinearLayoutManager(this));
        messagesAdapter = new MessagesAdapter();
        messagesAdapter.setData(messagesId);
        messagesAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onItemClicked(Message messages) {
                Toast.makeText(MessagesActivity.this, "clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemDelete(Message messages) {
                Toast.makeText(MessagesActivity.this, "Delete Successfully", Toast.LENGTH_SHORT).show();
                deleteMessage(messages);

            }

            @Override
            public void onItemEdit(Message messages) {
                Toast.makeText(MessagesActivity.this, "On Item Edit", Toast.LENGTH_SHORT).show();

            }
        });
        messagesRv.setAdapter(messagesAdapter);
    }

    private void setUpData() {
        messagesId = new ArrayList<>();
    }
}