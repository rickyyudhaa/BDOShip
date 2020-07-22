package com.example.bdoship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class progress extends AppCompatActivity {

    private Bdoshipdb dataBase;
    private List<Material> mats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        dataBase = Bdoshipdb.getInstance(getApplicationContext());

        mats = dataBase.matsDao().getAll();

        RecyclerView recyclerView = findViewById(R.id.progress_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final BdomatsAdapter adapter = new BdomatsAdapter(mats);
        recyclerView.setAdapter(adapter);
    }
}