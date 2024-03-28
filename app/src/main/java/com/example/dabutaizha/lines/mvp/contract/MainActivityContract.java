package com.example.dabutaizha.lines.mvp.contract;

import android.content.Context;
import android.content.Intent;
import android.icu.util.VersionInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import java.util.List;

public interface MainActivityContract {
    interface View {

        void setSelectPage(int item);

        void setTab(List<Fragment> fragmentList, String[] titles);

        void showUpdateDialog(Bundle bundle);

        void refreshView(int collectSize);

        void showMessage(String msg);

    }

    interface Presenter {

        void initData(Intent intent);

        void process();

        void clearCache();

        void getRecentVersionInfo();

        void compareVersionInfo(VersionInfo versionInfo);

        Intent buildFeedBackData(Context context);

        void refreshView(int collectSize);

        void querySentencesSize();

        void showMessage(String msg);

    }

    interface Model {

        void clearCache();

        void requestRecentVersionInfo();

        Intent buildFeedBackData(Context context);

        void querySentencesSize();

    }
}
