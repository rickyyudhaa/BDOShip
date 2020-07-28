package com.example.bdoship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class progress extends AppCompatActivity {

    private Bdoshipdb dataBase;
    private List<Material> mats;

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

        TextView shiptype = findViewById(R.id.shiptype);
        shiptype.setText(ship.getType());
    }
}