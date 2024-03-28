package com.example.dabutaizha.lines.mvp.contract;

public interface SplashActivityContract {
    interface View {

        void refreshGuidePage();

        void enterMainActivity();

    }

    interface Presenter {

        void initData();

        void process();

    }

    interface Model {

        void saveLaunchTag();

        boolean checkIsFirstLaunch();

    }
}
