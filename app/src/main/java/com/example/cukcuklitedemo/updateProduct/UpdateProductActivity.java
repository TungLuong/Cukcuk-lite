package com.example.cukcuklitedemo.updateProduct;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.cukcuklitedemo.Base.BaseProductActivity;
import com.example.cukcuklitedemo.Common.Common;
import com.example.cukcuklitedemo.R;
import com.example.cukcuklitedemo.customview.CustomButton;
import com.example.cukcuklitedemo.data.model.Product;

public class UpdateProductActivity extends BaseProductActivity {
    private CustomButton btnSave;
    private CustomButton btnDelete;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);
        initView();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Product product = (Product) bundle.getSerializable(Common.PRODUCT_KEY);
            initData(product);
        }
    }

    private void initData(Product product) {
        try {
            etProductName.setText(product.getProductName());
            tvProductPrice.setText(product.getProductPrice());
            tvUnit.setText(product.getUnit().getUnitName());
            unitId = product.getUnit().getUnitId();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initView() {
        super.initView();
        btnSave = findViewById(R.id.btn_save);
        btnDelete = findViewById(R.id.btn_delete);
    }
}
