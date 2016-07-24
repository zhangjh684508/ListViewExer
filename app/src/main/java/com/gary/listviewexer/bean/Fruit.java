package com.gary.listviewexer.bean;

/**
 * Created by lsx on 2016/7/24.
 */
public class Fruit {
    private String mName;
    private int mImageId;

    public Fruit(String mName, int mImageId) {
        this.mName = mName;
        this.mImageId = mImageId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int imageId) {
        this.mImageId = imageId;
    }
}
