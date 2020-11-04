package com.demo.aac;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by guoxiaodong on 2020-02-03 19:55
 */
public class LiveViewModel extends ViewModel {
    public MutableLiveData<String> liveData = new MutableLiveData<>();

    @Override
    protected void onCleared() {
        Log.d("gxd", "MyViewModel.onCleared-->");
    }
}
