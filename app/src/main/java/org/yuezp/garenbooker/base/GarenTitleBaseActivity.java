package org.yuezp.garenbooker.base;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.yuezp.garenbooker.R;

/**
 * Created by pangzhen on 16/11/30.
 */

public abstract class GarenTitleBaseActivity extends BaseActivity {

    protected View mTitleView;
    protected ImageView mImgLeft;
    protected TextView mTitleMid;
    protected ImageView mImgRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        View view = mInflater.inflate(layoutResID, null);
        setTitleStyle(true, view, null);
    }

    protected void setContentView(int layoutResID, boolean showTitle) {
        View view = mInflater.inflate(layoutResID, null);
        setTitleStyle(showTitle, view, null);
    }
    private void setRootView(View view) {
        super.setContentView(view);
    }


    private void setTitleStyle(boolean showTitle, View content, ViewGroup.LayoutParams params) {
        LinearLayout rootLayout = new LinearLayout(this.getApplicationContext());
        rootLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        rootLayout.setOrientation(LinearLayout.VERTICAL);

        if (showTitle) {
            mTitleView = mInflater.inflate(R.layout.layout_base_title, null);


            rootLayout.addView(mTitleView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            mImgLeft = (ImageView) mTitleView.findViewById(R.id.iv_title_left);
            mTitleMid = (TextView) mTitleView.findViewById(R.id.tv_title_mid);
            mImgRight = (ImageView) mTitleView.findViewById(R.id.iv_title_right);

            mTitleView.setVisibility(View.VISIBLE);

        }
        rootLayout.addView(content, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        setRootView(rootLayout);


        initView();
        initData();

    }

    @Override
    public void finish() {
        super.finish();
        onFinish();
    }

    /**
     * 初始view数据, 做setText, setAdapter 事情
     */
    protected abstract void initView();

    /**
     * 初始view数据, 做setText, setAdapter 事情
     */
    protected abstract void initData();

    protected abstract void onFinish();

}
