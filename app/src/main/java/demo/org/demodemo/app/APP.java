package demo.org.demodemo.app;

import android.app.Application;
import android.content.Context;

import demo.org.demodemo.util.DisplayUtiil;

/**
 * Author: zgc
 * Time: 2018/4/9 下午11:22
 * Description:
 **/
public class APP extends Application {
    public static Context sInstance = null;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;

        DisplayUtiil.init();
    }
}
