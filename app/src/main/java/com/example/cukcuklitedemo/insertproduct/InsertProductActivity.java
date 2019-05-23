package com.example.cukcuklitedemo.insertproduct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.cukcuklitedemo.Base.BaseProductActivity;
import com.example.cukcuklitedemo.R;
import com.example.cukcuklitedemo.customview.CustomButton;

public class InsertProductActivity extends BaseProductActivity {

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


}
