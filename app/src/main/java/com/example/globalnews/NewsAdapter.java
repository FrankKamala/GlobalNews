package com.example.globalnews;

import android.content.Context;
import android.widget.ArrayAdapter;

public class NewsAdapter extends ArrayAdapter {
    private String[] mTitle;
    private String[] mContent;
    private Context mContext;

    public NewsAdapter(Context mContext, int resource,String[] mTitle,String [] mContent){
        super(mContext,resource);
        this.mContext =mContext;
        this.mTitle =mTitle;
        this.mContent =mContent;


    }
}
