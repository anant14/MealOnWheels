package com.c2.mealonwheels.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.c2.mealonwheels.R;

public class Rest_detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_detail);

        TextView tv=findViewById(R.id.tv);
        tv.setText(getIntent().getStringExtra("resid"));
    }
}
