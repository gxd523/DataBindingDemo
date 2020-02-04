package com.demo.aac.data_binding;

import android.text.TextUtils;

import androidx.databinding.BindingConversion;

/**
 * 优先级比BindingAdapter高
 */
public class TextBindingConversion {
    @BindingConversion
    public static String conversionString(String text) {
        if (TextUtils.isEmpty(text)) {
            return text + "-BindingConversion";
        } else {
            return text;
        }
    }
}
