package com.example.seatrend.myapplication.activity;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.seatrend.myapplication.R;

public class FullScreenPalyActivity extends AppCompatActivity {


    private VideoView mVideoView;
    private ProgressBar mProgressBar;
    private TextView tvTips;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_full_screen_paly);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        initView();
    }

    private void initView() {

        mVideoView=findViewById(R.id.m_video_view);
        tvTips=findViewById(R.id.tv_tips);

        // MediaController mediaController=new MediaController(this);
        //  mVideoView.setMediaController(mediaController);
        //String path="http://ivi.bupt.edu.cn/hls/cctv6hd.m3u8";
        String path = getIntent().getStringExtra("path");
        mVideoView.setVideoPath(path);
        // mVideoView.requestFocus();
        mVideoView.setOnErrorListener(errorListener);
        mVideoView.setOnPreparedListener(preparedListener);
        mVideoView.setOnCompletionListener(completionListener);
        mVideoView.setOnInfoListener(infoListener);

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
            return false;//如果设置true就可以防止他弹出错误的提示框！
        }
    };

    private MediaPlayer.OnPreparedListener preparedListener=new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mp) {
            mVideoView.start();
            mp.setOnBufferingUpdateListener(bufferingUpdateListener);
        }
    };


    private MediaPlayer.OnCompletionListener completionListener=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {

        }
    };

    private MediaPlayer.OnBufferingUpdateListener bufferingUpdateListener=new MediaPlayer.OnBufferingUpdateListener() {
        @Override
        public void onBufferingUpdate(MediaPlayer mp, int percent) {
          //  mProgressBar.setSecondaryProgress(percent);

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
}
