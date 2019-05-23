package com.example.cukcuklitedemo.insertproduct;

import com.example.cukcuklitedemo.data.source.IProductDataSource;

public class InsertProductPresenter {
    IInsertProductContact.IVIew ivIew;
    IProductDataSource iProductDataSource;

    public InsertProductPresenter(IInsertProductContact.IVIew ivIew, IProductDataSource iProductDataSource) {
        this.ivIew = ivIew;
        this.iProductDataSource = iProductDataSource;
    }
}
