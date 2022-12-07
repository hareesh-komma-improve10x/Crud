package com.improve10x.crud.messages;

public interface OnItemActionListener {

    void onItemClicked(Message messages);
    void onItemDelete(Message messages);
    void onItemEdit(Message messages);
}
