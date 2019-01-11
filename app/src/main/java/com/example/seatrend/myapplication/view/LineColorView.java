package com.example.seatrend.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by seatrend on 2018/12/12.
 */

public class LineColorView extends View {

    private Paint mPaint;
    private Paint mColorPaint;

    private int colorStart=0;
    private int colorEnd=0;
    private int totalLength=0;


    public LineColorView(Context context) {
        super(context);
        init();
    }



    public LineColorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(30);
        mPaint.setColor(Color.BLACK);

        mColorPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mColorPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(30);
        mColorPaint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0,0,getWidth(),0,mPaint);
        canvas.drawLine(colorStart,0,colorEnd,0,mPaint);
    }

    public void setLineColorLength(int end){
        this.colorEnd=end;
        invalidate();
    }
    public void setLineTotalLength(int totalLength){
        this.totalLength=totalLength;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int resultWidth=200 ;
        int resultHeight=20 ;
        Log.i("logtest","widthMode== "+widthMode);
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
               // resultHeight=400;
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
        Log.i("logtest","resultWidth== "+resultWidth);
        setMeasuredDimension(totalLength,resultHeight);
    }
}
