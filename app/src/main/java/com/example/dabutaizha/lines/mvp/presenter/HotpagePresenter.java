package com.example.dabutaizha.lines.mvp.presenter;

import androidx.fragment.app.Fragment;

import com.example.dabutaizha.lines.R;
import com.example.dabutaizha.lines.ResUtil;
import com.example.dabutaizha.lines.mvp.contract.HotPageFragmentContract;
import com.example.dabutaizha.lines.mvp.view.HotPageItemFragment;

import java.util.ArrayList;

public class HotpagePresenter implements HotPageFragmentContract.Presenter {
    private HotPageFragmentContract.View mView;
    private String[] mTitles;
    private ArrayList<Fragment> mFragmentList;

    public HotpagePresenter(HotPageFragmentContract.View view) {
        mView = view;
    }
    @Override
    public void initData() {
        mTitles = ResUtil.getStringArray(R.array.hotpage_item);
        initFragmentList();
    }

    @Override
    public void process() {
        mView.setTab(mFragmentList, mTitles);
        mView.setSelectPage(0);
    }
    private void initFragmentList() {
        mFragmentList = new ArrayList<>();
        for (int i = 0; i < mTitles.length; i ++) {
            mFragmentList.add(HotPageItemFragment.newInstance(mTitles[i]));
        }
    }
}
