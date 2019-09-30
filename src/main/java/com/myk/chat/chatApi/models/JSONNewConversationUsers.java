package com.myk.chat.chatApi.models;

public class JSONNewConversationUsers {

    private Integer userId;
    private String userType;

    public void JSONNewConversationUsers(Integer userId, String userType) {
        this.userId = userId;
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
