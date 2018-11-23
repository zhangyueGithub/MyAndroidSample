package com.example.seatrend.myapplication.JavaTest;


import android.hardware.Camera;
import android.util.Log;

/**
 * Created by seatrend on 2018/4/19.
 */

public class FlashUtils {
    private static FlashUtils utils;
    private static Camera camera;
    public static boolean mIsOpen = true;

    //使用单例模式在这里初始化相机
    public static FlashUtils getInstance() {
        if (utils == null) {
            utils = new FlashUtils();
        }
        try {
            if (camera == null) {
                camera = Camera.open();
            }
        } catch (Exception e) {
            if (camera != null) {
                camera.release();
            }
            camera = null;
        }
        return utils;
    }

    //参考二维码工具的闪光灯
    public void switchFlash() {
        try {
            Camera.Parameters parameters = camera.getParameters();
            if (mIsOpen) {
                if (parameters.getFlashMode().equals("torch")) {
                    return;
                } else {
                    parameters.setFlashMode("torch");
                }
            } else {
                if (parameters.getFlashMode().equals("off")) {
                    return;
                } else {
                    parameters.setFlashMode("off");
                }
            }
            camera.setParameters(parameters);
        } catch (Exception e) {
            finishFlashUtils();
        }
        mIsOpen = !mIsOpen;
    }

    //页面销毁的时候调用此方法
    public void finishFlashUtils() {
        if (camera != null) {
            camera.stopPreview();
            camera.release();
        }
        camera = null;
    }

    /*public void Openshoudian() {
        //异常处理一定要加，否则Camera打开失败的话程序会崩溃
        try {
            Log.d("smile","camera打开");
            camera = Camera.open();
        } catch (Exception e) {
            Log.d("smile","Camera打开有问题");
            //Toast.makeText(context, "Camera被占用，请先关闭", Toast.LENGTH_SHORT).show();
        }

        if(camera != null)
        {
            //打开闪光灯
            camera.startPreview();
            Camera.Parameters parameter = camera.getParameters();
            parameter.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(parameter);
            Log.d("smile","闪光灯打开");


        }
    }

    public void Closeshoudian() {
        if (camera != null) {
            //关闭闪光灯
            Log.d("smile", "closeCamera()");
            camera.getParameters().setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(camera.getParameters());
            camera.stopPreview();
            camera.release();
            camera = null;

        }
    }*/

}
