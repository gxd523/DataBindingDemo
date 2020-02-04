package com.demo.aac.view_model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by guoxiaodong on 2020-02-03 19:55
 */
public class MyViewModel extends ViewModel {
    public MutableLiveData<String> liveData = new MutableLiveData<>();

    @Override
    protected void onCleared() {
        Log.d("gxd", "MyViewModel.onCleared-->");
    }
}
