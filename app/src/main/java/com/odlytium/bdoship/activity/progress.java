package com.odlytium.bdoship.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.odlytium.bdoship.db.Bdoshipdb;
import com.odlytium.bdoship.listener.ButtonPressedListener;
import com.odlytium.bdoship.entity.Material;
import com.odlytium.bdoship.adapter.MaterialAdapter;
import com.odlytium.bdoship.entity.ProgressEntity;
import com.odlytium.bdoship.R;
import com.odlytium.bdoship.entity.Ship;

import java.util.List;

public class progress extends AppCompatActivity {

    private Bdoshipdb dataBase;
    private List<Material> mats;
    private List<ProgressEntity> progressEntities;
    private MaterialAdapter adapter;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(progress.this, proglist.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        final Intent intent = getIntent();
        final int id = intent.getIntExtra("id",0);
        final int ship_id = intent.getIntExtra("ship_id",0);
        dataBase = Bdoshipdb.getInstance(getApplicationContext());

        final List<ProgressEntity> progressEntity = dataBase.progressDao().getbyshipid(id);

        Ship ship = dataBase.shipDao().getbyshipid(ship_id);
        mats = dataBase.matsDao().getAll();

        RecyclerView recyclerView = findViewById(R.id.progress_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final MaterialAdapter adapter = new MaterialAdapter(progressEntity,getApplicationContext());
        recyclerView.setAdapter(adapter);
        adapter.setButtonpressedlistener(new ButtonPressedListener() {
            @Override
            public void buttonpressedlistener(int id_progress) {
                finish();
                startActivity(getIntent());
            }
        });
        recyclerView.setAdapter(adapter);

        TextView shiptype = findViewById(R.id.shiptype);
        shiptype.setText(ship.getType());
    }
}