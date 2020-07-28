package com.odlytium.bdoship.util;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.odlytium.bdoship.entity.Ship;

import java.util.List;

public class BdoshipViewModel extends AndroidViewModel{

    private Bdoshiprepo repository;
    private LiveData<List<Ship>> allShips;

    public BdoshipViewModel(@NonNull Application application) {
        super(application);
        repository = new Bdoshiprepo(application);
        allShips = repository.getAllship();
    }


}
