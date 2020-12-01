package com.demo.aac.lifecycle;

import android.util.Log;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import io.reactivex.disposables.Disposable;

/**
 * Created by guoxiaodong on 12/1/20 09:17
 */
public class LifecyclePresenter implements DefaultLifecycleObserver {
    private final Set<Disposable> disposableSet = Collections.emptySet();

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        Iterator<Disposable> iterator = disposableSet.iterator();
        while (iterator.hasNext()) {
            Disposable disposable = iterator.next();
            if (disposable != null) {
                disposable.dispose();
            }
            iterator.remove();
        }
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        Log.d("gxd", "LifecyclePresenter.onCreate-->");
    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
        Log.d("gxd", "LifecyclePresenter.onStart-->");
    }
}