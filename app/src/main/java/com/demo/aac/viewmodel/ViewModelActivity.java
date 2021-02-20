package com.demo.aac.viewmodel;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

/**
 * ViewModel只会在Activity存活，且只会创建一次。
 * 当onDestroy()时，会主动调用onCleared()。
 * 旋转屏幕等销毁再重新创建的情况也不会重新创建
 */
public class ViewModelActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        Log.d("gxd", "ViewModelActivity.onCreate-->" + viewModel.hashCode());
    }

    @Override
    protected void onStart() {
        super.onStart();
        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        Log.d("gxd", "ViewModelActivity.onStart-->" + viewModel.hashCode());
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        Log.d("gxd", "ViewModelActivity.onResume-->" + viewModel.hashCode());
    }

    @Override
    protected void onStop() {
        super.onStop();
        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        Log.d("gxd", "ViewModelActivity.onStop-->" + viewModel.hashCode());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        Log.d("gxd", "ViewModelActivity.onDestroy-->" + viewModel.hashCode());
    }
}