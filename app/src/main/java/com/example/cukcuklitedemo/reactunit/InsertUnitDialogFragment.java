package com.example.cukcuklitedemo.reactunit;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.cukcuklitedemo.IListener;
import com.example.cukcuklitedemo.R;

@SuppressLint("ValidFragment")
public class InsertUnitDialogFragment extends ReactUnitDialogFragment {

    @SuppressLint("ValidFragment")
    public InsertUnitDialogFragment(IListener.IReactUnit iReactUnit) {
        super(iReactUnit);
    }

    public static InsertUnitDialogFragment newInstance(IListener.IReactUnit iReactUnit) {
        InsertUnitDialogFragment dialog = new InsertUnitDialogFragment(iReactUnit);
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_react_unit, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    @Override
    public void onResume() {
        super.onResume();
        Window window = getDialog().getWindow();
        Point size = new Point();

        Display display = window.getWindowManager().getDefaultDisplay();
        display.getSize(size);

        int width = size.x;

        window.setLayout((int) (width * 1), WindowManager.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);
    }
}
