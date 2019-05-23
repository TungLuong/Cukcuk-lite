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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cukcuklitedemo.R;

public class CustomButton extends LinearLayout {

    private static final int DURATION = 100;
    private Context mContext;
    private String mTitle;
    private int mDefaultButtonColor;
    private int mPressedButtonColor;
    private int mDefaultTextColor;
    private int mPressedTextColor;
    private float mCornersRadius;
    private Drawable mIcon;

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        try {
            setupAttributes(attrs);
            initView();
            invalidate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("ResourceAsColor")
    private void setupAttributes(AttributeSet attrs) {
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.CustomButton);
        mTitle = typedArray.getString(R.styleable.CustomButton_title);
        mDefaultButtonColor = typedArray.getColor(R.styleable.CustomButton_color_button_default, R.color.colorAccent);
        mPressedButtonColor = typedArray.getColor(R.styleable.CustomButton_color_button_pressed, R.color.colorAccent);
        mDefaultTextColor = typedArray.getColor(R.styleable.CustomButton_color_text_default, android.R.color.black);
        mPressedTextColor = typedArray.getColor(R.styleable.CustomButton_color_text_pressed, mDefaultTextColor);
        mIcon = typedArray.getDrawable(R.styleable.CustomButton_icon);
        mCornersRadius = typedArray.getFloat(R.styleable.CustomButton_corners_radius, 10);
        typedArray.recycle();
    }

    void initView() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.button_custom_view, this, true);

        TextView tvTitle = view.findViewById(R.id.tv_title);
        ImageView ivIcon = view.findViewById(R.id.iv_icon_button);
        tvTitle.setText(mTitle);
        if (mIcon == null) {
            ivIcon.setVisibility(GONE);
        } else {
            ivIcon.setImageDrawable(mIcon);

        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(generateSelector());
        }

        int[][] state = new int[][]{new int[]{android.R.attr.state_pressed}, new int[]{}};
        int[] color = new int[]{mPressedTextColor, mDefaultTextColor};
        ColorStateList colorStateList = new ColorStateList(state, color);
        tvTitle.setTextColor(colorStateList);
    }

    private Drawable generateSelector() {
        StateListDrawable drawable = new StateListDrawable();
        drawable.setExitFadeDuration(DURATION);
        drawable.addState(new int[]{android.R.attr.state_pressed}, createShape(mPressedButtonColor));
        drawable.addState(new int[]{}, createShape(mDefaultButtonColor));
        return drawable;
    }


    public GradientDrawable createShape(int color) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadii(new float[]{mCornersRadius, mCornersRadius, mCornersRadius, mCornersRadius, mCornersRadius, mCornersRadius, mCornersRadius, mCornersRadius});
        shape.setColor(color);
        return shape;
    }


}
