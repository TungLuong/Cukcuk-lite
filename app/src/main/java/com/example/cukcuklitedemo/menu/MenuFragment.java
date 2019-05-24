package com.example.cukcuklitedemo.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cukcuklitedemo.Common.Common;
import com.example.cukcuklitedemo.IListener;
import com.example.cukcuklitedemo.R;
import com.example.cukcuklitedemo.data.model.Product;
import com.example.cukcuklitedemo.data.model.Unit;
import com.example.cukcuklitedemo.data.source.ProductRepository;
import com.example.cukcuklitedemo.reactproduct.updateProduct.UpdateProductActivity;


public class MenuFragment extends Fragment implements IListener.IClickItem, IMenuContact.IView {

    private RecyclerView rcvProduct;
    private static MenuFragment sInstance;
    IMenuContact.IPresenter iPresenter;
    ProductAdapter adapter;

    public MenuFragment() {

    }

    /**
     * Tạo mới một thể hiện
     * create by lntung date 5/23/2019
     *
     * @return
     */
    public static MenuFragment newInstance() {
        MenuFragment fragment = new MenuFragment();
        return fragment;
    }

    /**
     * Lấy 1 thể hiện của lớp nếu thể hiện đó chưa tồn tại thì tạo mới.
     *
     * @return
     */
    public static MenuFragment getInstance() {
        if (sInstance == null) sInstance = newInstance();
        return sInstance;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        iPresenter = new MenuPresenter(this, ProductRepository.getInstance(getContext()));
        initView(view);
        return view;
    }

    private void initView(View v) {
        rcvProduct = v.findViewById(R.id.rcv_product);
        rcvProduct.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcvProduct.setLayoutManager(layoutManager);

        adapter = new ProductAdapter(this);
        rcvProduct.setAdapter(adapter);
        adapter.setData(iPresenter.getListProduct());
    }


    @Override
    public void onClickItem(Object object) {
        Product product = (Product) object;
        Intent intent = new Intent(getContext(), UpdateProductActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(Common.PRODUCT_KEY, product);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
