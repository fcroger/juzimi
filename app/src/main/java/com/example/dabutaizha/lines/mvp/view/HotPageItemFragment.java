package com.example.dabutaizha.lines.mvp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.dabutaizha.lines.Constant;
import com.example.dabutaizha.lines.R;
import com.example.dabutaizha.lines.ResUtil;
import com.example.dabutaizha.lines.bean.info.SearchInfo;
import com.example.dabutaizha.lines.mvp.adapter.HotPageSentencesAdapter;
import com.example.dabutaizha.lines.mvp.contract.HotPageFragmentContract;
import com.example.dabutaizha.lines.mvp.contract.HotPageItemFragmentContract;
import com.example.dabutaizha.lines.mvp.presenter.HotpageItemPresenter;

import java.util.List;

public class HotPageItemFragment extends BaseFragment implements HotPageItemFragmentContract.View {
    private HotPageSentencesAdapter mHotPageSentencesAdapter;

    private HotPageItemFragmentContract.Presenter mPresenter;

    private TextView mHeaderTag;
    private ImageView mHeaderImg;
    public static HotPageItemFragment newInstance(String category) {
        Bundle args = new Bundle();

        HotPageItemFragment fragment = new HotPageItemFragment();
        args.putString(Constant.FRAGMENT_TITLE, category);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void updateHeaderView(String url) {
        ImageLoader.loadGradientByUrl(getActivity(), mHeaderImg, url);
    }

    @Override
    public void refreshHeaderTag(String tag) {
        mHeaderTag.setText(tag);
    }

    @Override
    public void updateData(List<SearchInfo.SentencesItem> sentences) {
        if (!mRefreshLayout.isRefreshing()) {
            mHotPageSentencesAdapter.addData(sentences);
        }
        if (mRefreshLayout.isRefreshing()) {
            mHotPageSentencesAdapter.setNewData(sentences);

            // 不显示动画需要设置在setNewData之后，否则无效
            mHotPageSentencesAdapter.setNotDoAnimationCount(5);
            mRefreshLayout.setRefreshing(false);
        }

        // 由于添加了headerview,所以从下标1开始刷新
        mHotPageSentencesAdapter.notifyItemChanged(1, sentences.size());
        mHotPageSentencesAdapter.loadMoreComplete();
    }

    @Override
    public void showRequestError() {
        mRefreshLayout.setRefreshing(false);
        mErrorLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoadMoreRequestError() {
        mHotPageSentencesAdapter.loadMoreFail();
    }

    @Override
    public void showMessage(CharSequence msg) {
        if (!isAdded()) {
            return;
        }

        ResUtil.showToast(getActivity(), msg);
        if (msg.equals(getString(R.string.load_end))) {
            mHotPageSentencesAdapter.loadMoreEnd();
        }
    }

    @Override
    protected int getPageLayoutID() {
        return R.layout.fragment_hotpage_item;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mPresenter = new HotpageItemPresenter(this);
        mPresenter.initData(getArguments(), savedInstanceState);
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mRefreshLayout.setColorSchemeColors(
                BaseApplication.getInstance().getResources().getColor(R.color.red_bg)
        );

        mHotPageSentencesAdapter = new HotPageSentencesAdapter(new ArrayList<>());
        mHotPageSentencesAdapter.setHeaderAndEmpty(true);
        mHotPageSentencesAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        mHotPageSentencesAdapter.setEnableLoadMore(false);

        mRecyclerView.setAdapter(mHotPageSentencesAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mHotPageSentencesAdapter.removeAllHeaderView();
        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout. hotpage_header, null);
        mHotPageSentencesAdapter.addHeaderView(headerView);

        mHeaderTag = headerView.findViewById(R.id.header_tag);
        mHeaderImg = headerView.findViewById(R.id.header_img);

        mRefreshLayout.setRefreshing(true);
    }

    @Override
    protected void initTheme(int themeId) {
        mPresenter.notifyDataThemeChanged(mHotPageSentencesAdapter.getData(), themeId);
        mHotPageSentencesAdapter.notifyDataSetChanged();

        switch (themeId) {
            case Constant.DAY_TIME:
                mBackgroundLayout.setBackgroundColor(ResUtil.getColor(R.color.colorPrimary));
                break;
            case Constant.NIGHT:
                mBackgroundLayout.setBackgroundColor(ResUtil.getColor(R.color.hotpage_content_bg));
                break;
            default:
                break;
        }
    }

    @Override
    protected void process(Bundle savedInstanceState) {
        mPresenter.process(savedInstanceState);
    }
}
