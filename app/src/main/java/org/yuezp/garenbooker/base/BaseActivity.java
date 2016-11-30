package org.yuezp.garenbooker.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import org.yuezp.garenbooker.utils.LogInfo;

import butterknife.ButterKnife;

/**
 * Created by pangzhen on 2016/9/5.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected String TAG = BaseActivity.class.getSimpleName();
    protected Context mContext;
    protected boolean isFullScreen;
    protected LayoutInflater mInflater;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mInflater = LayoutInflater.from(this);
//        StatusBarCompat.compat(this, 0); 采取styles 主题方案设置 暂时不采用。



        LogInfo.log(TAG, "onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogInfo.log(TAG, "onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        ButterKnife.bind(this);
        LogInfo.log(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogInfo.log(TAG, "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogInfo.log(TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogInfo.log(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogInfo.log(TAG, "onDestroy");
    }




}
