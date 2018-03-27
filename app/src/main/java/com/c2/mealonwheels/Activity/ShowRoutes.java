package com.c2.mealonwheels.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.c2.mealonwheels.Interfaces.direction;
import com.c2.mealonwheels.Model.mDirection;
import com.c2.mealonwheels.R;
import com.c2.mealonwheels.RetroD;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowRoutes extends AppCompatActivity {

    String source;
    String dest;
    final String key="AIzaSyAGu_nRnhMchikhik8YciI7F7Zowhx0Tjs";
    public static final String TAG="ShowRoutes";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_routes);

        source= getIntent().getStringExtra("from");
        dest=getIntent().getStringExtra("to");

        direction direction= RetroD.getClient().create(com.c2.mealonwheels.Interfaces.direction.class);
        direction.getRoutes(source,dest,key).enqueue(new Callback<mDirection>() {
            @Override
            public void onResponse(Call<mDirection> call, Response<mDirection> response) {
                Log.d("ShowRoutes", "onResponse: "+response.body().toString());
            }

            @Override
            public void onFailure(Call<mDirection> call, Throwable t) {
                Log.d("ShowRoutes", "onFailure: "+t.getMessage());
            }
        });

    }
}
