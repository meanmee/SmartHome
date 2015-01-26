package com.mi.wuxiaomin.smarthome.util;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wuxiaomin on 2015/1/26.
 */
public class MyJsonParse {
    public static JSONObject jsonObj_send = new JSONObject();

    public static void sendJsonData() throws JSONException {
        jsonObj_send.accumulate("FurName", "TV");

        JSONArray array = new JSONArray();

        JSONObject object1 = new JSONObject();
        object1.accumulate("id", "111");
        object1.accumulate("name", "tv1");
        array.put(object1);

        JSONObject object2 = new JSONObject();
        object2.accumulate("id", "222");
        object2.accumulate("name", "tv2");
        array.put(object2);

        jsonObj_send.accumulate("Parameters", array);
        Log.v("Json",jsonObj_send.toString());
    }
}
