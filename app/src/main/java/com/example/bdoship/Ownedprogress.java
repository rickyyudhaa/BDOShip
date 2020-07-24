package com.example.bdoship;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ownedprogress_table")
public class Ownedprogress {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int id_ship;

    public Ownedprogress(int id_ship) {
        this.id_ship = id_ship;
    }

    public int getId_ship() {
        return id_ship;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
