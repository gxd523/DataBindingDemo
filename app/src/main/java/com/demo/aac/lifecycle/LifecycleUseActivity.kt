package com.demo.aac.lifecycle

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.TextView
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

        setContentView(TextView(this).apply {
            text = "Hello World!"
            textSize = 40f
            gravity = Gravity.CENTER
        })

        presenter.getDataOnStart(this)

        if (requestedOrientation == ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED) {
            window.decorView.postDelayed({
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            }, 10000)
        }
    }

    fun onRequestData(result: String) {
        Log.d("gxd", "LifecycleUseActivity.onRequestData-->${result}")
    }
}