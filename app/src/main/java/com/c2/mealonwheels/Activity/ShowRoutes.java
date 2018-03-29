package com.c2.mealonwheels.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.c2.mealonwheels.Adapters.RoutesAdapter;
import com.c2.mealonwheels.Interfaces.direction;
import com.c2.mealonwheels.Model.direction.mDirection;
import com.c2.mealonwheels.Model.direction.routes;
import com.c2.mealonwheels.R;
import com.c2.mealonwheels.RetroD;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowRoutes extends AppCompatActivity {

    String source;
    String dest;
    final String key="AIzaSyAGu_nRnhMchikhik8YciI7F7Zowhx0Tjs";
    public static final String TAG="ShowRoutes";

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_routes);

        source= getIntent().getStringExtra("from");
        dest=getIntent().getStringExtra("to");
        recyclerView=findViewById(R.id.rvRoutes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final ArrayList<routes> arrayListRoutes=new ArrayList<>();

        direction direction= RetroD.getClient().create(com.c2.mealonwheels.Interfaces.direction.class);
        direction.getRoutes(source,dest,key).enqueue(new Callback<mDirection>() {
            @Override
            public void onResponse(Call<mDirection> call, Response<mDirection> response) {
                Log.d("ShowRoutes", "onResponse: "+response.body());
                for(int i=0;i<response.body().getRoutes().size();i++){
                    arrayListRoutes.add(response.body().getRoutes().get(i));
                }
                RoutesAdapter routesAdapter=new RoutesAdapter(ShowRoutes.this,arrayListRoutes);
                recyclerView.setAdapter(routesAdapter);
            }

            @Override
            public void onFailure(Call<mDirection> call, Throwable t) {
                Log.d("ShowRoutes", "onFailure: "+t.getMessage());
            }
        });

    }
}
