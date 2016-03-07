package com.obo.plugmultible.model;

import android.support.v4.graphics.ColorUtils;

import com.obo.plugmultible.utils.UtilColor;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 界面属性数据model
 * Created by obo on 16/1/10.
 */
public class ViewModel implements Serializable{

    /**
     * view标示属性
     */
    //view的类型
    private int viewType;
    //view的id
    private int viewId;
    //父view的id
    private int parentId;
    //view名称
    private String name;
    /**
     * view布局属性
     */
    //左边距
    private ValueModel left = new ValueModel(0,false);
    //上边距
    private ValueModel top = new ValueModel(0,false) ;
    //宽
    private ValueModel width = new ValueModel(0,false);
    //高
    private ValueModel height = new ValueModel(0,false);

    /**
     * view内容属性
     */
    //view背景色
    private int backGroundColor = UtilColor.COLOR_VIEW_TOUCH_UP;
    //透明度
    private ValueModel alpha = new ValueModel(1,true);
    //view包含文字内容
    private String contentString;
    //view背景图片链接
    private String backImageUrl;



    //子view
    private ArrayList<ViewModel>subViewModels;

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

    public ArrayList<ViewModel> getSubViewModels() {
        return subViewModels;
    }

    public void setSubViewModels(ArrayList<ViewModel> subViewModels) {
        this.subViewModels = subViewModels;
    }

    public ValueModel getAlpha() {
        return alpha;
    }

    public void setAlpha(ValueModel alpha) {
        this.alpha = alpha;
    }
}
