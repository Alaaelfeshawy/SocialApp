package com.example.facebookv2.utls;

import com.example.facebookv2.model.Post;

import java.util.List;

import io.reactivex.Observable;

import retrofit2.http.GET;

public interface PostInterface {

    @GET("posts")
    public Observable<List<Post>> getPost();
}
