package com.example.seatrend.myapplication.activity;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.seatrend.myapplication.R;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;

public class QRTestActivity extends AppCompatActivity {
    private ImageView ivQr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrtest);
        ivQr=findViewById(R.id.iv_qr);
        init();
    }

    private void init() {
        ivQr.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

              new AlertDialog.Builder(QRTestActivity.this)
                        .setMessage("识别图中二维码")
                        .setNegativeButton("识别", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                readQr();
                            }
                        })
                        .setPositiveButton("取消",null)
                      .create().show();
                return false;
            }
        });
    }

    private void readQr(){
        Bitmap obmp = ((BitmapDrawable) (ivQr).getDrawable()).getBitmap();
        int width = obmp.getWidth();
        int height = obmp.getHeight();
        int[] data = new int[width * height];
        obmp.getPixels(data, 0, width, 0, 0, width, height);
        RGBLuminanceSource source = new RGBLuminanceSource(width, height, data);
        BinaryBitmap bitmap1 = new BinaryBitmap(new HybridBinarizer(source));
        QRCodeReader reader = new QRCodeReader();
        Result re = null;
        try {
            re = reader.decode(bitmap1);
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (ChecksumException e) {
            e.printStackTrace();
        } catch (FormatException e) {
            e.printStackTrace();
        }
        if (re == null) {
            Log.i("QRTestActivity"," --re == null -- ");
            showDialog("未识别到二维码");
        } else {
            //showSelectAlert(obmp, re.getText());
            String text = re.getText();
            Log.i("QRTestActivitypppp"," ---- "+text);
            showDialog(text);
        }
    }

    private void showDialog(String text){
        new AlertDialog.Builder(QRTestActivity.this)
                .setMessage(text)
                .setTitle("识别结果")
                .setPositiveButton("取消",null)
                .create().show();
    }
}
