package com.example.seatrend.myapplication.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
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
    private Map<String, Object> tagmap;
    private String imageTag = "";
    private String text;
    private Spinner photoPromptsSpi;
    private boolean safeToTakePicture = true;
    //private CameSpinnerAdapter adapter;
    private ArrayList<Map> photoslist = new ArrayList();
    private Button plus, sub, camera_change;
    private Context mContext = TestDefinedCameraActivity.this;
   // MaskView maskView = null;
    int DST_CENTER_RECT_WIDTH = 400;
    int DST_CENTER_RECT_HEIGHT = 100;
    int x1, y1;
    private SharedPreferences dataDictionaryShare;
   // Vehcrp vehcrpara;
    ArrayList<Map> cyzplist = new ArrayList();
    int spenneritem = 0;
    TextView v_xzyw, v_cyxm;
    ListView listview;
    //DefinedCameraPhotoAdapter photoAdapter;
   // SqliteUtil sqliteUtil;
    //UserInfo userInfo;
    String timeflag;
    public static long TIMETAGS = 0;
    LinearLayout lt_image;
    //ImageView  iv_iamge;
    Bitmap imageBitmap = null;
   // PhotoView mPhotoView;
    TextView bt_vin;
    double maxSize=320.00;
   // private DisplayImageOptions options;
   // private ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
       // dataDictionaryShare = getSharedPreferences(W.SHARE.BASE_SHARE, 0);
       // if (dataDictionaryShare.getBoolean(W.SHARE.PHOTOS_BUTTON,true)){
            setContentView(R.layout.activity_defined_camera_down_test);
       // }else setContentView(R.layout.activity_defined_camera_up);
       // imageLoader = ImageLoader.getInstance();
       // options = new DisplayImageOptions.Builder().bitmapConfig(Bitmap.Config.RGB_565).imageScaleType(ImageScaleType.IN_SAMPLE_INT).cacheInMemory(true).cacheOnDisc(true).build();
        //sqliteUtil = SqliteUtil.getInstance(getApplicationContext());
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

       // vehcrpara = (Vehcrp) Map2XmlUtils.Map2Xml_Response(dataDictionaryShare.getString(W.SHARE.VEHICLE_INFORMATION, "")).getBody().get(0);
       // userInfo = (UserInfo) Map2XmlUtils.Map2Xml_Response(dataDictionaryShare.getString(W.SHARE.USERINFO_LOGIN, "")).getBody().get(0);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        DST_CENTER_RECT_WIDTH = dm.widthPixels * 4 / 5;
        with = 1080;
       /* if (getIntent().getStringExtra("zc").equals("1")) {
            *//*查验项目和资料照片界面进入拍摄，等于其他值是是不合格照片*//*
            if (getIntent().getStringExtra("startflag").equals("dataphotoactivity")) {
                *//*资料照片界面进入拍摄*//*
               // cyzplist = DataPhotoActivity.cyzplist;
                if (getIntent().getStringExtra("BPLX").equals("02")) {
                    with = 1920;
                }
            } //else cyzplist = ProjectTableDecideFragment.cyzplist;
        }*/
        initWidgets();
        initHolder();
        //if (!sqliteUtil.getIsLSH(vehcrpara.getCylsh(), vehcrpara.getCycs()))
        //    sqliteUtil.insertPDA_PHOTO(dataDictionaryShare.getString(W.SHARE.HPHM, ""), vehcrpara.getCylsh(), vehcrpara.getCycs());

       // if (!dataDictionaryShare.getBoolean(W.SHARE.PHOTOS_SIZE, true)) {
          //  maxSize=220.00;
        //}
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
       // maskView = (MaskView) findViewById(R.id.view_mask);
        plus = (Button) findViewById(R.id.plus);
        sub = (Button) findViewById(R.id.sub);
      //  mPhotoView = (PhotoView) findViewById(R.id.iv_iamge);
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
   /*         tv1.setText(getResources().getString(R.string.vehicle_identification_code) + vehcrpara.getClsbdh());
            tv2.setText(getResources().getString(R.string.engine_number) + vehcrpara.getFdjh());
            fdjhm.setText(getResources().getString(R.string.engine_type) + vehcrpara.getFdjxh());*/
        }
        /*if (getIntent().getStringExtra("zc").equals("1")) {
            v_xzyw.setVisibility(View.VISIBLE);
            bt_vin.setVisibility(View.VISIBLE);
            photoPromptsSpi.setVisibility(View.VISIBLE);
            if (cyzplist != null && cyzplist.size() > 0) {
               // adapter = new CameSpinnerAdapter(mContext, cyzplist);
               // photoPromptsSpi.setAdapter(adapter);
                photoPromptsSpi.setOnItemSelectedListener(this);
                photoPromptsSpi.setSelection(0);
              //  imageTag = ((Map) adapter.getItem(0)).get("DMZ") + "";
              //  text = ((Map) adapter.getItem(0)).get("DMSM1") + "";
                spenneritem = 0;
            }
        } else {
            v_xzyw.setVisibility(View.GONE);
            photoPromptsSpi.setVisibility(View.GONE);
        }*/
        flashLight.setOnClickListener(this);
        takePhoto.setOnClickListener(this);
        photoslist.clear();
        //photoslist.addAll(HttpResultUtil.getList(getIntent().getStringExtra("photolist")));
       // photoAdapter = new DefinedCameraPhotoAdapter(context, photoslist);
       // listview.setAdapter(photoAdapter);

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
                takePhoto();
                break;
            case R.id.flashLight:
               /* if (!CheckUtil.isFastClick()) {
                    changeFlashLight();

                }*/
                break;
            case R.id.bt_vin:
                //PlugnIUitil.toVin((Activity) context,Constant.REQUEST_VIN_PHOTO,vehcrpara);
             //   startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), Constant.REQUEST_GET_PHOTO);
                break;
            case R.id.v_qr:
                 /*照片拍摄时，确认*/
                lt_image.setVisibility(View.GONE);
                if (getIntent().getStringExtra("zc").equals("1"))  photoPromptsSpi.setVisibility(View.VISIBLE);
                if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
                    // new Task().execute(bms);
                    Map result = savePhotos(imageBitmap, timeflag, imageTag);
                  //  photoAdapter.notifyDataSetChanged();
               /*     if (listview.isStackFromBottom()) {
                        listview.setStackFromBottom(false);
                    }
                    listview.setStackFromBottom(true);*/
                  //  UploadTaskManager downloadTaskMananger = UploadTaskManager.getInstance();
                    //downloadTaskMananger.addUploadTask(new UploadTask(getApplicationContext(), true, result.get("Zp") + "", result.get("PSSJ") + "", result.get("CYXM") + "", result.get("ZPZL") + "", result.get("ZPLJ") + "", vehcrpara.getCylsh(), vehcrpara.getCycs()));
                } else {
                   // Toast.makeText(mContext, getResources().getString(R.string.insert_memory_card), Toast.LENGTH_SHORT).show();
                }

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
          /*  if (data != null) {
                String markstring = vehcrpara.getClsbdh() + " " + TimeUtil.getFormatDate("yy-MM-dd HH:mm:ss") + "\n " + dataDictionaryShare.getString(W.SHARE.USERINFO_XYQMC, "");
                BitmapFactory.Options options = new BitmapFactory.Options();
             *//*   if (dataDictionaryShare.getBoolean(W.SHARE.PHOTOS_SIZE, true)) {
                    options.inSampleSize = 2;
                } else options.inSampleSize = 4;*//*
              //
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                options.inPurgeable = true;
                Bitmap bm = BitmapFactory.decodeByteArray(data, 0, data.length, options);
                timeflag = TimeUtil.getFormatDatemm();
                if (!getIntent().getStringExtra("zc").equals("1")) {
                    imageTag = getIntent().getStringExtra("DMZ") + "";
                }
                if (imageTag.equals("0103")) {
                    *//*车辆识别代号处理*//*
                    int xx = (int) ((float) bm.getWidth() / (float) (DisplayUtil.getScreenMetrics(TestDefinedCameraActivity.this).x * 4 / 5) * (float) x1);
                    int yy = (int) ((float) bm.getHeight() / (float) DisplayUtil.getScreenMetrics(TestDefinedCameraActivity.this).y * (float) y1);
                    int xpx = (int) ((float) bm.getWidth() / (float) (DisplayUtil.getScreenMetrics(TestDefinedCameraActivity.this).x * 4 / 5) * (DST_CENTER_RECT_WIDTH));
                    int ypx = (int) ((float) bm.getWidth() / (float) DisplayUtil.getScreenMetrics(TestDefinedCameraActivity.this).y * (float) DP2PX.dip2px(TestDefinedCameraActivity.this, DST_CENTER_RECT_HEIGHT - 20));
                    Bitmap rectBitmap = null;
                    if (xx + xpx <= bm.getWidth()) {
                        rectBitmap = Bitmap.createBitmap(bm, xx, yy, xpx, ypx);
                    } else rectBitmap = Bitmap.createBitmap(bm, xx, yy, bm.getWidth(), ypx);
                    savePhoto(ImageUtil.addWaterMark(context, rectBitmap, markstring));
                    if(rectBitmap != null){
                        rectBitmap.recycle();
                        rectBitmap=null;
                    }
                } else if (imageTag.equals("0198")) {
                     *//*标准照片处理*//*
                    int xx = (int) ((float) bm.getWidth() *(float) (1-(float)(DisplayUtil.getScreenMetrics(context).y*4 /5*88/60 / (float)(DisplayUtil.getScreenMetrics(context).x * 4 / 5 ) ))/2);
                    int yy = (int) ((float) bm.getHeight()*1/5/2);
                    int ypx = (int) ((float) bm.getHeight()*4/5);
                    int xpx =(int)(ypx*88/60);

                    Bitmap rectBitmap = null;
                    if (xx + xpx <= bm.getWidth()) {
                        rectBitmap = Bitmap.createBitmap(bm, xx, yy, xpx, ypx);
                    } else rectBitmap = Bitmap.createBitmap(bm, xx, yy, bm.getWidth(), ypx);
                    savePhoto(ImageUtil.addWaterMark(context, rectBitmap, markstring));
                    if(rectBitmap != null){
                        rectBitmap.recycle();
                        rectBitmap=null;
                    }
                } else savePhoto(ImageUtil.addWaterMark(context, bm, markstring)); //savePhoto(bm, timeflag, tag);
                if(bm !=null){
                    bm.recycle();
                    bm=null;
                }
            }
            safeToTakePicture = true;*/
            camera.startPreview();
        }
    };


    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
           // photoAdapter.notifyDataSetChanged();
           /* if (listview.isStackFromBottom()) {
                listview.setStackFromBottom(false);
            }
            listview.setStackFromBottom(true);*/
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

    private Map savePhotos(Bitmap bms, String timeFlag, String tags) {
        //photo = getImageView(bms);
        Map<String,String> map = null;
        // 得到照片目录，如果没有就新建目录
      /*  File dirFile = new File(Constant.CAMERA_PATH);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        // 照片名字为系统时间
        // 新建照片文件

        File file = new File(dirFile, TimeUtil.getFormatDateForPhoto(timeFlag) + ".jpg");
        if (!file.exists()) {
            tagmap = new HashMap<String, Object>();
            tagmap.put("path", file.getPath());// 存放照片路径到tag
            tagmap.put("text", text);
            tagmap.put("pzsj", TimeUtil.getFormatDate());
            tagmap.put("tag", tags);
            tagmap.put("isbeas64", "0");
           FileOutputStream fos;
            try {
                boolean succ = file.createNewFile();
                if (succ) {
                    fos = new FileOutputStream(file);
                    bms.compress(CompressFormat.JPEG, 100, fos);
                    fos.flush();
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            String jyws = BitmapTools.bitmapToBase64(mContext,BitmapTools.compressImageOutputStream(bms,320,60));
            if (getIntent().getStringExtra("zc").equals("1")) {
                tagmap.put("ZPZL", imageTag);
            } else {
                tagmap.put("ZPZL", getDate("01", "8002", tags).get("DMZ") + "");
            }
            photoslist.add(tagmap); // 把新增的imageview放入set集合中
            String CYZBBJ = vehcrpara.getCyzbbj() + "";
            String OTHER_YWLX = dataDictionaryShare.getString(W.SHARE.CHECK_OTHER_YWLX, "");
            if (OTHER_YWLX.indexOf(getIntent().getStringExtra("ywlx")) != -1) {
                CYZBBJ = "8";
            }
            if (getIntent().getStringExtra("zc").equals("1")) {
                *//*非不合格照片拍摄时，要先查出本次拍摄的照片在数据库中的数据先清除掉，再将拍摄照片插入数据库并显示*//*
                ArrayList<Map> newphotoslist = new ArrayList<Map>();
                ArrayList<Map> zplist = sqliteUtil.getPhoto(vehcrpara.getCylsh(), imageTag + "", vehcrpara.getCycs());
                for (int i = 0; i < zplist.size(); i++) {
                    Map deletemap = zplist.get(i);
                    File defile = new File(deletemap.get("ZP") + "");
                    if (defile.exists()) defile.delete();
                    sqliteUtil.deletePHOTO_LIST(vehcrpara.getCylsh(), imageTag + "", vehcrpara.getCycs());
                    sqliteUtil.deletePhotobase(deletemap.get("ZP") + "");
                    for (Map photomap : photoslist) {
                        if (photomap.get("path").equals(deletemap.get("ZP"))) {
                            newphotoslist.add(photomap);
                        }
                    }
                }
                if (zplist.size() > 0) {
                    photoslist.removeAll(newphotoslist);
                }
                  sqliteUtil.insertPhoto(vehcrpara.getCylsh(), dataDictionaryShare.getString(W.SHARE.USERINFO_XYQXH, ""), dataDictionaryShare.getString(W.SHARE.HPHM, ""), vehcrpara.getHpzl(), vehcrpara.getClsbdh(), file.getPath(), timeFlag, "", imageTag + "", "0", vehcrpara.getCycs(), CYZBBJ, userInfo.getGlbm());
            } else sqliteUtil.insertPhoto(vehcrpara.getCylsh(), dataDictionaryShare.getString(W.SHARE.USERINFO_XYQXH, ""), dataDictionaryShare.getString(W.SHARE.HPHM, ""), vehcrpara.getHpzl(), vehcrpara.getClsbdh(), file.getPath(), timeFlag, "" + getIntent().getStringExtra("DMZ"), getDate("01", "8002", tags).get("DMZ") + "", "0", vehcrpara.getCycs(), CYZBBJ, userInfo.getGlbm());

                  sqliteUtil.insertPhotobase(file.getPath(), jyws);
                    *//*拍照一张加入上传队列*//*
            if (getIntent().getStringExtra("zc").equals("1")) {
                map = new HashMap();
                map.put("nameflag", Util.getSyetemTime() + "");
                map.put("Zp", jyws);
                map.put("PSSJ", timeFlag);
                map.put("CYXM", "");
                map.put("ZPZL", imageTag);
                map.put("ZPLJ", file.getPath());
            } else {
                map = new HashMap();
                map.put("nameflag", Util.getSyetemTime() + "");
                map.put("Zp", jyws);
                map.put("PSSJ", timeFlag);
                map.put("CYXM", getIntent().getStringExtra("DMZ"));
                map.put("ZPZL", getDate("01", "8002", tags).get("DMZ") + "");
                map.put("ZPLJ", file.getPath());
            }
        }*/

        return map;

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

}
