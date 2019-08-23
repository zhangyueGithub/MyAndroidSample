package com.example.seatrend.myapplication.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seatrend.myapplication.BezierLineActivity;
import com.example.seatrend.myapplication.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 */
@SuppressLint("NewApi")
public class TestDefinedCameraActivity extends CameraActivity implements Callback, OnClickListener, OnItemSelectedListener {
    private ImageButton takePhoto;
    private String imageTag = "";
    private String text;
    private Spinner photoPromptsSpi;
    private ArrayList<Map> photoslist = new ArrayList();
    private Button plus, sub, camera_change;
    int DST_CENTER_RECT_WIDTH = 400;
    int DST_CENTER_RECT_HEIGHT = 100;
    int x1, y1;
   // Vehcrp vehcrpara;
    ArrayList<Map> cyzplist = new ArrayList();
    int spenneritem = 0;
    TextView v_xzyw, v_cyxm;
    ListView listview;
    String timeflag;
    public static long TIMETAGS = 0;
    LinearLayout lt_image;
    Bitmap imageBitmap = null;
    TextView bt_vin;
    double maxSize=320.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

            setContentView(R.layout.activity_defined_camera_down_test);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        int checkPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (checkPermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
        } else {
            setUI();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == 1) {
            int checkPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
            if (checkPermission != PackageManager.PERMISSION_GRANTED) {
               // ViewUtil.toast(context, getResources().getString(R.string.please_open_camera_permissions));
                finish();
            } else setUI();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    public void setUI() {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        DST_CENTER_RECT_WIDTH = dm.widthPixels * 4 / 5;
        with = 1080;
        initWidgets();
        initHolder();
    }

    private void initHolder() {
        holder = sv.getHolder();
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        holder.addCallback(this);
    }

    /**
     *
     *
     * */
    private void initWidgets() {
        bt_vin=(TextView) findViewById(R.id.bt_vin);
        listview = (ListView) findViewById(R.id.listview);
        plus = (Button) findViewById(R.id.plus);
        sub = (Button) findViewById(R.id.sub);
        camera_change = (Button) findViewById(R.id.camera_change);
       // mPhotoView = (PhotoView) findViewById(R.id.iv_iamge);
        lt_image = (LinearLayout) findViewById(R.id.lt_image);
        plus.setOnClickListener(changeZoomListener);
        sub.setOnClickListener(changeZoomListener);
        v_xzyw = (TextView) findViewById(R.id.v_xzyw);
        v_cyxm = (TextView) findViewById(R.id.v_cyxm);
        takePhoto = (ImageButton) findViewById(R.id.takePhoto);
        photoPromptsSpi = (Spinner) findViewById(R.id.photoPromptsSpi);
        flashLight = (ImageView) findViewById(R.id.flashLight);
        sv = (SurfaceView) findViewById(R.id.surfaceView);
        camera_change.setOnClickListener(this);
        findViewById(R.id.bgd_add).setOnClickListener(changeBGDListener);
        findViewById(R.id.bgd_sub).setOnClickListener(changeBGDListener);
        findViewById(R.id.v_qr).setOnClickListener(this);
        findViewById(R.id.v_qx).setOnClickListener(this);
        sv.setZOrderMediaOverlay(true);
        if (getIntent().getBooleanExtra("visibile", false)) {
            findViewById(R.id.top_msg).setVisibility(View.GONE);
        } else {
            TextView tv1 = (TextView) findViewById(R.id.camera_text1);
            TextView tv2 = (TextView) findViewById(R.id.camera_text2);
            TextView tv3 = (TextView) findViewById(R.id.camera_text3);
            TextView fdjhm = (TextView) findViewById(R.id.camera_fdjhm);

        }

        flashLight.setOnClickListener(this);
        takePhoto.setOnClickListener(this);
        photoslist.clear();
        bt_vin.setOnClickListener(this);
    }

    int cameraPosition = 0;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.camera_change:
                try {
                    mCamera.stopPreview();//
                    mCamera.release();//
                    mCamera = null;//
                    mCamera = Camera.open(cameraPosition);//
                    if (cameraPosition == 1)
                        cameraPosition = 0;
                    else
                        cameraPosition = 1;
                    try {
                        mCamera.setPreviewDisplay(holder);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mCamera.setParameters(defParameters(mCamera));
                    mCamera.startPreview();
                    mCamera.autoFocus(autoFocus);
                }catch (Exception e){
                   // ViewUtil.toast(mContext,e.toString());
                }

                break;

            case R.id.takePhoto:
               // takePhoto();
                startActivity(new Intent(this,BezierLineActivity.class));
                break;
            case R.id.flashLight:
               /* if (!CheckUtil.isFastClick()) {
                    changeFlashLight();

                }*/
                break;
            case R.id.bt_vin:
                break;
            case R.id.v_qr:
                 /*照片拍摄时，确认*/
                lt_image.setVisibility(View.GONE);
                if (getIntent().getStringExtra("zc").equals("1"))  photoPromptsSpi.setVisibility(View.VISIBLE);

                if (getIntent().getStringExtra("zc").equals("1")) {
                    cyzplist.get(spenneritem).put("sfcy", "1");
                    //adapter.notifyDataSetChanged();
                    if (spenneritem + 1 < cyzplist.size())
                        photoPromptsSpi.setSelection(spenneritem + 1);
                }
                if (cameraPosition == 0){
                    mCamera.stopPreview();//
                    mCamera.release();//
                    mCamera = null;//
                    mCamera = Camera.open(cameraPosition);//
                    cameraPosition = 1;
                    try {
                        mCamera.setPreviewDisplay(holder);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mCamera.setParameters(defParameters(mCamera));
                    mCamera.startPreview();
                    mCamera.autoFocus(autoFocus);
                }
                break;
            case R.id.v_qx:
                 /*照片拍摄时，取消重拍*/
                if (getIntent().getStringExtra("zc").equals("1")) photoPromptsSpi.setVisibility(View.VISIBLE);
                lt_image.setVisibility(View.GONE);
                imageBitmap = null;
                break;
        }
    }

    public void takePhoto() {

        /*if (!CheckUtil.checkSDCard()) {
            Toast.makeText(mContext, R.string.insufficient_memory, Toast.LENGTH_SHORT).show();
            return;
        }*/
       // if (!CheckUtil.isFastClick() && safeToTakePicture) {
            mCamera.takePicture(shutterCallback, null, jpegCallback);
        //    safeToTakePicture = false;
       // }
    }

    PictureCallback jpegCallback = new PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {

            camera.stopPreview();

            camera.startPreview();
        }
    };


    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {

            return false;
        }
    });

    public void savePhoto(Bitmap bms) {
        lt_image.setVisibility(View.VISIBLE);
        photoPromptsSpi.setVisibility(View.INVISIBLE);
        v_cyxm.setText(text);
    //   imageBitmap =  BitmapTools.compressImage(bms,maxSize,80);
        imageBitmap =  bms;
      //  mPhotoView.setImageBitmap(bms);
    }



    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        mCamera.stopPreview();
        mCamera.setParameters(defParameters(mCamera));
        mCamera.startPreview();
        mCamera.autoFocus(autoFocus);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        try {
            mCamera = Camera.open();
            if (mCamera != null) {
                mCamera.setPreviewDisplay(holder);
                mCamera.setZoomChangeListener(zoomListener);

            }

        } catch (IOException e) {
            releaseCamera();
            e.printStackTrace();
        }

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        releaseCamera();
    }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View view, int position, long arg3) {
        /*spenneritem = position;
        imageTag = ((Map) adapter.getItem(position)).get("DMZ") + "";
        text = ((Map) adapter.getItem(position)).get("DMSM1") + "";
        if ((imageTag.equals("0198") || imageTag.equals("0103")) && Constant.CAR_VIN_FLAG.equals("1")) {
            maskView.setVisibility(View.VISIBLE);
            if (maskView != null) {
                Rect screenCenterRect;
                if (imageTag.equals("0103")) {
                    screenCenterRect = createCenterScreenRect((DST_CENTER_RECT_WIDTH), DP2PX.dip2px(mContext, DST_CENTER_RECT_HEIGHT));
                    maskView.setCenterRect(screenCenterRect);
                } else if (imageTag.equals("0198")) {
                    screenCenterRect = createCenterScreenRectx((int) ((float)DisplayUtil.getScreenMetrics(TestDefinedCameraActivity.this).y * 4 / 5*88/60),(DisplayUtil.getScreenMetrics(TestDefinedCameraActivity.this).y * 4 / 5));
                    maskView.setCenterRect(screenCenterRect);
                }
            }
        } else {
            maskView.setVisibility(View.INVISIBLE);
        }*/

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 24 || keyCode == 25) {
            takePhoto();
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_BACK) {
            releaseCamera();
            Intent i = new Intent();
            //i.putExtra("data", HttpResultUtil.toJsonString(photoslist));
           // i.putExtra("list", HttpResultUtil.toJsonString(cyzplist));
            setResult(RESULT_OK, i);
            this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }


    /*private Rect createCenterScreenRectx(int w, int h) {
        x1 = (DisplayUtil.getScreenMetrics(this).x * 4 / 5 - DisplayUtil.getScreenMetrics(this).y*4 /5*88/60)/2;
        y1 = (DisplayUtil.getScreenMetrics(this).y -DisplayUtil.getScreenMetrics(this).y*4/5)/2;
        int x2 = x1 + w;
        int y2 = y1 + h;
        return new Rect(x1, y1, x2, y2);
    }
    private Rect createCenterScreenRect(int w, int h) {

        x1 = DisplayUtil.getScreenMetrics(this).x * 2 / 5 - w / 2;
        y1 = DisplayUtil.getScreenMetrics(this).y / 2 - h / 2;
        int x2 = x1 + w;
        int y2 = y1 + h;
        return new Rect(x1, y1, x2, y2);
    }*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       /* if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case Constant.ZPSCHD:
                    SerInfo serInfol = (SerInfo) data.getSerializableExtra("serinfo");
                    photoslist.clear();
                    photoslist.addAll((ArrayList<Map>) serInfol.getListmap());
                    photoAdapter.notifyDataSetChanged();
                    updataSpnner(photoslist);
                    break;
                case Constant.REQUEST_VIN_PHOTO:
                    timeflag = TimeUtil.getFormatDatemm();
                    if (getIntent().getStringExtra("zc").equals("1")) {
                        for (int i = 0; i <cyzplist.size() ; i++) {//DMZ
                            if ( (cyzplist.get(i).get("DMZ")+"").equals("0103") ){
                                text=cyzplist.get(i).get("DMSM1")+"";
                                imageTag = "0103";
                                photoPromptsSpi.setSelection(spenneritem);
                                ((Map<String,String>) cyzplist.get(i)).put("sfcy", "1");
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                    if (data != null) {
                            Bitmap curBitmap = imageLoader.loadImageSync("file://" + data.getStringExtra("zp"),options);
                            Map result = savePhotos(curBitmap, timeflag, imageTag);
                            photoAdapter.notifyDataSetChanged();
                            *//*if (listview.isStackFromBottom()) {
                                listview.setStackFromBottom(false);
                            }
                            listview.setStackFromBottom(true);*//*
                            UploadTaskManager downloadTaskMananger = UploadTaskManager.getInstance();
                            downloadTaskMananger.addUploadTask(new UploadTask(getApplicationContext(), true, result.get("Zp") + "", result.get("PSSJ") + "", result.get("CYXM") + "", result.get("ZPZL") + "", result.get("ZPLJ") + "", vehcrpara.getCylsh(), vehcrpara.getCycs()));
                    }
                    break;
                case Constant.REQUEST_GET_PHOTO:
                    timeflag = TimeUtil.getFormatDatemm();
                    if (getIntent().getStringExtra("zc").equals("1")) {
                        for (int i = 0; i <cyzplist.size() ; i++) {//DMZ
                            if ( (cyzplist.get(i).get("DMZ")+"").equals("0103") ){
                                ((Map<String,String>) cyzplist.get(i)).put("sfcy", "1");
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                    if (data != null) {
                        Uri uri = data.getData();
                        ContentResolver cr = this.getContentResolver();
                        try {
                            Bitmap curBitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                            Map result = savePhotos(curBitmap, timeflag, imageTag);
                            photoAdapter.notifyDataSetChanged();
                           *//* if (listview.isStackFromBottom()) {
                                listview.setStackFromBottom(false);
                            }
                            listview.setStackFromBottom(true);*//*
                            UploadTaskManager downloadTaskMananger = UploadTaskManager.getInstance();
                            downloadTaskMananger.addUploadTask(new UploadTask(getApplicationContext(), true, result.get("Zp") + "", result.get("PSSJ") + "", result.get("CYXM") + "", result.get("ZPZL") + "", result.get("ZPLJ") + "", vehcrpara.getCylsh(), vehcrpara.getCycs()));
                        } catch (FileNotFoundException e) {
                            Log.e("Exception", e.getMessage(), e);
                        }
                    }
                    break;

            }
        }*/

    }

    /*删除回掉更新拍照项目*/
    public void updataSpnner(ArrayList<Map> datalist) {
        if (getIntent().getStringExtra("zc").equals("1")) {
            for (int i = 0; i < cyzplist.size(); i++) {
                Boolean isdelete = true;
                for (Map zpmap : (ArrayList<Map>) datalist) {
                    if ((zpmap.get("tag") + "").equals(cyzplist.get(i).get("DMZ") + "")) {
                        isdelete = false;
                    }
                }
                if (isdelete) {
                    cyzplist.get(i).put("sfcy", "0");
                } else cyzplist.get(i).put("sfcy", "1");

            }
           // adapter.notifyDataSetChanged();
        }
    }

    /*public Map getDate(String XTLB, String DMLB, String DMSM3) {
        Map map = new HashMap();
        Map hpzlmap = SqliteUtil.getInstance(context).getSea_ZPZLDate(XTLB, DMLB, DMSM3);
        if (hpzlmap != null) {
            map = hpzlmap;
        }
        return map;
    }*/

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("ddd","--  "+newConfig.orientation);
        Toast.makeText(this,"-- "+newConfig.orientation,Toast.LENGTH_SHORT).show();
    }
}
