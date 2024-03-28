package com.example.dabutaizha.lines.mvp.adapter;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class TabAdapter extends FragmentStateAdapter {

    private List<Fragment> mFragmentList;
    private String[] mTitles;


    public TabAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    public void setData(List<Fragment> fragmentList, String[] titles) {
        mFragmentList = fragmentList;
        mTitles = titles;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mFragmentList == null ? null : mFragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mFragmentList.size();
    }

}
