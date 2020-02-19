package com.example.globalnews.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.globalnews.R;
import com.example.globalnews.model.Article;
import com.example.globalnews.ui.DetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

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



    public class MHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
//        TextView title,description,author,published,source,time;
//        ImageView imageView;.idea
//        ProgressBar progressBar;
        //OnItemClickListener onItemClickListener;
        @BindView(R.id.title) TextView mTitle;
        @BindView(R.id.desc)TextView mDesc;
        @BindView(R.id.author)TextView mAuthor;
        @BindView(R.id.publishedAt)TextView mPublish;
        @BindView(R.id.source)TextView mSource;
        @BindView(R.id.time)TextView mtime;
        @BindView(R.id.img)ImageView mPicha;

       // @BindView(R.id.progres) ProgressBar mprogress;

        private Context context;

        public MHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            context = itemView.getContext();
        }


        public void bindArticle(Article article) {
            Picasso.get().load(article.getUrlToImage()).into(mPicha);
            mTitle.setText(article.getTitle());
            mDesc.setText(article.getDescription());
            mAuthor.setText(article.getAuthor());
            mPublish.setText(article.getPublishedAt());
            mSource.setText(article.getSource().getName());
            mtime.setText(article.getPublishedAt());



        }

        @Override
        public void onClick(View v) {
            int itemPos = getLayoutPosition();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("position",itemPos);
            intent.putExtra("article", Parcels.wrap(articles));
            context.startActivity(intent);


        }
    }

}
