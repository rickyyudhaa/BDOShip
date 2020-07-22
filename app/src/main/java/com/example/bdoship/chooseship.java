package com.example.bdoship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class chooseship extends AppCompatActivity {

    private Bdoshipdb dataBase;
    private List<Ship> ships;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseship);
        dataBase = Bdoshipdb.getInstance(getApplicationContext());

        ships = dataBase.shipDao().getAll();

        RecyclerView recyclerView = findViewById(R.id.rcship);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final BdoshipAdapter adapter = new BdoshipAdapter(ships);
        recyclerView.setAdapter(adapter);

    }
}