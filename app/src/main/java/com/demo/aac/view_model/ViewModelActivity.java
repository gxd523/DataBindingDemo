package com.demo.aac.view_model;

import android.os.Bundle;

import com.demo.aac.R;
import com.demo.aac.data_binding.Presenter;
import com.demo.aac.databinding.ActivityViewModelBinding;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

/**
 * FragmentActivity实现了LifecycleOwner
 */
public class ViewModelActivity extends FragmentActivity {
    private ActivityViewModelBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_view_model);
        dataBinding.setPresenter(new Presenter());
        // liveData放在ViewModel中的写法
        dataBinding.setLifecycleOwner(this);
        MyViewModel viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        dataBinding.setViewModel(viewModel);
    }

    @Override
    protected void onStop() {
        super.onStop();

        dataBinding.getViewModel().liveData.setValue("onStop");
    }
}
