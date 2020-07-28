package com.odlytium.bdoship.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.odlytium.bdoship.R;

public class proglistempty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proglistempty);

        Button button = (Button) findViewById(R.id.addprogress);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(proglistempty.this, chooseship.class);*/
                Intent intent = new Intent(proglistempty.this, chooseship.class);
                startActivity(intent);
            }
        });
    }
}