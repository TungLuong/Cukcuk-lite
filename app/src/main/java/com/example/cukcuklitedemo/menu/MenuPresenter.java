package com.example.cukcuklitedemo.menu;

import com.example.cukcuklitedemo.data.model.Product;
import com.example.cukcuklitedemo.data.source.IProductDataSource;

import java.util.List;

public class MenuPresenter implements IMenuContact.IPresenter {
    IMenuContact.IView iView;
    IProductDataSource iRepository;

    public MenuPresenter(IMenuContact.IView iView, IProductDataSource iRepository) {
        this.iView = iView;
        this.iRepository = iRepository;
    }

    @Override
    public List<Product> getListProduct() {
        return iRepository.getListProduct();
    }
}
