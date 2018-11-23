package com.example.seatrend.myapplication.JavaTest;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;

import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/**
 * Created by seatrend on 2018/7/6.
 */

public class SignUtiles {


    public static String getAPPSign(Context context){
        PackageManager packageManager = context.getPackageManager();
        try {
            //请注意需要PackageManager.GET_SIGNATURES 这个flag
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            Signature[] signs = packageInfo.signatures;
            Signature sign = signs[0];
            // X509证书，X.509是一种非常通用的证书格式
            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");//X.509
            X509Certificate cert = (X509Certificate) certFactory.generateCertificate(new ByteArrayInputStream(sign.toByteArray()));
            // md5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 获得公钥
            byte[] b = md.digest(cert.getEncoded());
            //key即为应用签名
            String key=parseByte2HexStr(b).replace(":", "");
            return key;
        }catch (Exception e){
        }
        return null;
    }


    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

}
