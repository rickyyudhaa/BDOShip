package com.odlytium.bdoship.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.odlytium.bdoship.db.Bdoshipdb;
import com.odlytium.bdoship.R;
import com.odlytium.bdoship.entity.Material;
import com.odlytium.bdoship.entity.Ownedprogress;
import com.odlytium.bdoship.entity.ProgressEntity;
import com.odlytium.bdoship.entity.Ship;
import com.odlytium.bdoship.activity.progress;

import java.text.DecimalFormat;
import java.util.List;

public class OwnedProgressAdapter extends RecyclerView.Adapter<OwnedProgressAdapter.BdoOwnedHolder>{

    List<Ownedprogress> ownedprogressList;

    Context mcontext;

    public OwnedProgressAdapter(List<Ownedprogress> ownedprogressList, Context context){
        this.ownedprogressList = ownedprogressList;
        this.mcontext = context;
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
        final Ownedprogress currentOwned = ownedprogressList.get(position);
        Bdoshipdb database = Bdoshipdb.getInstance(mcontext);
        List<ProgressEntity> progressEntity = database.progressDao().getbyshipid(currentOwned.getId());
        Ship ship = database.shipDao().getbyshipid(currentOwned.getId_ship());

        holder.textViewShiptype.setText(ship.getType());
        holder.textViewDaysleft.setText(getMax(progressEntity)+"");
        holder.textViewPercent.setText(getAveragePercentage(progressEntity)+"");
        holder.imageViewship.setBackgroundResource(ship.getIcon());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, progress.class);
                intent.putExtra("id", currentOwned.getId());
                intent.putExtra("ship_id", currentOwned.getId_ship());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mcontext.startActivity(intent);
            }
        });
    }

    private String getMax(List<ProgressEntity> progressEntityList){
        double max=0;
        Bdoshipdb database = Bdoshipdb.getInstance(mcontext);

        for (ProgressEntity progressEntity :progressEntityList){

            Material material = database.matsDao().getbyid(progressEntity.getId_material());
            List<Material> material2 = database.matsDao().getAll();

            double dLeft = progressEntity.dailieleft(material.getQtyperday());
            Log.d("materaial", "total material :"+dLeft);

            if (dLeft>max){
                max = dLeft;
            }
        }
        return new DecimalFormat("###.#").format(max) ;
    }

    private String getAveragePercentage(List<ProgressEntity> progressEntityList){

        double total=0;

        for (ProgressEntity progressEntity :progressEntityList){
            total+=progressEntity.precentage();
        }
        return new DecimalFormat("###.#").format(total/progressEntityList.size()) ;
    }

    @Override
    public int getItemCount() {
        return ownedprogressList.size();
    }




    public class BdoOwnedHolder extends RecyclerView.ViewHolder{

        private TextView textViewShiptype;
        private TextView textViewDaysleft;
        private TextView textViewPercent;
        private View view;
        private ImageView imageViewship;

        public BdoOwnedHolder(@NonNull View itemView) {
            super(itemView);
            textViewShiptype = itemView.findViewById(R.id.owned_shiptype);
            textViewDaysleft = itemView.findViewById(R.id.owned_days);
            textViewPercent = itemView.findViewById(R.id.owned_percentage);
            view = itemView;
            imageViewship = itemView.findViewById(R.id.ship_icon);

        }
    }
}
