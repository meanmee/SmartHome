package com.mi.wuxiaomin.smarthome.util;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wuxiaomin on 2015/1/26.
 */
public class MyJson {
    //new一个静态的JSONObject，用来将存储Json数据.
    private static JSONObject jsonObj_send = new JSONObject();

    //供其它类使用jsonObj_send的数据
    public static JSONObject getJsonObj_send() {
        return jsonObj_send;
    }

    private static String[] strings_param_jsonFromCloud = new String[100];

    //供其它类使用
    public static String[] getStrings_param_jsonFromCloud() {
        return strings_param_jsonFromCloud;
    }


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

    public static void parseJsonData() {
        try {
            StringBuilder builder = new StringBuilder();
            builder = Socket_Cloud.getBuild_jsonFromCloud();
            //获取JsonObj
            JSONObject jsonObj = new JSONObject(builder.toString());
            JSONArray array = jsonObj.getJSONArray("Parameters");
            //家居名称，放入数组的首位
            strings_param_jsonFromCloud[0] = jsonObj.getString("FurName");
            //参数
            for (int i = 1; i <= array.length(); i++) {
                strings_param_jsonFromCloud[i] = jsonObj.getString("1");
            }
            Log.v("MyJsonParse_initJsonData", "从云端获取Json的结果：" + strings_param_jsonFromCloud);

        } catch (JSONException j) {

        }
    }
}
