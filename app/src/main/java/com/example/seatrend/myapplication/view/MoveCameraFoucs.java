package com.example.seatrend.myapplication.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.seatrend.myapplication.R;


/**
 * Created by seatrend on 2018/11/26.
 */

public class MoveCameraFoucs extends View {


    private Paint mPaint;
    private Bitmap bitmap;

    private float bitmapX,bitmapY;
    private int bitmapHeight;
    private int bitmapWidth;
    private  float degrees =0;

    public MoveCameraFoucs(Context context) {
        super(context);
        init(context);
    }

    public MoveCameraFoucs(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MoveCameraFoucs(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context) {
        mPaint = new Paint();
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.focus_icon);
        bitmapHeight = bitmap.getHeight();
        bitmapWidth = bitmap.getWidth();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bitmapX=getWidth()/2-bitmapWidth/2;
        bitmapY=getHeight()/2-bitmapHeight/2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.rotate(degrees,bitmapX+bitmapWidth/2,bitmapY+bitmapHeight/2);
        canvas.drawBitmap(bitmap,bitmapX,bitmapY,mPaint);

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
                float rawX = event.getRawX();
                float rawY = event.getRawY();
                bitmapX=rawX-bitmapWidth/2;
                bitmapY=rawY-bitmapHeight/2;
                break;
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <30 ; i++) {
                    degrees +=2;
                    postInvalidate();
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i <30 ; i++) {
                    degrees -=2;
                    postInvalidate();
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                degrees=0;
            }
        }).start();
        return super.onTouchEvent(event);
    }
}
