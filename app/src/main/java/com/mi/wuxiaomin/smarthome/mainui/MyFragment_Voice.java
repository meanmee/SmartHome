package com.mi.wuxiaomin.smarthome.mainui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gc.materialdesign.views.Button;
import com.mi.wuxiaomin.smarthome.R;
import com.mi.wuxiaomin.smarthome.util.Task_Socket_Cloud;

/**
 * Created by wuxiaomin on 2015/1/21.
 */
public class MyFragment_Voice extends Fragment {
    private View mView;
    protected static Activity mActivity_MyFragment_Voice;
    private Button mbtn_test;
    private Task_Socket_Cloud mTSC = new Task_Socket_Cloud();

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
    }

    @Override
    public void onStart() {
        super.onStart();

        mbtn_test = (Button) mActivity_MyFragment_Voice.findViewById(R.id.button_test);

        mbtn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task_Socket_Cloud().execute();
                Toast.makeText(mActivity_MyFragment_Voice, "连接完毕", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
