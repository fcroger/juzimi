package com.example.dabutaizha.lines.bean.info;

public abstract class BaseInfo implements IBase{
    public String rawResponse;
    @Override
    public String getResponse() {
        return rawResponse;
    }

    @Override
    public void setResponse(String response) {
        rawResponse = response;
    }
}
