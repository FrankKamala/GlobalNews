package com.example.globalnews.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.globalnews.R;
import com.example.globalnews.adapters.Adapter;
import com.example.globalnews.model.Article;
import com.example.globalnews.model.Constants;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {



//    @BindView(R.id.date) TextView date;title_on_appbar
    @BindView(R.id.time) TextView time;
    @BindView(R.id.descrip) TextView mDescription;

    @BindView(R.id.author) TextView author;
    @BindView(R.id.title_on_appbar) TextView source;
    @BindView(R.id.title) TextView mTitle;
    @BindView(R.id.newsImage) ImageView mImage;
    @BindView(R.id.saveNews) Button mSave;




    private Adapter viewAdapter;
    List<Article> mNews;
    private Context mContext;
    int itemPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mNews = Parcels.unwrap(getIntent().getParcelableExtra("article"));

        itemPos = getIntent().getIntExtra("position", 0);



//        viewAdapter = new Adapter(mNews, mContext);
//        mViewPager.setAdapter(viewAdapter);
//        mViewPager.setCurrentItem(itemPos);
//
        ButterKnife.bind(this);
        mSave.setOnClickListener(this);

        Picasso.get().load(mNews.get(itemPos).getUrlToImage()).into(mImage);

        time.setText(mNews.get(itemPos).getPublishedAt());
        author.setText(mNews.get(itemPos).getAuthor());

        mTitle.setText(mNews.get(itemPos).getTitle());
        mDescription.setText(mNews.get(itemPos).getDescription());




    }


    @Override
    public void onClick(View v) {

        if (v == mSave) {
            DatabaseReference newsRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_NEWS);
            newsRef.push().setValue(mNews.get(itemPos));
            Toast.makeText(DetailActivity.this, "Saved For Later", Toast.LENGTH_SHORT).show();


        }

    }
}
