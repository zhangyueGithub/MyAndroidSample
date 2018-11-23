package com.example.seatrend.myapplication.activity;

import android.content.Context;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.seatrend.myapplication.JavaTest.MyCamPara;
import com.example.seatrend.myapplication.R;

import java.util.List;
import java.util.TimerTask;

/**
 * Created by luokailiang on 2017/5/26.
 */

public class CameraActivity extends AppCompatActivity {
    private int zoom = 0;
    private int bgd = 0;
    public Camera mCamera;
    public ImageView flashLight;
    public SurfaceView sv;
    public boolean isFocusing = true;
    public SurfaceHolder holder;
    public static int with = 600;

    public void setBGDUp(Camera camera) {
        Camera.Parameters params = camera.getParameters();
        if (bgd != 2) {
            bgd += 1;
            params.setExposureCompensation(bgd);
            camera.setParameters(params);
        }
    }

    /**
     * */
    public void setBGDDown(Camera camera) {
        Camera.Parameters params = camera.getParameters();
        if (bgd != -2) {
            bgd -= 1;
            System.out.println("曝光度--减：" + bgd);
            params.setExposureCompensation(bgd);
            camera.setParameters(params);
        }
    }

    /**
     * */
    public void setZoomIn(Camera camera) {
        try {
            Camera.Parameters params = camera.getParameters();
            if (zoom < params.getMaxZoom()) {
                zoom = zoom + 5;
            } else {
                zoom = params.getZoom();
            }
            params.setZoom(zoom);
            camera.setParameters(params);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * */
    public void setZoomOut(Camera camera) {
        Camera.Parameters params = camera.getParameters();
        if (zoom > 5) {
            zoom = zoom - 5;
        } else {
            zoom = 0;
        }
        params.setZoom(zoom);
        camera.setParameters(params);

    }

    public View.OnClickListener changeBGDListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bgd_add:
                    setBGDUp(mCamera);
                    break;
                case R.id.bgd_sub:
                    setBGDDown(mCamera);
                    break;
            }
        }
    };
    public View.OnClickListener changeZoomListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.plus:
                    setZoomIn(mCamera);
                    break;

                case R.id.sub:
                    setZoomOut(mCamera);
                    break;
            }

        }
    };

    /**
     * */
    public void changeFlashLight() {
        Camera.Parameters params = mCamera.getParameters();
        params.setAutoWhiteBalanceLock(params.getAutoWhiteBalanceLock());
        String tag = flashLight.getTag() + "";
        String msg = "";
        msg = "";
     /*   if (tag.equals("off")) {// 3
            flashLight.setTag("on");
            flashLight.setBackgroundResource(R.drawable.button_flashautoon);
            params.setFlashMode(Camera.Parameters.FLASH_MODE_ON);
            msg = getString(R.string.sgd);
        } else if (tag.equals("on")) {// 2
            flashLight.setTag("always");
            flashLight.setBackgroundResource(R.drawable.button_flashon);
            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            msg = getString(R.string.light);

        } else if (tag.equals("always")) {// 1
            flashLight.setTag("off");
            params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            flashLight.setBackgroundResource(R.drawable.button_flashoff);
            msg = getString(R.string.shut);
        }*/
        mCamera.setParameters(params);
    }

    /**
     *
     * */
    public void releaseCamera() {
        if (mCamera != null) {
            mCamera.stopPreview();
            mCamera.release();
            mCamera = null;
        }
    }

    @Override
    protected void onDestroy() {
        releaseCamera();
        super.onDestroy();
    }



    /**
     *
     * */
    public Camera.ShutterCallback shutterCallback = new Camera.ShutterCallback() {

        @Override
        public void onShutter() {

        }
    };

    public Camera.AutoFocusCallback autoFocus = new Camera.AutoFocusCallback() {
        @Override
        public void onAutoFocus(boolean success, Camera camera) {
            if (success) {
                isFocusing = true;
                mCamera.setOneShotPreviewCallback(null);
                //Toast.makeText(context, R.string.djcg, Toast.LENGTH_SHORT).show();
            } else {
                isFocusing = false;
            }
        }
    };

    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {

            if (isFocusing) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                mCamera.autoFocus(autoFocus);
            }


        }
        return super.onTouchEvent(event);
    }

    class CameraTimerTask extends TimerTask {
        @Override
        public void run() {
            if (mCamera != null && isFocusing) {
                mCamera.autoFocus(autoFocus);
            }

        }

    }

    /**
     * @描述 设置相机参数
     */
    public Camera.Parameters defParameters(Camera mCameras) {
        Camera.Parameters parameters = mCameras.getParameters();// 获得相机参数
        List<Camera.Size> picSizes = parameters.getSupportedPictureSizes();
        Camera.Size picSize = null;
        // backCamPX = "无";
        if (picSizes!=null&&picSizes.size()>0){
           //if (picSizes.get(picSizes.size()-1).width>=with&&picSizes.get(picSizes.size()-1).height>=(with*4/3)){
            Camera.Size cameraSize=picSizes.get(0);
            if (picSizes.get(picSizes.size()-1).width>picSizes.get(0).width){
                cameraSize=picSizes.get(picSizes.size()-1);
            }
            if (cameraSize.width>=with&&cameraSize.height>=(with*4/3)){
               picSize = MyCamPara.getInstance().getPictureSize(picSizes, with, 1.33f);// 1.33ff
           }else {
               picSize = MyCamPara.getInstance().getPictureSize(picSizes, cameraSize.width, 1.33f);// 1.33ff
           }
            List<Camera.Size> preSizes = parameters.getSupportedPreviewSizes();
            Camera.Size preSize = MyCamPara.getInstance().getPreviewSize(preSizes, 950);// 部分手机不存在1000以上1.33f的比例
            parameters.setPreviewSize(preSize.width, preSize.height);// 设置预览照片
            WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);        // 设置预览大小,此属性影响清晰度
            Display display = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            display.getMetrics(displayMetrics);
            // 检查拍照设置的完整
            List<String> allfocus = parameters.getSupportedFocusModes();
            if (allfocus.contains(Camera.Parameters.FLASH_MODE_AUTO)) {
                parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
            }
            parameters.setPictureSize(picSize.width, picSize.height);
            parameters.setPictureFormat(PixelFormat.JPEG); // 设置照片格式
            parameters.setJpegQuality(100);
        }
        return parameters;
    }

    public Camera.OnZoomChangeListener zoomListener = new Camera.OnZoomChangeListener() {
        @Override
        public void onZoomChange(int zoomValue, boolean stopped, Camera camera) {

        }
    };


}
