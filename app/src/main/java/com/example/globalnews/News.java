package com.example.globalnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class News extends AppCompatActivity {
    @BindView(R.id.textView) TextView mOutput;
    @BindView(R.id.listView) ListView mListView;
    private String[] titles = new String[] {"Brexit Finally Happens",
            "Corona deaths reaches 259",
            "RIP Kobe Bryant",
            "Bruno Fernandes starts at Old Traford",
            "Tottenham now 4 points behind Chelsea",
            "Halland Yet AGAIN!",
            "50 goals in 70 games for CR7",
            "VAR or NO VAR", "UB 40 performance in Africa",
            "NO Flights to China"};
    private String[] content = new String[] {"The Uk has finally walked out ",
            "Confirmed cases of deaths by virus are now",
            "Rapper leaves 24 seconds of silence in new song",
            "The newly signed player makes his debut .. ",
            "Goal after Goal After Goal for Halland",
            "The Beast keeps Roaring for Juve",
            "Claims of poor VAR checks as Sterling makes dangerous tackle",
            "Famous Group make great show at Nairobi Kenya",
            "Countries put Travel bans on flights to China" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        ButterKnife.bind(this);

       NewsAdapter adapter = new NewsAdapter(this, android.R.layout.simple_list_item_1, titles, content);
        mListView.setAdapter(adapter);//set title and content

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String titles = ((TextView)view).getText().toString();


                Toast.makeText(News.this, titles, Toast.LENGTH_LONG).show();
            }
        });


        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        mOutput.setText("This articles were posted By:"+title+".");
    }
}
