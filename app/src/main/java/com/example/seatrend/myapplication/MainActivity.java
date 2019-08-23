package com.example.seatrend.myapplication;

import android.Manifest;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seatrend.myapplication.JavaTest.AESUtils;
import com.example.seatrend.myapplication.JavaTest.FlashUtils;
import com.example.seatrend.myapplication.JavaTest.NetWorkSpeedUtils;
import com.example.seatrend.myapplication.JavaTest.RSAUtils;
import com.example.seatrend.myapplication.JavaTest.Utils;
import com.example.seatrend.myapplication.JavaTest.WebViewActivity;
import com.example.seatrend.myapplication.activity.BlueToothActivity;
import com.example.seatrend.myapplication.activity.CameraActivity;
import com.example.seatrend.myapplication.activity.FocusListActivity;
import com.example.seatrend.myapplication.activity.HttpTestActivity;
import com.example.seatrend.myapplication.activity.ImageTestActivity;
import com.example.seatrend.myapplication.activity.MyVideoActivity;
import com.example.seatrend.myapplication.activity.NetWorkVideoActivity;
import com.example.seatrend.myapplication.activity.QianMingActivity;
import com.example.seatrend.myapplication.activity.SmartSwipeDemoActivity;
import com.example.seatrend.myapplication.activity.TaskTestActivity;
import com.example.seatrend.myapplication.activity.TbsDemoActivity;
import com.example.seatrend.myapplication.activity.TestDefinedCameraActivity;
import com.example.seatrend.myapplication.activity.FolatTestActivity;
import com.example.seatrend.myapplication.activity.SocketDemoActivity;
import com.example.seatrend.myapplication.activity.VideoActivity;
import com.example.seatrend.myapplication.activity.ViewPagerDemoActivity;
import com.example.seatrend.myapplication.activity.ZoomActivity;
import com.example.seatrend.myapplication.test.TestOnClick;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks{
    private final String TAG="MainActivity";

    private TextView mtext2;
    private String data="鹅鹅鹅，曲项向天歌，辣椒香油水，红掌剥清剥";
    private final String PWD="123456";
    private Button msbBtn;
    private LinearLayout mlinear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msbBtn=findViewById(R.id.sb_btn);
        mlinear=findViewById(R.id.linear);

        Utils.logString(this);
        aesTest();
       // HttpParams params = new BasicHttpParams();
        //intee();
       // inityyyyyyyy();
        initTest();
        RSAUtils.geRSAtKeys();
        EditText editText=new EditText(this);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            boolean b = EasyPermissions.hasPermissions(this, mPermissionList);
            if(!b){
                EasyPermissions.requestPermissions(this,"EasyPermissions 请求权限",6,mPermissionList);
            }
        }

    }

    private void initTest() {
      //ActivityManager manager= (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
      //  int memoryClass = manager.getMemoryClass(); //获取系统分配的 内存大小 单位M
      //  Log.i("memoryClass"," memoryClass == "+memoryClass);
        ExecutorService executorService = new ThreadPoolExecutor(0,
                5, 60, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());

        //long l = Runtime.getRuntime().maxMemory(); 获取当前应用最大的可用 内存  单位 字节
        /*ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(10);
        Executors.newSingleThreadExecutor();
*/

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message message = Message.obtain();
                message.obj="线程池里面的线成 发出去的 消息";
                message.what=6;
                handler.sendMessage(message);
            }
        });

        //RSAUtils.getKeys();
       String encrypt = RSAUtils.encrypt(data, RSAUtils.getPublicKey());


        Log.i("RSAUtils","加密后的数据 -- "+encrypt);

        String decrypt = RSAUtils.decrypt(encrypt, RSAUtils.getPrivateKey());
        Log.i("RSAUtils","解密后的数据 -- "+decrypt);
    }


    private void paTest(){
        String encode = it.sauronsoftware.base64.Base64.encode(data);

        Log.i("paTest","加密后的数据："+encode);

        String decode = it.sauronsoftware.base64.Base64.decode(encode);

        Log.i("paTest","解密后的数据："+decode);
    }

    private void aesTest(){

        byte[] encrypt = AESUtils.encrypt(data, PWD);
        String s2 = AESUtils.parseByte2HexStr(encrypt);
        Log.i("AESUtils","加密后的数据 -- "+s2);
        byte[] bytes = AESUtils.parseHexStr2Byte(s2);
        byte[] decrypt = AESUtils.decrypt(bytes, PWD);
        String s1 = new String(decrypt);
        Log.i("AESUtils","解密后的数据 -- "+s1);
        String p=Environment.getExternalStorageDirectory().getPath()+"/checkoutside"+System.currentTimeMillis();
        Log.i("AESUtils","p -- "+p);
    }



    @SuppressLint("HandlerLeak")
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 6){
               String str= (String) msg.obj;
                Toast.makeText(MainActivity.this," -- "+str,Toast.LENGTH_SHORT).show();
            }else {
                String obj = (String) msg.obj;
                mtext2.setText(obj);

            }

        }
    };

    private void intee() {
        /*try {
            String encode = URLEncoder.encode("好久不见", "utf-8");
            Log.i("encode","--encode--- "+encode);

            String decode = URLDecoder.decode(encode, "utf-8");
            Log.i("encode","--decode--- "+decode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/

        //TestOnClick.testMethord(this);

       // getPackageManager().getPackageArchiveInfo()
      //  DownloadManager.

       /* Test2 adpter = new Test2(this);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new MyDiffUtils(), true);
        diffResult.dispatchUpdatesTo(adpter);*/


       // VideoView
        //MemoryCache memoryCache=new MemoryCache();


    }

    private void inityyyyyyyy() {
        //DiffUtil.calculateDiff()
        String name = Thread.currentThread().getStackTrace()[2].getMethodName(); //getStackTrace

       /* StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTrace.length; i++) {
            Log.i("TestOnClick","------- "+stackTrace[i].getMethodName());
        }*/


        String threadName = Thread.currentThread().getName();
        Log.i("TestOnClick","inityyyyyyyy == "+name +"  threadName = "+threadName);
        /*String Classname = this.getClass().getName(); //url
        String source="waijian";
        String r="前一个页面的URL";
        long time=System.currentTimeMillis()/1000;

        UserB userB = new UserB();
*/
        //DownloadManager.getMaxBytesOverMobile()

        findViewById(R.id.m_text_view).setOnClickListener(new TestOnClick() {
            @Override
            public void OnClickEvent(View view) {

                /*Log.i("TestOnClick","m_text_view  +");
                Log.i(TAG,"OnClick");*/

                initTest();

                //paTest();

            }
        });
       final NetWorkSpeedUtils mNetWorkSpeedUtils=new NetWorkSpeedUtils(this,handler);
         mtext2 = (TextView) findViewById(R.id.m_text_view2);
        mtext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // mNetWorkSpeedUtils.startShowNetSpeed();
                aesTest();
            }
        });

    }



    private void snackBarEvent(){
        View view = LayoutInflater.from(this).inflate(R.layout.snackbar_view, null);
        // view snackBar的容器
        Snackbar snackbar = Snackbar.make(mlinear, "snackbar test", Snackbar.LENGTH_SHORT).setAction("有本事你点我啊", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "你还真敢点我", Toast.LENGTH_SHORT).show();
            }
        }).setActionTextColor(Color.BLUE);

        snackbar.getView().setBackgroundColor(getResources().getColor(R.color.colorAccent));
        snackbar.show();

    }



    public void BtnOnClick(View view) {
        startActivity(new Intent(this, DownLoadActivity.class));

    }

    public void sbOnClick(View view) {
        snackBarEvent();
    }


        private String [] mPermissionList={Manifest.permission.CAMERA,
        Manifest.permission.LOCATION_HARDWARE,
                Manifest.permission.CAPTURE_VIDEO_OUTPUT,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CALL_PHONE};
    public void flashOnClick(View view) {

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            boolean b = EasyPermissions.hasPermissions(this, mPermissionList);
            if(b){
                openFlash();
            }else {
                EasyPermissions.requestPermissions(this,"请同意打开闪光灯权限，否则无法打开闪光灯",6,mPermissionList);
            }
        }else {
            openFlash();
        }


    }

    private void openFlash(){
        FlashUtils.getInstance().switchFlash();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //跳转到onPermissionsGranted或者onPermissionsDenied去回调授权结果
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults,this);

    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        //成功

        openFlash();

        for (int i = 0; i < perms.size(); i++) {
            Log.i("Granted",""+perms.get(i));
        }


    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        //失败
        for (int i = 0; i < perms.size(); i++) {
            Log.i("Denied",""+perms.get(i));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {
            //拒绝授权后,从系统设置了授权后,返回APP进行相应的操作
            Log.i(TAG, "onPermissionsDenied:------>自定义设置授权后返回APP");

        }

    }

    public void webOnClick(View view) {
       startActivity(new Intent(this, WebViewActivity.class));
       //ThreadTest();
    }
    int tag=0;
    public void ThreadTest(){

       /* new Thread(){
            @Override
            public void run() {
                super.run();
                Looper.prepare();
                Toast.makeText(MainActivity.this,"子线程弹出的消息",Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        }.start();*/



    }
    private Thread thread=new Thread(){
        @Override
        public void run() {
            super.run();
            Looper.prepare();
            Toast.makeText(MainActivity.this,"子线程弹出的消息",Toast.LENGTH_SHORT).show();
            Looper.loop();
            stop();
        }
    };

    private void addTag(){
        tag++;
       // LayoutInflater.from(this).inflate()
        long maxMemory = Runtime.getRuntime().maxMemory() / 8;
        LruCache<String,Bitmap> mLruCache=new LruCache<String,Bitmap>((int) maxMemory){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                int byteCount = value.getByteCount();
                return byteCount;
            }
        };

    }

    public void bezierOnClick(View view) {
        //startActivity(new Intent(this,BezierLineActivity.class));
        startActivity(new Intent(this,TestDefinedCameraActivity.class));
        //startActivity(new Intent(this,KeepLiveActivity.class));
        //startAnimator();
    }

    private void startAnimator() {
                 final ValueAnimator animator = ValueAnimator.ofInt(0, 100);
                 animator.setDuration(5000);
                 animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
             @Override
             public void onAnimationUpdate(ValueAnimator animation) {
                                 /**
                                   * 通过这样一个监听事件，我们就可以获取
                                   * 到ValueAnimator每一步所产生的值。
                                   *
                                   * 通过调用getAnimatedValue()获取到每个时间因子所产生的Value。
                                   * */
                                 Integer value = (Integer) animation.getAnimatedValue();
                                 //btn_click.setText(value + "");
                 Log.i("value","value == "+value);
                             }
         });
                 animator.start();
             }

    public void blueToothOnClick(View view) {
        //startActivity(new Intent(this, BlueToothActivity.class));
        startActivity(new Intent(this, TaskTestActivity.class));
        //String currentWifiName = Utils.getCurrentWifiName(this);
        //Log.i("currentWifiName"," currentWifiName ==  "+currentWifiName);
    }

    public void SocketOnClick(View view) {
        startActivity(new Intent(this, SocketDemoActivity.class));
    }

    public void playerOnClick(View view) {
        startActivity(new Intent(this, VideoActivity.class));
    }

    public void playerOnClick2(View view) {
        startActivity(new Intent(this, MyVideoActivity.class));
    }

    public void playerOnClick3(View view) {
        startActivity(new Intent(this, NetWorkVideoActivity.class));
    }

    public void focusOnClick(View view) {
        startActivity(new Intent(this, ViewPagerDemoActivity.class));
    }
}
