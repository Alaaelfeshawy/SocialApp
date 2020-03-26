package com.example.facebookv2.ViewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.facebookv2.model.Post;
import com.example.facebookv2.utls.PostClient;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PostViewModel extends ViewModel {

    private static final String TAG = "PostViewModel";

    public MutableLiveData<List<Post>> data = new MutableLiveData<>();

    public void getPost(){

       Observable observable = PostClient.getInstance().getPosts()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread());

       Observer<List<Post>> observer = new Observer<List<Post>>() {
           @Override
           public void onSubscribe(Disposable d) {

           }

           @Override
           public void onNext(List<Post> value) {

               data.setValue(value);
           }

           @Override
           public void onError(Throwable e) {

               Log.d(TAG, "onError: "+e.toString());
           }

           @Override
           public void onComplete() {

           }
       };

       observable.subscribe(observer);

    }
}
