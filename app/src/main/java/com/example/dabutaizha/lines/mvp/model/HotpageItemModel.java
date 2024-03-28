package com.example.dabutaizha.lines.mvp.model;

import com.example.dabutaizha.lines.R;
import com.example.dabutaizha.lines.ResUtil;
import com.example.dabutaizha.lines.bean.info.SearchInfo;
import com.example.dabutaizha.lines.mvp.contract.HotPageItemFragmentContract;
import com.example.dabutaizha.lines.net.ApiServices;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HotpageItemModel implements HotPageItemFragmentContract.Model {
    private int mHotpageTag = 0;
    private String mHotpageTagName[] = ResUtil.getStringArray(R.array.hotpage_tag);

    private HotPageItemFragmentContract.Presenter mPresenter;
    private String mCategory;

    public HotpageItemModel(HotPageItemFragmentContract.Presenter mPresenter, String category) {
        this.mPresenter = mPresenter;
        mCategory = category;
    }

    @Override
    public void loadData(int page) {
        Observable<SearchInfo> observable = null;

        observable = getObservableByCategory(page);

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SearchInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SearchInfo searchInfo) {
                        if (searchInfo == null) {
                            mPresenter.fail(ResUtil.getString(R.string.load_fail));
                        }
                        if (searchInfo != null) {
                            mPresenter.loadData(searchInfo);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        String message = e.getMessage();

                        if (message.contains("404")) {
                            mPresenter.fail(ResUtil.getString(R.string.load_end));
                        } else {
                            mPresenter.fail(e.getMessage());
                            mPresenter.requestError();
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    private Observable<SearchInfo> getObservableByCategory(int page) {
        switch (mCategory) {
            case "最新上传":
                mHotpageTag = 0;
                return ApiServices.getAPIs().getHotPageNew(page);
            case "今日热门":
                mHotpageTag = 1;
                return ApiServices.getAPIs().getHotPageTodayHot(page);
            case "今日推荐":
                mHotpageTag = 2;
                return ApiServices.getAPIs().getHotPageRecommend(page);
            case "最受欢迎":
                mHotpageTag = 3;
                return ApiServices.getAPIs().getHotPageLike(page);
            default:
                return null;
        }
    }

    @Override
    public void loadPictureData() {

    }

    @Override
    public void savePicData(String url) {

    }

    @Override
    public String getLastPicData() {
        return null;
    }
}
