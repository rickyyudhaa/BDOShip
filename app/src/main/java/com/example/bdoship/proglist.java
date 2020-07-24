package com.example.bdoship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class proglist extends AppCompatActivity {

    private Bdoshipdb dataBase;
    private List<Ownedprogress> ownedprogressList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proglist);
        dataBase = Bdoshipdb.getInstance(getApplicationContext());

        ownedprogressList = dataBase.ownedprogressDao().getAll();

        RecyclerView recyclerView = findViewById(R.id.owned_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final OwnedProgressAdapter adapter = new OwnedProgressAdapter(ownedprogressList);
        recyclerView.setAdapter(adapter);
    }
}