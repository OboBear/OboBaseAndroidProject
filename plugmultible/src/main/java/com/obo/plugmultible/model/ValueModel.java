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

    // 最大的取值，用于计算百分比
    private double maxAbsoluteValue = 1;



    public ValueModel(double value,boolean isPercent) {
        this.isPercent = isPercent;

        if (isPercent) {
            this.percentValue = value;
        }
        else  {
            this.absoluteValue = value;
        }
    }

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
        this.absoluteValue = percentValue * this.maxAbsoluteValue / 100;
    }

    public double getAbsoluteValue() {
        return absoluteValue;
    }

    public void setAbsoluteValue(double absoluteValue) {
        this.absoluteValue = absoluteValue;
        this.percentValue = absoluteValue * 100/ this.maxAbsoluteValue;
    }

    //获取最大的值
    public double getMaxAbsoluteValue() {
        return maxAbsoluteValue;
    }
    //设置最大的值
    public void setMaxAbsoluteValue(double maxAbsoluteValue) {
        this.maxAbsoluteValue = maxAbsoluteValue;
    }
}
