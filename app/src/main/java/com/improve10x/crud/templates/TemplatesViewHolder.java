package com.improve10x.crud.templates;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;

public class TemplatesViewHolder extends RecyclerView.ViewHolder {

    public TextView titleTxt;
    public ImageButton deleteBtn;

    public TemplatesViewHolder(@NonNull View itemView) {
        super(itemView);
        titleTxt = itemView.findViewById(R.id.title_txt);
        deleteBtn = itemView.findViewById(R.id.delete_btn);
    }
}
