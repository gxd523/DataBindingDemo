package com.demo.aac.lifecycle

import android.os.Bundle

/**
 * Created by guoxiaodong on 3/26/21 10:51
 */
class LifecycleUseActivity : LifecycleActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(MyObserver())
    }
}