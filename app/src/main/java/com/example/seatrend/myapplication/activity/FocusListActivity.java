package com.example.seatrend.myapplication.activity;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.seatrend.myapplication.R;
import com.example.seatrend.myapplication.adapter.FocusListAdapter;
import com.example.seatrend.myapplication.util.DP2PX;
import com.example.seatrend.myapplication.view.FocusLayoutManager;

public class FocusListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus_list);
        initView();

       // DatePickerDialog datePickerDialog=new DatePickerDialog()
    }

    private void initView() {
        mRecyclerView= findViewById(R.id.m_recycler_view);

        FocusLayoutManager focusLayoutManager = new FocusLayoutManager.Builder()
                        .layerPadding(DP2PX.dp2px(this, 14))
                        .normalViewGap(DP2PX.dp2px(this, 14))
                        .focusOrientation(FocusLayoutManager.FOCUS_LEFT)
                        .isAutoSelect(true)
                        .maxLayerCount(3)
                        .setOnFocusChangeListener(new FocusLayoutManager.OnFocusChangeListener() {
                            @Override
                            public void onFocusChanged(int focusdPosition, int lastFocusdPosition) {

                            }
                        })
                .addTrasitionListener(new FocusLayoutManager.TrasitionListener() {
                    @Override
                    public void handleLayerView(FocusLayoutManager focusLayoutManager, View view, int viewLayer, int maxLayerCount, int position, float fraction, float offset) {
                        view.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void handleFocusingView(FocusLayoutManager focusLayoutManager, View view, int position, float fraction, float offset) {

                    }

                    @Override
                    public void handleNormalView(FocusLayoutManager focusLayoutManager, View view, int position, float fraction, float offset) {

                    }
                })
                .setOnFocusChangeListener(new FocusLayoutManager.OnFocusChangeListener() {
                    @Override
                    public void onFocusChanged(int focusdPosition, int lastFocusedPosition) {

                    }
                })

                        .build();

        mRecyclerView.setLayoutManager(focusLayoutManager);
        FocusListAdapter adapter=new FocusListAdapter(this);
        mRecyclerView.setAdapter(adapter);
    }
}
