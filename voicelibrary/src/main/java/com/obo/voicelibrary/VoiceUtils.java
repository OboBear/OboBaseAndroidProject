package com.obo.voicelibrary;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechUnderstander;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.TextUnderstander;
import com.iflytek.cloud.TextUnderstanderListener;
import com.iflytek.cloud.UnderstanderResult;

/**
 * Created by obo on 15/11/29.
 */
public class VoiceUtils {

    private Context context;
    private SpeechUnderstander mSpeechUnderstander = null;
    private SharedPreferences mSharedPreferences = null;
    private TextUnderstander mTextUnderstander = null;

    public static final String PREFER_NAME = "com.iflytek.setting";

    public static void setAppKey(Context context,String appKey) {

        SpeechUtility.createUtility(context, appKey);

    }


    public void init(Context context) {
        this.context = context;
        if (mSpeechUnderstander == null) {
            mSpeechUnderstander = SpeechUnderstander.createUnderstander(context, mSpeechUdrInitListener);
        }

        mTextUnderstander = TextUnderstander.createTextUnderstander(context, mTextUdrInitListener);
        mSharedPreferences = context.getSharedPreferences(PREFER_NAME, Activity.MODE_PRIVATE);

    }

    public void recognize(String stringInput) {
        setParam();
        if (mTextUnderstander.isUnderstanding()) {
            mTextUnderstander.cancel();

        } else {
            int ret = mTextUnderstander.understandText(stringInput, mTextUnderstanderListener);
            if (ret != 0) {
                Log.i(context.getClass().getCanonicalName(), "语义理解失败,错误码:" + ret);
            }
        }
    }


    /**
     * 参数设置
     *
     * @param
     * @return
     */
    public void setParam() {
        String lang = mSharedPreferences.getString("understander_language_preference", "mandarin");
        if (lang.equals("en_us")) {
            // 设置语言
            mSpeechUnderstander.setParameter(SpeechConstant.LANGUAGE, "en_us");
        } else {
            // 设置语言
            mSpeechUnderstander.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
            // 设置语言区域
            mSpeechUnderstander.setParameter(SpeechConstant.ACCENT, lang);
        }
        // 设置语音前端点:静音超时时间，即用户多长时间不说话则当做超时处理
        mSpeechUnderstander.setParameter(SpeechConstant.VAD_BOS, mSharedPreferences.getString("understander_vadbos_preference", "4000"));

        // 设置语音后端点:后端点静音检测时间，即用户停止说话多长时间内即认为不再输入， 自动停止录音
        mSpeechUnderstander.setParameter(SpeechConstant.VAD_EOS, mSharedPreferences.getString("understander_vadeos_preference", "1000"));

        // 设置标点符号，默认：1（有标点）
        mSpeechUnderstander.setParameter(SpeechConstant.ASR_PTT, mSharedPreferences.getString("understander_punc_preference", "1"));

        // 设置音频保存路径，保存音频格式支持pcm、wav，设置路径为sd卡请注意WRITE_EXTERNAL_STORAGE权限
        // 注：AUDIO_FORMAT参数语记需要更新版本才能生效
        mSpeechUnderstander.setParameter(SpeechConstant.AUDIO_FORMAT, "wav");
        mSpeechUnderstander.setParameter(SpeechConstant.ASR_AUDIO_PATH, Environment.getExternalStorageDirectory() + "/msc/sud.wav");
    }




    /**
     * 初始化监听器（语音到语义）。
     */
    private InitListener mSpeechUdrInitListener = new InitListener() {

        @Override
        public void onInit(int code) {
            Log.d(context.getClass().getCanonicalName(), "speechUnderstanderListener init() code = " + code);
            if (code != ErrorCode.SUCCESS) {

            }
        }
    };


    /**
     * 初始化监听器（文本到语义）。
     */
    private InitListener mTextUdrInitListener = new InitListener() {

        @Override
        public void onInit(int code) {
            Log.d(context.getClass().getCanonicalName(), "textUnderstanderListener init() code = " + code);
            if (code != ErrorCode.SUCCESS) {
            }
        }
    };



    private TextUnderstanderListener mTextUnderstanderListener = new TextUnderstanderListener() {

        @Override
        public void onResult(final UnderstanderResult result) {
            if (null != result) {
                // 显示
                String text = result.getResultString();
                if (!TextUtils.isEmpty(text)) {
//                    textResult.setText(text);
                    Log.i(context.getClass().getCanonicalName(), text);
                }
            } else {
                Log.d(context.getClass().getCanonicalName(), "understander result:null");
//                textResult.setText("识别结果不正确。");
            }
        }

        @Override
        public void onError(SpeechError error) {
            // 文本语义不能使用回调错误码14002，请确认您下载sdk时是否勾选语义场景和私有语义的发布
            Log.d(context.getClass().getCanonicalName(), "onError Code：" + error.getErrorCode());
        }
    };




}
