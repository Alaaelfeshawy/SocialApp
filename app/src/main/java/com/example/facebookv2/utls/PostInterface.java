package com.example.facebookv2.utls;

import com.example.facebookv2.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {

    @GET("posts")
    public Call<List<Post>> getPost();
}
