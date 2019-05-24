package com.example.cukcuklitedemo.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.cukcuklitedemo.R;

public class CustomIcon extends RelativeLayout {
    private static final int DURATION = 100;
    private Context mContext;
    private int mBackgroundColor;
    private ImageView ivBackground;
    private ImageView ivIcon;
    private Drawable mIconDrawable;


    public CustomIcon(Context context, AttributeSet attrs) {
        super(context);
        try {
            mContext = context;
            setupAttributes(attrs);
            initView();
            invalidate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("ResourceAsColor")
    private void setupAttributes(AttributeSet attrs) {
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.CustomIcon);

        mBackgroundColor = typedArray.getColor(R.styleable.CustomIcon_color_background, R.color.colorPrimary);
        mIconDrawable = typedArray.getDrawable(R.styleable.CustomIcon_image_icon);
        typedArray.recycle();
    }

    void initView() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.icon_custom_view, this, true);

        ivIcon = view.findViewById(R.id.iv_icon);
        ivBackground = view.findViewById(R.id.iv_background);
        if (mIconDrawable == null) {
            ivIcon.setVisibility(GONE);
        } else {
            ivIcon.setImageDrawable(mIconDrawable);
        }

        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.OVAL);
        shape.setColor(mBackgroundColor);
        ivBackground.setImageDrawable(shape);
    }

}
