package com.redonicsoft.mvvmproject.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.redonicsoft.mvvmproject.Model.User;
import com.redonicsoft.mvvmproject.R;

public class UserAdapter extends  RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    User[] users;

    public UserAdapter(User[] users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.user_list, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        holder.textView1.setText(users[position].getLogin());
        holder.textView2.setText(String.valueOf(users[position].getId()));
        holder.textView3.setText(users[position].getReposUrl());

        Glide.with(holder.imageView.getContext()).load(users[position].getAvatarUrl()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return users.length;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder
    {

        ImageView imageView;
        TextView textView1;
        TextView textView2;
        TextView textView3;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageViewId);
            textView1 = itemView.findViewById(R.id.textView1Id);
            textView2 = itemView.findViewById(R.id.textView2Id);
            textView3 = itemView.findViewById(R.id.textView3Id);
        }
    }

}
