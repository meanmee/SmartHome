package com.mi.wuxiaomin.smarthome.mainui;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by wuxiaomin on 2015/1/29.
 */
public class MyService_Voice extends Service {

    private MyService_Voice_Binder myBinder=new MyService_Voice_Binder();

    //需返回一个binder给onBinder方法
    @Override
    public IBinder onBind(Intent intent) {
        Log.v("MyService_Voice-onBind","");
        return myBinder;
    }

    @Override
    public void onCreate() {
        Log.v("MyService_Voice-onCreat","");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.v("MyService_Voice-onDestroy","");
        super.onDestroy();
    }

    @Override
    public void onRebind(Intent intent) {
        Log.v("MyService_Voice-onRebind","");
        super.onRebind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v("MyService_Voice-onStartCommand","");
        return super.onStartCommand(intent, flags, startId);
    }
    //需返回一个binder给onBinder方法
    public  class MyService_Voice_Binder extends Binder{
            public MyService_Voice getMyService_Voice(){
                return MyService_Voice.this;
        }
    }
}
