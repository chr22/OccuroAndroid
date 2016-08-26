package com.occuro_app.occuroandroid;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_PROGRESS);

        this.webView = new WebView(this);
        this.webView.getSettings().setJavaScriptEnabled(true);
        //this.webView.setWebContentsDebuggingEnabled(true);
        this.webView.getSettings().setDomStorageEnabled(true);

        final Activity activity = this;

        /*this.webView.setWebChromeClient(new WebChromeClient() {
            public void onReceivedError(WebView view, int errorCode, String desc, String failingUrl) {
                Toast.makeText(activity, desc, Toast.LENGTH_LONG).show();
            }

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });*/

        this.webView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String desc, String failingUrl) {
                Toast.makeText(activity, desc, Toast.LENGTH_LONG).show();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        this.webView.loadUrl("https://occuro-app.com");
        setContentView(webView);
    }
}
