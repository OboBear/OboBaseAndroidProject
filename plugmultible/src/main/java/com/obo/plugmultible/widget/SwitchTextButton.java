package com.obo.plugmultible.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.obo.plugmultible.R;
import com.obo.plugmultible.model.ValueModel;
import com.obo.plugmultible.utils.Utils;

/**
 * 按钮切换编辑
 * Created by obo on 16/1/10.
 */
public class SwitchTextButton extends RelativeLayout implements View.OnClickListener {

    public static final String TAG = SwitchTextButton.class.getCanonicalName();
    public Button btnSwitch;
    private ValueModel valueModel = null;

    private int intMaxValue = 0;
    private EditText edit_absolute_value;
    private EditText edit_percent_value;

    //第一次加载
    boolean isFirst = true;

    EditTextListener absoluteEditTextListener = null;
    EditTextListener percentEditTextListener = null;

    public SwitchTextButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.widget_switch_text_button, null);
        //绑定到widget_switch_text_button
        this.addView(view);

        btnSwitch = (Button) findViewById(R.id.button_switch);
        btnSwitch.setOnClickListener(this);
        //绑定字
        edit_absolute_value = (EditText) findViewById(R.id.edit_absolute_value);

        edit_percent_value = (EditText) findViewById(R.id.edit_percent_value);

    }

    /**
     * 点击切换按钮
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_switch: {
                valueModel.setIsPercent(!valueModel.isPercent());
                resetCurrentButtonStatus();
            }
            break;
        }
    }

    /**
     * 重置按钮状态
     */
    private void resetCurrentButtonStatus() {

        RelativeLayout.LayoutParams layoutParams = (LayoutParams) btnSwitch.getLayoutParams();
        if (!valueModel.isPercent() && layoutParams.leftMargin == 0) {
            layoutParams.leftMargin = btnSwitch.getWidth() - 1;
            btnSwitch.setText("数值");
            double absoluteValue = this.valueModel.getAbsoluteValue();
            edit_absolute_value.setText("" + (int) Utils.getApproximateValue(absoluteValue, 0));
        } else if (valueModel.isPercent()) {
            layoutParams.leftMargin = 0;
            btnSwitch.setText("百分比");
            edit_percent_value.setText("" + Utils.getApproximateValue(valueModel.getPercentValue() * 100, -3));
        }

        btnSwitch.setLayoutParams(layoutParams);
    }

    public ValueModel getValueModel() {
        return valueModel;
    }

    public void setValueModel(ValueModel valueModel) {

        Log.i(TAG, "width:" + valueModel.getAbsoluteValue() + "   :" + valueModel.getPercentValue());

        this.valueModel = valueModel;
        edit_percent_value.setText("" + ((int) (valueModel.getPercentValue() * 100)) / 100.0);
        edit_absolute_value.setText("" + (int) valueModel.getAbsoluteValue());
        resetCurrentButtonStatus();

        absoluteEditTextListener = new EditTextListener(edit_absolute_value);
        percentEditTextListener = new EditTextListener(edit_percent_value);
    }

    public int getIntMaxValue() {
        return intMaxValue;
    }

    public void setIntMaxValue(int intMaxValue) {
        this.intMaxValue = intMaxValue;



    }

    //编辑事件
    class EditTextListener implements TextWatcher {

        private EditText editText;

        public EditTextListener(EditText editText) {
            this.editText = editText;
            this.editText.addTextChangedListener(this);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String valueString = s.toString();
            boolean isModify = true;
            switch (editText.getId()) {

                case R.id.edit_absolute_value: {
                    if (valueString.length() == 0) {
                        valueString = "0";
                    } else if (valueString.length() >= 2 && valueString.charAt(0) == '0') {
                        valueString = valueString.substring(1, valueString.length());
                    } else if (Double.parseDouble(valueString) > intMaxValue) {
                        valueString = "" + intMaxValue;
                    } else {
                        isModify = false;
                    }

                    valueModel.setAbsoluteValue(Double.parseDouble(valueString));
                }
                break;

                case R.id.edit_percent_value: {
                    if (valueString.length() == 0) {
                        valueString = "0";
                    } else if (valueString.length() >= 2 && valueString.charAt(0) == '0' && valueString.charAt(1) != '.') {
                        valueString = valueString.substring(1, valueString.length());
                    } else if (Double.parseDouble(valueString) > 100) {
                        valueString = ""+100;
                    } else {
                        isModify = false;
                    }
//                    if (!isFirst) {
                        valueModel.setPercentValue(Double.parseDouble(valueString)/100);
//                    }
                    isFirst = false;
                }
                break;
            }
            if (isModify) {
                editText.setText(valueString);
                editText.setSelection(editText.getText().toString().length());
            }
        }

        public void setEditText(EditText editText) {
            this.editText = editText;
            if (editText != null)
                editText.addTextChangedListener(this);
        }
    }
}
