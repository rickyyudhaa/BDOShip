package com.example.bdoship;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BdomatsAdapter extends RecyclerView.Adapter<BdomatsAdapter.BdomatsHolder>{

    List<Material> mats;

    public BdomatsAdapter(List<Material> mats){
        this.mats = mats;
    }

    @NonNull
    @Override
    public BdomatsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.material_list, parent, false);
        return new BdomatsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BdomatsHolder holder, int position) {
        Material currentMats = mats.get(position);

        holder.textViewName.setText(currentMats.getName()+"");
        holder.textViewCoins.setText(currentMats.getPrice()+"");
        holder.textViewDailies.setText("10");
        holder.textViewHave.setText("20");
    }

    @Override
    public int getItemCount() {
        return mats.size();
    }

    class BdomatsHolder extends RecyclerView.ViewHolder{
        private TextView textViewName;
        private TextView textViewHave;

        private TextView textViewNeed;

        private TextView textViewDailies;

        private TextView textViewCoins;

        public BdomatsHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.material_name);
            textViewHave = itemView.findViewById(R.id.mats_have);
            textViewNeed = itemView.findViewById(R.id.mats_need);
            textViewDailies = itemView.findViewById(R.id.mats_dailies);
            textViewCoins = itemView.findViewById(R.id.mats_coins);
        }
    }
}
