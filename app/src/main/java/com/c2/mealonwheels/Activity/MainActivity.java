package com.c2.mealonwheels.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.c2.mealonwheels.R;

public class MainActivity extends AppCompatActivity {

    Button BtnR;
    EditText etfrom;
    EditText etto;
    Button BtnRe;
    String from;
    String to;
    public static final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etfrom=findViewById(R.id.etfrom);
        etto=findViewById(R.id.etto);
        BtnR=findViewById(R.id.btnR);
        BtnRe=findViewById(R.id.btnRe);


        BtnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                from=etfrom.getText().toString();
                to=etto.getText().toString();
                Intent i=new Intent(MainActivity.this,ShowRoutes.class);
                i.putExtra("from",from);
                i.putExtra("to",to);
                startActivity(i);
            }
        });

        BtnRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ShowRest.class);
                startActivity(i);
            }
        });

    }
}
