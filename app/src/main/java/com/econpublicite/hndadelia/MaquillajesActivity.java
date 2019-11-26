package com.econpublicite.hndadelia;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MaquillajesActivity extends AppCompatActivity {


    private WebView miWebView;
    ProgressBar progressBar;
    @Override
    public void onBackPressed() {
        if (miWebView.canGoBack()) {
            miWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maquillajes);
        miWebView = (WebView) findViewById(R.id.website);
        progressBar = (ProgressBar) findViewById(R.id.casa);


        WebSettings webSettings = miWebView.getSettings();

        webSettings.setJavaScriptEnabled(true);


        webSettings = miWebView.getSettings();

        miWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view,String url) {


                if (url.startsWith("http:") || url.startsWith("https:")) {
                    return false;

                }

                // Otherwise allow the OS to handle things like tel, mailto, etc.
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
                startActivity(intent);
                return true;
            }
        });
        miWebView.loadUrl("https://hinodeadelia.blogspot.com/search/label/Maquillaje");



        WebSettings webSettings1 = miWebView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        miWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view,String url,Bitmap favicon) {
                progressBar.setVisibility(View.VISIBLE);
                setTitle("Loading...");
                super.onPageStarted(view,url,favicon);
            }

            @Override
            public void onPageFinished(WebView view,String url) {
                progressBar.setVisibility(View.GONE);
                setTitle(view.getTitle());

                super.onPageFinished(view,url);
            }







            @Override
            public void onReceivedError(WebView webView,int errorCode,String description,String failingUrl) {
                webView.stopLoading();
                webView.loadUrl("file:///android_assets/www/hombre.html");
                webView.loadUrl("about:blank");
                AlertDialog dialogo = new AlertDialog.Builder(MaquillajesActivity.this).create();
                dialogo.setTitle("Sin conexion");
                dialogo.setMessage("Por favor, verifica tu conexión a internet para ver nuestros Catalogo De Fragancias");
                dialogo.setButton(DialogInterface.BUTTON_POSITIVE, "Intentar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int i) {
                        finish();
                        startActivity(getIntent());
                    }
                });

                dialogo.show();
            }
        });




    };}