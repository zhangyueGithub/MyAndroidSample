package com.example.seatrend.myapplication.JavaTest;

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
 * Created by seatrend on 2018/4/3.
 */

public class MyView extends View implements View.OnClickListener{

    private Context mContext;
    Paint mPaint;
    private int leftX;
    private int topY;

    private Bitmap bitmap;
    private int bitmapHeight;
    private int bitmapWidth;
    public MyView(Context context) {
        super(context);
        init(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs); init(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //默认左下角
        canvas.drawBitmap(bitmap,leftX,topY,mPaint);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        leftX=0;
        topY=getHeight()-bitmapHeight;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void init(Context context){
        bitmap= BitmapFactory.decodeResource(context.getResources(), R.drawable.shutter_still);
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);

        bitmapHeight = bitmap.getHeight();
        bitmapWidth = bitmap.getWidth();

        setOnClickListener(this);


        Runnable runnable=new Runnable() {
            @Override
            public void run() {

            }
        };
        Runnable runnable1=()->{};

    }

    @Override
    public void onClick(View v) {

    }
    private float startX=0;
    private float startY=0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                float   x= (int) event.getX();
                float   y= (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                x= (int) event.getX();
                y= (int) event.getY();
                if (x>=leftX && x<=leftX+bitmapWidth && y>=topY && y<topY+bitmapHeight
                        && x-bitmapWidth/2>0  && x+bitmapWidth/2<=getWidth()
                        && y-bitmapHeight/2>0  && y+bitmapHeight/2<=getHeight()){
                    Log.i("sddddddddd","come in");
                    leftX= (int) x-bitmapWidth/2;
                    topY= (int) y-bitmapHeight/2;
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                int endX= (int) event.getX();
                int endY= (int) event.getY();
                boolean isSlide=false;
                if (Math.abs(startX-endX)>10 || Math.abs(startY-endY)>10){
                    //滑动
                    isSlide=true;
                }else {
                    isSlide=false;
                }

                if (!isSlide && endX>=leftX && endX<=leftX+bitmapWidth && endY>=topY && endY<topY+bitmapHeight){
                if (mImageOnClick!=null){
                    mImageOnClick.OnClick();
                }
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    private ImageOnClick mImageOnClick;

    public void setImageOnClick(ImageOnClick mImageOnClick) {
        this.mImageOnClick = mImageOnClick;
    }

  public   interface ImageOnClick{
        void OnClick();
    }
}
