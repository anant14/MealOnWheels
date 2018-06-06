package com.c2.mealonwheels.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.c2.mealonwheels.R;

public class MainActivity extends AppCompatActivity {

    Button BtnR;
    EditText etfrom;
    EditText etto;
    Button Btngwf;
    Button btnef;
    String from;
    String to;
    Button btnrr;
    public static final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etfrom=findViewById(R.id.etfrom);
        etto=findViewById(R.id.etto);
        BtnR=findViewById(R.id.btnR);
        Btngwf=findViewById(R.id.btngwf);
        btnef=findViewById(R.id.btnef);
        btnrr=findViewById(R.id.btnrr);

        BtnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                from=etfrom.getText().toString();
                to=etto.getText().toString();
                if(from.isEmpty()||to.isEmpty()){
                    Toast.makeText(MainActivity.this, "Source or Destination is Empty", Toast.LENGTH_SHORT).show();
                }
                else
                    if(isNetworkConnected()==true)
                {
                    Intent i=new Intent(MainActivity.this,ShowRoutes.class);
                    i.putExtra("from",from);
                    i.putExtra("to",to);
                    startActivity(i);
                }
                else
                    {
                        Toast.makeText(MainActivity.this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
                    }

            }
        });

        Btngwf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Super_Finder.class);
                startActivity(i);
            }
        });


        btnef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,preferences.class);
                startActivity(i);
            }
        });

        btnrr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Recommend.class);
                startActivity(i);
            }
        });
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
