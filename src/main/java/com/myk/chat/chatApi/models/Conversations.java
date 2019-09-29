package com.myk.chat.chatApi.models;

import java.util.ArrayList;
import java.util.List;

public class Conversations {

    private String chatToken;
    private List<ConversationsUsers> users;

    public void Conversations(String chatToken, List<ConversationsUsers> users ) {
        this.chatToken = chatToken;
        this.users = users;
    }


    public String getChatToken() {
        return chatToken;
    }

    public List<ConversationsUsers> getUsers() {
        return users;
    }

    public void setChatToken(String chatToken) {
        this.chatToken = chatToken;
    }

    public void setUsers(List<ConversationsUsers> users) {
        this.users = users;
    }
}
