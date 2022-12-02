package com.improve10x.crud;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MessagesViewHolder extends RecyclerView.ViewHolder {

    public TextView nameTxt;
    public TextView phoneNumberTxt;
    public TextView messageTxt;

    public MessagesViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTxt = itemView.findViewById(R.id.name_txt);
        phoneNumberTxt = itemView.findViewById(R.id.phone_number_txt);
        messageTxt = itemView.findViewById(R.id.message_txt);
    }
}
