package com.odlytium.bdoship.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.odlytium.bdoship.entity.Ship;

import java.util.List;

@Dao
public interface ShipDao {

    @Query("SELECT * From ship_table")
    List<Ship> getAll();

    @Query("SELECT * FROM ship_table WHERE id = :id_ship")
    Ship getbyshipid(long id_ship);

    /*@Query("SELECT * FROM ship_table WHERE id = :id_ship")
    Ship getbyshipidlong(long id_ship);*/

    @Insert
    void insert(Ship ship);

}


