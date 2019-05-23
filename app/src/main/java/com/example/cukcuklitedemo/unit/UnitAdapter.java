package com.example.cukcuklitedemo.unit;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cukcuklitedemo.IListener;
import com.example.cukcuklitedemo.R;
import com.example.cukcuklitedemo.data.model.Unit;

import java.util.ArrayList;
import java.util.List;

public class UnitAdapter extends RecyclerView.Adapter<UnitAdapter.UnitViewHolder> {

    private List<Unit> mData;
    private int mSelectedId;
    private IListener.IClickItem iClickItem;
    private IListener.ILongClickItem iLongClickItem;

    @NonNull
    @Override
    public UnitViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_unit, viewGroup, false);
        return new UnitViewHolder(view);
    }

    public UnitAdapter(IListener.IClickItem iClickItem, IListener.ILongClickItem iLongClickItem) {
        this.iClickItem = iClickItem;
        this.iLongClickItem = iLongClickItem;
        mData = new ArrayList<>();
    }

    public void setData(List<Unit> mData) {
        this.mData = mData;
    }

    public void setSelectedId(int mSelectedId) {
        this.mSelectedId = mSelectedId;
    }

    @Override
    public void onBindViewHolder(@NonNull UnitViewHolder unitViewHolder, @SuppressLint("RecyclerView") final int i) {

        if (mSelectedId == mData.get(i).getUnitId()) {
            unitViewHolder.ivSelected.setVisibility(View.VISIBLE);
        } else {
            unitViewHolder.ivSelected.setVisibility(View.INVISIBLE);
        }

        unitViewHolder.ivUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iClickItem.onClickItem(mData.get(i));
            }
        });
        unitViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                iLongClickItem.onLongClickItem(mData.get(i));
                return true;
            }
        });
        unitViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSelectedId = mData.get(i).getUnitId();
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        try {
            return mData.size();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    class UnitViewHolder extends RecyclerView.ViewHolder {
        ImageView ivSelected;
        ImageView ivUpdate;
        TextView tvUnitName;

        UnitViewHolder(@NonNull View itemView) {
            super(itemView);
            ivSelected = itemView.findViewById(R.id.iv_selected);
            tvUnitName = itemView.findViewById(R.id.tv_unit_name);
            ivUpdate = itemView.findViewById(R.id.iv_update);

        }
    }
}
