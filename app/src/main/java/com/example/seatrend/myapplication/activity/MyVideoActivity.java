package com.example.seatrend.myapplication.activity;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.seatrend.myapplication.R;
import com.example.seatrend.myapplication.util.StringUtils;

import java.io.IOException;

public class MyVideoActivity extends AppCompatActivity implements View.OnClickListener{

    private SurfaceView mSurfaceView;
    private Button btnPause;
    private TextView tvProgress;
    private SeekBar mSeekBar;
    private MediaPlayer mMediaPlayer;
    private boolean isPlaying=false;
    private int currentPosition=0;
    private int changeValue=20; //手动点击 前进 后台 的改变值

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_my_video);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initView();
    }

    private void initView() {
        mSurfaceView=findViewById(R.id.m_surface_view);
        btnPause=findViewById(R.id.btn_pause);
        mSeekBar=findViewById(R.id.m_seek_bar);
        tvProgress=findViewById(R.id.tv_progress);

        btnPause.setOnClickListener(this);

        mSurfaceView.getHolder().addCallback(SurfaceHolderCallback);

        mSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);

    }

    @Override
    protected void onResume() {
        super.onResume();
       // startPlay();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener=new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            currentPosition=progress;
            tvProgress.setText(StringUtils.longToStringData(progress));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (mMediaPlayer!=null && mMediaPlayer.isPlaying()){
                mMediaPlayer.seekTo(mSeekBar.getProgress());
            }

        }
    };

    private SurfaceHolder.Callback SurfaceHolderCallback=new SurfaceHolder.Callback() {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            Log.i("SurfaceHolder","surfaceCreated");
            startPlay();

        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            Log.i("SurfaceHolder","surfaceChanged");
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            Log.i("SurfaceHolder","surfaceDestroyed");
            stopPlay();
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_pause:

                if (btnPause.getText().toString().equalsIgnoreCase("PAUSE")){
                    mMediaPlayer.pause();
                    btnPause.setText("CONTINUE");
                }else if (btnPause.getText().toString().equalsIgnoreCase("CONTINUE")){
                    mMediaPlayer.start();
                    btnPause.setText("PAUSE");
                }



                break;

        }
    }


    private void setMediaPlayerSeekto(int position){
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.seekTo(position);
        }
    }

     protected void stopPlay() {
         isPlaying=false;
         if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
             currentPosition=mMediaPlayer.getCurrentPosition();
                     mMediaPlayer.stop();
                     mMediaPlayer.release();
                     mMediaPlayer = null;
                     }
             }

     private void startPlay(){
         String path= Environment.getExternalStorageDirectory().getPath()+"/mp4song.mp4";
         mMediaPlayer = new MediaPlayer();

         try {

             mMediaPlayer.setDataSource(path);

             mMediaPlayer.setDisplay(mSurfaceView.getHolder());
             mMediaPlayer.prepareAsync();
             mMediaPlayer.setOnPreparedListener(preparedListener);
             mMediaPlayer.setOnCompletionListener(completionListener);
             mMediaPlayer.setOnErrorListener(errorListener);
         } catch (IOException e) {
             e.printStackTrace();
         }




     }

     private MediaPlayer.OnPreparedListener preparedListener=new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mp) {

            mMediaPlayer.start();
            mMediaPlayer.seekTo(currentPosition);
            mSeekBar.setMax(mMediaPlayer.getDuration());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        isPlaying=true;
                        while (isPlaying){
                            mSeekBar.setProgress(mMediaPlayer.getCurrentPosition());
                            Thread.sleep(500);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();

        }
    };

     private MediaPlayer.OnCompletionListener completionListener=new MediaPlayer.OnCompletionListener() {
         @Override
         public void onCompletion(MediaPlayer mp) {
             isPlaying=false;
         }
     };

     private MediaPlayer.OnErrorListener errorListener=new MediaPlayer.OnErrorListener() {
        @Override
        public boolean onError(MediaPlayer mp, int what, int extra) {
            isPlaying=false;
            return false;
        }
    };
}
