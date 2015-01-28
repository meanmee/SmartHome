package com.mi.wuxiaomin.smarthome.util;

import android.util.Log;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by wuxiaomin on 2015/1/23.
 */
public class Socket_Cloud {

    private static Socket mSocket_toCloud;
    private static StringBuilder builder_jsonFromCloud = new StringBuilder();

    public static StringBuilder getBuild_jsonFromCloud() {
        return builder_jsonFromCloud;
    }

    public static void connect(String IP) {
        try {
            mSocket_toCloud = new Socket(IP, 11112);
        } catch (IOException i) {
        }
    }

    public static void sendJsonToCloud() {
        try {
            //初始化Json数据
            MyJson.initJsonData();

            Log.v("Socket_Cloud--sendJsonToCloud", "Json.toString():" + MyJson.getJsonObj_send().toString());

            OutputStream outputStream = mSocket_toCloud.getOutputStream();

            PrintWriter printWriter = new PrintWriter(outputStream);

            printWriter.write(MyJson.getJsonObj_send().toString());

            printWriter.flush();
            printWriter.close();


        } catch (IOException ioException) {
            Log.v("Socket_Cloud中的sendJsonToCloud", "输出流错误IO");
        } catch (JSONException e) {
            Log.v("Socket_Cloud中的sendJsonToCloud", "初始化Json数据错误");
        }

    }

    public static void getJsonFromCloud() {
        try {
            InputStream inputStream = mSocket_toCloud.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            //读取流中的Json数据
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                builder_jsonFromCloud.append(line);
            }
            Log.v("Socket_Cloud中的sendJsonToCloud", "Json数据转换成StringBuilder结束");


        } catch (IOException e) {


        }
    }
}