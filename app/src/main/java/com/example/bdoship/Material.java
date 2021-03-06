package com.example.bdoship;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.sql.Blob;

@Entity(tableName = "material_table")
public class Material {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private int image;

    private int price, qtyperday;

    private boolean barter, daily, coin;

    public Material(String name, int image, int price, boolean barter, boolean daily, boolean coin, int qtyperday) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.barter = barter;
        this.daily = daily;
        this.coin = coin;
        this.qtyperday = qtyperday;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
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

    public int getQtyperday() {
        return qtyperday;
    }
}
