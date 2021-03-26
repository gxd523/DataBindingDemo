package com.demo.aac

import android.app.Application
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner


/**
 * Created by guoxiaodong on 3/26/21 14:24
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        /**
         * 监听应用程序进入前台或后台
         *
         * Application生命周期观察，提供整个应用进程的生命周期
         *
         * Lifecycle.Event.ON_CREATE只会分发一次，Lifecycle.Event.ON_DESTROY不会被分发。
         *
         * 第一个Activity进入时，ProcessLifecycleOwner将分派Lifecycle.Event.ON_START, Lifecycle.Event.ON_RESUME。
         * 而Lifecycle.Event.ON_PAUSE, Lifecycle.Event.ON_STOP，将在最后一个Activity退出后后延迟分发。
         * 如果由于配置更改而销毁并重新创建活动，则此延迟足以保证ProcessLifecycleOwner不会发送任何事件。
         */
        ProcessLifecycleOwner.get().lifecycle.addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            private fun onAppForeground() {
                Log.d("gxd", "app moved to foreground")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            private fun onAppBackground() {
                Log.d("gxd", "app moved to background")
            }
        })
    }
}