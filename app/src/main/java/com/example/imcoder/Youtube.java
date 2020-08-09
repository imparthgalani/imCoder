package com.example.imcoder;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.webkit.WebSettings;
        import android.webkit.WebView;
        import android.webkit.WebViewClient;

public class Youtube extends AppCompatActivity {

    public WebView mywebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        mywebview = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = mywebview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mywebview.loadUrl("https://www.youtube.com/channel/UCs8YuffktnbeZiHfPwQ2A9g?view_as=subscriber");

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
