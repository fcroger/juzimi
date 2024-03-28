package com.example.dabutaizha.lines.mvp.adapter;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.dabutaizha.lines.Constant;
import com.example.dabutaizha.lines.R;
import com.example.dabutaizha.lines.bean.info.SearchInfo;

import java.util.List;

public class HotPageSentencesAdapter extends BaseMultiItemQuickAdapter<SearchInfo.SentencesItem, BaseViewHolder> {

    public HotPageSentencesAdapter(List<SearchInfo.SentencesItem> data) {
        super(data);
        //addItemType绑定Type和Layout
        addItemType(Constant.DAY_TIME, R.layout.sentence_item);
        addItemType(Constant.NIGHT, R.layout.sentence_item_night);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, SearchInfo.SentencesItem sentencesItem) {

    }
}
