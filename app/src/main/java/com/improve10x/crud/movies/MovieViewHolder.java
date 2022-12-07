package com.improve10x.crud.movies;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    public ImageView moviesImageImg;
    public TextView moviesNameTxt;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        moviesImageImg = itemView.findViewById(R.id.movies_image_btn);
        moviesNameTxt = itemView.findViewById(R.id.movies_name_txt);
    }
}
