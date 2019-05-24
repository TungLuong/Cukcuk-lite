package com.example.cukcuklitedemo.reactunit;

import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cukcuklitedemo.IListener;
import com.example.cukcuklitedemo.R;
import com.example.cukcuklitedemo.customview.CustomButton;
import com.example.cukcuklitedemo.data.model.Unit;

public abstract class ReactUnitDialogFragment extends DialogFragment implements View.OnClickListener {
    protected TextView tvTitle;
    protected EditText etContent;
    protected ImageView ivClose;
    protected CustomButton btnCancel;
    protected CustomButton btnSave;
    protected IListener.IReactUnit iReactUnit;

    public ReactUnitDialogFragment(IListener.IReactUnit iReactUnit) {
        this.iReactUnit = iReactUnit;
    }

    protected void initView(View view){
        tvTitle = view.findViewById(R.id.tv_title_react_dialog);
        etContent = view.findViewById(R.id.et_content_react_dialog);
        ivClose = view.findViewById(R.id.iv_close);
        ivClose.setOnClickListener(this);
        btnCancel = view.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(this);
        btnSave = view.findViewById(R.id.btn_save);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel:
                dismiss();
                break;
            case R.id.iv_close:
                dismiss();
                break;
            case R.id.btn_save:
                Unit unit = new Unit();
                if (etContent.getText() != null){
                    unit.setUnitName(etContent.getText().toString());
                    if (iReactUnit.insertUnit(unit)) dismiss();
                }
                break;
            default:
                break;


        }
    }
}
