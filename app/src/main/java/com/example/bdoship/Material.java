package com.example.bdoship;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.sql.Blob;

@Entity(tableName = "material_table", foreignKeys = @ForeignKey(entity = Ship.class, parentColumns = "id", childColumns = "id"))
public class Material {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private Blob image;

    private int price;

    private boolean barter, daily, coin;

    public Material(String name, Blob image, int price, boolean barter, boolean daily, boolean coin) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.barter = barter;
        this.daily = daily;
        this.coin = coin;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Blob getImage() {
        return image;
    }

    public int getPrice() {
        return price;
    }

    public boolean isBarter() {
        return barter;
    }

    public boolean isDaily() {
        return daily;
    }

    public boolean isCoin() {
        return coin;
    }

    public void setId(int id) {
        this.id = id;
    }
}
