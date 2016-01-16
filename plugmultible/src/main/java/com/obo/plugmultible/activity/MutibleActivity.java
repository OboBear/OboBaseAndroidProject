package com.obo.plugmultible.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.obo.plugmultible.model.ViewModel;
import com.obo.plugmultible.view.DragScaleController;
import com.obo.plugmultible.view.DragScaleRelativeLayout;
import com.obo.plugmultible.R;
import com.obo.plugmultible.utils.ScreenUtil;
import com.obo.plugmultible.utils.UtilColor;

import java.util.ArrayList;

public class MutibleActivity extends BaseActivity implements View.OnClickListener , DragScaleController.DragScaleDelegate {
    public final String TAG = MutibleActivity.class.getSimpleName();
    RelativeLayout root_layout;
    View coverView;

    ArrayList<DragScaleController.DragScaleViewDelegate>viewArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_mutible);
        root_layout = (RelativeLayout) findViewById(R.id.root_layout);
        coverView = findViewById(R.id.coverView);
        coverView.setBackgroundColor(UtilColor.COLOR_VIEW_COVER);
        coverView.setVisibility(View.INVISIBLE);

        ScreenUtil.initScreenSize(this);
    }

    int buttonId = 1;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_button:

                // 创建view
                DragScaleRelativeLayout button = new DragScaleRelativeLayout(this);
                button.setId(buttonId++);
                button.setBackgroundColor(UtilColor.COLOR_VIEW_TOUCH_UP);

                // 创建布局
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(200, 200);
                layoutParams.setMargins(ScreenUtil.ScreenWith / 2 - 100, ScreenUtil.ScreenHeight / 2 - 100, 10000, 10000);
                button.setLayoutParams(layoutParams);
                button.setClickable(true);

                viewArray.add(button);
                root_layout.addView(button);

                // 创建布局改变控制器
                DragScaleController dragScale = new DragScaleController(button);
                dragScale.dragScaleDelegate = this;

                break;
        }
    }
    ////////////
    //DragScaleController
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
    public void doubleClick(View v,DragScaleController dragScaleController) {

        ViewModel viewModel = dragScaleController.viewModel;

        Log.i(TAG,"doubleClick:"+viewModel.getLeft().getAbsoluteValue());

        Intent intent = new Intent(this,SetViewParamsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("viewModel", viewModel);
        intent.putExtra("data", bundle);

        startActivityForResult(intent,0);
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

        Log.i(TAG,"onActivityResult"+viewModel.getLeft().getAbsoluteValue());
    }
}
