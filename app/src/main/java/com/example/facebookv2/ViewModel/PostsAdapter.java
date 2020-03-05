package com.example.facebookv2.ViewModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebookv2.R;
import com.example.facebookv2.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    private List<Post> moviesList = new ArrayList<>();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.titleTV.setText(moviesList.get(position).getTitle());
        holder.userTV.setText(moviesList.get(position).getUserId()+"");
        holder.bodyTV.setText(moviesList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public void setList(List<Post> moviesList) {
        this.moviesList = moviesList;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView titleTV, userTV, bodyTV;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleView);
            userTV = itemView.findViewById(R.id.idView);
            bodyTV = itemView.findViewById(R.id.bodyView);
        }
    }
}