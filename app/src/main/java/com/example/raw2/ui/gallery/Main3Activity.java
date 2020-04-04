package com.example.raw2.ui.gallery;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.raw2.R;
import com.example.raw2.ui.home.Main2Activity;
import com.example.raw2.ui.slideshow.Main17Activity;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

      ListView branch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Window window = getWindow();
        window.addFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN);

        branch = (ListView)findViewById(R.id.branch);

        String [] Branch = {"CSE","IT","Electrical","Electronic","Mechanical","Civil" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,Branch){

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view = super.getView(position, convertView, parent);
                TextView myText = (TextView)findViewById(android.R.id.text1);

                return view;
            }
        };
        branch.setAdapter(adapter);

        branch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position==0){

                    Intent intent = new Intent(getApplicationContext(), Main19Activity.class);
                    String item =  branch.getItemAtPosition(position).toString();
                    intent.putExtra("Branch",item);
                    startActivity(intent);

                }

                if (position==1){

                    Intent intent = new Intent(getApplicationContext(), Main19Activity.class);
                    String item =  branch.getItemAtPosition(position).toString();
                    intent.putExtra("Branch",item);
                    startActivity(intent);

                }
                if (position==2){

                    Intent intent = new Intent(getApplicationContext(), Main19Activity.class);
                    String item =  branch.getItemAtPosition(position).toString();
                    intent.putExtra("Branch",item);
                    startActivity(intent);

                }
            }
        });

    }
}
