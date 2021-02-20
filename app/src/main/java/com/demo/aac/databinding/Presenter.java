package com.demo.aac.databinding;

import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by guoxiaodong on 2020-02-04 10:42
 */
public class Presenter {
    public void onBtnClick(View view, DataBindingActivity.User user) {
        user.name.set("bbb");
        Toast.makeText(view.getContext(), "用户名：" + user.name.get(), Toast.LENGTH_SHORT).show();
    }

    public void afterTextChanged(Editable s) {
        Log.d("gxd", "EditText.afterTextChanged-->" + s);
    }
}
