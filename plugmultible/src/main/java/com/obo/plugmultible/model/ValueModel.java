package com.obo.plugmultible.model;

import java.io.Serializable;

/**
 * 数值类型
 * Created by obo on 16/1/10.
 */
public class ValueModel implements Serializable {
    // 是否是百分比
    boolean isPercent = false;
    // 百分比的值
    double percent;
    // 实际的值
    double value;
}
