package com.odlytium.bdoship.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.odlytium.bdoship.db.Bdoshipdb;
import com.odlytium.bdoship.listener.Onshipselectedlistener;
import com.odlytium.bdoship.R;
import com.odlytium.bdoship.entity.Ship;
import com.odlytium.bdoship.adapter.ShipAdapter;

import java.util.List;

public class chooseship extends AppCompatActivity {

    private Bdoshipdb dataBase;
    private List<Ship> ships;
    private ShipAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseship);
        dataBase = Bdoshipdb.getInstance(getApplicationContext());

        ships = dataBase.shipDao().getAll();

        RecyclerView recyclerView = findViewById(R.id.rcship);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        adapter = new ShipAdapter(ships,getApplicationContext());
        adapter.setSelectedlistener(new Onshipselectedlistener() {
            @Override
            public void shipselectedlistener(int id_ship) {
                Intent intent = new Intent(chooseship.this, proglist.class);
                intent.putExtra("id_ship", id_ship);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

    }
}