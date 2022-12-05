package com.improve10x.crud.templates;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;

import java.util.List;

public class TemplatesAdapter extends RecyclerView.Adapter<TemplatesViewHolder> {
    OnItemActionListener onItemActionListener;

    public void setOnItemActionListener(OnItemActionListener listener) {
        onItemActionListener = listener;
    }

    public List<Templates> templatesList;

    public void setTemplatesList(List<Templates> templatesArrayList) {
        templatesList = templatesArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TemplatesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.templates_item, parent,false);
        TemplatesViewHolder templatesViewHolder = new TemplatesViewHolder(view);
        return templatesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TemplatesViewHolder holder, int position) {
        Templates templates = templatesList.get(position);
        holder.titleTxt.setText(templates.messageTxt);
        holder.deleteBtn.setOnClickListener(view -> {
           onItemActionListener.onItemDelete(templates);
        });
        holder.itemView.setOnClickListener(view -> {
            onItemActionListener.onItemClicked(templates);
        });
    }

    @Override
    public int getItemCount() {
        return templatesList.size();
    }
}
