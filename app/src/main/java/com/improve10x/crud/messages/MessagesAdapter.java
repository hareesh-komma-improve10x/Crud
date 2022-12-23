package com.improve10x.crud.messages;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;
import com.improve10x.crud.databinding.MessagesItemBinding;

import java.util.List;

public class MessagesAdapter extends RecyclerView.Adapter<MessageViewHolder> {

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
        MessagesItemBinding binding = MessagesItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        MessageViewHolder messagesViewHolder = new MessageViewHolder(binding);
        return messagesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message messages = messageList.get(position);
        holder.binding.nameTxt.setText(messages.name);
        holder.binding.phoneNumberTxt.setText(messages.phoneNumber);
        holder.binding.messageTxt.setText(messages.messageText);
        holder.binding.deleteBtn.setOnClickListener(view -> {
            onItemActionListener.onItemDelete(messages);
        });
        holder.binding.getRoot().setOnClickListener(view -> {
            onItemActionListener.onItemClicked(messages);
        });
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}
