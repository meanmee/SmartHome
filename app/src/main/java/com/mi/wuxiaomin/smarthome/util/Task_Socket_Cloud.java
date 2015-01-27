package com.mi.wuxiaomin.smarthome.util;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.mi.wuxiaomin.smarthome.mainui.MyFragment_Voice;

/**
 * Created by wuxiaomin on 2015/1/23.
 */
public class Task_Socket_Cloud extends AsyncTask {

    @Override
    public void onPreExecute() {
        Log.v("Tssk_Socket_Cloud", "onPreExcute方法开始执行");
        Toast.makeText(MyFragment_Voice.mActivity_MyFragment_Voice, "开始链接", Toast.LENGTH_SHORT).show();

        super.onPreExecute();
    }

    @Override
    public void onPostExecute(Object o) {
        Log.v("Tssk_Socket_Cloud", "onPostExecute方法开始执行");
        Toast.makeText(MyFragment_Voice.mActivity_MyFragment_Voice, "发送成功", Toast.LENGTH_SHORT).show();
        super.onPostExecute(o);
    }

    @Override
    public Object doInBackground(Object[] objects) {
        Log.v("Tssk_Socket_Cloud", "doInBackgrounf方法开始执行");
        Socket_Cloud.connect(MyFragment_Voice.mString_ipAddress);
        Socket_Cloud.sendJsonToCloud();
        return null;
    }

    @Override
    public void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
        Log.v("Tssk_Socket_Cloud", "onProgressUpdate方法开始执行");
    }
}
