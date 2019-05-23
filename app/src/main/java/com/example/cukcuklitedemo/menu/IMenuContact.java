package com.example.cukcuklitedemo.menu;

import com.example.cukcuklitedemo.data.model.Product;

import java.util.List;

public interface IMenuContact  {
    interface IView{

    }

    interface IPresenter{

        List<Product> getListProduct();
    }
}
