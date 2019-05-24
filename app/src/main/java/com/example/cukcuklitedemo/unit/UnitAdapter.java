package com.example.cukcuklitedemo.unit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cukcuklitedemo.IListener;
import com.example.cukcuklitedemo.R;
import com.example.cukcuklitedemo.data.model.Unit;

import java.util.ArrayList;
import java.util.List;

public class UnitAdapter extends RecyclerView.Adapter<UnitAdapter.UnitViewHolder> {

    private List<Unit> mData;
    private int mSelectedId;
    private IListener.IClickItem iClickItem;
    private PopupWindow popupWindow;
    private Context mContext;

    @NonNull
    @Override
    public UnitViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_unit, viewGroup, false);
        return new UnitViewHolder(view);
    }

    public UnitAdapter(Context context, IListener.IClickItem iClickItem) {
        this.iClickItem = iClickItem;
        this.mContext = context;
        mData = new ArrayList<>();
    }

    public void setData(List<Unit> mData) {
        this.mData = mData;
    }

    public void setSelectedId(int mSelectedId) {
        this.mSelectedId = mSelectedId;
    }

    @Override
    public void onBindViewHolder(@NonNull final UnitViewHolder unitViewHolder, @SuppressLint("RecyclerView") final int i) {

        try {
            unitViewHolder.tvUnitName.setText(mData.get(i).getUnitName());

            if (mSelectedId == mData.get(i).getUnitId()) {
                unitViewHolder.ivSelected.setVisibility(View.VISIBLE);
            } else {
                unitViewHolder.ivSelected.setVisibility(View.INVISIBLE);
            }

            unitViewHolder.ivUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Show dialog
                    Toast.makeText(mContext, "AAAA", Toast.LENGTH_SHORT).show();
                }
            });
            unitViewHolder.tvUnitName.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
//                    iLongClickItem.onLongClickItem(mData.get(i));
                    showPopup(unitViewHolder.tvUnitName);
                    return true;
                }
            });

            unitViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iClickItem.onClickItem(mData.get(i));
                    mSelectedId = mData.get(i).getUnitId();
                    notifyDataSetChanged();
                }
            });
            unitViewHolder.tvUnitName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iClickItem.onClickItem(mData.get(i));
                    mSelectedId = mData.get(i).getUnitId();
                    notifyDataSetChanged();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

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

    public void showPopup(View v) {

        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View popupView = layoutInflater.inflate(R.layout.popup_delete_unit_layout, null);

        popupWindow = new PopupWindow(
                popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                //TODO do sth here on dismiss
            }
        });

        popupWindow.showAsDropDown(v);
    }
}
