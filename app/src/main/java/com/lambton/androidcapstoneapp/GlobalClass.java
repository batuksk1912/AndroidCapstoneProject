package com.lambton.androidcapstoneapp;



import android.app.Application;

public class GlobalClass extends Application {
    //public static final String BASE_URL = "http://192.168.18.8:8888/androidApp/";
    public static final String BASE_URL = "http://192.168.0.14/api/";

    private static GlobalClass singleton;

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }

    public static GlobalClass getInstance() {
        return singleton;
    }
}
