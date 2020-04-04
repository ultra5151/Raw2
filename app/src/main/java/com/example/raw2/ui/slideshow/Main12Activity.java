package com.example.raw2.ui.slideshow;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.raw2.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class Main12Activity extends AppCompatActivity {

    WebView webView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);

        getSupportActionBar().setTitle("Books");


        Window window = getWindow();
        window.addFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN);

        webView = (WebView)findViewById(R.id.webView);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        String getItem = getIntent().getStringExtra("pdfFileName");


            if(getItem.equals("DBMS")){

            webView.loadUrl("https://drive.google.com/open?id=1L_pgq9WvU8jIAh9EtGP6tEdkAP-pT4rV");

        }
        else if(getItem.equals("Theory of Computations")){

            webView.loadUrl(" https://drive.google.com/open?id=15ogZexyN0EH7wl47B8Gfz3vC1skvyMGi");

        }
        else if(getItem.equals("Machine Learning")){

            webView.loadUrl(" https://drive.google.com/open?id=1JYW7Iwd0QnCS6LlVxG1KwO7SuA2ETOIu");

        }
            else if(getItem.equals("Cyber Laws")){

                webView.loadUrl("https://drive.google.com/open?id=1S5NiTm9EJB4rQ-RGlRoFkhuGcJI3kxth");

            }
            else if(getItem.equals("Business Communication")){

                webView.loadUrl("https://drive.google.com/open?id=1zypSJEeyB7f4jGI_fTxc-_Esb8Sv07gL");

            }
            else if(getItem.equals("Compiler Design")){

                webView.loadUrl("https://drive.google.com/open?id=1StVR4AypCpYQ93K0Xni2bwFM1YeZfaQ0");

            }
            else if(getItem.equals("Computer Networks")){

                webView.loadUrl("https://drive.google.com/open?id=1kq6377a0zOfbPsKqrcHHOHmbBruZM4QM");

            }
            else if(getItem.equals("Artificial Intelligence")){

                webView.loadUrl("https://drive.google.com/open?id=1jy6AAIGewRVU5bBvsOEl0n7fxqOx2wp0");

            }
            else if(getItem.equals("GIS")){

                webView.loadUrl("https://drive.google.com/open?id=19OBhCxDKUk3BDJgRHXQvOThn8nWXCp6h");

            }
            else if(getItem.equals("IOT")){

                webView.loadUrl("https://drive.google.com/open?id=1S5NiTm9EJB4rQ-RGlRoFkhuGcJI3kxth");

            }
            else if(getItem.equals("NSS")){

                webView.loadUrl("https://drive.google.com/open?id=1sITYfK_7qPS6pPBF_uT0nKwZ1vvaviZm");

            }






        webView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(newProgress);
                setTitle("Loading....");

                if(newProgress==100){
                    progressBar.setVisibility(View.GONE);
                    setTitle(view.getTitle());

                }

                super.onProgressChanged(view, newProgress);
            }
        });
        webView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(final String url, final String userAgent, final String contentDisposition, final String mimetype, long contentLength) {

                Dexter.withActivity(Main12Activity.this)
                        .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse response) {

                                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                                request.setMimeType(mimetype);
                                String cookies = CookieManager.getInstance().getCookie(url);
                                request.addRequestHeader("cookie",cookies);
                                request.addRequestHeader("User-Agent",userAgent);
                                request.setDescription("Downloading.....");
                                request.setTitle(URLUtil.guessFileName(url,contentDisposition,mimetype));
                                request.allowScanningByMediaScanner();
                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                                request.setDestinationInExternalPublicDir(
                                        Environment.DIRECTORY_DOWNLOADS,URLUtil.guessFileName(
                                                url,contentDisposition,mimetype));

                                DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                                downloadManager.enqueue(request);
                                Toast.makeText(Main12Activity.this, "Downloading file....", Toast.LENGTH_SHORT).show();


                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse response) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                                token.continuePermissionRequest();
                            }
                        }).check();


            }
        });





    }
}
