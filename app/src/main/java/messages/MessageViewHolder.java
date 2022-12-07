package messages;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;

public class MessageViewHolder extends RecyclerView.ViewHolder {

     TextView nameTxt;
     TextView phoneNumberTxt;
     TextView messageTextTxt;
     ImageButton delete;

    public MessageViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTxt = itemView.findViewById(R.id.name_txt);
        phoneNumberTxt = itemView.findViewById(R.id.phone_number_txt);
        messageTextTxt = itemView.findViewById(R.id.message_txt);
        delete = itemView.findViewById(R.id.delete_btn);
    }
}
