package com.example.bdoship;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

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
