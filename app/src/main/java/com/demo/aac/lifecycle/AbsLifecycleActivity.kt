package com.demo.aac.lifecycle

import android.app.Activity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

abstract class AbsLifecycleActivity : Activity(), LifecycleOwner {
    private val lifecycleRegistry by lazy {
        LifecycleRegistry(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        lifecycleRegistry.currentState = Lifecycle.State.CREATED
        super.onSaveInstanceState(outState)
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }
}