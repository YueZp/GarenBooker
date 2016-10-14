package org.yuezp.garenbooker.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;

import org.yuezp.garenbooker.R;
import org.yuezp.garenbooker.base.BaseActivity;
import org.yuezp.garenbooker.utils.UIsUtils;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private int systemBrightness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
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
