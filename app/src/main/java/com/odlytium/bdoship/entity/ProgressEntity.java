package com.odlytium.bdoship.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "progressentity_table")
public class ProgressEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int id_material, haveMaterial, reqMaterial;

    private long id_ship;

    public ProgressEntity(long id_ship, int id_material, int haveMaterial, int reqMaterial) {
        this.id_ship = id_ship;
        this.id_material = id_material;
        this.haveMaterial = haveMaterial;
        this.reqMaterial = reqMaterial;
    }

    public int need(){
        return reqMaterial - haveMaterial;
    }

    public int precentage(){
        double persen = ((double)haveMaterial / (double)reqMaterial)*100;
        return (int) persen;
    }

    public int dailieleft(int qtyperday){
        if (qtyperday <= 0){
            return 0;
        }
        double daili = need() / qtyperday;
        return (int) daili;
    }

    public int coinsleft(int price){
        return need() - price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getId_ship() {
        return id_ship;
    }

    public void setId_ship(int id_ship) {
        this.id_ship = id_ship;
    }

    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
    }

    public int getHaveMaterial() {
        return haveMaterial;
    }

    public void setHaveMaterial(int haveMaterial) {
        this.haveMaterial = haveMaterial;
    }

    public int getReqMaterial() {
        return reqMaterial;
    }

    public void setReqMaterial(int reqMaterial) {
        this.reqMaterial = reqMaterial;
    }
}
