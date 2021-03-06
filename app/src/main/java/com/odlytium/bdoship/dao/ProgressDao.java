package com.odlytium.bdoship.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.odlytium.bdoship.entity.ProgressEntity;

import java.util.List;

@Dao
public interface ProgressDao {

    @Query("SELECT * From progressentity_table")
    List<ProgressEntity> getAll();

    @Query("UPDATE progressentity_table SET haveMaterial = :have WHERE id_ship = :shipid AND id_material = :matid")
    public void inserthave(int have, int shipid, int matid);

    @Query("SELECT * FROM progressentity_table WHERE id_ship= :idship")
    List<ProgressEntity> getbyshipid(int idship);


    @Insert
    void insert(ProgressEntity progressEntity);

    @Update
    void update(ProgressEntity progressEntity);
}
