package com.obo.plugchat.model;

/**
 * Created by obo on 16/1/29.
 */
public class ChatModel {
    private int type;
    private String name;
    private String content;
    private String headUrl;

    public ChatModel() {}
    public ChatModel(int type,String content) {
        this.type = type;
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }
}
