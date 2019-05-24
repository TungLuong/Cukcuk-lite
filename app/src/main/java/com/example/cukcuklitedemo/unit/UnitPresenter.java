package com.example.cukcuklitedemo.unit;

import android.widget.Toast;

import com.example.cukcuklitedemo.R;
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

    @Override
    public boolean deleteUnit(Unit unit) {
        try {
            if (unit.getCountChose() > 0) {
                iView.notificationMessage(R.string.unit_are_chosen);
                return false;
            } else {
                return iProductDataSource.deleteUnit(unit.getUnitId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUnit(Unit unit) {
        try {
            return iProductDataSource.updateUnit(unit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean insertUnit(Unit unit) {
        try {
            if (!unit.getUnitName().equals("")) {
                List<Unit> units = getListUnit();
                for (Unit u : units) {
                    if (u.getUnitName().equals(unit.getUnitName())) {
                        iView.notificationMessage(R.string.unit_exist);
                        return false;
                    }
                }
                return iProductDataSource.insertUnit(unit);
            } else {
                iView.notificationMessage(R.string.note_input_not_enough);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
