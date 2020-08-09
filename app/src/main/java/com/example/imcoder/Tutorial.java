package com.example.imcoder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Tutorial extends AppCompatActivity {

    public WebView mywebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        mywebview = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = mywebview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mywebview.loadUrl("https://github.com/iamparthgalani?tab=repositories");

        mywebview.setWebViewClient(new WebViewClient());
    }
    @Override
    public void  onBackPressed(){
        if (mywebview.canGoBack()){
            mywebview.goBack();
        }else{
            super.onBackPressed();
        }
    }

}