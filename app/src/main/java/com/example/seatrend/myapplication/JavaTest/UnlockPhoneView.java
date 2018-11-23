package com.example.seatrend.myapplication.JavaTest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by seatrend on 2018/5/2.
 */

public class UnlockPhoneView extends View {

    private Paint circlePaint;
    private Paint linePaint;

    private PointF centerPointF; //中心点 也就是数字5的点
    private PointF onePointF; //1
    private PointF twoPointF; //2
    private PointF threePointF; //3
    private PointF fourPointF; //4
    private PointF sixPointF; //6
    private PointF sevenPointF; //7
    private PointF eightPointF; //8
    private PointF ninePointF; //9

    private PointF startPointF; //起点
    private PointF endPointF; //结束点

    private boolean selected1=false;
    private boolean selected2=false;
    private boolean selected3=false;
    private boolean selected4=false;
    private boolean selected5=false;
    private boolean selected6=false;
    private boolean selected7=false;
    private boolean selected8=false;
    private boolean selected9=false;

    private PointF pointFTag;

    private Path path=new Path();



    private final int SPACING=60; //间距
    private final int RADIUS=120; //半径
    private final int  DIAMETER=2*RADIUS;//直径


    public UnlockPhoneView(Context context) {
        super(context);
        init();

    }

    public UnlockPhoneView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public UnlockPhoneView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        circlePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setColor(Color.YELLOW);

        linePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setColor(Color.RED);
        linePaint.setStrokeWidth(20);

        //setBackgroundColor(Color.BLUE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerPointF=new PointF(getWidth()/2,getHeight()/2);
        onePointF=new PointF(centerPointF.x-SPACING-DIAMETER,centerPointF.y-DIAMETER-SPACING);
        twoPointF=new PointF(centerPointF.x,centerPointF.y-DIAMETER-SPACING);
        threePointF=new PointF(centerPointF.x+SPACING+DIAMETER,centerPointF.y-DIAMETER-SPACING);
        fourPointF=new PointF(centerPointF.x-SPACING-DIAMETER,centerPointF.y);
        sixPointF=new PointF(centerPointF.x+SPACING+DIAMETER,centerPointF.y);
        sevenPointF=new PointF(centerPointF.x-SPACING-DIAMETER,centerPointF.y+DIAMETER+SPACING);
        eightPointF=new PointF(centerPointF.x,centerPointF.y+DIAMETER+SPACING);
        ninePointF=new PointF(centerPointF.x+SPACING+DIAMETER,centerPointF.y+DIAMETER+SPACING);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCirclePoint(canvas);
        drawLine(canvas);
    }

    private void drawLine(Canvas canvas) {
            canvas.drawPath(path,linePaint);
    }

    private void drawCirclePoint(Canvas canvas) {

        canvas.drawCircle(onePointF.x,onePointF.y,RADIUS,circlePaint);//1
        canvas.drawCircle(twoPointF.x,twoPointF.y,RADIUS,circlePaint);//2
        canvas.drawCircle(threePointF.x,threePointF.y,RADIUS,circlePaint);//3
        canvas.drawCircle(fourPointF.x,fourPointF.y,RADIUS,circlePaint);//4
        canvas.drawCircle(centerPointF.x,centerPointF.y,RADIUS,circlePaint);//5
        canvas.drawCircle(sixPointF.x,sixPointF.y,RADIUS,circlePaint);//6
        canvas.drawCircle(sevenPointF.x,sevenPointF.y,RADIUS,circlePaint);//7
        canvas.drawCircle(eightPointF.x,eightPointF.y,RADIUS,circlePaint);//8
        canvas.drawCircle(ninePointF.x,ninePointF.y,RADIUS,circlePaint);//9

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                float x = event.getX();
                float y = event.getY();
                PointF pointF = pointInCircle(x, y);
                if(pointF != null){
                    //Log.i("pointInCircle","down x== "+x+" y == "+y);
                    startPointF=pointF;
                    path.moveTo(startPointF.x,startPointF.y);
                }

                break;
            case MotionEvent.ACTION_MOVE:
                 float x1 = event.getX();
                 float y1 = event.getY();

                PointF pointF1 = pointInCircle(x1, y1);
                if(pointF1 != null){
                        endPointF=pointF1;
                        path.lineTo(endPointF.x,endPointF.y);
                        //startPointF=endPointF;
                       // CanvasLine();
                    invalidate();
                }

                break;
            case MotionEvent.ACTION_UP:
                //startPointF=null;
                //endPointF=null;

                break;
        }

        return true;
    }

    private PointF pointInCircle(float x,float y){

        if(onePointF.x-RADIUS<x&& onePointF.x+RADIUS>x && onePointF.y-RADIUS<y && onePointF.y+RADIUS>y ){
            Log.i("pointseleted","点中第 "+1);
            selected1=true;
            return onePointF;
        }else if(twoPointF.x-RADIUS<x&& twoPointF.x+RADIUS>x && twoPointF.y-RADIUS<y && twoPointF.y+RADIUS>y ){
            Log.i("pointseleted","点中第 "+2);
            selected2=true;
            return twoPointF;
        }else if(threePointF.x-RADIUS<x&& threePointF.x+RADIUS>x && threePointF.y-RADIUS<y && threePointF.y+RADIUS>y ){
            Log.i("pointseleted","点中第 "+3);
            selected3=true;
            return threePointF;
        }else if(fourPointF.x-RADIUS<x&& fourPointF.x+RADIUS>x && fourPointF.y-RADIUS<y && fourPointF.y+RADIUS>y ){
            Log.i("pointseleted","点中第 "+4);
            selected4=true;
            return fourPointF;
        }else if(centerPointF.x-RADIUS<x&& centerPointF.x+RADIUS>x && centerPointF.y-RADIUS<y && centerPointF.y+RADIUS>y ){
            Log.i("pointseleted","点中第 "+5);
            selected5=true;
            return centerPointF;
        }else if(sixPointF.x-RADIUS<x&& sixPointF.x+RADIUS>x && sixPointF.y-RADIUS<y && sixPointF.y+RADIUS>y ){
            Log.i("pointseleted","点中第 "+6);
            selected6=true;
            return sixPointF;
        }else if(sevenPointF.x-RADIUS<x&& sevenPointF.x+RADIUS>x && sevenPointF.y-RADIUS<y && sevenPointF.y+RADIUS>y ){
            Log.i("pointseleted","点中第 "+7);
            selected7=true;
            return sevenPointF;
        }else if(eightPointF.x-RADIUS<x&& eightPointF.x+RADIUS>x && eightPointF.y-RADIUS<y && eightPointF.y+RADIUS>y ){
            Log.i("pointseleted","点中第 "+8);
            selected8=true;
            return eightPointF;
        }else if(ninePointF.x-RADIUS<x&& ninePointF.x+RADIUS>x && ninePointF.y-RADIUS<y && ninePointF.y+RADIUS>y ){
            Log.i("pointseleted","点中第 "+9);
            selected9=true;
            return ninePointF;
        }

        return null;
    }

    private void CanvasLine(){
        if(startPointF !=null && endPointF != null){
            Log.i("CanvasLine","CanvasLine == ");
          //  mCanvas.drawLine(startPointF.x,startPointF.y,endPointF.x,endPointF.y,linePaint);

        }
    }
}
