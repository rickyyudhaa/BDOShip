package com.example.bdoship;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShipAdapter extends RecyclerView.Adapter<ShipAdapter.BdoshipHolder> {

    List<Ship> ships;

    Onshipselectedlistener onshipselectedlistener;

    Context mcontext;

    public ShipAdapter(List<Ship> ships, Context context) {
        this.ships = ships;
        this.mcontext = context;
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
        final Ship currentShip = ships.get(position);
        holder.textViewShiptype.setText(currentShip.getType());
        holder.textViewInventory.setText(currentShip.getInventory() + "");
        holder.textViewlt.setText(currentShip.getLt() + "");
        holder.textViewCannon.setText(currentShip.getCannons() + "");
        holder.textViewCannonballs.setText(currentShip.getCannonballs() + "");
        holder.textViewCabins.setText(currentShip.getCabins() + "");
        holder.textViewSpeed.setText(currentShip.getSpeed() + "%");
        holder.textViewTurn.setText(currentShip.getTurn() + "%");
        holder.textViewAccel.setText(currentShip.getAccel() + "%");
        holder.textViewBrake.setText(currentShip.getBrake() + "%");
        holder.textViewReload.setText(currentShip.getReload() + " S");
        holder.imageViewship.setBackgroundResource(currentShip.getIcon());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onshipselectedlistener.shipselectedlistener(currentShip.getId());
                Bdoshipdb database = Bdoshipdb.getInstance(mcontext);
                long id = database.ownedprogressDao().insert(new Ownedprogress(currentShip.getId()));

                if (currentShip.getId() == 1) {
                    int[] matsreq = {90, 300, 205, 150, 45, 60, 120, 400, 180, 180, 30, 30, 180, 144, 35, 42, 35, 1, 1, 1, 1};
                    int[] matsid = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
                    for (int idmats = 0; idmats < matsid.length; idmats++) {
                        ProgressEntity advance = new ProgressEntity(id, matsid[idmats], 0, matsreq[idmats]);
                        database.progressDao().insert(advance);
                    }
                } else if (currentShip.getId() == 2) {
                    int[] matsreq2 = {90, 300, 205, 150, 45, 60, 120, 400, 180, 180, 30, 30, 180, 144, 30, 50, 30, 1, 1, 1, 1};
                    int[] matsid2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
                    for (int idmats = 0; idmats < matsid2.length; idmats++) {
                        ProgressEntity balance = new ProgressEntity(id, matsid2[idmats], 0, matsreq2[idmats]);
                        database.progressDao().insert(balance);
                    }
                } else if (currentShip.getId() == 3) {

                    int[] matsreq3 = {100, 300, 250, 150, 45, 60, 250, 600, 180, 180, 30, 30, 210, 144, 30, 42, 30, 1, 1, 1, 1};
                    int[] matsid3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 22, 23, 24, 25};
                    for (int idmats = 0; idmats < matsid3.length; idmats++) {
                        ProgressEntity volante = new ProgressEntity(id, matsid3[idmats], 0, matsreq3[idmats]);
                        database.progressDao().insert(volante);
                    }
                } else {

                    int[] matsreq4 = {100, 300, 250, 150, 45, 60, 250, 600, 180, 180, 30, 30, 180, 170, 30, 42, 30, 1, 1, 1, 1};
                    int[] matsid4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 22, 23, 24, 25};
                    for (int idmats = 0; idmats < matsid4.length; idmats++) {
                        ProgressEntity valor = new ProgressEntity(id, matsid4[idmats], 0, matsreq4[idmats]);
                        database.progressDao().insert(valor);
                    }
                }
            }
        });
    }

    void setSelectedlistener(Onshipselectedlistener onshipselectedlistener){
        this.onshipselectedlistener = onshipselectedlistener;
    }

    @Override
    public int getItemCount() {
        return ships.size();
    }

    class BdoshipHolder extends RecyclerView.ViewHolder {
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
        private View view;
        private ImageView imageViewship;

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
            imageViewship = itemView.findViewById(R.id.ship_icon);
            view = itemView;
        }
    }
}
