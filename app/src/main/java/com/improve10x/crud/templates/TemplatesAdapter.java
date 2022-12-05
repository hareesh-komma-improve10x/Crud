package com.improve10x.crud.templates;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;

import java.util.List;

public class TemplatesAdapter extends RecyclerView.Adapter<TemplateViewHolder> {
    OnItemActionListener onItemActionListener;

    public void setOnItemActionListener(OnItemActionListener listener) {

        onItemActionListener = listener;
    }

    public List<Template> templateList;

    public void setTemplatesList(List<Template> templates) {
        templateList = templates;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TemplateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.templates_item, parent,false);
        TemplateViewHolder templatesViewHolder = new TemplateViewHolder(view);
        return templatesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TemplateViewHolder holder, int position) {
        Template templates = templateList.get(position);
        holder.titleTxt.setText(templates.messageText);
        holder.delete.setOnClickListener(view -> {
           onItemActionListener.onItemDelete(templates);
        });
        holder.itemView.setOnClickListener(view -> {
            onItemActionListener.onItemClicked(templates);
        });
    }

    @Override
    public int getItemCount() {
        return templateList.size();
    }
}
