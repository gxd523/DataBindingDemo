package com.demo.aac.databinding;

import android.os.Bundle;
import android.util.Log;

import com.demo.aac.BR;
import com.demo.aac.BaseActivity;
import com.demo.aac.R;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;

public class DataBindingActivity extends BaseActivity {
    /**
     * 注意这里是根据布局名称生成的Binding类
     */
    private ActivityMainBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        dataBinding.setPresenter(new Presenter());
        dataBinding.setUser(new User());
        dataBinding.setImageSrc(android.R.mipmap.sym_def_app_icon);

        Temp temp = new Temp("aaa", "bbb");
        temp.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (propertyId == BR.a) {
                    Log.d("gxd", "DataBindingActivity.onPropertyChanged-->a");
                } else if (propertyId == BR.b) {
                    Log.d("gxd", "DataBindingActivity.onPropertyChanged-->b");
                }
            }
        });
        dataBinding.setTemp(temp);


//        startActivity(new Intent(this, ViewModelActivity.class));
    }

    @Override
    protected void onStop() {
        super.onStop();
//        dataBinding.getUser().name.set("onStop");
    }

    @Override
    protected void onDestroy() {
        Log.d("gxd", "MainActivity.onDestroy-->a");
        super.onDestroy();
        Log.d("gxd", "MainActivity.onDestroy-->" + (dataBinding == null));
    }

    public static class User {
        //        public ObservableField<String> name = new ObservableField<>();
        public String name;
    }

    public static class Temp extends BaseObservable {
        private String a;
        private String b;

        public Temp(String a, String b) {
            this.a = a;
            this.b = b;
        }

        @Bindable
        public String getA() {
            return a;
        }

        @Bindable
        public String getB() {
            return b;
        }

        public void updateAll(String a, String b) {
            this.a = a;
            this.b = b;
            notifyChange();
        }

        public void updateA(String a, String b) {
            this.a = a;
            this.b = b;
            notifyPropertyChanged(BR.a);
        }
    }
}
