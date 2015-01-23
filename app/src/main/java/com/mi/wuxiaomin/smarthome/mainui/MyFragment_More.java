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
    protected static Activity mActivity_MyFragment_More;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.more_setting,null);
        return mView;
    }

}
