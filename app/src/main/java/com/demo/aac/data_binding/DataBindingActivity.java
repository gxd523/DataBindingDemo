package com.demo.aac.data_binding;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.demo.aac.R;
import com.demo.aac.databinding.ActivityMainBinding;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;

public class DataBindingActivity extends Activity {
    /**
     * 注意这里是根据布局名称生成的Binding类
     */
    private ActivityMainBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        dataBinding.setPresenter(new Presenter());
        dataBinding.setUser(new User());
        dataBinding.setImageSrc(R.mipmap.ic_launcher);
    }

    @Override
    protected void onPause() {
        super.onPause();
        dataBinding.getUser().name.set("onPause");
    }

    @Override
    protected void onDestroy() {
        Log.d("gxd", "MainActivity.onDestroy-->a");
        super.onDestroy();
        Log.d("gxd", "MainActivity.onDestroy-->" + (dataBinding == null));
    }

    public class User {
        public ObservableField<String> name = new ObservableField<>();
    }
}
