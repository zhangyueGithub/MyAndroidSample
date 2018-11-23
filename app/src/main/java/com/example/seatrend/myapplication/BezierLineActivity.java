package com.example.seatrend.myapplication;

import android.Manifest;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.seatrend.myapplication.JavaTest.RSAUtils;
import com.example.seatrend.myapplication.JavaTest.RuningView;
import com.example.seatrend.myapplication.JavaTest.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class BezierLineActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks{
    int number=0;


    private String [] mPermissionList={Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private RuningView runingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezier_line);
        String type = Build.MODEL;
        Log.i("BezierLineActivity"," -- "+type);
        Utils.logString(this);
        runingView = findViewById(R.id.yyyy);


        EasyPermissions.requestPermissions(this,"tongyi",10,mPermissionList);
        new Thread(new Runnable() {
            @Override
            public void run() {
                pingNetwork();
            }
        }).start();
    }

    private void pingNetwork() {
        String command="ping -c 3 -w 10 11.121.35.23";
        try {
            Process process = Runtime.getRuntime().exec(command);
            int status = process.waitFor();
            if(status == 0){
                //能ping通

            }else {
                //不能ping通
            }
            Log.i("pingNetwork"," ---status-- "+status);
            BufferedReader buf = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String str;
            StringBuffer buffer=new StringBuffer();
            // 读出所有信息并显示
            while ((str = buf.readLine()) != null) {
                str = str + "\n";
                buffer.append(str);
            }
            Log.i("pingNetwork"," ----- "+buffer.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.i("pingNetwork"," --InterruptedException--- "+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("pingNetwork"," --IOException--- "+e.getMessage());
        }
    }

    public  void getPublicKey() {

        try {
            // 用证书的私钥解密 - 该私钥存在生成该证书的密钥库中
           // FileInputStream fis2 = new FileInputStream("C:\\Users\\seatrend\\Desktop\\checkoutsiade.jks");
            InputStream fis2 = getAssets().open("checkoutsiade.jks");
            KeyStore ks = KeyStore.getInstance("JKS"); // 加载证书库
            char[] kspwd = "123456".toCharArray(); // 证书库密码
            char[] keypwd = "123456".toCharArray(); // 证书密码
            String alias = "he";// 别名
            ks.load(fis2, kspwd); // 加载证书
            PrivateKey privateKey = (PrivateKey) ks.getKey(alias, keypwd); // 获取证书私钥
            PublicKey publicKey = ks.getCertificate(alias).getPublicKey();// 获取证书公钥
            fis2.close();

            String pubilckKeyString = RSAUtils.getPubilckKeyString(publicKey);

            Log.i("pubilckKeyString","--"+pubilckKeyString);

            // 测试加密解密字符串
            String srcContent = "今天天气不错。";

        } catch (Exception e) {
            e.printStackTrace();

            Log.i("pubilckKeyString","-Exception -" + e.getMessage());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //跳转到onPermissionsGranted或者onPermissionsDenied去回调授权结果
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults,this);

    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        getPublicKey();
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }

    public void btnStart(View view) {
        runingView.startGo();
    }
}
