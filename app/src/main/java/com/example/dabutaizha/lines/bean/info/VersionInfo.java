package com.example.dabutaizha.lines.bean.info;

import java.util.List;

import me.ghui.fruit.annotations.Pick;
import me.ghui.retrofit.converter.annotations.Html;

public class VersionInfo extends BaseInfo{
    @Pick("div.apk_topbar_mss") @Html
    private List<VersionMessage> versionMessage;

    public VersionMessage getVersionMessage() {
        return versionMessage.get(0);
    }

    public void setVersionMessage(List<VersionMessage> versionMessage) {
        this.versionMessage = versionMessage;
    }

    @Override
    public String toString() {
        return "VersionInfo{" +
                "versionMessage=" + versionMessage +
                '}';
    }

    public static class VersionMessage {

        @Pick(value = "span.list_app_info")
        private String versionCode;

        @Pick(value = "p.apk_topba_message")
        private String apkMessage;

        public String getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(String versionCode) {
            this.versionCode = versionCode;
        }

        public String getApkMessage() {
            return apkMessage;
        }

        public void setApkMessage(String apkMessage) {
            this.apkMessage = apkMessage;
        }

        @Override
        public String toString() {
            return "VersionMessage{" +
                    "versionCode='" + versionCode + '\'' +
                    ", apkMessage='" + apkMessage + '\'' +
                    '}';
        }
    }
    @Override
    public boolean isValid() {
        return false;
    }
}
