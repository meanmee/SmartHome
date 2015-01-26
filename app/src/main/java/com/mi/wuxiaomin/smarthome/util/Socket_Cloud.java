package com.mi.wuxiaomin.smarthome.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by wuxiaomin on 2015/1/23.
 */
public class Socket_Cloud {

    private static Socket mSocket_toCloud;

    public static void connect(String IP) {
        try {
            mSocket_toCloud = new Socket(IP, 11111);
        } catch (IOException i) {
        }
    }

    public static void sendToCloud() {
        try {

            OutputStream outputStream = mSocket_toCloud.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(MyJsonParse.jsonObj_send.toString());
            bufferedWriter.flush();
            mSocket_toCloud.close();

        } catch (IOException ioException) {

        }

    }
}
