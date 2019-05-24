package com.example.cukcuklitedemo.data.model;

import java.io.Serializable;

public class Unit implements Serializable {
    private int unitId;
    private String unitName;
    private int countChose = 0;

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

    public int getCountChose() {
        return countChose;
    }

    public void setCountChose(int countChose) {
        this.countChose = countChose;
    }
}
