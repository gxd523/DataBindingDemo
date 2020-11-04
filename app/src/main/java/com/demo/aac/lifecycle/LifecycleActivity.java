package com.demo.aac.lifecycle;

import com.demo.aac.BaseActivity;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

/**
 * lifecycle原理
 */
public class LifecycleActivity extends BaseActivity implements LifecycleOwner {
    private LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return null;
    }
}
