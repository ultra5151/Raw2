package com.example.raw2.ui.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;

import com.example.raw2.R;
import com.example.raw2.ui.home.Main2Activity;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

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

public class Main3Activity extends AppCompatActivity {

    WebView webView;
    ProgressBar progressBar;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Window window = getWindow();
        window.addFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN);

        webView = (WebView)findViewById(R.id.webView);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading_Please_Wait");

        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(" https://drive.google.com/open?id=1lGTDZw-WoiC1kMcyZFsLPYwocDCSLNP4");

        webView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(newProgress);
                setTitle("Loading....");
                progressDialog.show();
                if(newProgress==100){
                    progressBar.setVisibility(View.GONE);
                    setTitle(view.getTitle());
                    progressDialog.dismiss();
                }

                super.onProgressChanged(view, newProgress);
            }
        });





        webView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(final String url, final String userAgent, final String contentDisposition, final String mimetype, long contentLength) {

                Dexter.withActivity(Main3Activity.this)
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
                                Toast.makeText(Main3Activity.this, "Downloading file....", Toast.LENGTH_SHORT).show();


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
