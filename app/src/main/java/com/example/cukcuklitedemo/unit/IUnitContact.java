package com.example.cukcuklitedemo.unit;

import com.example.cukcuklitedemo.data.model.Unit;

import java.util.List;

public interface IUnitContact {
    interface IPresenter{

        List<Unit> getListUnit();

        //:TODO
        boolean deleteUnit(Unit unit);

        boolean updateUnit(Unit unit);

        boolean insertUnit(Unit unit);
    }

    interface IView{

        void notificationMessage(int idString);
    }
}
