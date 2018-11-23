package com.example.seatrend.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;

import com.example.seatrend.myapplication.JavaTest.LoadingDialog;
import com.example.seatrend.myapplication.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class RxJavaTestActivity extends AppCompatActivity {

    private final static String TAG="RxJavaTestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_test);

        init();
    }

    private void init() {
        //observable.subscribe(observer);

        Observable.just(1,2,3)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i(TAG,"----- onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.i(TAG,"----- onNext "+integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG,"----- onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG,"----- onComplete");
                    }
                });
    }

    Observable observable=Observable.create(new ObservableOnSubscribe<Integer>() {
        @Override
        public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
           emitter.onComplete();

        }
    });

    Observer observer=new Observer<Integer>() {
        @Override
        public void onSubscribe(Disposable d) {
            Log.i(TAG,"----- onSubscribe");
        }

        @Override
        public void onNext(Integer o) {

            Log.i(TAG,"----- onNext  "+o);

        }

        @Override
        public void onError(Throwable e) {
            Log.i(TAG,"----- onError");
        }

        @Override
        public void onComplete() {
            Log.i(TAG,"----- onComplete");
        }
    };

    public void dialogOnClick(View view) {
        LoadingDialog.showDialog(this);
    }

    public void dialogOnClickDIs(View view) {
        LoadingDialog.dismissDialog();
    }
}
