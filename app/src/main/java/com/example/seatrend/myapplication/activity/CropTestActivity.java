package com.example.seatrend.myapplication.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.seatrend.myapplication.R;

public class CropTestActivity extends AppCompatActivity {

    ImageView ivCropBefore,ivCropLater;
    int[] location=new int[2];
    LinearLayout linearLayoutTest;
    Button btnCrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_test);
        init();
    }

    private void init() {
        ivCropBefore=findViewById(R.id.iv_crop_before);
        ivCropLater=findViewById(R.id.iv_crop_later);
        linearLayoutTest=findViewById(R.id.linear_layout_test);
        btnCrop=findViewById(R.id.btn_crop);
        //LruCache
    }

    public void btnCrop(View view) {
        int statusBarHeight = getStatusBarHeight(this);
        ivCropBefore.getLocationInWindow(location);
        Log.i("btnCrop"," --statusBarHeight----- "+statusBarHeight);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.butt);
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        //Bitmap bitmap1 = Bitmap.createBitmap(bitmap, 100, 100, bitmapWidth-100, bitmapHeight-400);
        Bitmap bitmap1 = convertViewToBitmap(linearLayoutTest);
        btnCrop.getLocationInWindow(location);
        btnCrop.getWidth();
        Bitmap bitmap2 = Bitmap.createBitmap(bitmap1, location[0], location[1]-statusBarHeight, btnCrop.getWidth(), btnCrop.getHeight());
        ivCropLater.setImageBitmap(bitmap2);
    }

    public Bitmap convertViewToBitmap(View view){

        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());

        view.buildDrawingCache();

        Bitmap bitmap=view.getDrawingCache();

        return bitmap;

    }


    private int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public  Bitmap capture() {
        getWindow().getDecorView().setDrawingCacheEnabled(true);
        Bitmap bmp = getWindow().getDecorView().getDrawingCache();
        return bmp;
    }


}
