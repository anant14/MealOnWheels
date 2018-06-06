package com.c2.mealonwheels.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.c2.mealonwheels.Activity.Rest_detail;
import com.c2.mealonwheels.Model.zomato.nearby_restaurants;
import com.c2.mealonwheels.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by anant bansal on 3/29/2018.
 */

public class RestAdapter extends RecyclerView.Adapter<RestAdapter.holderRest>{

    Context context;
    ArrayList<nearby_restaurants> nearby_restaurants;
    public static final String TAG="RestAdapter";

    public RestAdapter(Context context, ArrayList<nearby_restaurants> nearby_restaurants) {
        this.context = context;
        this.nearby_restaurants = nearby_restaurants;
    }

    @Override
    public holderRest onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview;
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemview=li.inflate(R.layout.rest,parent,false);
        return new RestAdapter.holderRest(itemview);
    }

    @Override
    public void onBindViewHolder(holderRest holder, final int position) {
        Log.d(TAG, "onBindViewHolder: "+nearby_restaurants.get(position).getRestaurant().getName());
        holder.tvname.setText(nearby_restaurants.get(position).getRestaurant().getName());
        holder.tvcuisine.setText(nearby_restaurants.get(position).getRestaurant().getCuisines());
        holder.tvprice.setText(String.valueOf(nearby_restaurants.get(position).getRestaurant().getAverage_cost_for_two()));
        holder.tvrating.setText(String.valueOf(nearby_restaurants.get(position).getRestaurant().getUser_rating().getAggregate_rating()));
        if(nearby_restaurants.get(position).getRestaurant().getFeatured_image().isEmpty()){
            holder.foodimg.setImageResource(R.drawable.deafult_rest);
        }
        else {
            Picasso.get().load(nearby_restaurants.get(position).getRestaurant().getFeatured_image()).into(holder.foodimg);
        }
       holder.tvlocation.setText(nearby_restaurants.get(position).getRestaurant().getLocation().getLocality());
        holder.Rootview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context.getApplicationContext(), Rest_detail.class);
                i.putExtra("resid",nearby_restaurants.get(position).getRestaurant().getR().getRes_id());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nearby_restaurants.size();
    }

    public class holderRest extends RecyclerView.ViewHolder{

        ImageView foodimg;
        TextView tvname;
        TextView tvrating;
        TextView tvcuisine;
        TextView tvprice;
        TextView tvlocation;
        View Rootview;

        public holderRest(View itemView) {
            super(itemView);
            foodimg=itemView.findViewById(R.id.foodimg);
            tvname=itemView.findViewById(R.id.tvname);
            tvrating=itemView.findViewById(R.id.tvrating);
            tvcuisine=itemView.findViewById(R.id.tvcuisine);
            tvprice=itemView.findViewById(R.id.tvprice);
            tvlocation=itemView.findViewById(R.id.tvlocation);
            Rootview=itemView;
        }
    }
}
