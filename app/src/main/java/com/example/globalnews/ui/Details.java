package com.example.globalnews.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.globalnews.R;
import com.example.globalnews.model.Article;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class Details extends Fragment {
    @BindView(R.id.img2) ImageView mImageLabel;
    @BindView(R.id.time) TextView mTime;
    @BindView(R.id.title) TextView mTitle;

//    @BindView(R.id.img) ImageView mImageLabel2;

    private Article mArticle;


    public Details() {
        // Required empty public constructor
    }

    public static Details newInstance(Article news) {
        Details details = new Details();
        Bundle args = new Bundle();

        args.putParcelable("news", Parcels.wrap(news));
        details.setArguments(args);
        return details;
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        ButterKnife.bind(this, view);

        Picasso.get().load(mArticle.getUrlToImage()).into(mImageLabel);




        mTitle.setText(mArticle.getTitle());


        mTime.setText(mArticle.getPublishedAt());
       // mAddressLabel.setText(mRestaurant.getLocation().toString());

        return view;
    }


}
