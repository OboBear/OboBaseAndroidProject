package com.obo.plugchat.network;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by obo on 16/2/4.
 */
public class ChatInterfaceClass {

    public interface ChatInterface {

        @GET("/zjutchat/chatbot/conversation_start.php")
        Call<ChatResult> getChatResult(@Query("bot_id") String bot_id,@Query("say") String say,@Query("convo_id") String convo_id , @Query("format") String format);
    }

}

