package com.example.seatrend.myapplication.JavaTest;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seatrend.myapplication.R;

public class WebViewActivity extends AppCompatActivity {

    private WebView mWebView;
    private TextView Title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
      //  mWebView=findViewById(R.id.web_view);
        Title=findViewById(R.id.tv_title);
        LinearLayout webParentLl = findViewById(R.id.web_parent_ll);
        // 如何防止WebView内存溢出 用new 的形式 不要在 mxl中写，context传 getApplicationContext（）；
     LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mWebView = new WebView(getApplicationContext());
        mWebView.setLayoutParams(params);
        webParentLl.addView(mWebView);
        initWebView();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView() {

        //声明WebSettings子类
        WebSettings webSettings = mWebView.getSettings();

        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
        // 若加载的 html 里有JS 在执行动画等操作，会造成资源浪费（CPU、电量）
       // 在 onStop 和 onResume 里分别把 setJavaScriptEnabled() 给设置成 false 和 true 即可

        //支持插件
       // webSettings.setPluginsEnabled(true);

         //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

        //缩放操作
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件

        //其他细节操作
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式

        //优先使用缓存:
       // webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        //缓存模式如下：
        //LOAD_CACHE_ONLY: 不使用网络，只读取本地缓存数据
        //LOAD_DEFAULT: （默认）根据cache-control决定是否从网络上取数据。
        //LOAD_NO_CACHE: 不使用缓存，只从网络获取数据.
        //LOAD_CACHE_ELSE_NETWORK，只要本地有，无论是否过期，或者no-cache，都使用缓存中的数据。

        mWebView.setWebViewClient(mWebViewClient);
        mWebView.setWebChromeClient(mWebChromeClient);






        //方式1. 加载一个网页：
        mWebView.loadUrl("https://www.baidu.com/");

        //方式2：加载apk包中的html页面
       // mWebView.loadUrl("file:///android_asset/test.html");

        //方式3：加载手机本地的html页面
        //mWebView.loadUrl("content://com.android.htmlfileprovider/sdcard/test.html");

    }

    private void androidCallJs(){

      // 因为该方法在 Android 4.4 版本才可使用，所以使用时需进行版本判断
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            mWebView.evaluateJavascript("javascript:callJS()", new ValueCallback<String>() {
                @Override
                public void onReceiveValue(String value) {
                    //此处为 js 返回的结果
                }
            });

        } else {
            mWebView.loadUrl("javascript:callJS()");
        }


    }

    @Override
    protected void onResume() {
        super.onResume();

        if(mWebView != null){
            mWebView.onResume();
            /*当应用程序(存在webview)被切换到后台时，这个方法不仅仅针对当前的webview而是全局的全应用程序的webview
            它会暂停所有webview的layout，parsing，javascripttimer。降低CPU功耗*/
            mWebView.resumeTimers();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if(mWebView != null){
            mWebView.onPause();
            mWebView.pauseTimers();
        }
    }

    private WebViewClient mWebViewClient=new WebViewClient(){
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //在webview 中打开网页，不跳到游览器
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            //页面开始加载 时调用
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            //页面加载结束时调用
        }

        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);

        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            //加载错误时调用
            Toast.makeText(WebViewActivity.this,"onReceivedError is execute",Toast.LENGTH_SHORT).show();



        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            super.onReceivedSslError(view, handler, error);
            //处理HTTPS 请求，默认是不处理的 显示已一片空白

            // 特别注意：5.1以上默认禁止了https和http混用，以下方式是开启
           /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mWebView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
            }*/
            Toast.makeText(WebViewActivity.this,"onReceivedSslError is execute",Toast.LENGTH_SHORT).show();


        }


    };

    private WebChromeClient mWebChromeClient=new WebChromeClient(){
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            //进度条的值
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            Title.setText(title);

            //每个网页都有一个 标题，这里我们可以用来设置自己的标题
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            //响应 js的 对话框
            return super.onJsAlert(view, url, message, result);
        }
    };

    /**
     * 如何防止WebView内存溢出 用new 的形式 不要在 mxl中写，context传 getApplicationContext（）；
     * LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
     mWebView = new WebView(getApplicationContext());
     mWebView.setLayoutParams(params);
     mLayout.addView(mWebView);
     */

    @Override
    protected void onDestroy() {
        //activity 结束时 摧毁webview
        if (mWebView != null) {
           mWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            mWebView.stopLoading();
            mWebView.clearHistory();
            mWebView.clearCache(true);
            ((ViewGroup) mWebView.getParent()).removeView(mWebView);
            mWebView.destroy();
            mWebView = null;
        }

        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(mWebView !=null && mWebView.canGoBack()){
                mWebView.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
