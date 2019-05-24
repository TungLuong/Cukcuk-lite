package com.example.cukcuklitedemo.reactproduct;

import com.example.cukcuklitedemo.data.model.Unit;
import com.example.cukcuklitedemo.data.source.IProductDataSource;
import com.example.cukcuklitedemo.reactproduct.IReactProductContact;

import java.util.List;

public class ReactProductPresenter implements IReactProductContact.IPresenter {
    IReactProductContact.IVIew ivIew;
    IProductDataSource iProductDataSource;

    public ReactProductPresenter(IReactProductContact.IVIew ivIew, IProductDataSource iProductDataSource) {
        this.ivIew = ivIew;
        this.iProductDataSource = iProductDataSource;
    }

    @Override
    public List<Unit> getUnitList() {
        return iProductDataSource.getListUnit();
    }

    @Override
    public Unit getUnitById(int unitId) {
        return iProductDataSource.getUnitById(unitId);
    }
}
