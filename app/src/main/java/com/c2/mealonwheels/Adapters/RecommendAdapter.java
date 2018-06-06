package com.c2.mealonwheels.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.c2.mealonwheels.Model.sear.Restaurant;
import com.c2.mealonwheels.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by anant bansal on 5/10/2018.
 */

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.holderRest> {
    ArrayList<Restaurant> restaurant;
    Context context;

    public RecommendAdapter(ArrayList<Restaurant> restaurant, Context context) {
        this.restaurant = restaurant;
        this.context = context;
    }

    @Override
    public holderRest onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview;
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemview=li.inflate(R.layout.rest,parent,false);
        return new RecommendAdapter.holderRest(itemview);
    }

    @Override
    public void onBindViewHolder(holderRest holder, int position) {
        holder.tvname.setText(restaurant.get(position).getRestaurant().getName());
        holder.tvcuisine.setText(restaurant.get(position).getRestaurant().getCuisines());
        holder.tvprice.setText(String.valueOf(restaurant.get(position).getRestaurant().getAverageCostForTwo()));
        holder.tvlocation.setText(restaurant.get(position).getRestaurant().getLocation().getLocality());
        if(restaurant.get(position).getRestaurant().getFeaturedImage().isEmpty()){
            holder.foodimg.setImageResource(R.drawable.deafult_rest);
        }
        else {
            Picasso.get().load(restaurant.get(position).getRestaurant().getFeaturedImage()).into(holder.foodimg);
        }
    }

    @Override
    public int getItemCount() {
        return restaurant.size();
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
