package com.example.seatrend.myapplication.JavaTest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by seatrend on 2018/7/13.
 */

public class VinRedRectangle extends View {
    /**
     * 红色虚线的矩形框
     */

    private Paint mPaint;
    private PointF leftPointF;
    private PointF topPointF;
    private PointF rightPointF;
    private PointF bottomPointF;
    private PointF centerPointF;
    private int centerLineWidth=50;
    private int vertexLineWidth=80;
    private int pointSpacingWidth=0;

    public VinRedRectangle(Context context) {
        super(context);
        init();
    }

    public VinRedRectangle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VinRedRectangle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerPointF=new PointF(getWidth()/2,getHeight()/2);
        leftPointF=new PointF(pointSpacingWidth,pointSpacingWidth);
        topPointF=new PointF(pointSpacingWidth,getHeight()-pointSpacingWidth);
        rightPointF=new PointF(getWidth()-pointSpacingWidth,pointSpacingWidth);
        bottomPointF=new PointF(getWidth()-pointSpacingWidth,getHeight()-pointSpacingWidth);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int resultWidth=0 ;
        int resultHeight=0 ;

        switch (widthMode){
            case MeasureSpec.UNSPECIFIED:
                resultWidth=500;
                break;
            case MeasureSpec.AT_MOST:
                //resultWidth=Math.min(resultWidth,width);
                resultWidth=500;
                break;
            case MeasureSpec.EXACTLY:
                resultWidth=width;
                break;
                default:
        }
        switch (heightMode){
            case MeasureSpec.UNSPECIFIED:
                resultHeight=400;
                break;
            case MeasureSpec.AT_MOST:
                //resultHeight=Math.min(resultHeight,height);
                resultHeight=400;
                break;
            case MeasureSpec.EXACTLY:
                resultHeight=height;
                break;
            default:
        }
        setMeasuredDimension(resultWidth,resultHeight);

    }




    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(leftPointF.x,leftPointF.y,leftPointF.x,leftPointF.y+vertexLineWidth,mPaint);
        canvas.drawLine(leftPointF.x,leftPointF.y,leftPointF.x+vertexLineWidth,leftPointF.y,mPaint);

        canvas.drawLine(topPointF.x,topPointF.y,topPointF.x,topPointF.y-vertexLineWidth,mPaint);
        canvas.drawLine(topPointF.x,topPointF.y,topPointF.x+vertexLineWidth,topPointF.y,mPaint);

        canvas.drawLine(rightPointF.x,rightPointF.y,rightPointF.x,rightPointF.y+vertexLineWidth,mPaint);
        canvas.drawLine(rightPointF.x,rightPointF.y,rightPointF.x-vertexLineWidth,rightPointF.y,mPaint);

        canvas.drawLine(bottomPointF.x,bottomPointF.y,bottomPointF.x,bottomPointF.y-vertexLineWidth,mPaint);
        canvas.drawLine(bottomPointF.x,bottomPointF.y,bottomPointF.x-vertexLineWidth,bottomPointF.y,mPaint);

        canvas.drawLine(centerPointF.x-centerLineWidth,centerPointF.y,centerPointF.x+centerLineWidth,centerPointF.y,mPaint);
        canvas.drawLine(centerPointF.x,centerPointF.y-centerLineWidth,centerPointF.x,centerPointF.y+centerLineWidth,mPaint);

        //画中间的虚线
        float dottedStartX=0;
        float dottedStopX=0;
        int dottedWidth=30;
        int dottedSpacing=40;
        for (int i = 0; i < 50; i++) {
            if(dottedStartX>centerPointF.x-centerLineWidth &&dottedStartX< centerPointF.x+centerLineWidth){
                dottedStartX=centerPointF.x+centerLineWidth+dottedSpacing;
                continue;
            }
            if(dottedStartX>getWidth()){
                break;
            }
            dottedStopX=dottedStartX+dottedWidth;
            canvas.drawLine(dottedStartX,centerPointF.y,dottedStopX,centerPointF.y,mPaint);
            dottedStartX=dottedStopX+dottedSpacing;
        }



    }
}
