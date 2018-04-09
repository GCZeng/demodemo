package demo.org.demodemo.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import demo.org.demodemo.app.APP;


/**
 * Created by Nick on 2017/12/5
 */
public class DisplayUtiil {
    private static int mScreenWidth = 0;
    private static int mScreenHeight = 0;

    public static void init() {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) APP.sInstance.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        mScreenWidth = metrics.widthPixels;
        mScreenHeight = metrics.heightPixels;
    }

    public static int getScreenWidth() {
        return mScreenWidth;
    }

    public static int getScreenHeight() {
        return mScreenHeight;
    }


}
