package com.example.seatrend.myapplication.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.seatrend.myapplication.R;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import static android.graphics.Bitmap.Config.ARGB_8888;

public class ImageTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_test);
        initView();
    }

    private void initView() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                BitmapFactory.Options options=new BitmapFactory.Options();
                options.inPreferredConfig= Bitmap.Config.ARGB_8888;
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.butt,options);

                int height = options.outHeight;
                int width = options.outWidth;
                Log.d("ssssss",width+"--"+height);
                compressImage(bitmap);
                //compressImages(bitmap);
                //writeTest(compressImages(bitmap));
            }
        }).start();


    }

    public  Bitmap compressImage(Bitmap image) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        int options = 100;
        android.util.Log.d("ssssss","压缩前大小："+baos.toByteArray().length/1024);
        while ( baos.toByteArray().length / 1024>500) { //循环判断如果压缩后图片是否大于500kb,大于继续压缩
            baos.reset();
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);
            options -= 10;
            android.util.Log.d("ssssss","正在压缩：");
        }
        android.util.Log.d("ssssss","压缩后大小："+baos.toByteArray().length/1024);
        writeTest(baos);
        return null;
    }

    private  void writeTest(ByteArrayOutputStream baos){
        //Bitmap bitmap = BitmapTools.Base64ToBitmap(bitmapstring);
        // 得到照片目录，如果没有就新建目录
        File dirFile = new File(Environment.getExternalStorageDirectory() + "/testImage/");
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        // 照片名字为系统时间
        // 新建照片文件
        File file = new File(dirFile, System.currentTimeMillis() + ".jpg");
        try {
            FileOutputStream fos = new FileOutputStream(file);
           // bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.write(baos.toByteArray());
            fos.flush();
            fos.close();
            android.util.Log.d("ssssss","保存成功");
        } catch (Exception e) {

        }

    }
    private  void writeTest(Bitmap bitmap){
        //Bitmap bitmap = BitmapTools.Base64ToBitmap(bitmapstring);
        // 得到照片目录，如果没有就新建目录
        File dirFile = new File(Environment.getExternalStorageDirectory() + "/testImage/");
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        // 照片名字为系统时间
        // 新建照片文件
        File file = new File(dirFile, System.currentTimeMillis() + ".jpg");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            //fos.write(baos.toByteArray());
            fos.flush();
            fos.close();
            android.util.Log.d("ssssss","保存成功");
        } catch (Exception e) {

        }

    }

    public static Bitmap compressImages(Bitmap image) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        int options = 100;
        android.util.Log.d("ssssss","压缩前大小："+baos.toByteArray().length/1024);
        while ( baos.toByteArray().length / 1024>500) { //循环判断如果压缩后图片是否大于500kb,大于继续压缩
            baos.reset();
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);
            options -= 10;
        }
        android.util.Log.d("ssssss","压缩后大小："+baos.toByteArray().length/1024);
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
        Bitmap bitmap = BitmapFactory.decodeStream(isBm);
        return bitmap;
    }
}
