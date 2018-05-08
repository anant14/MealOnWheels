package com.c2.mealonwheels.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.c2.mealonwheels.Activity.ShowRest;
import com.c2.mealonwheels.Model.direction.routes;
import com.c2.mealonwheels.R;

import java.util.ArrayList;

/**
 * Created by anant bansal on 3/27/2018.
 */

public class RoutesAdapter extends RecyclerView.Adapter<RoutesAdapter.holderRoutes> {

    Context context;
    ArrayList<routes> routes;
    public static final String TAG="RoutesAdapter";
    Float x2,z1;
    String a1,b1,a2,b2,temp="1 hour 50 mins";
    int h1,m1,h2,m2;


    public RoutesAdapter(Context context, ArrayList<com.c2.mealonwheels.Model.direction.routes> routes) {
        this.context = context;
        this.routes = routes;
    }

    @Override
    public holderRoutes onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onBindViewHolder: "+temp.length());
        Log.d(TAG, "onBindViewHolder: "+temp);
        View itemview;
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemview=li.inflate(R.layout.route,parent,false);
        return new holderRoutes(itemview);
    }

    @Override
    public void onBindViewHolder(holderRoutes holder, final int position) {
            if (position == 0) {
                a1 = routes.get(0).getLegs().get(0).getSteps().get(position).getDistance().text;
                for(int i=0;i<a1.length();i++){
                    if(a1.substring(i).matches("km")){
                        z1=Float.valueOf(a1.substring(0,i-1));
                        z1=z1*1000;
                        break;
                    }
                    else if(a1.substring(i).matches("m"))
                    {
                        z1=Float.valueOf(a1.substring(0,i-1));
                    }
                }
                b1 = routes.get(0).getLegs().get(0).getSteps().get(position).getDuration().text;
                for(int j=0;j<b1.length();j++){
                    if(b1.substring(j).matches("min")||b1.substring(j).matches("mins")){
                        m1=Integer.valueOf(b1.substring(0,j-1));
                    }
                    else if (b1.substring(j).matches("hour")) {
                            h1 = Integer.valueOf(b1.substring(0, j - 1));
                            for (int k = j+2; k < b1.length(); k++) {
                                if (b1.substring(k).matches("min") || b1.substring(k).matches("mins")) {
                                    m1 = Integer.valueOf(b1.substring(j+2, k - 2));
                                    break;
                                }
                            }
                        }

                }
                holder.tvdist.setText(routes.get(0).getLegs().get(0).getSteps().get(position).getDistance().text);
                holder.tvdur.setText(routes.get(0).getLegs().get(0).getSteps().get(position).getDuration().text);
                holder.tvway.setText(routes.get(0).getLegs().get(0).getSteps().get(position).html_instructions);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(context.getApplicationContext(), ShowRest.class);
                        i.putExtra("lat", String.valueOf(routes.get(0).getLegs().get(0).getSteps().get(position).start_location.getLat()));
                        i.putExtra("lng", String.valueOf(routes.get(0).getLegs().get(0).getSteps().get(position).start_location.getLng()));
                        context.startActivity(i);
                    }
                });
            } else {
                a2 = routes.get(0).getLegs().get(0).getSteps().get(position).getDistance().text;
                b2 = routes.get(0).getLegs().get(0).getSteps().get(position).getDuration().text;
                //if km then make it to meter
                Log.d(TAG, "onBindViewHolder: "+b2);
                for(int i=0;i<a2.length();i++){
                    if(a2.substring(i).matches("km")){
                        x2=Float.valueOf(a2.substring(0,i-1));
                        x2=x2*1000;
                        break;
                    }
                    else if(a2.substring(i).matches("m"))
                    {
                        x2=Float.valueOf(a2.substring(0,i-1));
                    }
                }
                z1 = (z1 + x2);
                if (z1 < 1000) {
                    holder.tvdist.setText(String.format("%.1f", z1) + " m");
                }
                if (z1 > 1000) {
                    z1 = z1 / 1000;
                    holder.tvdist.setText(String.format("%.1f", z1) + " km");
                    z1 = z1 * 1000;
                }

                for(int j=0;j<b2.length();j++){
                    if(b2.substring(j).matches("min")||b2.substring(j).matches("mins")){
                        m2=Integer.valueOf(b2.substring(0,j-1));
                    }
                    else
                    if(b2.substring(2,5).matches("hour")){
                        h2=Integer.valueOf(b2.substring(0,j-1));
                        for(int k=j+2;k<b2.length();k++){
                            if(b2.substring(k).matches("min")||b2.substring(k).matches("mins")){
                                m2=Integer.valueOf(b2.substring(j+2,k-1));
                                break;
                            }
                        }
                    }
                }

                if(h1!=0&&h2!=0){h1=h1+h2;}
                if(h1==0&&h2!=0){h1=h2;}
                if(m1!=0&&m2!=0){m1=m1+m2;}
                if(m1==0&&m2!=0){m1=m2;}
                if(m1>60){
                    h1=(m1-60)+1;
                    m1=m1-60;
                }
                if(h1>0){holder.tvdur.setText(h1+" hours"+m1+" minutes");}
                else
                {holder.tvdur.setText(m1+" minutes");}
                holder.tvway.setText(routes.get(0).getLegs().get(0).getSteps().get(position).html_instructions);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(context.getApplicationContext(), ShowRest.class);
                        i.putExtra("lat", String.valueOf(routes.get(0).getLegs().get(0).getSteps().get(position).start_location.getLat()));
                        i.putExtra("lng", String.valueOf(routes.get(0).getLegs().get(0).getSteps().get(position).start_location.getLng()));
                        context.startActivity(i);
                    }
                });
            }
    }


    @Override
    public int getItemCount() {
        return routes.get(0).getLegs().get(0).getSteps().size();
    }
    public class holderRoutes extends RecyclerView.ViewHolder{
        TextView tvdist;
        TextView tvdur;
        TextView tvway;
        View rootview;

        public holderRoutes(View itemView) {
            super(itemView);
            tvdist=itemView.findViewById(R.id.tvdist);
            tvdur=itemView.findViewById(R.id.tvdur);
            tvway=itemView.findViewById(R.id.tvway);
            rootview=itemView;
        }
    }


}
