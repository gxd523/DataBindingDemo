package com.demo.aac;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

/**
 * Created by guoxiaodong on 2020/9/7 10:49
 */
public abstract class BaseActivity extends FragmentActivity {
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d("gxd", String.format("%s...%s()", this.getClass().getSimpleName(), "onSaveInstanceState"));
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d("gxd", String.format("%s...%s()", this.getClass().getSimpleName(), "onRestoreInstanceState"));
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.d("gxd", String.format("%s...%s()", this.getClass().getSimpleName(), "onNewIntent"));
        super.onNewIntent(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("gxd", String.format("%s...%s()", this.getClass().getSimpleName(), "onCreate"));
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        Log.d("gxd", String.format("%s...%s()", this.getClass().getSimpleName(), "onStart"));
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.d("gxd", String.format("%s...%s()", this.getClass().getSimpleName(), "onRestart"));
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.d("gxd", String.format("%s...%s()", this.getClass().getSimpleName(), "onResume"));
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("gxd", String.format("%s...%s()", this.getClass().getSimpleName(), "onPause"));
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("gxd", String.format("%s...%s()", this.getClass().getSimpleName(), "onStop"));
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("gxd", String.format("%s...%s()", this.getClass().getSimpleName(), "onDestroy"));
        super.onDestroy();
    }
}
