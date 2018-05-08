package com.c2.mealonwheels.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.c2.mealonwheels.R;

public class preferences extends AppCompatActivity {

    CheckBox cbNI,cbSI,cbCH,cbCO,cbFF,cbDE,cbIT;
    int NI=0,SI=0,CH=0,CO=0,FF=0,DE=0,IT=0;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        cbNI=findViewById(R.id.checkBoxNI);
        cbCH=findViewById(R.id.checkBoxCH);
        cbCO=findViewById(R.id.checkBoxCO);
        cbDE=findViewById(R.id.checkBoxDE);
        cbFF=findViewById(R.id.checkBoxFF);
        cbSI=findViewById(R.id.checkBoxSI);
        cbIT=findViewById(R.id.checkBoxIT);
        submit=findViewById(R.id.btnsubit);

        if(cbNI.isChecked()==true){
            NI=1;
        }
        else if(cbSI.isChecked()==true){
            SI=1;
        }
        else if(cbCH.isChecked()==true){
            CH=1;
        }
        else if(cbCO.isChecked()==true){
            CO=1;
        }
        else if(cbFF.isChecked()==true){
            FF=1;
        }
        else if(cbIT.isChecked()==true){
            IT=1;
        }
        else if(cbDE.isChecked()==true){
            DE=1;
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(preferences.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
