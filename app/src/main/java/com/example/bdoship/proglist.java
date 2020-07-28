package com.example.bdoship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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

        final OwnedProgressAdapter adapter = new OwnedProgressAdapter(ownedprogressList,getApplicationContext());
        recyclerView.setAdapter(adapter);

        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.fab);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(proglistempty.this, chooseship.class);*/
                Intent intent = new Intent(proglist.this, chooseship.class);
                startActivity(intent);
            }
        });
    }
}