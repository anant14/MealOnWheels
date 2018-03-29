package com.c2.mealonwheels.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

    public RoutesAdapter(Context context, ArrayList<com.c2.mealonwheels.Model.direction.routes> routes) {
        this.context = context;
        this.routes = routes;
    }

    @Override
    public holderRoutes onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview;
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemview=li.inflate(R.layout.route,parent,false);
        return new holderRoutes(itemview);
    }

    @Override
    public void onBindViewHolder(holderRoutes holder, final int position) {
        holder.tvdist.setText(routes.get(0).getLegs().get(0).getSteps().get(position).getDistance().text);
        holder.tvdur.setText(routes.get(0).getLegs().get(0).getSteps().get(position).getDuration().text);
        holder.tvway.setText(routes.get(0).getLegs().get(0).getSteps().get(position).html_instructions);

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
