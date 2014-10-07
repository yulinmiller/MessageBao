package com.example.MessageBao.model;

/**
 * Created by 麟 on 2014/10/5.
 */
public class Sms {
    private int id;
    private String fromWhom;
    private String content;
    private String date;

    public String getDate() {
        return date;
    }

    public String getFromWhom() {
        return fromWhom;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setFromWhom(String fromWhom) {
        this.fromWhom = fromWhom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
