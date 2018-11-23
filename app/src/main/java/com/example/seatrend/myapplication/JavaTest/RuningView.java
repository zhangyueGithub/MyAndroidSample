package com.example.seatrend.myapplication.JavaTest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by seatrend on 2018/7/19.
 */

public class RuningView extends View implements View.OnClickListener {

    private Paint grayPaint;
    private Paint redPaint;
    private Paint textPaint;

    private static final int MAGIN = 10; //与边线的距离
    private static final int BORDER_LENGTH = 100;  // 边长
    private int verticalNumber = 0; //竖直方向的数量
    private int horizontalNumber = 0; //水平方向的数量
    private float horizontalSpacing = 0; //水平矩形间的间距
    private List<RectF> rectFList = new ArrayList<>();
    private int locationIndexFirst = 0;
    private int locationIndexSecond = -1;
    private int locationIndexThird = -2;

    private int sleepTime = 200;
    private int runTime = 10 * 5 * 200;
    private int currentTime = 0;
    private boolean isRuning = false;

    public RuningView(Context context) {
        super(context);
        init();
    }

    public RuningView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RuningView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        grayPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        grayPaint.setStyle(Paint.Style.FILL);
        grayPaint.setColor(Color.GRAY);

        redPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        redPaint.setStyle(Paint.Style.FILL);
        redPaint.setColor(Color.RED);

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(40);
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int width = getWidth();
        int height = getHeight();
        int horizontalRectNumber = width / BORDER_LENGTH;//如果不考虑间距，这可以画这么多个矩形
        horizontalNumber=horizontalRectNumber-3; //这里用3个矩形的位置的空间来做矩形间的间距
        int horizontalRest = width - horizontalNumber * BORDER_LENGTH -2*MAGIN; //水平方向剩余的空间
        float horizontalSpac = (float) horizontalRest / (float) (horizontalNumber - 1);
        DecimalFormat df = new DecimalFormat("0.00");
        String format= df.format(horizontalSpac);
        horizontalSpacing=Float.valueOf(format);

        int verticalRectNumber = (int) ((height-BORDER_LENGTH*2-MAGIN*2) / (BORDER_LENGTH+horizontalSpacing));//这可以画这么多个矩形
        verticalNumber=verticalRectNumber;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rectFList.clear();
        float left=MAGIN;
        float top=MAGIN;
        float rigth=MAGIN+BORDER_LENGTH;
        float bottom=MAGIN+BORDER_LENGTH;
        Rect rect;
      //上
        for (int i = 0; i < horizontalNumber; i++) {
         if(i>0) {
                left=left+BORDER_LENGTH+horizontalSpacing;
                rigth=rigth+BORDER_LENGTH+horizontalSpacing;
            }

            RectF rectF=new RectF(left,top,rigth,bottom);
            rectFList.add(rectF);
            canvas.drawRect(rectF, grayPaint);

            rect = new Rect();
            textPaint.getTextBounds(String.valueOf(rectFList.size()), 0, String.valueOf(rectFList.size()).length(), rect);
            int w = rect.width();
            int h = rect.height();
            canvas.drawText(String.valueOf(rectFList.size()),rectF.centerX()-w/2,rectF.centerY()+h/2,textPaint);
        }

        //右
        top=BORDER_LENGTH+MAGIN+horizontalSpacing;
        bottom=2*BORDER_LENGTH+MAGIN+horizontalSpacing;
        rigth=getWidth()-MAGIN-BORDER_LENGTH;;
        left=getWidth()-MAGIN;
        for (int i = 0; i < verticalNumber; i++) {
            if(i>0) {
                top=top+BORDER_LENGTH+horizontalSpacing;
                bottom=bottom+BORDER_LENGTH+horizontalSpacing;
            }
            RectF rectF=new RectF(left,top,rigth,bottom);
            rectFList.add(rectF);
            canvas.drawRect(rectF, grayPaint);

            rect = new Rect();
            textPaint.getTextBounds(String.valueOf(rectFList.size()), 0, String.valueOf(rectFList.size()).length(), rect);
            int w = rect.width();
            int h = rect.height();
            canvas.drawText(String.valueOf(rectFList.size()),rectF.centerX()-w/2,rectF.centerY()+h/2,textPaint);
        }

