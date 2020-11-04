package com.demo.aac.viewmodel;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.demo.aac.BaseActivity;
import com.demo.aac.R;
import com.demo.aac.databinding.ActivityViewModelBinding;

import java.util.concurrent.TimeUnit;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

/**
 * FragmentActivity实现了LifecycleOwner
 */
public class ViewModelActivity extends BaseActivity {
    private ActivityViewModelBinding binding;
    private MutableLiveData<String> tempLiveData = new MutableLiveData<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_model);
        // liveData放在ViewModel中的写法
        binding.setLifecycleOwner(this);
        final MyViewModel viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        binding.setViewModel(viewModel);
        tempLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d("gxd", "liveData Changed-->" + s);
            }
        });
        viewModel.liveData.setValue("aaa");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                viewModel.liveData.postValue("bbbb");
            }
        }).start();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, new ViewModelFragment());
        transaction.commit();

        binding.activityViewModelTitleTv.addTextChangedListener(new TextWatcher() {
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
        tempLiveData.setValue("onStop");
    }
}
