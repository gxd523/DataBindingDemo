package com.demo.aac;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.demo.aac.databinding.ActivityAacBinding;

import java.util.concurrent.TimeUnit;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

/**
 * DataBinding+ViewModel+LiveData
 */
public class AACActivity extends BaseActivity {
    private ActivityAacBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_aac);
        // 加了这句就不需要设置liveData.observe()了
        binding.setLifecycleOwner(this);
        final LiveViewModel viewModel = new ViewModelProvider(this).get(LiveViewModel.class);
        binding.setViewModel(viewModel);
        viewModel.liveData.setValue("onCreate");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                viewModel.liveData.postValue(Thread.currentThread().getName());
            }
        }).start();

        binding.activityAacTitleTv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("gxd", "ViewModelActivity.onTextChanged-->" + s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        binding.getViewModel().liveData.setValue("onStop");
    }
}
