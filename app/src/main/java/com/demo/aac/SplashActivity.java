package com.demo.aac;

import android.content.Intent;
import android.os.Bundle;

import com.demo.aac.databinding.DataBindingActivity;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

/**
 * Created by guoxiaodong on 2020/11/4 10:05
 */
public class SplashActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, DataBindingActivity.class));
        finish();
    }
}