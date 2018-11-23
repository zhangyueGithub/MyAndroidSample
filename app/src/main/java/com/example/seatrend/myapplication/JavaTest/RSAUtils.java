package com.example.seatrend.myapplication.JavaTest;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Observable;
import java.util.Observer;

import it.sauronsoftware.base64.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * Created by seatrend on 2018/4/11.
 */

public class RSAUtils {

    private static final String MD5="MD5";

//
    /**
     * 公钥一般存于客户端，私钥存于服务端
     */
    private static String publicKeystr="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDNCe5Ce4taoqJUiY8bX+Swk18LP5BGbtPDN1CvbG4K0SVTku9JVbc1wbxYNGicyYCCNuc/tvmzq3bR0GFn0T8ENYzHRPciqIRV1Ny/tDoR/3pcMTWOVeeiUh3SF3bmiTfrrfKYY8xVkADp0dDdJzcIUxzL7EpvCmMitLjFjNB2qwIDAQAB";
    private static String privateKeystr="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAM0J7kJ7i1qiolSJjxtf5LCTXws/kEZu08M3UK9sbgrRJVOS70lVtzXBvFg0aJzJgII25z+2+bOrdtHQYWfRPwQ1jMdE9yKohFXU3L+0OhH/elwxNY5V56JSHdIXduaJN+ut8phjzFWQAOnR0N0nNwhTHMvsSm8KYyK0uMWM0HarAgMBAAECgYEAqXRCoFlgc1ij1kAVsKcQ5sn1K+OthjhD9Tu7CDARxgjR039FGZOopdnmofM2XhW+il97wNGlDtNvkLmqNtXdQE+bIrpJgnln5dauN+ex8MXc6/OuOyaH1b5+x3b3qWQP/aKHC4zfDqJdBnnbL+PjHtnu9gZspDCHoMrancjUivECQQDlgTcZCS0k9RcnsCJWbVbbuHufRsT56vk5TiWGhcKO6bEb+L1crv53X3n7H+Fr201soL5JAHY3CXgUeW4W9sTpAkEA5LWmArkW/yQSJUdHWYcZMB+MH7/vDw3gtjbqJgruY+q1p5PWyKf3HlKpV2sfXUmKA5/KU4k3/7Maoup79yyycwJAYZZ3MjsXqh5ZUTPw9eUaSOWCE3EJMue6P6a+CBx6ZUBzYdx70JxMcb/0Y1bkCHPA0U7seqgqnC53k+UqbbNSeQJASDMz+i4WHWt0swICezfT8sYyxR8hR75Yzw0c8++FfFNvDzzzlBq6P39W6DrwBtIdWLGL/L0XyYfwA7hEdC5PEwJBAICPQQ2ZTJmQ5qSM1kEGpcPz97FklixJAz3jtbD6PBPJq/DvHda+5z456ktqNV96eWJ4iav3pGp+PvVGqGJwHQs=";

    private static final String transformation="RSA/NONE/PKCS1Padding";

    public static void geRSAtKeys(){
        try {
            KeyPairGenerator pairGenerator = KeyPairGenerator.getInstance("RSA");
            pairGenerator.initialize(1024); //一般为1024，值越大 越安全 但 一般不超过2048
            KeyPair keyPair = pairGenerator.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();

            /*String pubilckKeyString = getPubilckKeyString(publicKey);
            String privateKeyString = getPrivateKeyString(privateKey);*/

            String pubilckKeyString = parseByte2HexStr(publicKey.getEncoded());
            String privateKeyString = parseByte2HexStr(privateKey.getEncoded());

           // String md5 = getMD5(MD5);
            Log.i("getKeys"," pubilckKeyString-- "+pubilckKeyString );
            Log.i("getKeys"," pubilckKeyString  pp -- "+privateKeyString );

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }






    public static String getPubilckKeyString(PublicKey publicKey){
         byte[] encode = Base64.encode(publicKey.getEncoded());

        return  new String(encode) ;

    }

    private static String getPrivateKeyString(PrivateKey privateKey){

        byte[] encode = Base64.encode(privateKey.getEncoded());

        return  new String(encode) ;


    }

    private static String getMD5(String string){
        //单向散列函数
        try {
            MessageDigest md5 = MessageDigest.getInstance(MD5);
            byte[] digest = md5.digest(string.getBytes());

            String result = "";
            for (byte b : digest) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }

            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 通过字符串生成私钥
     */
    public static PrivateKey getPrivateKey(){
        PrivateKey privateKey = null;
        try {
             byte[] encode = Base64.decode(privateKeystr.getBytes());//将字符串Base64解码
            PKCS8EncodedKeySpec x509= new PKCS8EncodedKeySpec(encode);//创建x509证书封装类
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");//指定RSA
            privateKey = keyFactory.generatePrivate(x509);//生成私钥

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return privateKey;
    }



    /**
     * 通过字符串生成公钥
     */
    public static PublicKey getPublicKey(){
    PublicKey publicKey = null;
    try {
        byte [] decode = Base64.decode(publicKeystr.getBytes());
        X509EncodedKeySpec x509 = new X509EncodedKeySpec(decode);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        publicKey = keyFactory.generatePublic(x509);
        } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    } catch (InvalidKeySpecException e) {
    e.printStackTrace();
    }
        return publicKey;
    }


    /**
     * 加密
     */
    public static String encrypt(String data,Key key){
        try {
                Cipher cipher = Cipher.getInstance(transformation);
                cipher.init(Cipher.ENCRYPT_MODE, key);
               byte[] bytes=cipher.doFinal(data.getBytes());
            String st = byteToBase64String(bytes);
            return st;
            } catch (Exception e) {
            e.printStackTrace();
            }
            return null;
                            }

    /**
     * 解密
     */
    public static String decrypt(String data,Key key){
        try {
            byte[] stByte = base64StringToByte(data);
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] bytes = cipher.doFinal(stByte);
            return new String(bytes);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将加密结果 用base64加密成字符串形式，便于传输和查看
     * @param data
     * @return
     */
    private static String byteToBase64String(byte[] data){
        return new String(Base64.encode(data));
    }

    /**
     * 解密之前先用base64 解密一下
     * @param date
     * @return
     */
    private static byte[] base64StringToByte(String date){
        return Base64.decode(date.getBytes());
    }


    /**将二进制转换成16进制
     * @param buf
     * @return
     */
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

    /**将16进制转换为二进制
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

}
