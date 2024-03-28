package com.example.dabutaizha.lines;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.dabutaizha.lines.mvp.view.BaseApplication;

public class AppThemeUtils {
    public static int getCurrentAppTheme() {
        SharedPreferences sp = BaseApplication.getInstance()
                .getSharedPreferences(Constant.APP_THEME_ID, Context.MODE_PRIVATE);
        return sp.getInt(Constant.THEME_SAVE, 0);
    }
}
