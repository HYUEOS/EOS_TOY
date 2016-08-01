package com.eos.eostoy.data;

/**
 * Created by jyoung on 16. 7. 31..
 */
public class IntentData {
    private int imageId, code;
    private String title;

    public IntentData(int imageId, int code, String title) {
        this.imageId = imageId;
        this.code = code;
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
