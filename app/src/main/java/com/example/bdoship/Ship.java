package com.example.bdoship;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "ship_table", foreignKeys = @ForeignKey(entity = User.class, parentColumns = "id", childColumns = "User_id"))
public class Ship {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String type, material;

    private int inventory, cabins, cannonballs, cannons, lt;

    public Ship(String type, String material, int inventory, int cabins, int cannonballs, int cannons, int lt) {
        this.type = type;
        this.material = material;
        this.inventory = inventory;
        this.cabins = cabins;
        this.cannonballs = cannonballs;
        this.cannons = cannons;
        this.lt = lt;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getMaterial() {
        return material;
    }

    public int getInventory() {
        return inventory;
    }

    public int getCabins() {
        return cabins;
    }

    public int getCannonballs() {
        return cannonballs;
    }

    public int getCannons() {
        return cannons;
    }

    public int getLt() {
        return lt;
    }

    public void setId(int id) {
        this.id = id;
    }
}
