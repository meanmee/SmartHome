package com.mi.wuxiaomin.smarthome.util;

import android.util.Log;

import org.json.JSONException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by wuxiaomin on 2015/1/23.
 */
public class Socket_Cloud {

    private static Socket mSocket_toCloud;

    public static void connect(String IP) {
        try {
            mSocket_toCloud = new Socket(IP, 11112);
        } catch (IOException i) {
        }
    }

    public static void sendJsonToCloud() {
        try {
            //初始化Json数据
            MyJsonParse.initJsonData();

            Log.v("Socket_Cloud--sendJsonToCloud", "Json.toString():" + MyJsonParse.getJsonObj_send().toString());

            OutputStream outputStream = mSocket_toCloud.getOutputStream();
//            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "utf-8");
//            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
//            bufferedWriter.write(MyJsonParse.getJsonObj_send().toString());
            PrintWriter printWriter = new PrintWriter(outputStream);

            printWriter.write(MyJsonParse.getJsonObj_send().toString());

            printWriter.flush();
            printWriter.close();

//            bufferedWriter.flush();
//            bufferedWriter.close();

        } catch (IOException ioException) {
            Log.v("Socket_Cloud中的sendJsonToCloud", "输出流错误IO");
        } catch (JSONException e) {
            Log.v("Socket_Cloud中的sendJsonToCloud", "初始化Json数据错误");
        }

    }
}
