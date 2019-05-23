package com.example.cukcuklitedemo.data.source;

import com.example.cukcuklitedemo.data.model.ColorBackground;
import com.example.cukcuklitedemo.data.model.Product;
import com.example.cukcuklitedemo.data.model.Unit;

import java.util.List;

public interface IProductDataSource {

    List<Product> getListProduct();
    List<ColorBackground> getListColorBackground();
    List<Unit> getListUnit();

    boolean insertProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(int productId);

    boolean insertUnit(Unit unit);
    boolean updateUnit(Unit unit);
    boolean deleteUnit(int productId);

}
