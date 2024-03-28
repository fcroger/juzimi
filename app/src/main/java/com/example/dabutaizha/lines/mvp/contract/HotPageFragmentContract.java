package com.example.dabutaizha.lines.mvp.contract;

import androidx.fragment.app.Fragment;

import java.util.List;

public interface HotPageFragmentContract {
    interface View {

        void setSelectPage(int item);

        void setTab(List<Fragment> fragmentList, String[] titles);

        void showMessage(int resid);

    }

    interface Presenter {

        void initData();

        void process();

    }
}
