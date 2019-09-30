package com.myk.chat.chatApi.models;

import java.util.List;

public class JSONNewConversation {

    private String cToken;
    private List<JSONNewConversationUsers> users;

    public String getcToken() {
        return cToken;
    }

    public List<JSONNewConversationUsers> getUsers() {
        return users;
    }

    public void setcToken(String cToken) {
        this.cToken = cToken;
    }

    public void setUsers(List<JSONNewConversationUsers> users) {
        this.users = users;
    }
}
