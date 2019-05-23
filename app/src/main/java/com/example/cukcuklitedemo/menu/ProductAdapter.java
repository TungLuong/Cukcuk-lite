package com.example.cukcuklitedemo.menu;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cukcuklitedemo.IListener;
import com.example.cukcuklitedemo.R;
import com.example.cukcuklitedemo.data.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> data;
    private IListener.IClickItem iListenerClickItem;

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_product, viewGroup, false);
        return new ProductViewHolder(view);
    }

    public ProductAdapter(IListener.IClickItem iListenerClickItem) {
        this.iListenerClickItem = iListenerClickItem;
        data = new ArrayList<>();
    }

    void setData(List<Product> data) {
        this.data = data;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, final int i) {
        productViewHolder.tvProductName.setText(data.get(i).getProductName());
        productViewHolder.tvProductPrice.setText(data.get(i).getProductPrice());
        productViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iListenerClickItem.onClickItem(data.get(i));
            }
        });
    }

    /**
     * Lấy số lượng item
     *
     * @return số lượng item
     */
    @Override
    public int getItemCount() {
        try {
            return data.size();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Lớp view holder để hiển thị lên rcv
     */
    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivIcon;
        private TextView tvProductName;
        private TextView tvProductPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.iv_icon);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvProductPrice = itemView.findViewById(R.id.tv_product_price);

        }
    }
}
