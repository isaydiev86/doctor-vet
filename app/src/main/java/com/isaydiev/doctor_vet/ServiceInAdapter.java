package com.isaydiev.doctor_vet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.isaydiev.doctor_vet.Models.Item;

import java.util.ArrayList;

/**
 * Created by USER on 20.04.2017.
 */

public class ServiceInAdapter extends RecyclerView.Adapter<ServiceInAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Item> serviceInList;

    public ServiceInAdapter(Context context, ArrayList<Item> serviceInList) {
        this.context = context;
        this.serviceInList = serviceInList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.service_in_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = serviceInList.get(position);
        holder.twoTitle.setText(item.getTitle());
        holder.threeTitle.setText(item.getTitle());
        holder.twoPrice.setText(item.getPrice());
        holder.threePrice.setText(item.getPrice());
    }

    @Override
    public int getItemCount() {
        return serviceInList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView twoTitle, threeTitle, twoPrice, threePrice;
        public ViewHolder(View itemView) {
            super(itemView);
            twoTitle = (TextView)itemView.findViewById(R.id.service_two_title);
            threeTitle = (TextView)itemView.findViewById(R.id.price_three_title);
            twoPrice = (TextView)itemView.findViewById(R.id.price_two_title);
            threePrice = (TextView)itemView.findViewById(R.id.price_three_title);
        }
    }
}
