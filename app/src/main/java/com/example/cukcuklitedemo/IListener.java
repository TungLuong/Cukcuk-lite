package com.example.cukcuklitedemo;

import com.example.cukcuklitedemo.data.model.Unit;

public interface IListener {

    interface IClickItem {
        void onClickItem(Object object);
    }

    interface ILongClickItem {

        void onLongClickItem(Object o);
    }

    interface IReactUnit{
        boolean deleteUnit(Unit unit);
        boolean insertUnit(Unit unit);
        boolean updateUnit(Unit unit);
    }
}
