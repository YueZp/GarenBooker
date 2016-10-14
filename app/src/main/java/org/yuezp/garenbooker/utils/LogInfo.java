package org.yuezp.garenbooker.utils;

import android.util.Log;

/**
 * Created by pangzhen on 2016/9/12.
 */
public class LogInfo {

    private final static boolean isDebug = true;
    private final static int DEBUG_LEVEL = 4;
    private static final String TAG_CONTENT_PRINT = "%s:%s.%s:%d";

    /**
     * 统计信息打印
     */
    public static void LogStatistics(String msg) {
        String TAG_STATISTICS = "statistics";
        log(TAG_STATISTICS, msg);
    }

    public static void log(String tag, String msg) {
        if (isDebug) {
            Log.e(tag, msg);
        }

    }

    /**
     * 打印trace
     *
     * @param tag
     */
    public static void trace(String tag) {
        if (isDebug) {
            Log.d(tag, getContent(getCurrentStackTraceElement(), tag));
        }
    }

    private static StackTraceElement getCurrentStackTraceElement() {
        return Thread.currentThread().getStackTrace()[4];
    }

    private static String getContent(StackTraceElement trace, String tag) {
        return String
                .format(TAG_CONTENT_PRINT, tag, trace.getClassName(), trace.getMethodName(), trace.getLineNumber());
    }
}
