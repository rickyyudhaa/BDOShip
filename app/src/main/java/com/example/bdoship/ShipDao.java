package com.example.bdoship;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ShipDao {

    @Query("SELECT * From ship_table")
    List<Ship> getAll();

    @Insert
    void insert(Ship ship);

}


