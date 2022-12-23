package com.improve10x.crud.messages;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;
import com.improve10x.crud.databinding.MessagesItemBinding;

public class MessageViewHolder extends RecyclerView.ViewHolder {

    MessagesItemBinding binding;

    public MessageViewHolder(MessagesItemBinding messagesItemBinding) {
        super(messagesItemBinding.getRoot());
        binding = messagesItemBinding;
    }
}
