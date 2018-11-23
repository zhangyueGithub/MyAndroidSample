package com.example.seatrend.myapplication.JavaTest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by seatrend on 2018/4/28.
 */

public class ClockView extends View implements View.OnClickListener{

    private Paint circlePaint;
    private Paint numberPaint;
    private Paint linePaint;



    private PointF centerPointF; //中心点

    private final int Radius=300;
    private final int degrees=6;
    private final int scaleLine=25; //刻度线长度
    private final int pointerLine=150; //指针长度
    private  int pointerDegrees=0; //指针旋转角度

    private boolean onClickTag=true;
    private boolean drawTag=true;


    public ClockView(Context context) {
        super(context);
        init();
    }

    public ClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        circlePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setColor(Color.BLACK);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeWidth(10);

        numberPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        numberPaint.setColor(Color.BLUE);
        numberPaint.setStyle(Paint.Style.STROKE);
        //numberPaint.setStrokeWidth(10);
        numberPaint.setTextSize(50);

        linePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(Color.BLACK);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(5);

        setOnClickListener(this);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerPointF=new PointF(getWidth()/2,getHeight()/2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(drawTag){

        }
        drawCircle(canvas);
        drawTag=false;
        drawPointer(canvas);
    }

    private void drawCircle(Canvas canvas) {
        canvas.drawCircle(centerPointF.x,centerPointF.y,Radius,circlePaint);
        int number=0;
        Rect rect;
        for (int i = 0; i <60 ; i++) {
            if(i%5 == 0){

                canvas.drawLine(centerPointF.x,centerPointF.y-Radius,centerPointF.x,centerPointF.y-Radius+2*scaleLine,linePaint);
               if(i==0){
                   number=12;
                   String s = String.valueOf(number);
                   //通过字体所占矩形的宽高 获得 字体的宽高
                    rect = new Rect();
                   numberPaint.getTextBounds(s, 0, s.length(), rect);
                   int w = rect.width();
                   int h = rect.height();

                   canvas.drawText(String.valueOf(number),centerPointF.x-w/2,centerPointF.y-Radius+2*scaleLine+h+5,numberPaint);
                   number=0;
               }else {
                   String s = String.valueOf(number);
                    rect = new Rect();
                   numberPaint.getTextBounds(s, 0, s.length(), rect);
                   int w = rect.width();
                   int h = rect.height();
                   canvas.drawText(String.valueOf(number),centerPointF.x-w/2,centerPointF.y-Radius+2*scaleLine+h+5,numberPaint);
               }

                number++;
            }else {
                canvas.drawLine(centerPointF.x,centerPointF.y-Radius,centerPointF.x,centerPointF.y-Radius+scaleLine,linePaint);
            }
            canvas.rotate(degrees,centerPointF.x,centerPointF.y);
        }




    }

    //画指针
    private void drawPointer(Canvas canvas){
        canvas.rotate(pointerDegrees,centerPointF.x,centerPointF.y);
        canvas.drawLine(centerPointF.x,centerPointF.y,centerPointF.x,centerPointF.y-pointerLine,linePaint);
    }

    @Override
    public void onClick(View v) {
        if(onClickTag){
            thread.start();
            onClickTag=false;
        }
    }

    private Thread thread=new Thread(){
        @Override
        public void run() {
            super.run();
            for (; ;) {
                pointerDegrees+=6;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                postInvalidate();
            }

        }
    };

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int wMode = MeasureSpec.getMode(widthMeasureSpec);
        int hMode = MeasureSpec.getMode(heightMeasureSpec);

        int wSize = MeasureSpec.getSize(widthMeasureSpec);
        int hSize = MeasureSpec.getSize(heightMeasureSpec);
        switch (wMode){
            case MeasureSpec.AT_MOST:

                break;

            case MeasureSpec.UNSPECIFIED:

                break;

            case MeasureSpec.EXACTLY:

                break;
        }

        Log.i("onMeasure"," wMode== "+wMode+"wSize  = "+wSize+"  hSize= "+hSize);



        //setMeasuredDimension(0,0);
    }
}
