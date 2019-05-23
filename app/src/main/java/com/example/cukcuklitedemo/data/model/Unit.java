package com.example.cukcuklitedemo.data.model;

import java.io.Serializable;

public class Unit implements Serializable {
    private int unitId;
    private String unitName;
    private int isChose = 0;

    public Unit() {
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public int getIsChose() {
        return isChose;
    }

    public void setIsChose(int isChose) {
        this.isChose = isChose;
    }
}
