package com.example.globalnews.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.globalnews.model.Article;
import com.example.globalnews.ui.Details;

import java.util.List;

public class NewsPagerAdapter extends FragmentPagerAdapter {

    private List<Article> mArticle;

    public NewsPagerAdapter(FragmentManager fm, List<Article> articles) {
        super(fm);
        mArticle = articles;
    }

    @Override
    public Fragment getItem(int position) {
        return Details.newInstance(mArticle.get(position));
    }

    @Override
    public int getCount() {
        return mArticle.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mArticle.get(position).getTitle();
    }
}
