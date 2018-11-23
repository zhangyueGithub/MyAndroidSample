package com.example.seatrend.myapplication.JavaTest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by seatrend on 2018/4/26.
 */

public class bounceBall extends View implements View.OnClickListener{


    private Paint mPaint;
    private int circleCenterX1=100;
    private int circleCenterY1 =400;
    private int circleRadius =100;

    private int circleCenterX2=350;
    private int circleCenterY2 =400;

    private int circleCenterX3=600;
    private int circleCenterY3 =400;



    private int layoutHeight;
    private int layoutWidth;

    private boolean onClickTag=true;
    private boolean upMoveTag=false;
    private boolean downMoveTag=true;
    private boolean leftMoveTag=false;
    private boolean rightMoveTag=true;

    private boolean upMoveTag2=false;
    private boolean downMoveTag2=true;
    private boolean leftMoveTag2=false;
    private boolean rightMoveTag2=true;


    private boolean upMoveTag3=false;
    private boolean downMoveTag3=true;
    private boolean leftMoveTag3=false;
    private boolean rightMoveTag3=true;


    private final int MoveValue=2;
    private final int sleepTime =10;


    public bounceBall(Context context) {
        super(context);
        init(context);
    }

    public bounceBall(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public bounceBall(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);
        setOnClickListener(this);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        layoutWidth=getWidth();
        layoutHeight=getHeight();




    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawOne(canvas);
    }

    private void drawOne(Canvas canvas) {
        canvas.drawCircle(circleCenterX1, circleCenterY1, circleRadius,mPaint);
        canvas.drawCircle(circleCenterX2, circleCenterY2, circleRadius,mPaint);
        canvas.drawCircle(circleCenterX3, circleCenterY3, circleRadius,mPaint);



    }



    @Override
    public void onClick(View v) {

        if(onClickTag) {
            thread1.start();
            //thread2.start();
           thread3.start();
            onClickTag = false;
        }


    }

   private Thread thread1=new Thread(){
        @Override
        public void run() {
            super.run();

            for (; ;) {

                if(circleCenterY1 - circleRadius <=0){
                    upMoveTag=false;
                    downMoveTag=true;
                }

                if(circleCenterX1 - circleRadius <=0){
                    rightMoveTag=true;
                    leftMoveTag=false;
                }

                if(circleCenterX1 + circleRadius >=layoutWidth){
                    rightMoveTag=false;
                    leftMoveTag=true;
                }



                if (  circleCenterY1 + circleRadius >=layoutHeight) {
                    upMoveTag=true;
                    downMoveTag=false;
                }



                //double sqrt = Math.sqrt(Math.pow(Math.abs(circleCenterX1 - circleCenterX2), 2) - Math.pow(Math.abs(circleCenterY1 - circleCenterY2), 2));
               double sqrt1 =(int) Math.sqrt(Math.pow(Math.abs(circleCenterX1 - circleCenterX3), 2) - Math.pow(Math.abs(circleCenterY1 - circleCenterY3), 2));
                Log.i("sqrt1","sqrt1==  "+sqrt1);
                if(sqrt1<=2*circleRadius ) {
                    //水平碰撞 改变其X方向的运动 Y轴不变
                   /* if(circleCenterY1 == circleCenterY2){
                        if (leftMoveTag) {
                            leftMoveTag = false;
                            rightMoveTag = true;

                        } else {
                            leftMoveTag = true;
                            rightMoveTag = false;
                        }
                    }else {
                        //不是水平碰撞 也就是斜撞 都会改变其X轴的运动方向
                            if (leftMoveTag) {
                                leftMoveTag = false;
                                rightMoveTag = true;

                            } else {
                                leftMoveTag = true;
                                rightMoveTag = false;
                            }
                    }*/


                    if (leftMoveTag) {
                        leftMoveTag = false;
                        rightMoveTag = true;

                        leftMoveTag3 = true;
                        rightMoveTag3 = false;
                    } else {
                        leftMoveTag = true;
                        rightMoveTag = false;

                        leftMoveTag3 = false;
                        rightMoveTag3 = true;

                    }



                }

                if(rightMoveTag){
                    circleCenterX1 +=MoveValue;
                }
                if(leftMoveTag){
                    circleCenterX1 -=MoveValue;
                }
                if(downMoveTag){
                    circleCenterY1 +=MoveValue;
                }
                if(upMoveTag){
                    circleCenterY1 -=MoveValue;
                }


                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //invalidate();
                postInvalidate();
            }
        }
    };

