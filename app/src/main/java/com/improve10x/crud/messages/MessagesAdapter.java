package com.improve10x.crud.messages;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;

import java.util.List;

public class MessagesAdapter extends RecyclerView.Adapter<MessageViewHolder>{

    public List<Message> messageList;

    public OnItemActionListener onItemActionListener;

    void setOnItemActionListener(OnItemActionListener listener) {
        onItemActionListener = listener;
    }

     void setData(List<Message> message) {
        messageList = message;
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
        Message messages = messageList.get(position);
        holder.nameTxt.setText(messages.name);
        holder.phoneNumberTxt.setText(messages.phoneNumber);
        holder.messageTextTxt.setText(messages.messageText);
        holder.delete.setOnClickListener(view -> {
            onItemActionListener.onItemDelete(messages);
        });
        holder.itemView.setOnClickListener(view -> {
            onItemActionListener.onItemClicked(messages);
        });
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}
