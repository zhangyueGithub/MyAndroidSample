package com.example.seatrend.myapplication;

import android.app.Activity;
import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.billy.android.swipe.SmartSwipeBack;
import com.billy.android.swipe.SwipeConsumer;
import com.tencent.smtt.sdk.QbSdk;

/**
 * Created by seatrend on 2019/3/26.
 */

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        QbSdk.initX5Environment(getApplicationContext(), new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {

            }

            @Override
            public void onViewInitFinished(boolean b) {
                Log.i("applic","onViewInitFinished==  "+b);

            }
        });

        SmartSwipeBack.activityDoorBack(this,filter, SwipeConsumer.DIRECTION_TOP,50,
                R.color.colorAccent,true);
        //SmartSwipeBack.activitySlidingBack(this, filter);
      //  SmartSwipeBack.activityDoorBack(this,filter);
    }



    private SmartSwipeBack.ActivitySwipeBackFilter filter=  new SmartSwipeBack.ActivitySwipeBackFilter() {
        @Override
        public boolean onFilter(Activity activity) {
            return true;
        }
    };
}
