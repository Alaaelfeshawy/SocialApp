package com.example.facebookv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.facebookv2.ViewModel.PostViewModel;
import com.example.facebookv2.ViewModel.PostsAdapter;
import com.example.facebookv2.model.Post;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PostViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        model = ViewModelProviders.of(this).get(PostViewModel.class);

        model.getPost();

        RecyclerView recyclerView = findViewById(R.id.recycler);

        PostsAdapter adapter = new PostsAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);

        model.mutableLiveData.observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {

                adapter.setList(posts);

            }
        });
    }
}
