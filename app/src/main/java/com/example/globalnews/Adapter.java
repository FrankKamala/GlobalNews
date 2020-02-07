package com.example.globalnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Adapter extends RecyclerView.Adapter<Adapter.MHolder> {
    private List <Article> articles;
    private Context context ;
//    private OnItemClickListener onItemClickListener;


    public Adapter(List<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }


    @NonNull
    @Override
    public MHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        MHolder viewHolder = new MHolder(view);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull MHolder holder, int position) {
        holder.bindArticle(articles.get(position));


    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public interface OnItemClickListener{
        void onItemClickListener (View view, int position);
    }

    public class MHolder extends RecyclerView.ViewHolder {
//        TextView title,description,author,published,source,time;
//        ImageView imageView;
//        ProgressBar progressBar;
        //OnItemClickListener onItemClickListener;
        @BindView(R.id.title) TextView mTitle;
        @BindView(R.id.desc)TextView mDesc;
        @BindView(R.id.author)TextView mAuthor;
        @BindView(R.id.publishedAt)TextView mPublish;
        @BindView(R.id.source)TextView mSource;
        @BindView(R.id.time)TextView mtime;
       // @BindView(R.id.img)ImageView mPicha;
       // @BindView(R.id.progres) ProgressBar mprogress;

        private Context context;

        public MHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
        }


        public void bindArticle(Article article) {
            mTitle.setText(article.getTitle());
            mDesc.setText(article.getDescription());
            mAuthor.setText(article.getAuthor());
            mPublish.setText(article.getPublishedAt());
            mSource.setText(article.getSource().getName());
            mtime.setText(article.getPublishedAt());

        }

    }

}
