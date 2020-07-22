package com.example.bdoship;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MatsDao {

    @Query("SELECT * From material_table")
    List<Material> getAll();

    @Insert
    void insert(Material mats);
}
