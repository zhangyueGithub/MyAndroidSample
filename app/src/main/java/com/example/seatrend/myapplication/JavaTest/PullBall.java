package com.example.seatrend.myapplication.JavaTest;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.seatrend.myapplication.R;

/**
 * Created by seatrend on 2018/4/28.
 */

public class PullBall extends View implements View.OnClickListener{

    Paint mPaint;
    PointF centerPointF;

    private int centerX;
    private int centerY;

    private Bitmap bitmap;
    private int bitmapHeight;
    private int bitmapWidth;

    public PullBall(Context context) {
        super(context);
        init(context);
    }

    public PullBall(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PullBall(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context){
        bitmap= BitmapFactory.decodeResource(context.getResources(), R.mipmap.ball);
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);

        bitmapHeight = bitmap.getHeight();
        bitmapWidth = bitmap.getWidth();

        setOnClickListener(this);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //centerPointF=new PointF(getWidth()/2,getHeight()/2);
        centerX=getWidth()/2;
        centerY=getHeight()/2;


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap,centerX-bitmapWidth/2,centerY-bitmapHeight/2,mPaint);

    }


    private void startAnimation(){
        //Animation animation=new TranslateAnimation()

        ValueAnimator animator=ValueAnimator.ofInt(0,1);
        animator.setDuration(3000);
        animator.start();
        //setAnimation(animator);
        //ValueAnimator animator1=ValueAnimator.ofObject();

        ImageView imageView;


    }


    @Override
    public void onClick(View v) {
        startAnimation();
    }
}
