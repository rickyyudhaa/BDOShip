package com.example.bdoship;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public class ShipDao {

    @Query("SELECT type,inventory,cabins,cannonballs,cannons,lt From ship_table")
    List<Ship> getAll();
}
