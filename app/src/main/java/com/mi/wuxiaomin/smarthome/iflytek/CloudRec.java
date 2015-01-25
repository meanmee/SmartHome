package com.mi.wuxiaomin.smarthome.iflytek;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechRecognizer;
import com.mi.wuxiaomin.smarthome.mainui.MyFragment_Voice;

/**
 * Created by wuxiaomin on 2015/1/24.
 */
public class CloudRec {
    public static SpeechRecognizer mSpeechRec;


    public static Object mObj_result = new Object();

    //设置语音识别的相关参数
    public static void startRec_setPar(Activity activity, String mAudioSource_string) {

        //创建SpeechrRecognizer对象
        mSpeechRec = SpeechRecognizer.createRecognizer(activity, null);
        //设置参数
        mSpeechRec.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
        mSpeechRec.setParameter(SpeechConstant.DOMAIN, "iat");
        mSpeechRec.setParameter(SpeechConstant.ACCENT, "mandarin");
        mSpeechRec.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_LOCAL);
        mSpeechRec.setParameter(SpeechConstant.TEXT_ENCODING, "utf-8");
        mSpeechRec.setParameter(SpeechConstant.AUDIO_FORMAT, "audio_format");


        if (mAudioSource_string != null) {
            //设置音频源
            mSpeechRec.setParameter(SpeechConstant.ASR_SOURCE_PATH, mAudioSource_string);
            //设置合成及采样的频率 8000~16000
            mSpeechRec.setParameter(SpeechConstant.SAMPLE_RATE, "8000");
        }
        mSpeechRec.startListening(mRecLis);
    }

    //开始语音识别


    //-----------------------------------------------------------------------------------------------
    public static RecognizerListener mRecLis = new RecognizerListener() {
        @Override
        public void onVolumeChanged(int i) {

        }

        @Override
        public void onBeginOfSpeech() {
            MyFragment_Voice.mEdt_voice.append("开始");
        }

        @Override
        public void onEndOfSpeech() {

        }

        @Override
        public void onResult(RecognizerResult recognizerResult, boolean b) {
            //返回的是Json格式的数据，需要解析。
            if (recognizerResult != null) {
                String mRes_string = JsonParse.parseIatResult(recognizerResult.getResultString());
                MyFragment_Voice.mEdt_voice.append(mRes_string);
                Log.d("1", mRes_string);
            } else {
                MyFragment_Voice.mEdt_voice.append("无返回结果");
            }
        }

        @Override
        public void onError(SpeechError speechError) {

        }

        @Override
        public void onEvent(int i, int i2, int i3, Bundle bundle) {

        }
    };
}
