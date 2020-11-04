package com.demo.aac.viewmodel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

/**
 * Created by guoxiaodong on 2020/9/7 09:59
 */
public class ViewModelFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // of()中传入的参数相同，拿到的viewModel也相同
        MyViewModel viewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        MyViewModel fragmentViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
