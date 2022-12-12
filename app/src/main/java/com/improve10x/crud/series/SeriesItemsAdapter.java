package com.improve10x.crud.series;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SeriesItemsAdapter extends RecyclerView.Adapter<SeriesItemViewHolder> {

    public List<SeriesItem> seriesList;

    OnItemActionListener onItemActionListener;

    void setOnItemActionListener(OnItemActionListener listener) {
        onItemActionListener = listener;
    }

    void setData(List<SeriesItem> seriesItems) {
        seriesList = seriesItems;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SeriesItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.serieslist_item, parent, false);
        SeriesItemViewHolder seriesItemViewHolder = new SeriesItemViewHolder(view);
        return seriesItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SeriesItemViewHolder holder, int position) {
        SeriesItem seriesItem = seriesList.get(position);
        holder.seriesNameTxt.setText(seriesItem.title);
        Picasso.get().load(seriesItem.imageUrl).into(holder.seriesImg);
        holder.deleteBtn.setOnClickListener(view -> {
            onItemActionListener.onItemDelete(seriesItem);
        });
        holder.itemView.setOnClickListener(view -> {
            onItemActionListener.onItemClicked(seriesItem);
        });
    }

    @Override
    public int getItemCount() {
        return seriesList.size();
    }
}
