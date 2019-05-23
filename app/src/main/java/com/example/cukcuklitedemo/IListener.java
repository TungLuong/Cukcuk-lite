package com.example.cukcuklitedemo;

public interface IListener {

    interface IClickItem {
        void onClickItem(Object object);
    }

    interface ILongClickItem {

        void onLongClickItem(Object o);
    }
}
