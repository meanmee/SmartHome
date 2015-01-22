package com.mi.wuxiaomin.smarthome.mainui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mi.wuxiaomin.smarthome.R;

/**
 * Created by wuxiaomin on 2015/1/21.
 */
public class MyFragmen_Voice extends Fragment {
    private View mView;
    private Activity mActivity;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.voice_add,null);
        return mView;
    }
    //获取MainActivity
    public  MyFragmen_Voice(){
        mActivity=getActivity();
    }
}
