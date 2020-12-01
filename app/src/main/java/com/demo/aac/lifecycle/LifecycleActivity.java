package com.demo.aac.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

public abstract class LifecycleActivity extends Activity implements LifecycleOwner {
    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
    private LifecyclePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new LifecyclePresenter();
        // 添加生命周期观察者
        getLifecycle().addObserver(presenter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d("gxd", String.format("%s...%s()", this.getClass().getSimpleName(), "onSaveInstanceState"));
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        super.onSaveInstanceState(outState);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return lifecycleRegistry;
    }
}
