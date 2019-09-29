package com.myk.chat.chatApi.models;

public class CheckServerModel {

    private String db;
    private String status;
    private Boolean error;

//        public CheckServerModel(String db, String status) {
//            this.db=db;
//            this.status=status;
//        }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error=error;
    }
    public String getDb() {
        return  db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
