package messages;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;

public class MessageViewHolder extends RecyclerView.ViewHolder {

    public TextView nameTxt;
    public TextView phoneNumberTxt;
    public TextView messageTxt;
    public ImageButton deleteBtn;

    public MessageViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTxt = itemView.findViewById(R.id.name_txt);
        phoneNumberTxt = itemView.findViewById(R.id.phone_number_txt);
        messageTxt = itemView.findViewById(R.id.message_txt);
        deleteBtn = itemView.findViewById(R.id.delete_btn);
    }
}
