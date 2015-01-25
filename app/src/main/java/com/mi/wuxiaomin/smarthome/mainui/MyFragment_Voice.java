package com.mi.wuxiaomin.smarthome.mainui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.gc.materialdesign.views.Button;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;
import com.mi.wuxiaomin.smarthome.R;
import com.mi.wuxiaomin.smarthome.iflytek.CloudRec;
import com.mi.wuxiaomin.smarthome.util.Task_Socket_Cloud;

/**
 * Created by wuxiaomin on 2015/1/21.
 */
public class MyFragment_Voice extends Fragment {
    private View mView;
    public static Activity mActivity_MyFragment_Voice;
    private Button mbtn_Connect, mBtn_StartRec, mBtn_InitClo;
    private Task_Socket_Cloud mTSC = new Task_Socket_Cloud();
    public static EditText mEdt_voice;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.voice_add, null);


        return mView;
    }

    //获取MainActivity
    public MyFragment_Voice() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //创建用户语音配置对象


    }

    @Override
    public void onStart() {
        super.onStart();

        mEdt_voice = (EditText) mActivity_MyFragment_Voice.findViewById(R.id.edt_voice);
        mbtn_Connect = (Button) mActivity_MyFragment_Voice.findViewById(R.id.button_connect);
        mBtn_StartRec = (Button) mActivity_MyFragment_Voice.findViewById(R.id.button_startRec);
        mBtn_InitClo = (Button) mActivity_MyFragment_Voice.findViewById(R.id.button_initClo);


        mBtn_InitClo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpeechUtility.createUtility(MyFragment_Voice.mActivity_MyFragment_Voice, SpeechConstant.APPID + "=54c3a2b8");
                Toast.makeText(mActivity_MyFragment_Voice, "初始化...", Toast.LENGTH_SHORT).show();
            }
        });

        mbtn_Connect.setOnClickListener(new View.OnClickListener() {//连接服务器
            @Override
            public void onClick(View view) {
                new Task_Socket_Cloud().execute();
            }
        });


        mBtn_StartRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//开始手机录音识别
                CloudRec.startRec_setPar(mActivity_MyFragment_Voice, null);
                Toast.makeText(mActivity_MyFragment_Voice, "开始识别", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
