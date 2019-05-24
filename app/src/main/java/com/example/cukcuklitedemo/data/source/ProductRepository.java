package com.example.cukcuklitedemo.data.source;

import android.content.Context;

import com.example.cukcuklitedemo.data.model.ColorBackground;
import com.example.cukcuklitedemo.data.model.Product;
import com.example.cukcuklitedemo.data.model.Unit;
import com.example.cukcuklitedemo.data.source.Bd.ProductHelper;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductDataSource {

    private static ProductRepository sInstance;
    private IProductDataSource productHelper;


    private ProductRepository(Context context) {
        if (productHelper == null) productHelper = ProductHelper.getInstance(context);
    }

    public static ProductRepository getInstance(Context context) {
        if (sInstance == null) sInstance = new ProductRepository(context);
        return sInstance;
    }

    @Override
    public List<Product> getListProduct() {
        List<Product> products = new ArrayList<>();
        try {
            products = productHelper.getListProduct();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<ColorBackground> getListColorBackground() {
        return null;
    }

    @Override
    public List<Unit> getListUnit() {
        List<Unit> units = new ArrayList<>();
        try {
            units = productHelper.getListUnit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return units;
    }

    @Override
    public boolean insertProduct(Product product) {

        try {
            return productHelper.insertProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteProduct(Product product) {
        try {
            return productHelper.deleteProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean insertUnit(Unit unit) {
        try {
            return productHelper.insertUnit(unit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUnit(Unit unit) {
        try {
            return productHelper.updateUnit(unit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUnit(int unitId) {
        try {
            return productHelper.deleteUnit(unitId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Unit getUnitById(int unitId) {
        try {
            productHelper.getUnitById(unitId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Unit();
    }
}
