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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.seatrend.myapplication.R;

/**
 * Created by seatrend on 2018/12/12.
 */

public class CheckBoxText extends ViewGroup {

   private Paint mPaint;
   private Context mContext;
   private TextView textView;

   private int viewTop=0;
   private int viewLeft=0;
   private int viewWidth=0;


    public CheckBoxText(Context context) {
        super(context);
        mContext=context;
        init();
    }

    public CheckBoxText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        init();
    }
    private int childMarginLeft=0;
    private int childMarginTop=0;
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int top=0;
        int left=0;
        viewWidth=getWidth();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            int childViewMeasuredWidth = childView.getMeasuredWidth();
            left=(getWidth()-childViewMeasuredWidth)/2;
            childView.layout(left,top,childViewMeasuredWidth+left,childView.getMeasuredHeight()+top);
            top+=childView.getMeasuredHeight()+childMarginTop;

        }
    }

    private void init(){
        LayoutParams params=new RadioGroup.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        CheckBox checkBox=new CheckBox(mContext);
        textView = new TextView(mContext);
        textView.setText("TC");
        checkBox.setButtonDrawable(mContext.getResources().getDrawable(R.drawable.rb_circle_bg));
        addView(checkBox,params);
        addView(textView,params);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });



    }

    public void setCheckedChange(boolean isChecked){
        if(isChecked){
            textView.setTextColor(Color.RED);
        }else {
            textView.setTextColor(Color.BLACK);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);



    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int resultWidth=100 ;
        int resultHeight=100 ;

        switch (widthMode){
            case MeasureSpec.UNSPECIFIED:
                //resultWidth=500;
                break;
            case MeasureSpec.AT_MOST:
                //resultWidth=Math.min(resultWidth,width);
                //resultWidth=500;
                break;
            case MeasureSpec.EXACTLY:
                resultWidth=width;
                break;
            default:
        }
        switch (heightMode){
            case MeasureSpec.UNSPECIFIED:
                //resultHeight=400;
                break;
            case MeasureSpec.AT_MOST:
                //resultHeight=Math.min(resultHeight,height);
                //resultHeight=400;
                break;
            case MeasureSpec.EXACTLY:
                resultHeight=height;
                break;
            default:
        }
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        setMeasuredDimension(resultWidth,resultHeight);
    }
}
