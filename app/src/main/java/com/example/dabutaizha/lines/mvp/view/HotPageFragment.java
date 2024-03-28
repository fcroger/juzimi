package com.example.dabutaizha.lines.mvp.view;


import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.example.dabutaizha.lines.Constant;
import com.example.dabutaizha.lines.R;
import com.example.dabutaizha.lines.mvp.adapter.MenuAdapter;
import com.example.dabutaizha.lines.mvp.contract.HotPageFragmentContract;
import com.example.dabutaizha.lines.mvp.presenter.HotpagePresenter;

import java.util.List;

public class HotPageFragment extends BaseFragment implements HotPageFragmentContract.View {

    private MenuAdapter mMenuAdapter;

    private HotPageFragmentContract.Presenter mPresenter;
    public static HotPageFragment newInstance(String category) {
        Bundle args = new Bundle();

        HotPageFragment fragment = new HotPageFragment();
        args.putString(Constant.FRAGMENT_TITLE, category);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setSelectPage(int item) {

    }

    @Override
    public void setTab(List<Fragment> fragmentList, String[] titles) {

    }

    @Override
    public void showMessage(int resid) {

    }

    @Override
    protected int getPageLayoutID() {
        return R.layout.fragment_hotpage;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mPresenter = new HotpagePresenter(this);
        mPresenter.initData();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initTheme(int themeId) {

    }

    @Override
    protected void process(Bundle savedInstanceState) {

    }
}
