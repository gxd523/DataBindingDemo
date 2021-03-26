package com.demo.aac.lifecycle

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity

/**
 * Created by guoxiaodong on 3/26/21 10:51
 */
class LifecycleUseActivity : ComponentActivity() {
    private val presenter by lazy {
        LifecyclePresenter(this).also(lifecycle::addObserver)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.getDataOnStart(this)
    }

    fun onRequestData(result: String) {
        Log.d("gxd", "LifecycleUseActivity.onRequestData-->${result}")
    }
}