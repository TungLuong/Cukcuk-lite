package com.example.cukcuklitedemo.reactproduct;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cukcuklitedemo.Common.Common;
import com.example.cukcuklitedemo.R;
import com.example.cukcuklitedemo.customview.CustomIcon;
import com.example.cukcuklitedemo.data.model.Unit;
import com.example.cukcuklitedemo.data.source.ProductRepository;
import com.example.cukcuklitedemo.unit.UnitActivity;

import java.util.List;

public abstract class ReactProductActivity extends AppCompatActivity implements View.OnClickListener, IReactProductContact.IVIew {
    private ImageView ivBack;
    private TextView tvSave;
    protected EditText etProductName;
    protected TextView tvProductPrice;
    protected TextView tvUnit;
    protected CustomIcon ivBackgroundColor;
    protected CustomIcon ivIcon;
    protected IReactProductContact.IPresenter iPresenter;
    private static final int REQUEST_CODE_SELECT_UNIT = 1;


    protected List<Unit> unitList;
    protected Unit mUnit;

    protected ReactProductActivity() {
        iPresenter = new ReactProductPresenter(this, ProductRepository.getInstance(this));
        unitList = iPresenter.getUnitList();
        mUnit = unitList.get(0);
    }

    protected void initView() {
        try {
            etProductName = findViewById(R.id.et_product_name);
            tvProductPrice = findViewById(R.id.tv_product_price);
            tvUnit = findViewById(R.id.tv_unit);
            ivBackgroundColor = findViewById(R.id.iv_background_color);
            ivIcon = findViewById(R.id.iv_icon_product);
            tvUnit.setOnClickListener(this);
            ivBack = findViewById(R.id.iv_back);
            ivBack.setOnClickListener(this);
            tvSave = findViewById(R.id.tv_save);
            tvSave.setOnClickListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.tv_save:
                saveProduct();
                break;
            case R.id.tv_unit:
                openUnitActivity();
                break;
            case R.id.iv_background_color:
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

    protected abstract void saveProduct();

    private void openUnitActivity() {
        Intent intent = new Intent(this, UnitActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(Common.UNIT_KEY, mUnit);
        intent.putExtras(bundle);
        startActivityForResult(intent,REQUEST_CODE_SELECT_UNIT);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE_SELECT_UNIT) {
            if (resultCode == Activity.RESULT_OK) {
                Bundle bundle = data.getExtras();
                if (bundle != null) {
                    mUnit = (Unit) bundle.getSerializable(Common.UNIT_KEY);
                    tvUnit.setText(mUnit.getUnitName());
                }
            }
            if (resultCode == Activity.RESULT_CANCELED) {

            }
        }
    }
}
