package com.mi.wuxiaomin.smarthome.mainui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
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
public class MyFragment_Voice extends Fragment implements ServiceConnection, View.OnClickListener {
    private View mView;
    public static Activity mActivity_MyFragment_Voice;
    private Button mBtn_StartRec, mBtn_ipSetting, mBtn_startQr;
    private Task_Socket_Cloud mTSC = new Task_Socket_Cloud();
    public static EditText mEdt_voice, mEdt_ipAddress, mEdt_qrResult, mEdt_jsonFromCloud;
    public static String mString_ipAddress;
    private Button mBtn_bindService, mBtn_unBindService;
    private Intent mItt_MyService_Voice = new Intent(mActivity_MyFragment_Voice, MyService_Voice.class);


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.voice_add, null);
        return mView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

        mEdt_voice = (EditText) mActivity_MyFragment_Voice.findViewById(R.id.edt_voice);
        mBtn_StartRec = (Button) mActivity_MyFragment_Voice.findViewById(R.id.button_startRec);
        mBtn_ipSetting = (Button) mActivity_MyFragment_Voice.findViewById(R.id.btn_ipSettting);
        mEdt_ipAddress = (EditText) mActivity_MyFragment_Voice.findViewById(R.id.edt_iPSetting);
        mBtn_startQr = (Button) mActivity_MyFragment_Voice.findViewById(R.id.button_startRec);
        mEdt_qrResult = (EditText) mActivity_MyFragment_Voice.findViewById(R.id.edt_qrResult);
        mEdt_jsonFromCloud = (EditText) mActivity_MyFragment_Voice.findViewById(R.id.edt_jsonFormCloud);
        mBtn_bindService = (Button) mActivity_MyFragment_Voice.findViewById(R.id.btn_bindService);
        mBtn_unBindService = (Button) mActivity_MyFragment_Voice.findViewById(R.id.btn_unBindService);

        mBtn_bindService.setOnClickListener(this);
        mBtn_unBindService.setOnClickListener(this);

        //设置默认的ip地址
        mEdt_ipAddress.setText("172.27.35.1");

        mBtn_startQr.setOnClickListener(new View.OnClickListener() {//开始二维码识别
            @Override
            public void onClick(View v) {
            }
        });

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_bindService:
                mActivity_MyFragment_Voice.bindService(mItt_MyService_Voice, this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btn_unBindService:
                mActivity_MyFragment_Voice.unbindService(this);
                break;
        }

    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.v("MyFragment_Voice---onServiceConnected", "Service连接成功");
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.v("MyFragment_Voice---onServiceDisconnected", "Service崩溃");
    }
}
