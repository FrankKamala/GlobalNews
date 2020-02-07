package com.example.globalnews;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter {
    private List <Article> articles;
    private Context context ;
    private OnItemClickListener onItemClickListener;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {

        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public interface OnItemClickListener{
        void onItemClickListener (View view, int position);
    }

    public class MHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title,desc,author,published_ad,source,time;
        ImageView imageView;
        ProgressBar progressBar;
        OnItemClickListener onItemClickListener;
        public MHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View v) {

        }
    }

}
