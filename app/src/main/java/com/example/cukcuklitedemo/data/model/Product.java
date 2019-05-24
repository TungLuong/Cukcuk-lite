package com.example.cukcuklitedemo.data.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String productName;
    private String productPrice;
    private Unit unit;
    private ColorBackground background;
    private String iconName;
    private int isSellStop = 0;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public ColorBackground getBackground() {
        return background;
    }

    public void setBackground(ColorBackground background) {
        this.background = background;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public int getIsSellStop() {
        return isSellStop;
    }

    public void setIsSellStop(int isSellStop) {
        this.isSellStop = isSellStop;
    }
}
