package com.mi.wuxiaomin.smarthome.iflytek;

import com.iflytek.cloud.SpeechConstant;

/**
 * Created by wuxiaomin on 2015/1/24.
 */
public class RecSettings {
    //设置发音人
    public static void voiceName(String voiceName_string) {
        NativeRec.mSpeechRec.setParameter(SpeechConstant.VOICE_NAME, voiceName_string);
    }

    //设置语速
    public static void voiceSpeed(String voiceSpeed_sring) {
        NativeRec.mSpeechRec.setParameter(SpeechConstant.SPEED, voiceSpeed_sring);
    }

    //录音机的录音方式，默认为MIC(MediaRecorder.AudioSource.MIC),如果需要外部传送录音，设置为-1，通过WriteAudio接口送入音频；读外部音频文件，设置为-2。
    public static void audioSource(String audioSource_sring) {
        NativeRec.mSpeechRec.setParameter(SpeechConstant.AUDIO_SOURCE, audioSource_sring);
    }


}
