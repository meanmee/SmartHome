package com.mi.wuxiaomin.smarthome.mainui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.gc.materialdesign.views.Button;
import com.mi.wuxiaomin.smarthome.R;
import com.mi.wuxiaomin.smarthome.iflytek.NativeRec;
import com.mi.wuxiaomin.smarthome.util.Task_Socket_Cloud;

/**
 * Created by wuxiaomin on 2015/1/21.
 */
public class MyFragment_Voice extends Fragment {
    private View mView;
    public static Activity mActivity_MyFragment_Voice;
    private Button mBtn_StartRec, mBtn_ipSetting;
    private Task_Socket_Cloud mTSC = new Task_Socket_Cloud();
    public static EditText mEdt_voice, mEdt_ipAddress;
    public static String mString_ipAddress;


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
        mBtn_StartRec = (Button) mActivity_MyFragment_Voice.findViewById(R.id.button_startRec);
        mBtn_ipSetting = (Button) mActivity_MyFragment_Voice.findViewById(R.id.btn_ipSettting);
        mEdt_ipAddress = (EditText) mActivity_MyFragment_Voice.findViewById(R.id.edt_iPSetting);

        //设置默认的ip地址
        mEdt_ipAddress.setText("172.27.35.1");

        mBtn_ipSetting.setOnClickListener(new View.OnClickListener() {//设置好IP地址并连接
            @Override
            public void onClick(View view) {//设置ip地址并连接
                if (mEdt_ipAddress == null) {
                    toastUtil("IP地址错误");
                } else {
                    mString_ipAddress = mEdt_ipAddress.getText().toString();
                    new Task_Socket_Cloud().execute();
                    Log.v("MyFragment_Voice---mBtn_ipSetting", "已执行Task_Socket_Cloud的excute（）方法");
                }
            }
        });


        mBtn_StartRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//开始手机录音识别
                NativeRec.startRec_setPar(mActivity_MyFragment_Voice, null);
                toastUtil("开始识别");
            }
        });
    }

    private void toastUtil(String s) {
        Toast.makeText(mActivity_MyFragment_Voice, s, Toast.LENGTH_SHORT).show();
    }
}
