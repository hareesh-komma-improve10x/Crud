package messages;

public interface OnItemActionListener {

    void onItemClicked(Message messages);
    void onItemDelete(Message messages);
    void onItemEdit(Message messages);
}
