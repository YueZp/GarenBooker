package org.yuezp.garenbooker.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import org.yuezp.garenbooker.utils.LogInfo;

import butterknife.ButterKnife;

/**
 * Created by pangzhen on 2016/9/5.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();
    protected Context mContext;
    protected boolean isFullScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutID());
        mContext = this;
//        StatusBarCompat.compat(this, 0); 采取styles 主题方案设置 暂时不采用。
        ButterKnife.bind(this);


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

    /**
     * 设置ContentView
     *
     * @return
     */
    protected abstract int getLayoutID();


}
