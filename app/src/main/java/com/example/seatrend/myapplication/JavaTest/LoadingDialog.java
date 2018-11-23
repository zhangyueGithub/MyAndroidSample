package com.example.seatrend.myapplication.JavaTest;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.seatrend.myapplication.R;

/**
 * Created by seatrend on 2018/6/25.
 */

public class LoadingDialog extends Dialog {

    private static LoadingDialog mLoadingDialog;

    public LoadingDialog(@NonNull Context context) {
        super(context);
    }

    public LoadingDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }
    public static void showDialog(Context context){
        mLoadingDialog=new LoadingDialog(context, R.style.loading_dialog);

        //触摸外部无法取消,必须
        mLoadingDialog.setCanceledOnTouchOutside(true);

        mLoadingDialog.setTitle("");
        mLoadingDialog.setContentView(R.layout.dialog_loading);
        mLoadingDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
       /* if(message==null|| TextUtils.isEmpty(message)){
            mLoadingDialog.findViewById(R.id.loading_tv).setVisibility(View.GONE);
        }else {
            TextView tv = (TextView) mLoadingDialog.findViewById(R.id.loading_tv);
            tv.setText(message);
        }*/
        //按返回键响应是否取消等待框的显示
        mLoadingDialog.setCancelable(true);

        mLoadingDialog.show();
    }

    public static void dismissDialog(){
        if(mLoadingDialog!=null){

            mLoadingDialog.dismiss();
        }
    }
}
