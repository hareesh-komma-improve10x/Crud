package com.improve10x.crud;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesViewHolder>{
    public List<Messages> messagesArrayList;

    public void setData(List<Messages> messages) {
        messagesArrayList = messages;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MessagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.messages_item, parent,false);
        MessagesViewHolder messagesViewHolder = new MessagesViewHolder(view);
        return messagesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesViewHolder holder, int position) {
        Messages messages = messagesArrayList.get(position);
        holder.nameTxt.setText(messages.name);
        holder.phoneNumberTxt.setText(messages.phoneNumber);
        holder.messageTxt.setText(messages.message);
    }

    @Override
    public int getItemCount() {
        return messagesArrayList.size();
    }
}
