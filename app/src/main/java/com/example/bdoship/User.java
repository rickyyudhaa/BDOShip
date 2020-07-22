package com.example.bdoship;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int inventory;

    private String ships;

    public int getId() {
        return id;
    }

    public int getInventory() {
        return inventory;
    }

    public String getShips() {
        return ships;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public void setShips(String ships) {
        this.ships = ships;
    }
}
