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
import com.example.raw2.ui.home.Main2Activity;

public class Main10Activity extends AppCompatActivity {

    ListView branch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);



        getSupportActionBar().setTitle("Branch");

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

                            Intent intent = new Intent(getApplicationContext(), Main17Activity.class);
                            String item =  branch.getItemAtPosition(position).toString();
                            intent.putExtra("Branch",item);
                            startActivity(intent);

                        }

                        if (position==1){

                            Intent intent = new Intent(getApplicationContext(), Main17Activity.class);
                            String item =  branch.getItemAtPosition(position).toString();
                            intent.putExtra("Branch",item);
                            startActivity(intent);

                        }
                        if (position==2){

                            Intent intent = new Intent(getApplicationContext(), Main17Activity.class);
                            String item =  branch.getItemAtPosition(position).toString();
                            intent.putExtra("Branch",item);
                            startActivity(intent);

                        }
                if (position==3){

                    Intent intent = new Intent(getApplicationContext(), Main17Activity.class);
                    String item =  branch.getItemAtPosition(position).toString();
                    intent.putExtra("Branch",item);
                    startActivity(intent);

                }
                if (position==4){

                    Intent intent = new Intent(getApplicationContext(), Main17Activity.class);
                    String item =  branch.getItemAtPosition(position).toString();
                    intent.putExtra("Branch",item);
                    startActivity(intent);

                }
                if (position==5){

                    Intent intent = new Intent(getApplicationContext(), Main17Activity.class);
                    String item =  branch.getItemAtPosition(position).toString();
                    intent.putExtra("Branch",item);
                    startActivity(intent);

                }


            }
        });



    }

}



