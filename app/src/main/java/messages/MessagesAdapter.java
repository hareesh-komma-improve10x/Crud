package messages;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.crud.R;

import java.util.List;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesViewHolder>{
    public List<Messages> messagesArrayList;
    public OnItemActionListener onItemActionListener;

    public void setOnItemActionListener(OnItemActionListener listener) {
        onItemActionListener = listener;
    }

    public void setData(List<Messages> messages) {
        messagesArrayList = messages;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MessagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.messages_item, parent,false);
        MessagesViewHolder messagesViewHolder = new MessagesViewHolder(view);
        return messagesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesViewHolder holder, int position) {
        Messages messages = messagesArrayList.get(position);
        holder.nameTxt.setText(messages.name);
        holder.phoneNumberTxt.setText(messages.phoneNumber);
        holder.messageTxt.setText(messages.message);
        holder.deleteBtn.setOnClickListener(view -> {
            onItemActionListener.onItemDelete(messages);
        });
        holder.itemView.setOnClickListener(view -> {
            onItemActionListener.onItemClicked(messages);
        });
    }

    @Override
    public int getItemCount() {
        return messagesArrayList.size();
    }
}
