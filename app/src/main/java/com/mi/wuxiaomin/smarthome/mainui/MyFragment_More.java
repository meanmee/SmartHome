package com.mi.wuxiaomin.smarthome.mainui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mi.wuxiaomin.smarthome.R;

/**
 * Created by wuxiaomin on 2015/1/22.
 */
public class MyFragment_More extends Fragment {
    private View mView;
    private Activity mActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.more_setting,null);
        return mView;
    }

    public  MyFragment_More(){
        mActivity=getActivity();
    }
}
