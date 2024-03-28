package com.example.dabutaizha.lines.net;

import com.example.dabutaizha.lines.bean.info.PictureInfo;

import io.reactivex.rxjava3.core.Observable;
import me.ghui.retrofit.converter.annotations.Html;
import retrofit2.http.GET;

public interface APIAssistant {
    /**
     *Description: 用于获取首页所用的图片
     */
    @GET("/") @Html
    Observable<PictureInfo> getHotPagePictures();
}
