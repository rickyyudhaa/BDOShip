package com.example.bdoship;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OwnedProgressAdapter extends RecyclerView.Adapter<OwnedProgressAdapter.BdoOwnedHolder>{

    List<Ownedprogress> ownedprogressList;

    public OwnedProgressAdapter(List<Ownedprogress> ownedprogressList){
        this.ownedprogressList = ownedprogressList;
    }

    @NonNull
    @Override
    public BdoOwnedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.owned_list, parent, false);
        return new BdoOwnedHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BdoOwnedHolder holder, int position) {
        Ownedprogress currentOwned = ownedprogressList.get(position);

        holder.textViewShiptype.setText("Carrack Advance");
        holder.textViewDaysleft.setText("70");
        holder.textViewPercent.setText("0");
    }

    @Override
    public int getItemCount() {
        return ownedprogressList.size();
    }




    public class BdoOwnedHolder extends RecyclerView.ViewHolder{

        private TextView textViewShiptype;
        private TextView textViewDaysleft;
        private TextView textViewPercent;

        public BdoOwnedHolder(@NonNull View itemView) {
            super(itemView);
            textViewShiptype = itemView.findViewById(R.id.owned_shiptype);
            textViewDaysleft = itemView.findViewById(R.id.owned_days);
            textViewPercent = itemView.findViewById(R.id.owned_percentage);

        }
    }
}
