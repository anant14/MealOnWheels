package com.c2.mealonwheels.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.c2.mealonwheels.Adapters.RecommendAdapter;
import com.c2.mealonwheels.Interfaces.zomato;
import com.c2.mealonwheels.Model.sear.Main;
import com.c2.mealonwheels.Model.sear.Restaurant;
import com.c2.mealonwheels.R;
import com.c2.mealonwheels.RetroZ;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Recommend extends AppCompatActivity {

    EditText etquery;
    Button btnquery;
    RecyclerView rvquery;
    public static final String TAG="Recommend";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        etquery = findViewById(R.id.etquery);
        btnquery = findViewById(R.id.btnquery);
        rvquery = findViewById(R.id.rvquery);
        rvquery.setLayoutManager(new LinearLayoutManager(this));

        final ArrayList<Restaurant> restaurants = new ArrayList<>();

        final zomato zomato = RetroZ.getClient().create(com.c2.mealonwheels.Interfaces.zomato.class);
        btnquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zomato.getrest(etquery.getText().toString(), "8", "28.6438232", "77.3726377", "3000", "3,7", "cost", "asc").enqueue(new Callback<Main>() {
                    @Override
                    public void onResponse(Call<Main> call, Response<Main> response) {
                        Log.d(TAG, "onResponse: " + response.body());
                        for (int i = 0; i < response.body().getRestaurants().size(); i++) {
                            restaurants.add(response.body().getRestaurants().get(i));
                        }
                        RecommendAdapter recommendAdapter = new RecommendAdapter(restaurants, Recommend.this);
                        rvquery.setAdapter(recommendAdapter);
                    }

                    @Override
                    public void onFailure(Call<Main> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                    }
                });
            }

        });
    }
}
