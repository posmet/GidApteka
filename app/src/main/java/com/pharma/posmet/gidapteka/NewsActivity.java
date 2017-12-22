package com.pharma.posmet.gidapteka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        WebView news=(WebView) findViewById(R.id.news);
        news.loadUrl("http://pharma-soft.ru/category/news/");
    }
}
