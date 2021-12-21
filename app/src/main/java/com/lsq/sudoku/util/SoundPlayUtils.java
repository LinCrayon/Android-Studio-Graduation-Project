package com.lsq.sudoku.util;


import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import com.lsq.sudoku.R;

public class SoundPlayUtils {
    public static SoundPool mSoundPlayer = new SoundPool(10,
            AudioManager.STREAM_SYSTEM, 5);
    public static SoundPlayUtils soundPlayUtils;
    static Context mContext;


    public static SoundPlayUtils init(Context context) {
        if (soundPlayUtils == null) {
            soundPlayUtils = new SoundPlayUtils();
        }

        // 初始化声音
        mContext = context;

        mSoundPlayer.load(mContext, R.raw.hecheng, 1);
        mSoundPlayer.load(mContext, R.raw.yidong2, 1);

        return soundPlayUtils;
    }


    public static void play(int soundID) {
        mSoundPlayer.play(soundID, 1, 1, 0, 0, 1);
    }



}
