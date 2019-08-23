package com.example.seatrend.myapplication.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.seatrend.myapplication.R;
import com.example.seatrend.myapplication.util.StringUtils;

public class NetWorkVideoActivity extends AppCompatActivity {

    private VideoView mVideoView;
    private ProgressBar mProgressBar;
    private TextView tvTips,tvTime;
    private Button btnFull;
    private static final int UPDATE_BUFFER_PROGRESS_CODE=7;
    private static final int UPDATE_PROGRESS_CODE=6;
    private static final String TAG="LOGMES";
    //http:/api.m.mtime.cn/PageSubArea/TrailerList.api           测试地址 里面一大堆
   // String path="http://ivi.bupt.edu.cn/hls/cctv6hd.m3u8";//播放源
    String path="http://vfx.mtime.cn/Video/2019/a1/21/mp4/190121221027701384.mp4";//播放源
    String YsbAd = "http://v.ysbang.cn/data/test/test0.mp4";
    String test1 = "http://v.ysbang.cn//data/video/2015/rkb/2015rkb01.mp4";
    String test2 = "http://vfx.mtime.cn/Video/2018/12/28/mp4/181228150811700206.mp4";
    String test3 = "http://vfx.mtime.cn/Video/2018/12/25/mp4/181225232135365424.mp4";
    String test4 = "http://vfx.mtime.cn/Video/2018/11/27/mp4/181127172736804651.mp4";




    @SuppressLint("HandlerLeak")
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case UPDATE_PROGRESS_CODE:
                    mProgressBar.setProgress(mVideoView.getCurrentPosition());
                    tvTime.setText(StringUtils.longToStringData(1547136000000l+mVideoView.getCurrentPosition()));

                    //每隔1秒更新进度条
                    sendEmptyMessageDelayed(UPDATE_PROGRESS_CODE,1000);
                    break;

                case UPDATE_BUFFER_PROGRESS_CODE:


                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_net_work_video);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initView();
    }


    private void initView() {
        mVideoView=findViewById(R.id.m_video_view);
        mProgressBar=findViewById(R.id.m_progress_bar);
        tvTips=findViewById(R.id.tv_tips);
        tvTime=findViewById(R.id.tv_time);
        btnFull=findViewById(R.id.btn_full);

       // MediaController mediaController=new MediaController(this);
      //  mVideoView.setMediaController(mediaController);

        mVideoView.setVideoPath(path);
       // mVideoView.setVideoPath(YsbAd);
       // mVideoView.setVideoPath(test4);
        mVideoView.requestFocus();
        mVideoView.setOnErrorListener(errorListener);
        mVideoView.setOnPreparedListener(preparedListener);
        mVideoView.setOnCompletionListener(completionListener);
        mVideoView.setOnInfoListener(infoListener);

//        int currentPosition = mVideoView.getCurrentPosition();
//        int bufferPercentage = mVideoView.getBufferPercentage();


        btnFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NetWorkVideoActivity.this,FullScreenPalyActivity.class);
                intent.putExtra("path",test4);
                startActivity(intent);
            }
        });
        tvTips.setVisibility(View.VISIBLE);
        tvTips.setText("视频正在加载...");
    }

    private MediaPlayer.OnErrorListener errorListener=new MediaPlayer.OnErrorListener() {
        @Override
        public boolean onError(MediaPlayer mp, int what, int extra) {
            if(what== MediaPlayer.MEDIA_ERROR_UNKNOWN //未指定的媒体播放器错误。
                    ||what==MediaPlayer.MEDIA_ERROR_SERVER_DIED //媒体服务器死了。在这种情况下，应用程序必须释放
                    ||what==MediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK//视频流，其容器对逐行扫描无效。
                    ||what==MediaPlayer.MEDIA_ERROR_MALFORMED//文件或网络操作错误
                    ||what==MediaPlayer.MEDIA_ERROR_UNSUPPORTED//比特流符合相关的编码标准或文件规范，但 媒体框架不支持该功能。
                    ||what==MediaPlayer.MEDIA_ERROR_TIMED_OUT//超时
                    ||what==MediaPlayer.MEDIA_ERROR_IO){ //IO刘错误

            }

            tvTips.setText("视频加载失败");
            return false;//如果设置true就可以防止他弹出错误的提示框！
        }
    };

    private MediaPlayer.OnPreparedListener preparedListener=new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mp) {
            mp.setOnBufferingUpdateListener(bufferingUpdateListener);
            tvTips.setVisibility(View.GONE);
            int duration = mVideoView.getDuration();
            Log.i(TAG,"duration= "+duration);
            mProgressBar.setMax(duration);
            mVideoView.start();
            mHandler.sendEmptyMessage(UPDATE_PROGRESS_CODE);
        }
    };


    private MediaPlayer.OnCompletionListener completionListener=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            mVideoView.pause();

        }
    };

    private MediaPlayer.OnBufferingUpdateListener bufferingUpdateListener=new MediaPlayer.OnBufferingUpdateListener() {
        @Override
        public void onBufferingUpdate(MediaPlayer mp, int percent) {
            Log.i(TAG,"percent= "+percent);

            mProgressBar.setSecondaryProgress((percent*mProgressBar.getMax())/100);

        }
    };

    private MediaPlayer.OnInfoListener infoListener= new MediaPlayer.OnInfoListener() {
        @Override
        public boolean onInfo(MediaPlayer mp, int what, int extra) {
            if (what==MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START){
                tvTips.setVisibility(View.GONE);

            }else if (what==MediaPlayer.MEDIA_INFO_BUFFERING_START){
                tvTips.setVisibility(View.VISIBLE);
                tvTips.setText("努力加载中...");
            }


            return false;
        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mVideoView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mVideoView.start();
    }
}
