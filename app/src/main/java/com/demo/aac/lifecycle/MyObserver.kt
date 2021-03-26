package com.demo.aac.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * Created by guoxiaodong on 3/26/21 10:52
 */
class MyObserver : LifecycleObserver {
    @OnLifecycleEvent(value = Lifecycle.Event.ON_START)
    fun onStart() {
        Log.d("gxd", "MyObserver.onStart-->")
    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.d("gxd", "MyObserver.onStop-->")
    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.d("gxd", "MyObserver.onDestroy-->")
    }
}