        //下
        top=getHeight()-BORDER_LENGTH-MAGIN;
        bottom=getHeight()-MAGIN;
        rigth=getWidth()-MAGIN;;
        left=getWidth()-MAGIN-BORDER_LENGTH;
        for (int i = 0; i < horizontalNumber; i++) {
         if(i>0) {
                left=left-BORDER_LENGTH-horizontalSpacing;
                rigth=rigth-BORDER_LENGTH-horizontalSpacing;
            }
            RectF rectF=new RectF(left,top,rigth,bottom);
            rectFList.add(rectF);
            canvas.drawRect(rectF, grayPaint);

            rect = new Rect();
            textPaint.getTextBounds(String.valueOf(rectFList.size()), 0, String.valueOf(rectFList.size()).length(), rect);
            int w = rect.width();
            int h = rect.height();
            canvas.drawText(String.valueOf(rectFList.size()),rectF.centerX()-w/2,rectF.centerY()+h/2,textPaint);


        }
        //左
        top=getHeight()-2*BORDER_LENGTH-MAGIN-horizontalSpacing;
        bottom=getHeight()-BORDER_LENGTH-MAGIN-horizontalSpacing;
        rigth=MAGIN+BORDER_LENGTH;;
        left=MAGIN;
        for (int i = 0; i < verticalNumber; i++) {
         if(i>0) {
                top=top-BORDER_LENGTH-horizontalSpacing;
                bottom=bottom-BORDER_LENGTH-horizontalSpacing;
            }
            RectF rectF=new RectF(left,top,rigth,bottom);
            rectFList.add(rectF);
            canvas.drawRect(rectF, grayPaint);

            rect = new Rect();
            textPaint.getTextBounds(String.valueOf(rectFList.size()), 0, String.valueOf(rectFList.size()).length(), rect);
            int w = rect.width();
            int h = rect.height();
            canvas.drawText(String.valueOf(rectFList.size()),rectF.centerX()-w/2,rectF.centerY()+h/2,textPaint);
        }

        //画红色的
        if(locationIndexFirst>=rectFList.size()) {
            locationIndexFirst=0;
        }
        if(locationIndexSecond>=rectFList.size()) {
            locationIndexSecond=0;
        }
        if(locationIndexThird>=rectFList.size()) {
            locationIndexThird=0;
        }
        canvas.drawRect(rectFList.get(locationIndexFirst),redPaint);
        rect = new Rect();
        textPaint.getTextBounds(String.valueOf(rectFList.size()), 0, String.valueOf(rectFList.size()).length(), rect);
        int w = rect.width();
        int h = rect.height();
        canvas.drawText(String.valueOf(locationIndexFirst+1),rectFList.get(locationIndexFirst).centerX()-w/2,rectFList.get(locationIndexFirst).centerY()+h/2,textPaint);
        if(isRuning){
            if(locationIndexSecond>=0){

                canvas.drawRect(rectFList.get(locationIndexSecond),redPaint);
                rect = new Rect();
                textPaint.getTextBounds(String.valueOf(rectFList.size()), 0, String.valueOf(rectFList.size()).length(), rect);
                w = rect.width();
                h = rect.height();
                canvas.drawText(String.valueOf(locationIndexSecond+1),rectFList.get(locationIndexSecond).centerX()-w/2,rectFList.get(locationIndexSecond).centerY()+h/2,textPaint);
            }
            if(locationIndexThird>=0){
                canvas.drawRect(rectFList.get(locationIndexThird),redPaint);
                rect = new Rect();
                textPaint.getTextBounds(String.valueOf(rectFList.size()), 0, String.valueOf(rectFList.size()).length(), rect);
                w = rect.width();
                h = rect.height();
                canvas.drawText(String.valueOf(locationIndexThird+1),rectFList.get(locationIndexThird).centerX()-w/2,rectFList.get(locationIndexThird).centerY()+h/2,textPaint);
            }

        }

    }

    public void startGo(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    isRuning=true;
                    locationIndexFirst++;

                    if(locationIndexFirst>0){
                        locationIndexSecond=locationIndexFirst-1;
                    }
                    if(locationIndexSecond>0){
                        locationIndexThird=locationIndexSecond-1;
                    }
                    if(locationIndexFirst==1 && locationIndexSecond == 0 && locationIndexThird>0){
                        locationIndexThird=rectFList.size()-1;
                    }


                    try {
                        sleepTime=200;
                        if(currentTime<=runTime*0.1){
                            sleepTime=sleepTime-50;
                        }else if(currentTime>runTime* 0.1 && currentTime <runTime*0.4){
                            sleepTime=sleepTime-100;
                        }else if(currentTime>runTime* 0.4 && currentTime <runTime*0.6 ){
                            sleepTime=sleepTime-180;
                        }else if(currentTime>runTime* 0.6 && currentTime <runTime*0.8){
                            sleepTime=sleepTime-100;
                        }else if(currentTime>runTime* 0.8 && currentTime <runTime*0.9){
                            sleepTime=sleepTime-50;
                        }else if(currentTime>runTime* 0.9){
                            sleepTime=200;
                        }
                        Thread.sleep(sleepTime);
                        currentTime+=sleepTime;
                        if(currentTime>=runTime){
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    postInvalidate();
                }
                isRuning=false;
                currentTime=0;
                postInvalidate();


            }
        }).start();

    }


    @Override
    public void onClick(View v) {
        if(!isRuning){
            startGo();
        }

    }


}
