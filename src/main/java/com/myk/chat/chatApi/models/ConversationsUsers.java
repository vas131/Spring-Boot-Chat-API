package com.myk.chat.chatApi.models;

public class ConversationsUsers {

    private Integer userID;
    private String userType;

    public void ConversationsUsers(Integer userID, String userType) {
        this.userID = userID;
        this.userType = userType;
    }


    public Integer getUserID() {
        return userID;
    }

    public String getUserType() {
        return userType;
    }


    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
