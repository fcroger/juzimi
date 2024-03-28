package com.example.dabutaizha.lines.mvp.model;

import android.content.Context;
import android.content.Intent;

import com.example.dabutaizha.lines.mvp.contract.MainActivityContract;

public class MainModel implements MainActivityContract.Model {
    @Override
    public void clearCache() {

    }

    @Override
    public void requestRecentVersionInfo() {

    }

    @Override
    public Intent buildFeedBackData(Context context) {
        return null;
    }

    @Override
    public void querySentencesSize() {

    }
}
