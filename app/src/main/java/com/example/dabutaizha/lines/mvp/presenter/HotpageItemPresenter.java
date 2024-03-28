package com.example.dabutaizha.lines.mvp.presenter;

import android.os.Bundle;

import com.example.dabutaizha.lines.Constant;
import com.example.dabutaizha.lines.bean.info.SearchInfo;
import com.example.dabutaizha.lines.mvp.contract.HotPageItemFragmentContract;
import com.example.dabutaizha.lines.mvp.model.HotpageItemModel;

import java.util.List;

public class HotpageItemPresenter implements HotPageItemFragmentContract.Presenter {
    private HotPageItemFragmentContract.View mView;
    private HotPageItemFragmentContract.Model mModel;
    private int mCurrentPage;
    public HotpageItemPresenter(HotPageItemFragmentContract.View mView) {
        this.mView = mView;
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void initData(Bundle bundle, Bundle savedInstanceState) {
        String category = bundle.getString(Constant.FRAGMENT_TITLE);
        mModel = new HotpageItemModel(this, category);
    }

    @Override
    public void process(Bundle savedInstanceState) {

    }

    @Override
    public void loadData(SearchInfo searchInfo) {

    }

    @Override
    public void loadPictureData(String url) {

    }

    @Override
    public void pullToRefresh(boolean isLoadMore) {

    }

    @Override
    public void refreshHeaderTag(String tag) {

    }

    @Override
    public void fail(String msg) {

    }

    @Override
    public void requestError() {

    }

    @Override
    public void notifyDataThemeChanged(List<SearchInfo.SentencesItem> itemList, int themeId) {

    }
}
