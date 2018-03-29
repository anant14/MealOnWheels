package com.c2.mealonwheels.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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

public class ShowRest extends AppCompatActivity {

    RecyclerView recyclerView;
    public static final String TAG="ShowRest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_rest);

        recyclerView=findViewById(R.id.rvcycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final ArrayList<nearby_restaurants> nearby_restaurants=new ArrayList<>();

        final zomato zomato= RetroZ.getClient().create(com.c2.mealonwheels.Interfaces.zomato.class);
        zomato.getRoutes("28.6366264","77.3607227").enqueue(new Callback<main>() {
            @Override
            public void onResponse(Call<main> call, Response<main> response) {
                Log.d(TAG, "onResponse: "+response.body().getNearby_restaurants().size());
                for(int i=0;i<response.body().getNearby_restaurants().size();i++){
                    nearby_restaurants.add(response.body().getNearby_restaurants().get(i));
                }
                RestAdapter restAdapter=new RestAdapter(ShowRest.this,nearby_restaurants);
                recyclerView.setAdapter(restAdapter);
            }

            @Override
            public void onFailure(Call<main> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());

            }
        });

    }
}
