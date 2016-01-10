package com.obo.plugmultible.model;

import java.io.Serializable;

/**
 * Created by obo on 16/1/10.
 */
public class ViewModel implements Serializable{

    private String name;
    private String contentString;
    private String backImageUrl;

    private int backGroundColor;
    private int viewType;
    private int viewId;

    private int parentId;

    private ValueModel left;
    private ValueModel top;
    private ValueModel width;
    private ValueModel height;

    public int getViewId() {
        return viewId;
    }

    public void setViewId(int viewId) {
        this.viewId = viewId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentString() {
        return contentString;
    }

    public void setContentString(String contentString) {
        this.contentString = contentString;
    }

    public String getBackImageUrl() {
        return backImageUrl;
    }

    public void setBackImageUrl(String backImageUrl) {
        this.backImageUrl = backImageUrl;
    }

    public int getBackGroundColor() {
        return backGroundColor;
    }

    public void setBackGroundColor(int backGroundColor) {
        this.backGroundColor = backGroundColor;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public ValueModel getLeft() {
        return left;
    }

    public void setLeft(ValueModel left) {
        this.left = left;
    }

    public ValueModel getTop() {
        return top;
    }

    public void setTop(ValueModel top) {
        this.top = top;
    }

    public ValueModel getWidth() {
        return width;
    }

    public void setWidth(ValueModel width) {
        this.width = width;
    }

    public ValueModel getHeight() {
        return height;
    }

    public void setHeight(ValueModel height) {
        this.height = height;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
