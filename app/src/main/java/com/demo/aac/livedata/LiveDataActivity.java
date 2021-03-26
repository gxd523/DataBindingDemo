package com.demo.aac.livedata;

import android.os.Bundle;
import android.util.Log;

import com.demo.aac.lifecycle.AbsLifecycleActivity;

import java.util.concurrent.TimeUnit;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

/**
 * 1、感知对应Activity的生命周期，只有生命周期处于onStart与onResume时，LiveData处于活动状态，才会把更新的数据通知至对应的Activity
 * 2、当生命周期处于onStop或者onPause时，不回调数据更新，直至生命周期为onResume时，立即回调
 * 3、当生命周期处于onDestroy时，观察者会自动删除，防止内存溢出
 * 4、共享资源。可以使用单例模式扩展LiveData对象以包装系统服务，以便可以在应用程序中共享它们，同时有遵守了以上生命周期
 */
public class LiveDataActivity extends AbsLifecycleActivity {
    private final MutableLiveData<String> liveData = new MutableLiveData<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        liveData.setValue("aaa");

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            liveData.postValue("bbb");
        }).start();

        liveData.observe(this, s -> Log.d("gxd", "LiveDataActivity.onChanged-->" + s));
    }

    @Override
    protected void onStop() {
        super.onStop();
        liveData.postValue("onStop");
    }
}
