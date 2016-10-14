package org.yuezp.garenbooker.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by pangzhen on 2016/9/7.
 */
public class UIsUtils {

    /**
     * 得到屏幕宽度
     *
     * @param context 最好传入Application的Context
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int getScreenHeight(Context context) {
        return ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE))
                .getDefaultDisplay().getHeight();
    }


    /**
     * 得到屏幕宽度
     *
     * @param context 最好传入Application的Context
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int getScreenWidth(Context context) {
        return ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
    }

    /**
     * 判断是否是横屏
     *
     * @param context 最好传入Application的Context
     * @return
     */
    public static boolean isLandscape(Context context) {
        if (context == null) {
            return false;
        }

        int t = context.getResources().getConfiguration().orientation;
        return t == Configuration.ORIENTATION_LANDSCAPE;

    }

    /**
     * 全屏
     *
     * @param context
     */
    public static void fullScreen(Activity context) {
        context.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    /**
     * 取消全屏
     *
     * @param context
     */
    public static void unFullScreen(Activity context) {
        context.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * 控制View的显示或隐藏
     *
     * @param show  显示View
     * @param views 隐藏View
     */
    protected static void setViewVisbility(boolean show, final View... views) {
        if (views != null && views.length > 0) {
            for (View view : views) {
                if (view != null) {
                    view.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            }
        }
    }

    /**
     * 是否打开自动调节亮度
     *
     * @param contentResolver
     * @return
     */
    public static boolean isAutoBrightness(ContentResolver contentResolver) {
        boolean autoBrightness = false;
        try {
            autoBrightness
                    = Settings.System.getInt(contentResolver,
                    Settings.System.SCREEN_BRIGHTNESS_MODE)
                    == Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return autoBrightness;
    }


    /**
     * 设置屏幕亮度模式 1：自动调节 0：手动调节
     *
     * @param context
     */
    public static void setBrightnessMode(Context context) {
        int screenMode = 0;
        try {
            screenMode = Settings.System.getInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS_MODE);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        screenMode = screenMode == 0 ? 1 : 0;
        Settings.System.putInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS_MODE, screenMode);
    }

    /**
     * 设置全局的亮度值
     *
     * @param context
     * @param brightnessValue 亮度值
     */
    public static void saveBrightness(Context context, int brightnessValue) {
        Settings.System.putInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
        Settings.System.putInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, brightnessValue);
    }

    /**
     * 获取当前系统亮度
     * <p/>
     * 获取失败返回-1,获取成功返回正常非负数 0 - 255
     *
     * @param context
     * @return
     */
    public static int getSystemBrightness(Context context) {
        int brightnessValue = -1;
        try {
            brightnessValue = Settings.System.getInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brightnessValue;
    }
}
