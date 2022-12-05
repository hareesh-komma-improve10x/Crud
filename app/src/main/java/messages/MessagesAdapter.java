package messages;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;

import java.util.List;

public class MessagesAdapter extends RecyclerView.Adapter<MessageViewHolder>{

    public List<Message> messagesArrayList;
    public OnItemActionListener onItemActionListener;
    public void setOnItemActionListener(OnItemActionListener listener) {
        onItemActionListener = listener;
    }

    public void setData(List<Message> messages) {
        messagesArrayList = messages;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.messages_item, parent,false);
        MessageViewHolder messagesViewHolder = new MessageViewHolder(view);
        return messagesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message messages = messagesArrayList.get(position);
        holder.nameTxt.setText(messages.name);
        holder.phoneNumberTxt.setText(messages.phoneNumber);
        holder.messageTxt.setText(messages.messageText);
        holder.deleteBtn.setOnClickListener(view -> {
            onItemActionListener.onItemDelete(messages);
        });
        holder.itemView.setOnClickListener(view -> {
            onItemActionListener.onItemClicked(messages);
        });
    }

    @Override
    public int getItemCount() {
        return messagesArrayList.size();
    }
}
