package com.example.raw2.ui.slideshow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.raw2.R;


public class Main17Activity extends AppCompatActivity {

    ListView thirdQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);

        getSupportActionBar().setTitle("Question Papers");


        thirdQuestion = (ListView)findViewById(R.id.thirdQuestion);

        String [] firstBook = {"DBMS","Theory of Computations","Machine Learning", "Cyber Laws", "Business Communication","Compiler Design","Computer Networks","Artificial Intelligence","GIS","IOT","NSS" };
        String [] Qit = {"Compiler Design","Computer Networks","Artificial Intelligence","GIS","IOT","NSS" };

        String getItem = getIntent().getStringExtra("Branch");
        if (getItem.equals("CSE")) {

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, firstBook) {

                @NonNull
                @Override
                public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                    View view = super.getView(position, convertView, parent);
                    TextView myText = (TextView) findViewById(android.R.id.text1);
                    return view;
                }
            };
            thirdQuestion.setAdapter(adapter);
        }

        if (getItem.equals("IT")){

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, Qit) {

                @NonNull
                @Override
                public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                    View view = super.getView(position, convertView, parent);
                    TextView myText = (TextView) findViewById(android.R.id.text1);
                    return view;
                }
            };
            thirdQuestion.setAdapter(adapter);

        }



        thirdQuestion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    String item = thirdQuestion.getItemAtPosition(position).toString();
                    Intent intent = new Intent(getApplicationContext(),Main18Activity.class);
                    intent.putExtra("pdfFileName",item);
                    startActivity(intent);
                }

                if(position==1){
                    String item = thirdQuestion.getItemAtPosition(position).toString();
                    Intent intent = new Intent(getApplicationContext(),Main18Activity.class);
                    intent.putExtra("pdfFileName",item);
                    startActivity(intent);
                }

                if(position==2){
                    String item = thirdQuestion.getItemAtPosition(position).toString();
                    Intent intent = new Intent(getApplicationContext(),Main18Activity.class);
                    intent.putExtra("pdfFileName",item);
                    startActivity(intent);
                }
                if(position==3){
                    String item = thirdQuestion.getItemAtPosition(position).toString();
                    Intent intent = new Intent(getApplicationContext(),Main18Activity.class);
                    intent.putExtra("pdfFileName",item);
                    startActivity(intent);
                }
                if(position==4){
                    String item = thirdQuestion.getItemAtPosition(position).toString();
                    Intent intent = new Intent(getApplicationContext(),Main18Activity.class);
                    intent.putExtra("pdfFileName",item);
                    startActivity(intent);
                }
                if(position==5){
                    String item = thirdQuestion.getItemAtPosition(position).toString();
                    Intent intent = new Intent(getApplicationContext(),Main18Activity.class);
                    intent.putExtra("pdfFileName",item);
                    startActivity(intent);
                }
                if(position==6){
                    String item = thirdQuestion.getItemAtPosition(position).toString();
                    Intent intent = new Intent(getApplicationContext(),Main18Activity.class);
                    intent.putExtra("pdfFileName",item);
                    startActivity(intent);
                }
                if(position==7){
                    String item = thirdQuestion.getItemAtPosition(position).toString();
                    Intent intent = new Intent(getApplicationContext(),Main18Activity.class);
                    intent.putExtra("pdfFileName",item);
                    startActivity(intent);
                }
                if(position==8){
                    String item = thirdQuestion.getItemAtPosition(position).toString();
                    Intent intent = new Intent(getApplicationContext(),Main18Activity.class);
                    intent.putExtra("pdfFileName",item);
                    startActivity(intent);
                }
                if(position==9){
                    String item = thirdQuestion.getItemAtPosition(position).toString();
                    Intent intent = new Intent(getApplicationContext(),Main18Activity.class);
                    intent.putExtra("pdfFileName",item);
                    startActivity(intent);
                }
                if(position==10){
                    String item = thirdQuestion.getItemAtPosition(position).toString();
                    Intent intent = new Intent(getApplicationContext(),Main18Activity.class);
                    intent.putExtra("pdfFileName",item);
                    startActivity(intent);
                }



            }
        });

    }
}
