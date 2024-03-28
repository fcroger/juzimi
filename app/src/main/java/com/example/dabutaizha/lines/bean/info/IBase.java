package com.example.dabutaizha.lines.bean.info;

import me.ghui.fruit.converter.retrofit.IBaseWrapper;

public interface IBase extends IBaseWrapper {
    /**
     * 某个接口返回业务上的合法性
     */
    boolean isValid();
}
