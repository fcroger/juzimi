package com.example.dabutaizha.lines.mvp.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.dabutaizha.lines.Constant;
import com.example.dabutaizha.lines.mvp.contract.SplashActivityContract;
import com.example.dabutaizha.lines.mvp.view.BaseApplication;

public class SplashModel implements SplashActivityContract.Model {
    private SplashActivityContract.Presenter mPresenter;

    public SplashModel(SplashActivityContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void saveLaunchTag() {
        SharedPreferences sp = BaseApplication.getInstance().getSharedPreferences(Constant.SEARCH_TAG, Context.MODE_PRIVATE);
        sp.edit().putBoolean(Constant.IS_FIRST, false).apply();
    }

    @Override
    public boolean checkIsFirstLaunch() {
        boolean isFirstLaunch;
        SharedPreferences sp = BaseApplication.getInstance().getSharedPreferences(Constant.SEARCH_TAG, Context.MODE_PRIVATE);
        isFirstLaunch = sp.getBoolean(Constant.IS_FIRST, true);

        return isFirstLaunch;
    }
}
