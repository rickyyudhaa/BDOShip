package com.example.bdoship;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BdoshipAdapter extends RecyclerView.Adapter<BdoshipAdapter.BdoshipHolder>{

    List<Ship> ships;

    public BdoshipAdapter(List<Ship> ships) {
        this.ships = ships;
    }

    @NonNull
    @Override
    public BdoshipHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ship_list, parent, false);
        return new BdoshipHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull BdoshipHolder holder, int position) {
        Ship currentShip = ships.get(position);
        holder.textViewShiptype.setText(currentShip.getType());
        holder.textViewInventory.setText(currentShip.getInventory()+"");
        holder.textViewlt.setText(currentShip.getLt()+"");
        holder.textViewCannon.setText(currentShip.getCannons()+"");
        holder.textViewCannonballs.setText(currentShip.getCannonballs()+"");
        holder.textViewCabins.setText(currentShip.getCabins()+"");
        holder.textViewSpeed.setText(currentShip.getSpeed()+"%");
        holder.textViewTurn.setText(currentShip.getTurn()+"%");
        holder.textViewAccel.setText(currentShip.getAccel()+"%");
        holder.textViewBrake.setText(currentShip.getBrake()+"%");
        holder.textViewReload.setText(currentShip.getReload()+" Seconds");
    }

    @Override
    public int getItemCount() {
        return ships.size();
    }

    class BdoshipHolder extends RecyclerView.ViewHolder{
        private TextView textViewShiptype;
        private TextView textViewInventory;
        private TextView textViewCabins;
        private TextView textViewCannonballs;
        private TextView textViewCannon;
        private TextView textViewlt;
        private TextView textViewSpeed;
        private TextView textViewTurn;
        private TextView textViewAccel;
        private TextView textViewBrake;
        private TextView textViewReload;

        public BdoshipHolder(@NonNull View itemView) {
            super(itemView);
            textViewShiptype = itemView.findViewById(R.id.shiptype);
            textViewInventory = itemView.findViewById(R.id.ship_inv);
            textViewCabins = itemView.findViewById(R.id.ship_cabins);
            textViewCannonballs = itemView.findViewById(R.id.ship_cballs);
            textViewCannon = itemView.findViewById(R.id.ship_cannons);
            textViewlt = itemView.findViewById(R.id.ship_lt);
            textViewSpeed = itemView.findViewById(R.id.ship_speed);
            textViewTurn = itemView.findViewById(R.id.ship_turn);
            textViewAccel = itemView.findViewById(R.id.ship_turn);
            textViewBrake = itemView.findViewById(R.id.ship_brake);
            textViewReload = itemView.findViewById(R.id.ship_reload);
        }
    }
}
