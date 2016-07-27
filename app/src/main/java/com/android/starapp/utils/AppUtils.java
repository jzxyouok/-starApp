package com.android.starapp.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import com.android.starapp.R;

/**
 * 常用工具类
 * <p/>
 * <p/>
 * <p/>
 * Created by My on 2016/7/13 0013.
 */
public class AppUtils {
    static Context mContext;


    public Context getmContext() {
        return mContext;
    }

    /**
     * 获取版本号
     *
     * @return 当前应用的版本号
     */
    public static String getVersion(Context context) {
        String version = 0 + "";
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            version = info.versionName;
            return context.getString(R.string.version_name) + version;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return context.getString(R.string.version_name) + version;
    }

    // Toast
    public static void showShort(Context context, CharSequence message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }



}