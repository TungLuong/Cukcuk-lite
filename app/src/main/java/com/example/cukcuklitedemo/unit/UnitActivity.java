package com.example.cukcuklitedemo.unit;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cukcuklitedemo.Common.Common;
import com.example.cukcuklitedemo.IListener;
import com.example.cukcuklitedemo.R;
import com.example.cukcuklitedemo.customview.CustomButton;
import com.example.cukcuklitedemo.data.model.Unit;
import com.example.cukcuklitedemo.data.source.ProductRepository;
import com.example.cukcuklitedemo.menu.MenuFragment;
import com.example.cukcuklitedemo.reactproduct.updateProduct.UpdateProductActivity;
import com.example.cukcuklitedemo.reactunit.InsertUnitDialogFragment;

import java.util.List;

public class UnitActivity extends AppCompatActivity implements IListener.IClickItem, IUnitContact.IView, View.OnClickListener, IListener.IReactUnit {

    private ImageView ivBack;
    private ImageView ivAddUnit;
    private CustomButton btnFinish;
    private RecyclerView rcvUnit;
    private Unit selectedUnit;
    private IUnitContact.IPresenter iPresenter;
    private UnitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_unit);
            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                selectedUnit = (Unit) bundle.getSerializable(Common.UNIT_KEY);
            }
            iPresenter = new UnitPresenter(this, ProductRepository.getInstance(this));
            initView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(this);
        ivAddUnit = findViewById(R.id.iv_add_unit);
        ivAddUnit.setOnClickListener(this);
        btnFinish = findViewById(R.id.btn_finish);
        btnFinish.setOnClickListener(this);
        rcvUnit = findViewById(R.id.rcv_unit);
        rcvUnit.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rcvUnit.setLayoutManager(layoutManager);
        adapter = new UnitAdapter(this, this);
        adapter.setData(iPresenter.getListUnit());
        adapter.setSelectedId(selectedUnit.getUnitId());
        rcvUnit.setAdapter(adapter);
    }

    @Override
    public void onClickItem(Object object) {
        //open dialog update
        selectedUnit = (Unit) object;
    }


    /**
     * Created by tung
     * Created date 24/05/2019
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                Toast.makeText(this, "Da click", Toast.LENGTH_SHORT).show();
                onBackPressed();
                break;
            case R.id.iv_add_unit:
                showDialogAddUnit();
                break;
            case R.id.btn_finish:
                finishSelectUnit(selectedUnit);
                break;
            default:
                break;


        }
    }

    private void finishSelectUnit(Unit selectedUnit) {
        Intent returnIntent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Common.UNIT_KEY, selectedUnit);
        returnIntent.putExtras(bundle);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }

    /**
     * Created by tung
     * Created date 24/05/2019
     */
    private void showDialogAddUnit() {
        FragmentManager fm = getSupportFragmentManager();
        InsertUnitDialogFragment dialogFragment = InsertUnitDialogFragment.newInstance(this);
        dialogFragment.show(fm, null);
    }


    /**
     * Created by tung
     * Created date 24/05/2019
     *
     * @param unit
     * @return
     */
    @Override
    public boolean deleteUnit(Unit unit) {
        try {
            iPresenter.deleteUnit(unit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Created by tung
     * Created date 24/05/2019
     *
     * @param unit
     * @return
     */
    @Override
    public boolean insertUnit(Unit unit) {
        try {
            return iPresenter.insertUnit(unit);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Created by tung
     * Created date 24/05/2019
     *
     * @param unit
     * @return
     */
    @Override
    public boolean updateUnit(Unit unit) {
        try {
            iPresenter.updateUnit(unit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public void notificationMessage(int idString) {
        Toast.makeText(this, getResources().getString(idString), Toast.LENGTH_SHORT).show();
    }

}
