package com.example.seatrend.myapplication.activity;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.seatrend.myapplication.R;
import com.tencent.smtt.sdk.TbsReaderView;

import java.io.File;

public class TbsDemoActivity extends AppCompatActivity {


    private TbsReaderView mTbsReaderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tbs_demo);

        initView();
    }

    private void initView() {


        mTbsReaderView = new TbsReaderView(this, new TbsReaderView.ReaderCallback() {
            @Override
            public void onCallBackAction(Integer integer, Object o, Object o1) {

            }
        });
        LinearLayout rootRl = (LinearLayout) findViewById(R.id.rl_root);
        rootRl.addView(mTbsReaderView, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        tbsOpenFile();
    }



    private void tbsOpenFile(){
        //String path = Environment.getExternalStorageDirectory().getPath() + "/" + "TBS_Sdk_FAQ.pdf";
        String path = Environment.getExternalStorageDirectory().getPath() + "/" + "android面试题及答案.docx";
        File file=new File(path);
        if (file.exists()){


            Bundle bundle=new Bundle();
            bundle.putString("filePath", file.getPath());
            bundle.putString("tempPath", Environment.getExternalStorageDirectory().getPath());
            boolean result = mTbsReaderView.preOpen("doc", false);//Word类型的是“doc” 、 PDF的类型是“pdf”

            mTbsReaderView.openFile(bundle);

        }else {
            Toast.makeText(this,"文件不存在",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mTbsReaderView.onStop();
        mTbsReaderView=null;
    }
}
