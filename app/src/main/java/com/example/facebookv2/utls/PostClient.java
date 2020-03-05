package com.example.facebookv2.utls;

import com.example.facebookv2.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {

    private static final String BASE_URL ="https://jsonplaceholder.typicode.com/";

    private static PostClient instance ;

    private PostInterface postInterface ;

    public static PostClient getInstance() {
        if (instance == null){

            instance = new PostClient();
        }
        return instance;
    }

    public PostClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }


    public Call<List<Post>> getPosts(){
        return postInterface.getPost();
    }
}
