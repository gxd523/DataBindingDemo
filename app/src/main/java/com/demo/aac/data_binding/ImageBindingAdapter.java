package com.demo.aac.data_binding;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

/**
 * Created by guoxiaodong on 2020-02-04 11:13
 */
public class ImageBindingAdapter {
    @BindingAdapter(value = {"bind:imageSrc"}, requireAll = true)
    public static void setImageSrc(ImageView imageView, int src) {
        imageView.setImageResource(src);
    }
}
