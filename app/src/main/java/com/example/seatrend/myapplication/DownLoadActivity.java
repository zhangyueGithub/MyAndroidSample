package com.example.seatrend.myapplication;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.http.HttpsConnection;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.seatrend.myapplication.JavaTest.Test2;
import com.example.seatrend.myapplication.JavaTest.Utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;

public class DownLoadActivity extends AppCompatActivity {

    Button downLoadBtn;
    ImageView downLoadIv;
    //http://p5.so.qhimgs1.com/t017f7f555a8bb37fab.jpg

   private final String IMAGE_PATH="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1523858450494&di=21673a0ff98d435d6b05a79b1306baf9&imgtype=0&src=http%3A%2F%2Fup.enterdesk.com%2Fedpic_source%2Fca%2F6b%2F5f%2Fca6b5f366b3ea52aab975235096594e8.jpg";
    //private final String IMAGE_PATH="http://p5.so.qhimgs1.com/t017f7f555a8bb37fab.jpg";

    private Bitmap downLoadBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_load);
        Utils.logString(this);
        init();
        new Thread(new Runnable() {
            @Override
            public void run() {
                testUrl();
            }
        }).start();
    }

    @SuppressLint("HandlerLeak")
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int what = msg.what;
            switch (what){
                case 0:

                    downLoadIv.setImageBitmap(downLoadBitmap);
                    break;
            }
        }
    };

    private void init() {
        downLoadBtn= findViewById(R.id.down_load_btn);
        downLoadIv= (ImageView) findViewById(R.id.down_load_iv);

        downLoadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Glide.with(DownLoadActivity.this).load(IMAGE_PATH).into(downLoadIv);
                Bitmap bitmap = Base64ToBitmapx(IMAGE_PATH);
                downLoadIv.setImageBitmap(bitmap);

            }
        });
        /*Looper.prepare();
        Looper.loop();*/
       // SoftReference<Test2> softReference = new SoftReference<Test2>(new Test2(this));
        //softReference.get().getdata();

    }

    private class SafeHostnameVerifier implements HostnameVerifier{
        @Override
        public boolean verify(String hostname, SSLSession session) {
             //为了安全起见 禁止在此方法中不做任何处理 直接返回true
            Log.i("hostname"," -- "+hostname);
            if("your hostname".equals(hostname)){
                return true;
            }else {
                // 其他操作的判定
            }

            return true;
        }
    }

    private class SafeTrustManager extends InputStream implements X509TrustManager {
        @Override
        public int read() throws IOException {
            return 0;
        }

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            Log.i("testUrl","checkClientTrusted"+authType);
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

            X509Certificate x509Certificate = chain[0];
            x509Certificate.checkValidity();
            Log.i("testUrl","checkServerTrusted -- "+authType+"  -- "+chain.length+"");

        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            Log.i("testUrl","getAcceptedIssuers");
            return new X509Certificate[0];
        }
    }

    private void testUrl(){
        try {
            URL url=new URL(IMAGE_PATH);
            HttpsURLConnection connection= (HttpsURLConnection) url.openConnection();
            //HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);
            connection.setHostnameVerifier(new SafeHostnameVerifier());
            //SSLContext sslContext = SSLContext.getInstance("SSL","SunJSSE");
            SSLContext sslContext = SSLContext.getInstance("SSL");
            X509TrustManager [] x509TrustManagers={new SafeTrustManager()};
            sslContext.init(null,x509TrustManagers,new SecureRandom());
            SSLSocketFactory socketFactory = sslContext.getSocketFactory();
             connection.setSSLSocketFactory(socketFactory);
            int responseCode = connection.getResponseCode();

            if(responseCode == HttpsURLConnection.HTTP_OK){
                InputStream inputStream = connection.getInputStream();

                /*byte[] buffer = new byte[1024];
                int len = 0;
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                while((len = inputStream.read(buffer)) != -1) {
                    bos.write(buffer, 0, len);
                }
                bos.close();
                byte[] bitmapArray = bos.toByteArray();
                downLoadBitmap= BitmapFactory.decodeByteArray(bitmapArray,0,bitmapArray.length);*/

                 downLoadBitmap = BitmapFactory.decodeStream(inputStream);


                int width = downLoadBitmap.getWidth();
                int height = downLoadBitmap.getHeight();
                if(downLoadBitmap ==null){
                    Log.i("testUrl","bitmap ==null");
                }else {
                    Log.i("testUrl","bitmap !=null "+width+"  and  "+height);
                    handler.sendEmptyMessage(0);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*private void test(){
        InputStream certificate12306 = Utils.getContext().getResources().openRawResource(R.raw.srca);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60000, TimeUnit.MILLISECONDS)
                .connectTimeout(60000, TimeUnit.MILLISECONDS)
                .addInterceptor(interceptor)
                .addInterceptor(new HttpHeaderInterceptor())
                .addNetworkInterceptor(new HttpCacheInterceptor())
                .sslSocketFactory(getSSLSocketFactoryForOneWay(certificate12306))
                .hostnameVerifier(new SafeHostnameVerifier())
                .cache(cache)
                .build();
    }*/

   /* *//**
     * 单项认证
     *//*
    public  SSLSocketFactory getSSLSocketFactoryForOneWay(InputStream... certificates) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance(CLIENT_TRUST_MANAGER, CLIENT_TRUST_PROVIDER);
            KeyStore keyStore = KeyStore.getInstance(CLIENT_TRUST_KEYSTORE);
            keyStore.load(null);
            int index = 0;
            for (InputStream certificate : certificates) {
                String certificateAlias = Integer.toString(index++);
                keyStore.setCertificateEntry(certificateAlias, certificateFactory.generateCertificate(certificate));
                try {
                    if (certificate != null)
                        certificate.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            SSLContext sslContext = SSLContext.getInstance(CLIENT_AGREEMENT);

            TrustManagerFactory trustManagerFactory =
                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());

            trustManagerFactory.init(keyStore);
            sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
            return sslContext.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/

    public  Bitmap Base64ToBitmapx(String base64Str) {
        byte[] bitmapArray;
        Bitmap bitmap = null;
        InputStream input = null;
        try {
            bitmapArray = Base64.decode(base64Str, Base64.DEFAULT);
            //  bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 8;
            input = new ByteArrayInputStream(bitmapArray);
            SoftReference softRef = new SoftReference(BitmapFactory.decodeStream(input, null, options));
            bitmap = (Bitmap) softRef.get();
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
