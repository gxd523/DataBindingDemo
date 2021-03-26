package com.demo.aac.lifecycle

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView

/**
 * Created by guoxiaodong on 3/26/21 10:51
 */
class LifecycleActivity : AbsLifecycleActivity() {
    private val presenter by lazy {
        LifecyclePresenter(this).also(lifecycle::addObserver)
    }
    private val textView by lazy {
        TextView(this).apply {
            text = "Hello World!"
            textSize = 40f
            gravity = Gravity.CENTER
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(textView)

        presenter.getDataOnStart(this)

        if (requestedOrientation == ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED) {
            window.decorView.postDelayed({
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            }, 10000)
        }
    }

    fun onRequestData(result: String) {
        textView.text = result
    }
}