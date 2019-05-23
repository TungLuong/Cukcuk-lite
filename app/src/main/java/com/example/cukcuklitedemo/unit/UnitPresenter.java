package com.example.cukcuklitedemo.unit;

import com.example.cukcuklitedemo.data.model.Unit;
import com.example.cukcuklitedemo.data.source.IProductDataSource;

import java.util.List;

public class UnitPresenter implements IUnitContact.IPresenter {
    IUnitContact.IView iView;
    IProductDataSource iProductDataSource;

    public UnitPresenter(IUnitContact.IView iView, IProductDataSource iProductDataSource) {
        this.iView = iView;
        this.iProductDataSource = iProductDataSource;
    }

    @Override
    public List<Unit> getListUnit() {
        return iProductDataSource.getListUnit();
    }
}
