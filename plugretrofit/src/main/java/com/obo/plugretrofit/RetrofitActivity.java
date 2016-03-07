package com.obo.plugretrofit;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.obo.model.Example;
import com.obo.model.Result;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public class RetrofitActivity extends AppCompatActivity {

    public interface GitHubService {
        @GET("/testJson")
        Example listRepos();

        @POST("/testJson")
        void doRepos(@Body Result e, Callback<Result> callback);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        thread.start();
    }

    Thread thread = new Thread() {
        public void run() {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("http://10.173.167.149:8080")
                    .build();

            GitHubService service = restAdapter.create(GitHubService.class);
            Example repos = service.listRepos();


            service.doRepos(repos.getResult(), new Callback<Result>() {
                @Override
                public void success(Result result, Response response) {

                }

                @Override
                public void failure(RetrofitError error) {

                }
            });

            Log.i("TAG","get result:"+repos.getResult().getUseruserName());

        }
    };



}
