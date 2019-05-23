package com.example.cukcuklitedemo.Base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cukcuklitedemo.Common.Common;
import com.example.cukcuklitedemo.R;
import com.example.cukcuklitedemo.unit.UnitActivity;
import com.example.cukcuklitedemo.updateProduct.UpdateProductActivity;

public abstract class BaseProductActivity extends AppCompatActivity implements View.OnClickListener {
    protected EditText etProductName;
    protected TextView tvProductPrice;
    protected TextView tvUnit;
    protected ImageView ivColorBackground;
    protected ImageView ivIcon;
    protected int unitId = 1;

    protected void initView() {
        etProductName = findViewById(R.id.et_product_name);
        tvProductPrice = findViewById(R.id.tv_product_price);
        tvUnit = findViewById(R.id.tv_unit);
        ivColorBackground = findViewById(R.id.iv_color_backgroud);
        ivIcon = findViewById(R.id.iv_icon);
        tvUnit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_unit:
                openUnitActivity();
                break;

            case R.id.iv_color_backgroud:
                // open dialog color background
                break;
            case R.id.iv_icon:
                // open dialog icon
                break;
            case R.id.tv_product_price:
                //open dialog calculator
                break;
            default:
                break;


        }
    }

    private void openUnitActivity() {
        Intent intent = new Intent(this, UnitActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(Common.UNIT_ID_KEY, unitId);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
