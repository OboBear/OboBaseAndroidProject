package com.obo.plugmultible.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.obo.plugmultible.R;
import com.obo.plugmultible.model.ViewModel;
import com.obo.plugmultible.thirdlib.ColorPicker.ColorPickerDialog;
import com.obo.plugmultible.utils.UtilScreen;
import com.obo.plugmultible.widget.SwitchTextButton;

public class SetViewParamsActivity extends BaseActivity implements View.OnClickListener {
    public static final String TAG = SetViewParamsActivity.class.getCanonicalName();

    ViewModel viewModel;
    TextView textTitle;

    String titleStringArray[] = {"左边距", "上边距", "宽度", "高度"};
    int titleIdArray[] = {R.id.left, R.id.top, R.id.width, R.id.height};
    SwitchTextButton switchTextButton[] = new SwitchTextButton[4];

    Button btnPickColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_set_view_params);
        initDatas();
        initViews();
    }

    private void initDatas() {

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        viewModel = (ViewModel) bundle.get("viewModel");
    }

    private void initViews() {

        textTitle = (TextView) findViewById(R.id.text_title);
        textTitle.setText("修改控件属性");
        initItems();
    }

    private void initItems() {

        //控件样式
        for (int i = 0; i < titleIdArray.length; i++) {
            View view = findViewById(titleIdArray[i]);
            ((TextView) view.findViewById(R.id.switch_text)).setText(titleStringArray[i]);
            switchTextButton[i] = (SwitchTextButton) view.findViewById(R.id.switch_text_button);
        }

        switchTextButton[0].setIntMaxValue(UtilScreen.ScreenWith);
        switchTextButton[0].setValueModel(viewModel.getLeft());
        switchTextButton[1].setIntMaxValue(UtilScreen.ScreenHeight);
        switchTextButton[1].setValueModel(viewModel.getTop());
        switchTextButton[2].setIntMaxValue(UtilScreen.ScreenWith);
        switchTextButton[2].setValueModel(viewModel.getWidth());
        switchTextButton[3].setIntMaxValue(UtilScreen.ScreenHeight);
        switchTextButton[3].setValueModel(viewModel.getHeight());

        //控件内容
        btnPickColor = (Button) findViewById(R.id.button_pick_color);
        btnPickColor.setBackgroundColor(viewModel.getBackGroundColor());
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()) {

            case R.id.button_pick_color:
                ColorPickerDialog dialog = new ColorPickerDialog(this, viewModel.getBackGroundColor(),
                        getResources().getString(R.string.set_params_pick_color),
                        new ColorPickerDialog.OnColorChangedListener() {
                            @Override
                            public void colorChanged(int color) {
                                v.setBackgroundColor(color);
                                Log.i(TAG,"color:"+color);
                                viewModel.setBackGroundColor(color);
                            }
                        });
                dialog.show();
                break;

            case R.id.button_back:
                backAction();
                break;
        }
    }


    private ViewModel getResetModel() {

        return viewModel;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                backAction();
                break;
        }

        return super.onKeyDown(keyCode, event);
    }

    //返回所进行的操作
    private void backAction() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("viewModel", getResetModel());
        intent.putExtra("data", bundle);
        setResult(0, intent);
        finish();
        //调用gc释放资源
        System.gc();
    }
}
