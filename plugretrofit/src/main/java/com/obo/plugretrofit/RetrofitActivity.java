package com.obo.plugretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.obo.model.Example;
import com.obo.model.Result;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;

public class RetrofitActivity extends AppCompatActivity {

    public interface GitHubService {
        @GET("/testJson")
        Example listRepos();
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

            Log.i("TAG","get result:"+repos.getResult().getUseruserName());

        }
    };

}
