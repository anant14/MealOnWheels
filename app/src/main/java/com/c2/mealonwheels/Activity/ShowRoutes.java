package com.c2.mealonwheels.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.c2.mealonwheels.R;
import com.c2.mealonwheels.RetroD;
import com.c2.mealonwheels.model.mDirection;

public class ShowRoutes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_routes);

        mDirection mDirection= RetroD.getClient().create(com.c2.mealonwheels.model.mDirection.class);
    }
}
