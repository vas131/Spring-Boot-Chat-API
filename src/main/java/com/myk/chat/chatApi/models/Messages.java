package com.myk.chat.chatApi.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Messages {

    private Integer sender;
    private String message;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date time_created;
    private Integer cID;
    private String cToken;
    private String uniqueID;

    public Messages(Integer sender, String message, Date time_created, Integer cID, String cToken, String uniqueID) {
        this.sender = sender;
        this.message = message;
        this.time_created = time_created;
        this.cID = cID;
        this.cToken = cToken;
        this.uniqueID = uniqueID;
    }

    //getters

    public Integer getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public Integer getcID() {
        return cID;
    }

    public String getcToken() { return  cToken; }

    public  Date getTime_created() { return time_created; }

    public String getUniqueID() { return uniqueID; }

    //setters
    public void setSender(Integer sender1) {
        this.sender = sender1;
    }

    public void setMessage(String message1) {
        this.message = message1;
    }


    public void setcID(Integer cID) {
        this.cID = cID;
    }

    public void setcToken(String cToken1) { this.cToken = cToken1; }

    public void setTime_created(Date time_created) {
        this.time_created = time_created;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }
}
