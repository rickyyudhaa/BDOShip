package com.example.bdoship;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface OwnedprogressDao {

    @Query("SELECT * From ownedprogress_table")
    List<Ownedprogress> getAll();

    @Query("SELECT * FROM ownedprogress_table WHERE id_ship = :id_ship")
    List<Ownedprogress> getbyshipid(int id_ship);

    @Query("SELECT * FROM ownedprogress_table WHERE id = :id")
    Ownedprogress getprogress(int id);

    @Insert
    long insert(Ownedprogress ownedprogress);
}
