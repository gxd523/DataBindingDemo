package com.demo.aac.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import kotlin.concurrent.thread

/**
 * Created by guoxiaodong on 3/26/21 10:52
 */
class LifecyclePresenter(private val viewer: LifecycleActivity) : LifecycleObserver {
    fun getDataOnStart(owner: LifecycleOwner) {
        requestData { result ->
            if (owner.lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                viewer.runOnUiThread {
                    viewer.onRequestData(result)
                }
            }
        }
    }

    private fun requestData(block: (String) -> Unit) {
        thread {
            Thread.sleep(5000)
            block("get data!!!")
        }
    }

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

    /**
     * 接收全部生命周期事件
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(owner: LifecycleOwner?, event: Lifecycle.Event?) {
//        Log.d("gxd", "LifecyclePresenter.onAny-->${event?.name}")
    }
}