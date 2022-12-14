package com.improve10x.crud.quotes;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;

import org.w3c.dom.Text;

public class QuoteViewHolder extends RecyclerView.ViewHolder {

    ImageView quoteImageImg;
    TextView quoteTextTxt;
    TextView authorNameTxt;

    public QuoteViewHolder(@NonNull View itemView) {
        super(itemView);
        quoteImageImg = itemView.findViewById(R.id.quote_image_img);
        quoteTextTxt = itemView.findViewById(R.id.quote_text_txt);
        authorNameTxt = itemView.findViewById(R.id.author_name_txt);
    }
}
