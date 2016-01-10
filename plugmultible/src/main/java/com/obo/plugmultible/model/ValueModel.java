package com.obo.plugmultible.model;

import java.io.Serializable;

/**
 * 数值类型
 * Created by obo on 16/1/10.
 */
public class ValueModel implements Serializable {
    // 是否是百分比
    private boolean isPercent = false;
    // 百分比的值
    private double percentValue;
    // 实际的值
    private double absoluteValue;

    public boolean isPercent() {
        return isPercent;
    }

    public void setIsPercent(boolean isPercent) {
        this.isPercent = isPercent;
    }

    public double getPercentValue() {
        return percentValue;
    }

    public void setPercentValue(double percentValue) {
        this.percentValue = percentValue;
    }

    public double getAbsoluteValue() {
        return absoluteValue;
    }

    public void setAbsoluteValue(double absoluteValue) {
        this.absoluteValue = absoluteValue;
    }
}
