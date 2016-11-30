package org.yuezp.garenbooker.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;

import org.yuezp.garenbooker.R;
import org.yuezp.garenbooker.base.GarenTitleBaseActivity;
import org.yuezp.garenbooker.utils.UIsUtils;

import butterknife.OnClick;

public class MainActivity extends GarenTitleBaseActivity {

    private int systemBrightness;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TAG = MainActivity.class.getSimpleName();
    }

    @Override
    protected void initView() {


    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onFinish() {

    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    public void textclick(View view) {
        if (isFullScreen) {
            UIsUtils.unFullScreen((Activity) mContext);
        } else {
            UIsUtils.fullScreen((Activity) mContext);
        }
        isFullScreen = !isFullScreen;

    }


    @OnClick(R.id.id_day_night)
    public void setDayNight() {
        int mode = AppCompatDelegate.getDefaultNightMode();
        mode = mode == AppCompatDelegate.MODE_NIGHT_YES ? AppCompatDelegate.MODE_NIGHT_NO : AppCompatDelegate.MODE_NIGHT_YES;
        AppCompatDelegate.setDefaultNightMode(mode);
        recreate();
    }



}