    private Thread thread2=new Thread(){
        @Override
        public void run() {
            super.run();

            for (; ;) {

                if(circleCenterY2 - circleRadius <=0){
                    upMoveTag2=false;
                    downMoveTag2=true;
                }

                if(circleCenterX2 - circleRadius <=0){
                    rightMoveTag2=true;
                    leftMoveTag2=false;
                }

                if(circleCenterX2 + circleRadius >=layoutWidth){
                    rightMoveTag2=false;
                    leftMoveTag2=true;
                }



                if (  circleCenterY2 + circleRadius >=layoutHeight) {
                    upMoveTag2=true;
                    downMoveTag2=false;
                }



               /* double sqrt = Math.sqrt(Math.pow(Math.abs(circleCenterX1 - circleCenterX2), 2) - Math.pow(Math.abs(circleCenterY1 - circleCenterY2), 2));
                double sqrt1 = Math.sqrt(Math.pow(Math.abs(circleCenterX3 - circleCenterX2), 2) - Math.pow(Math.abs(circleCenterY3 - circleCenterY2), 2));

                if(sqrt<=2*circleRadius || sqrt1<=2*circleRadius ) {
                    if (leftMoveTag2) {
                        leftMoveTag2 = false;
                        rightMoveTag2 = true;

                    } else {
                        leftMoveTag2 = true;
                        rightMoveTag2 = false;
                    }
                }*/

                if(rightMoveTag2){
                    circleCenterX2 +=MoveValue;
                }
                if(leftMoveTag2){
                    circleCenterX2 -=MoveValue;
                }
                if(downMoveTag2){
                    circleCenterY2 +=MoveValue;
                }
                if(upMoveTag2){
                    circleCenterY2 -=MoveValue;
                }

                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //invalidate();
                postInvalidate();
            }
        }
    };

    private Thread thread3=new Thread(){
        @Override
        public void run() {
            super.run();

            for (; ;) {

                if(circleCenterY3 - circleRadius <=0){
                    upMoveTag3=false;
                    downMoveTag3=true;
                }

                if(circleCenterX3 - circleRadius <=0){
                    rightMoveTag3=true;
                    leftMoveTag3=false;
                }

                if(circleCenterX3 + circleRadius >=layoutWidth){
                    rightMoveTag3=false;
                    leftMoveTag3=true;
                }



                if (  circleCenterY3 + circleRadius >=layoutHeight) {
                    upMoveTag3=true;
                    downMoveTag3=false;
                }




                /*double sqrt = Math.sqrt(Math.pow(Math.abs(circleCenterX1 - circleCenterX3), 2) - Math.pow(Math.abs(circleCenterY1 - circleCenterY3), 2));
                //double sqrt1 = Math.sqrt(Math.pow(Math.abs(circleCenterX3 - circleCenterX2), 2) - Math.pow(Math.abs(circleCenterY3 - circleCenterY2), 2));

                if(sqrt<=2*circleRadius) {
                    if (leftMoveTag) {
                        leftMoveTag3 = false;
                        rightMoveTag3 = true;

                    } else {
                        leftMoveTag3 = true;
                        rightMoveTag3 = false;
                    }
                }*/

                if(rightMoveTag3){
                    circleCenterX3 +=MoveValue;
                }
                if(leftMoveTag3){
                    circleCenterX3 -=MoveValue;
                }
                if(downMoveTag3){
                    circleCenterY3 +=MoveValue;
                }
                if(upMoveTag3){
                    circleCenterY3 -=MoveValue;
                }
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //invalidate();
                postInvalidate();
            }
        }
    };
}
