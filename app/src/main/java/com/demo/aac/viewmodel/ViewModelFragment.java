package com.demo.aac.viewmodel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.aac.LiveViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by guoxiaodong on 2020/9/7 09:59
 */
public class ViewModelFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // of()中传入的参数相同，拿到的viewModel也相同
        LiveViewModel viewModel = new ViewModelProvider(getActivity()).get(LiveViewModel.class);
        LiveViewModel fragmentViewModel = new ViewModelProvider(this).get(LiveViewModel.class);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
