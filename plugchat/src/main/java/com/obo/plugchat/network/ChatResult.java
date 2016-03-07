package com.obo.plugchat.network;

import org.json.*;

import java.io.Serializable;


public class ChatResult implements Serializable{
	
    private String usersay;
    private String convo_id;
    private String botsay;

	public ChatResult () {
		
	}	
        
    public ChatResult (JSONObject json) {
    
        this.usersay = json.optString("usersay");
        this.convo_id = json.optString("convo_id");
        this.botsay = json.optString("botsay");

    }
    
    public String getUsersay() {
        return this.usersay;
    }

    public void setUsersay(String usersay) {
        this.usersay = usersay;
    }

    public String getConvo_id() {
        return this.convo_id;
    }

    public void setConvo_id(String convoId) {
        this.convo_id = convoId;
    }

    public String getBotsay() {
        return this.botsay;
    }

    public void setBotsay(String botsay) {
        this.botsay = botsay;
    }


    
}
