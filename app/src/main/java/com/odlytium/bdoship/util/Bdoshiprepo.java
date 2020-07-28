package com.odlytium.bdoship.util;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.odlytium.bdoship.dao.MatsDao;
import com.odlytium.bdoship.dao.OwnedprogressDao;
import com.odlytium.bdoship.dao.ProgressDao;
import com.odlytium.bdoship.dao.ShipDao;
import com.odlytium.bdoship.db.Bdoshipdb;
import com.odlytium.bdoship.entity.Material;
import com.odlytium.bdoship.entity.Ownedprogress;
import com.odlytium.bdoship.entity.ProgressEntity;
import com.odlytium.bdoship.entity.Ship;

import java.util.List;

public class Bdoshiprepo {
    private ShipDao shipDao;
    private MatsDao matsDao;
    private ProgressDao progressDao;
    private OwnedprogressDao ownedprogressDao;
    private LiveData<List<Ship>> allship;
    private LiveData<List<Material>> allmats;
    private LiveData<List<ProgressEntity>> allprogress;
    private LiveData<List<Ownedprogress>> allOwned;

    public Bdoshiprepo(Application application){
        Bdoshipdb database = Bdoshipdb.getInstance(application);
        shipDao = database.shipDao();
        matsDao = database.matsDao();
        progressDao = database.progressDao();
        ownedprogressDao = database.ownedprogressDao();
    }

    public LiveData<List<Ship>> getAllship() {
        return allship;
    }
    public LiveData<List<Material>> getAllmats() { return allmats;}
    public LiveData<List<ProgressEntity>> getAllprogress() { return allprogress;}
    public LiveData<List<Ownedprogress>> getAllOwned() { return allOwned;}
}
