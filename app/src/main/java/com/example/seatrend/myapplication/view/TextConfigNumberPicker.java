package com.example.seatrend.myapplication.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.example.seatrend.myapplication.R;

import java.lang.reflect.Field;

/**
 * Created by seatrend on 2019/6/13.
 */

public class TextConfigNumberPicker extends NumberPicker {


    public TextConfigNumberPicker(Context context) {
        super(context);
        init();
    }

    public TextConfigNumberPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextConfigNumberPicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public void addView(View child) {
        super.addView(child);
        updateView(child);
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        super.addView(child, params);
        updateView(child);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        updateView(child);
    }

    private void updateView(View view) {
        if (view instanceof EditText) {
            //设置文字的颜色和大小
            ((EditText) view).setTextColor(getResources().getColor(R.color.black));
            ((EditText) view).setTextSize(16);
        }
    }

    private void init(){
        setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        setWrapSelectorWheel(true);
        setNumberPickerDividerColor(this);
    }
    private void setNumberPickerDividerColor(NumberPicker numberPicker) {
        Field[] pickerFields = NumberPicker.class.getDeclaredFields();
        for (Field pf : pickerFields) {
            if (pf.getName().equals("mSelectionDivider")) {
                pf.setAccessible(true);
                try {
                    //设置分割线的颜色值
                    pf.set(numberPicker, new ColorDrawable(getResources().getColor(R.color.black)));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
