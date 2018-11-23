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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by seatrend on 2018/4/26.
 */

public class CircleTest extends View implements View.OnClickListener{

    Paint mRingPaint;
    Paint mCirclePaint;
    Paint mLinePaint;


    private int ringCenterX;
    private int ringCenterY;
    private int ringRadius=200;
    private int circleRadius=50;
    private  int degrees=0;
    private final static int SLEEPTIME=10;

    private boolean onClickTag=true;
    private List<PointF> PointFList=new ArrayList();



    private PointF ringPointF=new PointF();


    public CircleTest(Context context) {
        super(context);
        init();
    }

    public CircleTest(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public CircleTest(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }


    private void init(){
        //圆环画笔
        mRingPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mRingPaint.setColor(Color.BLUE);
        mRingPaint.setStrokeWidth(16);
        mRingPaint.setStyle(Paint.Style.STROKE);

        //运动圆 画笔
        mCirclePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setColor(Color.RED);
        mCirclePaint.setStrokeWidth(16);
        mCirclePaint.setStyle(Paint.Style.FILL);

        //线

        mLinePaint =new Paint(Paint.ANTI_ALIAS_FLAG);
        mLinePaint.setColor(Color.BLACK);
        mLinePaint.setStrokeWidth(6);
        mLinePaint.setStyle(Paint.Style.FILL);

        setOnClickListener(this);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        /*ringCenterX=getWidth()/2;
        ringCenterY=getHeight()/2;*/

        ringPointF.set(getWidth()/2,getHeight()/2);
        thread2.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(ringPointF.x,ringPointF.y,ringRadius,mRingPaint);
        canvas.rotate(degrees,ringPointF.x,ringPointF.y);
        canvas.drawCircle(ringPointF.x,ringPointF.y-ringRadius,circleRadius,mCirclePaint);

        float pointY=ringPointF.y-ringRadius-200;
        float pointX=ringPointF.x;
        canvas.drawPoint(pointX,pointY, mLinePaint);
        canvas.drawLine(ringPointF.x,ringPointF.y-ringRadius,ringPointF.x,ringPointF.y,mLinePaint);
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
            for (; ; ) {
                degrees--;
                postInvalidate();
                try {
                    Thread.sleep(SLEEPTIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    };

    private Thread thread2=new Thread(){
        @Override
        public void run() {
            super.run();
            int height = getHeight();
            int width = getWidth();

            for (int i = 0; i <height ; i++) {
                for (int j = 0; j <width ; j++) {
                    boolean b = Math.pow(i-ringPointF.y, 2) + Math.pow(j-ringPointF.x, 2) == Math.pow(ringRadius,2);
                    if(b){
                        Log.i("PointFList","i == "+i+"  j == "+j);
                        PointFList.add(new PointF(j,i));
                    }

                }
            }

            Log.i("PointFList","PointFList ==  "+PointFList.size());


        }
    };


}
