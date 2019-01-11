package com.example.seatrend.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

/**
 * Created by seatrend on 2018/12/12.
 */

public class CheckBoxLinearlayout extends ViewGroup implements CompoundButton.OnCheckedChangeListener{


    private LineColorView mLineColorView;

    public CheckBoxLinearlayout(Context context) {
        super(context);
        init(context);

    }



    public CheckBoxLinearlayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }
    private void init(Context context) {
        mLineColorView = new LineColorView(context);
        LayoutParams params=new RadioGroup.LayoutParams(LayoutParams.WRAP_CONTENT,36);
        addView(mLineColorView,params);
    }

    private void addChildChcekEvent(){
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if(view instanceof ViewGroup){
                int count = ((ViewGroup) view).getChildCount();
                for (int j = 0; j <count; j++) {
                    View childAt = ((ViewGroup) view).getChildAt(j);
                    if(childAt instanceof CheckBox){
                        CheckBox checkBox = (CheckBox) childAt;
                        checkBox.setTag(i);
                        checkBox.setOnCheckedChangeListener(this);
                    }
                }
            }
        }
    }

    int te=10;

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View view = getChildAt(i);
                if(view instanceof CheckBoxText){
                    int count = ((CheckBoxText) view).getChildCount();
                    for (int j = 0; j <count; j++) {
                        View childAt = ((CheckBoxText) view).getChildAt(j);
                        if(childAt instanceof CheckBox){
                            CheckBox checkBox = (CheckBox) childAt;
                            Log.i("logtest","id== "+buttonView.getTag());
                            if(!buttonView.getTag().equals(checkBox.getTag())){
                                checkBox.setChecked(false);
                                ((CheckBoxText) view).setCheckedChange(false);
                            }else {
                                ((CheckBoxText) view).setCheckedChange(true);
                                te+=10;
                                mLineColorView.setLineColorLength(te);


                            }

                        }
                    }

                }
            }


        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        addChildChcekEvent();

        int top=0;
        int left=0;
        int totalLength=0;
        int childCount = getChildCount();
        int firstlLength=0;
        int endLength=0;
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            if(!(childView instanceof LineColorView)){
                int childViewMeasuredWidth = childView.getMeasuredWidth();
                childView.layout(left,top,childViewMeasuredWidth+left,childView.getMeasuredHeight()+top);
                totalLength+=childViewMeasuredWidth;
                left+=childViewMeasuredWidth;

                if(i==1){
                    firstlLength=childViewMeasuredWidth;
                }else if(i==childCount-1){
                    endLength=childViewMeasuredWidth;
                }
            }
        }

        Log.i("logtest","totalLength="+totalLength);
        totalLength=totalLength-firstlLength/2;
        mLineColorView.setLineTotalLength(totalLength);
        Log.i("logtest","totalLength="+totalLength);
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
             if(childView instanceof LineColorView){
                int childViewMeasuredWidth = childView.getMeasuredWidth();
                childView.layout(firstlLength/2,20,childViewMeasuredWidth,childView.getMeasuredHeight());

            }
        }
    }
}
