package com.example.bdoship;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProgressDao {

    @Query("UPDATE progressentity_table SET haveMaterial = :have WHERE id_ship = :shipid AND id_material = :matid")
    public void inserthave(int have, int shipid, int matid);

    @Query("SELECT * FROM progressentity_table WHERE id_ship= :idship")
    ProgressEntity getbyshipid(int idship);

    @Insert
    void insert(ProgressEntity progressEntity);
}
