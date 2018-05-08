package com.c2.mealonwheels.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.c2.mealonwheels.Adapters.RestAdapter;
import com.c2.mealonwheels.Interfaces.zomato;
import com.c2.mealonwheels.Model.zomato.main;
import com.c2.mealonwheels.Model.zomato.nearby_restaurants;
import com.c2.mealonwheels.R;
import com.c2.mealonwheels.RetroZ;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class conn extends AppCompatActivity {

    Button btnrest;
    RecyclerView recyclerView;
    public static final String TAG="conn";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conn);

        btnrest=findViewById(R.id.btnrest);
        recyclerView=findViewById(R.id.rvcycles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final ArrayList<nearby_restaurants> nearby_restaurants=new ArrayList<>();

        btnrest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final zomato zomato= RetroZ.getClient().create(com.c2.mealonwheels.Interfaces.zomato.class);
                zomato.getRoutes("28.6366264","77.3607227").enqueue(new Callback<main>() {
                    @Override
                    public void onResponse(Call<main> call, Response<main> response) {
                        for(int i=0;i<response.body().getNearby_restaurants().size();i++){
                            nearby_restaurants.add(response.body().getNearby_restaurants().get(i));
                        }
                        RestAdapter restAdapter=new RestAdapter(conn.this,nearby_restaurants);
                        recyclerView.setAdapter(restAdapter);
                    }

                    @Override
                    public void onFailure(Call<main> call, Throwable t) {
                        Log.d(TAG, "onFailure: "+t.getMessage());
                    }
                });
            }
        });



    }
}
