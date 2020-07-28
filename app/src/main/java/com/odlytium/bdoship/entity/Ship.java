package com.odlytium.bdoship.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ship_table")
public class Ship {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String type, material;

    private int icon, inventory, cabins, cannonballs, cannons, lt, speed, turn, accel, brake, reload;

    public Ship(String type, String material, int icon , int inventory, int cabins, int cannonballs, int cannons, int lt, int speed, int turn, int accel, int brake, int reload) {
        this.type = type;
        this.icon = icon;
        this.material = material;
        this.inventory = inventory;
        this.cabins = cabins;
        this.cannonballs = cannonballs;
        this.cannons = cannons;
        this.lt = lt;
        this.speed = speed;
        this.turn = turn;
        this.accel = accel;
        this.brake = brake;
        this.reload = reload;
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

    public int getIcon() {
        return icon;
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

    public int getSpeed() {
        return speed;
    }

    public int getTurn() {
        return turn;
    }

    public int getAccel() {
        return accel;
    }

    public int getBrake() {
        return brake;
    }

    public int getReload() {
        return reload;
    }

    public void setId(int id) {
        this.id = id;
    }
}
