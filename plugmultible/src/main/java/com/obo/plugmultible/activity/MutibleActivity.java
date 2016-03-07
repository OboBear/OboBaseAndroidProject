package com.obo.plugmultible.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.obo.plugmultible.model.ViewModel;
import com.obo.plugmultible.view.controller.MutibleViewController;
import com.obo.plugmultible.view.DragScaleRelativeLayout;
import com.obo.plugmultible.R;
import com.obo.plugmultible.utils.UtilScreen;
import com.obo.plugmultible.utils.UtilColor;

import java.util.ArrayList;

public class MutibleActivity extends BaseActivity implements View.OnClickListener , MutibleViewController.MutibleViewDelegate {
    public final String TAG = MutibleActivity.class.getSimpleName();
    RelativeLayout root_layout;
    View coverView;

    ArrayList<MutibleViewController.DragScaleViewDelegate>viewArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_mutible);
        root_layout = (RelativeLayout) findViewById(R.id.root_layout);
        coverView = findViewById(R.id.coverView);
        coverView.setBackgroundColor(UtilColor.COLOR_VIEW_COVER);
        coverView.setVisibility(View.INVISIBLE);

        UtilScreen.initScreenSize(this);
    }

    int mutibleViewId = 1;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_button:

                // 创建view
                DragScaleRelativeLayout mutibleView = new DragScaleRelativeLayout(this);
                mutibleView.setId(mutibleViewId++);
                mutibleView.setBackgroundColor(UtilColor.COLOR_VIEW_TOUCH_UP);

                // 创建布局
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(200, 200);
                layoutParams.setMargins(UtilScreen.ScreenWith / 2 - 100, UtilScreen.ScreenHeight / 2 - 100, 10000, 10000);
                mutibleView.setLayoutParams(layoutParams);
                mutibleView.setClickable(true);

                viewArray.add(mutibleView);
                root_layout.addView(mutibleView);

                // 创建布局改变控制器
                MutibleViewController dragScale = new MutibleViewController();
                dragScale.setDragScaleViewDelegate(mutibleView);

                ViewModel viewModel = new ViewModel();
                viewModel.getLeft().setMaxAbsoluteValue(UtilScreen.ScreenWith);
                viewModel.getLeft().setAbsoluteValue(UtilScreen.ScreenWith / 2 - 100);
                viewModel.getWidth().setMaxAbsoluteValue(UtilScreen.ScreenWith);
                viewModel.getWidth().setAbsoluteValue(200);
                viewModel.getTop().setMaxAbsoluteValue(UtilScreen.ScreenHeight);
                viewModel.getTop().setAbsoluteValue(UtilScreen.ScreenHeight / 2 - 100);
                viewModel.getHeight().setMaxAbsoluteValue(UtilScreen.ScreenHeight);
                viewModel.getHeight().setAbsoluteValue(200);
                viewModel.getAlpha().setPercentValue(1);
                dragScale.setViewModel(viewModel);
                dragScale.updateViewModel();
                dragScale.dragScaleDelegate = this;

                break;
        }
    }
    /////////////////
    //MutibleViewController
    @Override
    public void longPress(View v) {
        Log.i(TAG, "longPress");
        coverView.setVisibility(View.VISIBLE);
        root_layout.bringChildToFront(coverView);
        root_layout.bringChildToFront(v);
    }

    @Override
    public void upPress(View v) {
        Log.i(TAG,"upPress");
        coverView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void doubleClick(View v,MutibleViewController mutibleViewController) {

        ViewModel viewModel = mutibleViewController.getViewModel();

        Intent intent = new Intent(this,SetViewParamsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("viewModel", viewModel);
        intent.putExtra("data", bundle);


        startActivityForResult(intent,0);
    }

    @Override
    public void flushViewWithId(int id) {
        for(MutibleViewController.DragScaleViewDelegate view :viewArray) {
            if (view.getId() == id) {
                view.invalidate();
                break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bundle bundle = data.getBundleExtra("data");
        ViewModel viewModel = (ViewModel) bundle.get("viewModel");

        for (int i=0;i<viewArray.size();i++) {
            if (viewArray.get(i).getId() == viewModel.getViewId()) {

                viewArray.get(i).getDragScaleImpl().setViewModel(viewModel);
                viewArray.get(i).setBackgroundColor(viewModel.getBackGroundColor());
                break;
            }
        }
    }
}
