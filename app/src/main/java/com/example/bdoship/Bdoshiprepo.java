package com.example.bdoship;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Bdoshiprepo {
    private ShipDao shipDao;
    private MatsDao matsDao;
    private LiveData<List<Ship>> allship;
    private LiveData<List<Material>> allmats;

    public Bdoshiprepo(Application application){
        Bdoshipdb database = Bdoshipdb.getInstance(application);
        shipDao = database.shipDao();
        matsDao = database.matsDao();
        /*allship = shipDao.getAll();*/
    }

    public LiveData<List<Ship>> getAllship() {
        return allship;
    }
    public LiveData<List<Material>> getAllmats() { return allmats;}
}
