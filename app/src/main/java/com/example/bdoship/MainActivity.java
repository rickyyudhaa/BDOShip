package com.example.bdoship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        final Bdoshipdb database = Bdoshipdb.getInstance(getApplicationContext());
        List<Ship> ships = database.shipDao().getAll();
        if (ships.isEmpty()) {
            Ship advance = new Ship("Carrack Advance", "", 40, 50, 1530, 18, 16500, 110, 115, 100, 115, 13);
            Ship balance = new Ship("Carrack Balance", "", 35, 50, 1620, 18, 15000, 115, 115, 100, 115, 12);
            Ship volante = new Ship("Carrack Volante", "", 20, 50, 1710, 18, 13500, 120, 125, 110, 125, 12);
            Ship valor = new Ship("Carrack Valor", "", 20, 50, 1800, 18, 13500, 115, 125, 110, 125, 11);

            database.shipDao().insert(advance);
            database.shipDao().insert(balance);
            database.shipDao().insert(volante);
            database.shipDao().insert(valor);
        }

        List<Material> mats = database.matsDao().getAll();
        if (mats.isEmpty()) {
            Material ruddy = new Material("Ruddy Manganese Nodule", "", 1500, true, true, true, 2);
            Material eitcp = new Material("Enhanced Island Tree Coated Plywood", "", 80, true, true, true, 10);
            Material sStalk = new Material("Seaweed Stalk", "", 600, true, true, true, 4);
            Material godi = new Material("Great Ocean Dark Iron", "", 160, true, false, true, 0);
            Material purepearl = new Material("Pure Pearl Crystal", "", 550, true, true, true, 2);
            Material pBeginner = new Material("Cox Pirates' Artifact (Parley Beginner)", "", 150, true, false, true, 0);
            Material cCombat = new Material("Cox Pirates' Artifact (Combat)", "", 800, true, true, true, 3);
            Material moon = new Material("Moon Scale Plywood", "", 160, true, true, true, 10);
            Material tds = new Material("Tide-Dyed Standardized Timber Square", "", 350, true, true, true, 3);
            Material reef = new Material("Bright Reef Piece", "", 140, true, true, true, 8);
            Material pExpert = new Material("Cox Pirates' Artifact (Parley Expert)", "", 800, true, true, true, 1);
            Material luminous = new Material("Luminous Cobalt Ingot", "", 800, true, false, true, 0);
            Material moonFabric = new Material("Moon Vein Flax Fabric", "", 600, true, true, true, 3);
            Material dtds = new Material("Deep Tide-Dyed Standardized Timber Square", "", 1000, true, true, true, 3);
            Material bRock = new Material("Brilliant Rock Salt Ingot", "", 1600, true, false, true, 0);
            Material tear = new Material("Tear of the Ocean ", "", 3900, true, true, true, 1);
            Material bPearl = new Material("Brilliant Pearl Shard", "", 1600, true, false, true, 0);
            Material cProw = new Material("Epheria Caravel: Brass Prow +10", "", 0, false, false, false, 0);
            Material cPlat = new Material("Epheria Caravel: Upgraded Plating +10", "", 0, false, false, false, 0);
            Material cSail = new Material("Epheria Caravel: White Wind Sail +10", "", 0, false, false, false, 0);
            Material cCannon = new Material("Epheria Caravel: Verisha Cannon +10", "", 0, false, false, false, 0);
            Material gProw = new Material("Epheria Galleass: White Horn Prow +10", "", 0, false, false, false, 0);
            Material gPlat = new Material("Epheria Galleass: Upgraded Plating +10", "", 0, false, false, false, 0);
            Material gSail = new Material("Epheria Galleass: White Wind Sail +10", "", 0, false, false, false, 0);
            Material gCannon = new Material("Epheria Galleass: Verisha Cannon +10", "", 0, false, false, false, 0);

            database.matsDao().insert(ruddy);
            database.matsDao().insert(eitcp);
            database.matsDao().insert(sStalk);
            database.matsDao().insert(godi);
            database.matsDao().insert(purepearl);
            database.matsDao().insert(pBeginner);
            database.matsDao().insert(cCombat);
            database.matsDao().insert(moon);
            database.matsDao().insert(tds);
            database.matsDao().insert(reef);
            database.matsDao().insert(pExpert);
            database.matsDao().insert(luminous);
            database.matsDao().insert(moonFabric);
            database.matsDao().insert(dtds);
            database.matsDao().insert(bRock);
            database.matsDao().insert(tear);
            database.matsDao().insert(bPearl);
            database.matsDao().insert(cProw);
            database.matsDao().insert(cPlat);
            database.matsDao().insert(cSail);
            database.matsDao().insert(cCannon);
            database.matsDao().insert(gProw);
            database.matsDao().insert(gPlat);
            database.matsDao().insert(gSail);
            database.matsDao().insert(gCannon);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<Ownedprogress> ownedprogressList = database.ownedprogressDao().getAll();
                if (ownedprogressList.size() > 0) {
                    Intent intent = new Intent(MainActivity.this, proglist.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(MainActivity.this, proglistempty.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, SPLASH_SCREEN);
    }
}
