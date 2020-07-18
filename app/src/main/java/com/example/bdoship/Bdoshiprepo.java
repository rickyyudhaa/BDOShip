package com.example.bdoship;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Bdoshiprepo {
    private ShipDao shipDao;
    private LiveData<List<Ship>> allship;

    public Bdoshiprepo(Application application){
        Bdoshipdb database = Bdoshipdb.getInstance(application);
        shipDao = database.shipDao();
        allship = shipDao.getAll();
    }

    public LiveData<List<Ship>> getAllship() {
        return allship;
    }
}
