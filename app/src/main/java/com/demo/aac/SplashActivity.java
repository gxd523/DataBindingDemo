package com.demo.aac;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.demo.aac.livedata.LiveDataActivity;

import androidx.annotation.Nullable;

/**
 * Created by guoxiaodong on 2020/11/4 10:05
 */
public class SplashActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, LiveDataActivity.class));
    }
}