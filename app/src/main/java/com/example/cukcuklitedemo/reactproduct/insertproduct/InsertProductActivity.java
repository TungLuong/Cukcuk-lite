package com.example.cukcuklitedemo.reactproduct.insertproduct;

import android.os.Bundle;

import com.example.cukcuklitedemo.reactproduct.ReactProductActivity;
import com.example.cukcuklitedemo.R;
import com.example.cukcuklitedemo.customview.CustomButton;

public class InsertProductActivity extends ReactProductActivity {

    private CustomButton btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_product);
        initView();
        initData();
    }

    private void initData() {
        tvProductPrice.setText("0");
    }

    @Override
    protected void initView() {
         super.initView();
         btnSave = findViewById(R.id.btn_save);
    }

    @Override
    protected void saveProduct() {

    }


}
