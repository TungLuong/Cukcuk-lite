package com.example.cukcuklitedemo.reactproduct;

import com.example.cukcuklitedemo.data.model.Unit;

import java.util.List;

public interface IReactProductContact {
    interface IPresenter{

        List<Unit> getUnitList();

        Unit getUnitById(int unitId);
    }
    interface IVIew{

    }
}
