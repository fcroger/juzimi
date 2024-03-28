package com.example.dabutaizha.lines.net;

import com.example.dabutaizha.lines.bean.info.VersionInfo;

import io.reactivex.rxjava3.core.Observable;
import me.ghui.retrofit.converter.annotations.Html;
import retrofit2.http.GET;

public interface APIUpdate {
    /**
     *Description: 用于获取最新的正式版本号
     */
    @GET("/apk/com.example.dabutaizha.lines") @Html
    Observable<VersionInfo> getRecentVersion();
}
