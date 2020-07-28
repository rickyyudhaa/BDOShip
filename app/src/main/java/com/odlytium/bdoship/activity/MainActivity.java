package com.odlytium.bdoship.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.odlytium.bdoship.db.Bdoshipdb;
import com.odlytium.bdoship.entity.Material;
import com.odlytium.bdoship.entity.Ownedprogress;
import com.odlytium.bdoship.R;
import com.odlytium.bdoship.entity.Ship;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        final Bdoshipdb database = Bdoshipdb.getInstance(getApplicationContext());
        List<Ship> ships = database.shipDao().getAll();
        if (ships.isEmpty()) {
            Ship advance = new Ship("Carrack Advance", "",R.drawable.icon_advance, 40, 50, 1530, 18, 16500, 110, 115, 100, 115, 13);
            Ship balance = new Ship("Carrack Balance", "",R.drawable.icon_balance, 35, 50, 1620, 18, 15000, 115, 115, 100, 115, 12);
            Ship volante = new Ship("Carrack Volante", "",R.drawable.icon_volante, 20, 50, 1710, 18, 13500, 120, 125, 110, 125, 12);
            Ship valor = new Ship("Carrack Valor", "",R.drawable.icon_valor, 20, 50, 1800, 18, 13500, 115, 125, 110, 125, 11);

            database.shipDao().insert(advance);
            database.shipDao().insert(balance);
            database.shipDao().insert(volante);
            database.shipDao().insert(valor);
        }

        List<Material> mats = database.matsDao().getAll();
        if (mats.isEmpty()) {
            List<Material> materialList = new ArrayList<>();

            Material ruddy = new Material("Ruddy Manganese Nodule", R.drawable.icon_ruddy, 1500, true, true, true, 2);
            Material eitcp = new Material("Enhanced Island Tree Coated Plywood", R.drawable.icon_eitcp, 80, true, true, true, 10);
            Material sStalk = new Material("Seaweed Stalk", R.drawable.icon_sstalk, 600, true, true, true, 4);
            Material godi = new Material("Great Ocean Dark Iron", R.drawable.icon_godi, 160, true, false, true, 0);
            Material purepearl = new Material("Pure Pearl Crystal", R.drawable.icon_purepearl, 550, true, true, true, 2);
            Material pBeginner = new Material("Cox Pirates' Artifact (Parley Beginner)", R.drawable.icon_pbeginner, 150, true, false, true, 0);
            Material cCombat = new Material("Cox Pirates' Artifact (Combat)", R.drawable.icon_ccombat, 800, true, true, true, 3);
            Material moon = new Material("Moon Scale Plywood", R.drawable.icon_moon, 160, true, true, true, 10);
            Material tds = new Material("Tide-Dyed Standardized Timber Square", R.drawable.icon_tds, 350, true, true, true, 3);
            Material reef = new Material("Bright Reef Piece", R.drawable.icon_reef, 140, true, true, true, 8);
            Material pExpert = new Material("Cox Pirates' Artifact (Parley Expert)", R.drawable.icon_pexpert, 800, true, true, true, 1);
            Material luminous = new Material("Luminous Cobalt Ingot", R.drawable.icon_luminous, 800, true, false, true, 0);
            Material moonFabric = new Material("Moon Vein Flax Fabric", R.drawable.icon_fabric, 600, true, true, true, 3);
            Material dtds = new Material("Deep Tide-Dyed Standardized Timber Square", R.drawable.icon_dtds, 1000, true, true, true, 3);
            Material bRock = new Material("Brilliant Rock Salt Ingot", R.drawable.icon_brock, 1600, true, false, true, 0);
            Material tear = new Material("Tear of the Ocean ", R.drawable.icon_tear, 3900, true, true, true, 1);
            Material bPearl = new Material("Brilliant Pearl Shard", R.drawable.icon_bpearl, 1600, true, false, true, 0);
            Material cProw = new Material("Epheria Caravel: Brass Prow +10", R.drawable.icon_cprow, 0, false, false, false, 0);
            Material cPlat = new Material("Epheria Caravel: Upgraded Plating +10", R.drawable.icon_cplat, 0, false, false, false, 0);
            Material cSail = new Material("Epheria Caravel: White Wind Sail +10", R.drawable.icon_csail, 0, false, false, false, 0);
            Material cCannon = new Material("Epheria Caravel: Verisha Cannon +10", R.drawable.icon_ccannon, 0, false, false, false, 0);
            Material gProw = new Material("Epheria Galleass: White Horn Prow +10", R.drawable.icon_gprow, 0, false, false, false, 0);
            Material gPlat = new Material("Epheria Galleass: Upgraded Plating +10", R.drawable.icon_gplat, 0, false, false, false, 0);
            Material gSail = new Material("Epheria Galleass: White Wind Sail +10", R.drawable.icon_gsail, 0, false, false, false, 0);
            Material gCannon = new Material("Epheria Galleass: Verisha Cannon +10", R.drawable.icon_gcannon, 0, false, false, false, 0);

            materialList.add(ruddy);
            materialList.add(eitcp);
            materialList.add(sStalk);
            materialList.add(godi);
            materialList.add(purepearl);
            materialList.add(pBeginner);
            materialList.add(cCombat);
            materialList.add(moon);
            materialList.add(tds);
            materialList.add(reef);
            materialList.add(pExpert);
            materialList.add(luminous);
            materialList.add(moonFabric);
            materialList.add(dtds);
            materialList.add(bRock);
            materialList.add(tear);
            materialList.add(bPearl);
            materialList.add(cProw);
            materialList.add(cPlat);
            materialList.add(cSail);
            materialList.add(cCannon);
            materialList.add(gProw);
            materialList.add(gPlat);
            materialList.add(gSail);
            materialList.add(gCannon);

            database.matsDao().insertAll(materialList);
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
