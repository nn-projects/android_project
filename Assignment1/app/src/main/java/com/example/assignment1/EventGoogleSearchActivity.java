package com.example.assignment1;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class EventGoogleSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_event_google_search);
        WebView webView = findViewById(R.id.webView);

// get country name from Intent
        String eventName = getIntent().getExtras().getString("eventName");


// compile the Google URL, which will be used to load into WebView
        String googlePageURL = "https://www.google.com/search?q=" + eventName;

// set new WebView Client for the WebView
// This gives the WebView ability to be load the URL in the current WebView
// instead of navigating to default web browser of the device
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(googlePageURL);
    }
}