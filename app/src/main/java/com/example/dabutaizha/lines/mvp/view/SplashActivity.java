package com.example.dabutaizha.lines.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.dabutaizha.lines.R;
import com.example.dabutaizha.lines.databinding.ActivitySplashBinding;
import com.example.dabutaizha.lines.mvp.presenter.SplashPresenter;
import com.example.dabutaizha.lines.mvp.contract.SplashActivityContract;

import cn.bingoogolapple.bgabanner.BGALocalImageSize;

public class SplashActivity extends BaseActivity implements SplashActivityContract.View {

    private ActivitySplashBinding activitySplashBinding;

    private  SplashActivityContract.Presenter mPresenter;


    @Override
    protected void initData() {
        mPresenter = new SplashPresenter(this);
        mPresenter.initData();
    }

    @Override
    protected void initView() {
        activitySplashBinding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(activitySplashBinding.getRoot());
    }

    @Override
    protected void initViewListener() {
        activitySplashBinding.bannerForeground.setEnterSkipViewIdAndDelegate(R.id.btn_enter, 0, ()->{
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }

    @Override
    protected void initTheme(int themeId) {

    }

    @Override
    protected void process() {
        mPresenter.process();
    }

    @Override
    protected int getPageLayoutID() {
        return R.layout.activity_splash;
    }


    @Override
    public void refreshGuidePage() {
        //设置数据源
        BGALocalImageSize localImageSize = new BGALocalImageSize(1080, 1920, 320, 640);
        activitySplashBinding.bannerBackground.setData(localImageSize, ImageView.ScaleType.CENTER_CROP,
                R.drawable.splash_bg_0,
                R.drawable.splash_bg_1,
                R.drawable.splash_bg_2,
                R.drawable.splash_bg_3);
        activitySplashBinding.bannerForeground.setData(localImageSize, ImageView.ScaleType.CENTER_CROP,
                R.drawable.splash0,
                R.drawable.splash1,
                R.drawable.splash2,
                R.drawable.splash3);
    }

    @Override
    public void enterMainActivity() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }
}