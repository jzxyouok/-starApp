package com.android.starapp.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 *  读写工具类
 *
 * Created by My on 2016/7/13 0013.
 */
public class StreamTools {


    public static String StreamToString(InputStream is) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            is.close();
            baos.close();
            byte[] res = baos.toByteArray();
            String tem = new String(res);
            return new String(res);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}