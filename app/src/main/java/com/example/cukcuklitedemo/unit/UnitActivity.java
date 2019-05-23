package com.example.cukcuklitedemo.unit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cukcuklitedemo.Common.Common;
import com.example.cukcuklitedemo.IListener;
import com.example.cukcuklitedemo.R;
import com.example.cukcuklitedemo.data.source.ProductRepository;

public class UnitActivity extends AppCompatActivity implements IListener.IClickItem, IListener.ILongClickItem, IUnitContact.IView {

    private RecyclerView rcvUnit;
    private int selectedId;
    private IUnitContact.IPresenter iPresenter;
    private UnitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            selectedId = bundle.getInt(Common.UNIT_ID_KEY);
        }
        iPresenter = new UnitPresenter(this, ProductRepository.getInstance(this));
        initView();
    }

    private void initView() {
        rcvUnit = findViewById(R.id.rcv_unit);
        rcvUnit.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rcvUnit.setLayoutManager(layoutManager);
        adapter = new UnitAdapter(this, this);
        adapter.setSelectedId(selectedId);
        adapter.setData(iPresenter.getListUnit());
        rcvUnit.setAdapter(adapter);
    }

    @Override
    public void onClickItem(Object object) {
        //open dialog update
    }

    @Override
    public void onLongClickItem(Object o) {
        //open dialog delete
    }
}
