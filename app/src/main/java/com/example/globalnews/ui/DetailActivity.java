package com.example.globalnews.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.globalnews.R;
import com.example.globalnews.adapters.Adapter;
import com.example.globalnews.model.Article;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {



//    @BindView(R.id.date) TextView date;
    @BindView(R.id.time) TextView time;

    @BindView(R.id.author) TextView author;
    @BindView(R.id.title) TextView mTitle;




    private Adapter viewAdapter;
    List<Article> mNews;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mNews = Parcels.unwrap(getIntent().getParcelableExtra("article"));
        int itemPos = getIntent().getIntExtra("position", 0);


//        viewAdapter = new Adapter(mNews, mContext);
//        mViewPager.setAdapter(viewAdapter);
//        mViewPager.setCurrentItem(itemPos);
//
        ButterKnife.bind(this);


        time.setText(mNews.get(itemPos).getPublishedAt());
        author.setText(mNews.get(itemPos).getAuthor());
        mTitle.setText(mNews.get(itemPos).getTitle());




    }


}
