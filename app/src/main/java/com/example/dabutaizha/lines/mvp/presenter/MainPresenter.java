package com.example.dabutaizha.lines.mvp.presenter;

import android.content.Context;
import android.content.Intent;
import android.icu.util.VersionInfo;
import android.util.Log;

import androidx.fragment.app.Fragment;

import com.example.dabutaizha.lines.Constant;
import com.example.dabutaizha.lines.ResUtil;
import com.example.dabutaizha.lines.database.PremissionObjectBox;
import com.example.dabutaizha.lines.mvp.contract.MainActivityContract;
import com.example.dabutaizha.lines.mvp.model.MainModel;
import com.example.dabutaizha.lines.mvp.view.HotPageFragment;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter implements MainActivityContract.Presenter {
    private MainActivityContract.View mView;
    private MainActivityContract.Model mModel;

    private String[] mTitles;
    private List<Fragment> mFragmentList;

    public MainPresenter(MainActivityContract.View mView) {
        this.mView = mView;
        mModel = new MainModel(this);
        querySentencesSize();
    }

    @Override
    public void initData(Intent intent) {
        checkInputSentencePremission();

        mTitles = ResUtil.getStringArray(R.array.tab_item);
        initFragmentList();
    }

    private void checkInputSentencePremission() {
        PremissionObjectBox.getInstance().findAllByRxJava().subscribe(premissionModels -> {
            if (premissionModels != null) {
                int size = premissionModels.size();
                if (size == 0) {
                    Log.d("dabutaizha", "PremissionBox Error0" + size);
                    Constant.INPUT_SENTENCE_PREMISSION = false;
                }
                if (size == 1) {
                    Log.d("dabutaizha", "PremissionBox Error1" + size);
                    Constant.INPUT_SENTENCE_PREMISSION = premissionModels.get(0).isInputSentencePremission();
                }
                if (size != 0 && size != 1){
                    Log.d("dabutaizha", "PremissionBox Error" + size);
                    Constant.INPUT_SENTENCE_PREMISSION = false;
                }
            }
        });
    }

    private void initFragmentList() {
        mFragmentList = new ArrayList<>();

        for (int i = 0; i < mTitles.length; i ++) {
            switch (i) {
                case 0:
                    mFragmentList.add(HotPageFragment.newInstance(mTitles[i]));
                    break;
                case 1:
                    //mFragmentList.add(DialogueFragment.newInstance(mTitles[i]));
                    break;
                case 2:
                    //mFragmentList.add(MenuFragment.newInstance(mTitles[i]));
                    break;
                case 3:
                    //mFragmentList.add(new SearchFragment());
                    break;
                default:

                    break;
            }
        }
    }

    @Override
    public void process() {

    }

    @Override
    public void clearCache() {

    }

    @Override
    public void getRecentVersionInfo() {

    }

    @Override
    public void compareVersionInfo(VersionInfo versionInfo) {

    }

    @Override
    public Intent buildFeedBackData(Context context) {
        return null;
    }

    @Override
    public void refreshView(int collectSize) {

    }

    @Override
    public void querySentencesSize() {

    }

    @Override
    public void showMessage(String msg) {

    }
}
