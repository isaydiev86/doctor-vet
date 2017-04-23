package com.isaydiev.doctor_vet;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebView webView = (WebView)findViewById(R.id.web_view);
//        webView.setWebViewClient(new WebViewClient() {
//            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
//                Toast.makeText(getApplicationContext(), description, Toast.LENGTH_SHORT).show();
//            }
//        });
        webView.loadUrl(getIntent().getStringExtra("url"));
        //Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_LONG).show();
        //Log.e("Error", getIntent().getStringExtra("url"));
    }
}
