package com.example.dabutaizha.lines.bean.info;

import java.util.List;

import me.ghui.fruit.annotations.Pick;
import me.ghui.retrofit.converter.annotations.Html;

public class PictureInfo extends BaseInfo{
    @Override
    public boolean isValid() {
        return false;
    }
    @Pick("div.item") @Html
    private List<PictureItem> pictureItems;

    public List<PictureItem> getPictureItems() {
        return pictureItems;
    }

    public void setPictureItems(List<PictureItem> pictureItems) {
        this.pictureItems = pictureItems;
    }

    @Override
    public String toString() {
        return "PictureInfo{" +
                "pictureItems=" + pictureItems +
                '}';
    }

    public static class PictureItem {

        @Pick(value = "img.fp-one-imagen", attr = "src")
        private String pictureUrl;

        @Pick(value = "div.fp-one-cita", attr = "text")
        private String pictureMessage;

        public String getPictureUrl() {
            return pictureUrl;
        }

        public void setPictureUrl(String pictureUrl) {
            this.pictureUrl = pictureUrl;
        }

        public String getPictureMessage() {
            return pictureMessage;
        }

        public void setPictureMessage(String pictureMessage) {
            this.pictureMessage = pictureMessage;
        }

        @Override
        public String toString() {
            return "PictureItem{" +
                    "pictureUrl='" + pictureUrl + '\'' +
                    ", pictureMessage='" + pictureMessage + '\'' +
                    '}';
        }
    }
}
