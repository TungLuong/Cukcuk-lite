package com.example.cukcuklitedemo.reactproduct.updateProduct;

import android.content.Intent;
import android.os.Bundle;

import com.example.cukcuklitedemo.reactproduct.ReactProductActivity;
import com.example.cukcuklitedemo.Common.Common;
import com.example.cukcuklitedemo.R;
import com.example.cukcuklitedemo.customview.CustomButton;
import com.example.cukcuklitedemo.data.model.Product;

public class UpdateProductActivity extends ReactProductActivity {
    private CustomButton btnSave;
    private CustomButton btnDelete;
    private Product oldProduct;
    private Product newProduct;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);
        initView();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            oldProduct = (Product) bundle.getSerializable(Common.PRODUCT_KEY);
            initData(oldProduct);
        }
    }

    private void initData(Product product) {
        try {
            etProductName.setText(product.getProductName());
            tvProductPrice.setText(product.getProductPrice());
            tvUnit.setText(product.getUnit().getUnitName());
            mUnit = product.getUnit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initView() {
        super.initView();
        btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(this);
        btnDelete = findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(this);
    }

    @Override
    protected void saveProduct() {
        deleteOldProduct();
        createNewProduct();
    }

    private void createNewProduct() {
//        Product product = new Product();
//        product.setProductName(String.valueOf(etProductName.getText()));
//        product.setProductPrice(String.valueOf(tvProductPrice.getText()));
//        product.setUnit(iPresenter.getUnitById(unitId));
//        product.setBackground(iPresenter.get);
    }


    private void deleteOldProduct() {

    }
}
