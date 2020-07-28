package com.example.bdoship;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.List;

public class MaterialAdapter extends RecyclerView.Adapter<MaterialAdapter.BdomatsHolder> {

    List<ProgressEntity> progressEntities;

    Context mcontext;

    public MaterialAdapter(List<ProgressEntity> mats, Context context) {
        this.progressEntities = mats;
        this.mcontext = context;
    }

    @NonNull
    @Override
    public BdomatsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.material_list, parent, false);
        return new BdomatsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final BdomatsHolder holder, int position) {
        final ProgressEntity progressEntity = progressEntities.get(position);
        final Bdoshipdb database = Bdoshipdb.getInstance(mcontext);

        final Ship currentShips = database.shipDao().getbyshipid(progressEntity.getId_ship());
        final Material currentMats = database.matsDao().getbyid(progressEntity.getId_material());


        holder.textViewName.setText(currentMats.getName() + "");
        holder.textViewNeed.setText(progressEntity.need() + "");
        holder.textViewCoins.setText(currentMats.getPrice() + "");
        holder.textViewDailies.setText(progressEntity.dailieleft(currentMats.getQtyperday()) + "");
        holder.editTextHave.setText(progressEntity.getHaveMaterial()+"");
        holder.editTextHave.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String haveNew = s.toString();
                if (!haveNew.equals("")) {
                    int newHave = Integer.parseInt(haveNew);
                    database.progressDao().inserthave(newHave, currentShips.getId(), currentMats.getId());
                }
            }
        });
        holder.textViewPercent.setText(progressEntity.precentage()+"%");
        holder.imageViewicon.setBackgroundResource(currentMats.getImage());
    }

    @Override
    public int getItemCount() {
        return progressEntities.size();
    }

    class BdomatsHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private EditText editTextHave;
        private TextView textViewPercent;
        private TextView textViewNeed;
        private TextView textViewDailies;
        private TextView textViewCoins;
        private ImageView imageViewicon;
        private TextView textViewshiptype;


        public BdomatsHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.material_name);
            editTextHave = itemView.findViewById(R.id.mats_have);
            textViewNeed = itemView.findViewById(R.id.mats_need);
            textViewDailies = itemView.findViewById(R.id.mats_dailies);
            textViewCoins = itemView.findViewById(R.id.mats_coins);
            imageViewicon = itemView.findViewById(R.id.mat_icon);
            textViewPercent = itemView.findViewById(R.id.mats_percentage);
            textViewshiptype = itemView.findViewById(R.id.shiptype);
        }
    }
}
