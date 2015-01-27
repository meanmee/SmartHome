package com.mi.wuxiaomin.smarthome.util;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wuxiaomin on 2015/1/26.
 */
public class MyJsonParse {

    //供其它类使用jsonObj_send的数据
    public static JSONObject getJsonObj_send() {
        return jsonObj_send;
    }

    //new一个静态的JSONObject，用来将存储Json数据.
    private static JSONObject jsonObj_send = new JSONObject();

    public static void initJsonData() throws JSONException {
        jsonObj_send.put("FurName", "TV");
        //新建Json数组
        JSONArray array = new JSONArray();
        //json数组中的对象1
        JSONObject object1 = new JSONObject();
        object1.put("id", "111");
        object1.put("name", "tv1");
        //json对象1传入数组
        array.put(object1);


        //Json数组中的对象2
        JSONObject object2 = new JSONObject();
        object2.put("id", "222");
        object2.put("name", "tv2");
        //json对象2传入数组
        array.put(object2);

        //数组传入静态的json对象
        jsonObj_send.put("Parameters", array);
        Log.v("MyJsonParse_initJsonData", jsonObj_send.toString());
    }
}
