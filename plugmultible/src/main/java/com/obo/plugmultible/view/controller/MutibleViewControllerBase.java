package com.obo.plugmultible.view.controller;

import android.view.View;
import android.view.ViewGroup;

import com.obo.plugmultible.model.ViewModel;

/**
 * Created by obo on 16/1/17.
 */
public abstract class MutibleViewControllerBase {

    //数据模型
    protected ViewModel viewModel = new ViewModel();

    protected DragScaleViewDelegate dragScaleViewDelegate;

    //拖动代理
    public MutibleViewDelegate dragScaleDelegate = null;

    //更新
    public abstract void updateViewModel();

    //////////////////
    //interface
    //对外部使用
    public interface MutibleViewDelegate {

        void longPress(View v);
        void upPress(View v);
        void doubleClick(View v, MutibleViewController mutibleViewController);
        /**
         * 更新指定id的view
         * @param id
         */
        void flushViewWithId(int id);
    }

    //对DragScalView使用
    public interface DragScaleViewDelegate {
        int getViewType();
        void setDragScale(MutibleViewController dragScale);
        MutibleViewController getDragScaleImpl();
        ViewGroup.LayoutParams getLayoutParams();
        void setLayoutParams(ViewGroup.LayoutParams layoutParams);
        int getId();
        void invalidate();
        void setBackgroundColor(int color);
    }
}
