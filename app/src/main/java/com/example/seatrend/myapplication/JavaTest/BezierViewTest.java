package com.example.seatrend.myapplication.JavaTest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by seatrend on 2018/4/25.
 */

public class BezierViewTest extends View {


   private Paint mPaint;
   private Path mPath;

   private int startPonitX=200;
   private int startPonitY=600;

   private int endPonitX=400;
   private int endPonitY=600;

   private int controlPonitX=startPonitX+(endPonitX-startPonitX)/2;
   private int controlPonitY=1000;




    public BezierViewTest(Context context) {
        super(context);
        init(context);
    }

    public BezierViewTest(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BezierViewTest(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }


    private void init(Context context){
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);// 抗锯齿
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
         // 抗锯齿
        //mPaint.setAntiAlias(true);
        // 防抖动
        mPaint.setDither(true);
        mPaint.setStrokeWidth(16);
        mPath=new Path();


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        onDrawOne(canvas);
    }

    private void onDrawOne(Canvas canvas) {
        mPath.reset();

        PointF startPointF=new PointF(startPonitX,startPonitY);
        PointF endPointF=new PointF(endPonitX,endPonitY);
        PointF controlPointF=new PointF(controlPonitX,controlPonitY);


        mPath.moveTo(startPointF.x,startPointF.y);
        mPath.quadTo(controlPointF.x,controlPointF.y,endPointF.x,endPointF.y);
        canvas.drawPath(mPath,mPaint);

        mPath.reset();
        startPointF=new PointF(endPonitX,endPonitY);
        mPath.moveTo(startPointF.x,startPointF.y);
        endPointF=new PointF(endPonitX+(endPonitX-startPonitX),startPonitY);
        controlPointF=new PointF(controlPonitX+(endPonitX-startPonitX),controlPonitY-2*(controlPonitY-startPonitY));
        mPath.quadTo(controlPointF.x,controlPointF.y,endPointF.x,endPointF.y);
        canvas.drawPath(mPath,mPaint);

        mPath.reset();
         startPointF=new PointF(startPonitX,startPonitY);
         endPointF=new PointF(endPonitX,endPonitY);
         controlPointF=new PointF(controlPonitX,controlPonitY-2*(controlPonitY-startPonitY));
        mPath.moveTo(startPointF.x,startPointF.y);
        mPath.quadTo(controlPointF.x,controlPointF.y,endPointF.x,endPointF.y);
        canvas.drawPath(mPath,mPaint);


        mPath.reset();
        startPointF=new PointF(endPonitX,endPonitY);
        mPath.moveTo(startPointF.x,startPointF.y);
        endPointF=new PointF(endPonitX+(endPonitX-startPonitX),startPonitY);
        controlPointF=new PointF(controlPonitX+(endPonitX-startPonitX),controlPonitY);
        mPath.quadTo(controlPointF.x,controlPointF.y,endPointF.x,endPointF.y);
        canvas.drawPath(mPath,mPaint);



    }
}
