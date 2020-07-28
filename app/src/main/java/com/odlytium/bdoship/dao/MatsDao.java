package com.odlytium.bdoship.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.odlytium.bdoship.entity.Material;

import java.util.List;

@Dao
public interface MatsDao {

    @Query("SELECT * From material_table")
    List<Material> getAll();

    @Query("SELECT * FROM material_table WHERE id = :id_mats")
    Material getbyid(int id_mats);

    @Insert
    void insert(Material mats);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Material> mats);
}
