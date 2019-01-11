package com.example.seatrend.myapplication.activity;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

import com.example.seatrend.myapplication.R;

import java.lang.reflect.Field;

public class VideoActivity extends AppCompatActivity {

    private VideoView mVideoView;

    ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        initView();
    }

    private void initView() {
        mVideoView=findViewById(R.id.m_video_view);
        MediaController mediaController=new MediaController(this);
        mVideoView.setMediaController(mediaController);
        String path=Environment.getExternalStorageDirectory().getPath()+"/mp4song.mp4";
        //String path="http://ivi.bupt.edu.cn/hls/cctv6hd.m3u8";
        mVideoView.setVideoPath(path);

        mVideoView.requestFocus();
        mVideoView.setOnErrorListener(errorListener);



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
}
