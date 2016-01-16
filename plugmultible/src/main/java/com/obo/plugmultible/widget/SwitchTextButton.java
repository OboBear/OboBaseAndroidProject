package com.obo.plugmultible.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.obo.plugmultible.R;
import com.obo.plugmultible.model.ValueModel;
import com.obo.plugmultible.utils.Utils;

import org.w3c.dom.Text;

/**
 * Created by obo on 16/1/10.
 */
public class SwitchTextButton extends RelativeLayout implements View.OnClickListener {

    public static final String TAG = SwitchTextButton.class.getCanonicalName();
    public Button button;
    public TextView textView;
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
        this.addView(view);

        findViewById(R.id.button_switch).setOnClickListener(this);
        edit_absolute_value = (EditText) findViewById(R.id.edit_absolute_value);
        absoluteEditTextListener = new EditTextListener();
        absoluteEditTextListener.setEditText(edit_absolute_value);
        edit_percent_value = (EditText) findViewById(R.id.edit_percent_value);
        percentEditTextListener = new EditTextListener();
        percentEditTextListener.setEditText(edit_percent_value);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_switch: {
                RelativeLayout.LayoutParams layoutParams = (LayoutParams) v.getLayoutParams();

                if (layoutParams.leftMargin == 0) {
                    layoutParams.leftMargin = v.getWidth() - 1;
                    ((Button) v).setText("数值");
                    valueModel.setIsPercent(false);

                    double percentValue = this.valueModel.getPercentValue();
                    edit_absolute_value.setText("" + (int)(percentValue*intMaxValue/100));
                } else {
                    layoutParams.leftMargin = 0;
                    ((Button) v).setText("百分比");
                    valueModel.setIsPercent(true);
//                    Log.i(TAG, "setPercentValue:" + valueModel.getPercentValue());
                    edit_percent_value.setText("" +  valueModel.getPercentValue());
                }
                v.setLayoutParams(layoutParams);
            }
            break;
        }
    }

    public ValueModel getValueModel() {
        return valueModel;
    }

    public void setValueModel(ValueModel valueModel) {
        this.valueModel = valueModel;
        valueModel.setPercentValue(valueModel.getAbsoluteValue() * 100.0 / intMaxValue);

//        Log.i(TAG, "setPercentValue:" + valueModel.getPercentValue());
        edit_percent_value.setText("" + ((int) (valueModel.getPercentValue() * 100 ))/100.0);
        edit_absolute_value.setText("" + (int)valueModel.getAbsoluteValue());

    }

    public int getIntMaxValue() {
        return intMaxValue;
    }

    public void setIntMaxValue(int intMaxValue) {
        this.intMaxValue = intMaxValue;
    }

    class EditTextListener implements TextWatcher {

        private EditText editText;

        /////////////
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String valueString = s.toString();
            switch (editText.getId()) {

                case R.id.edit_absolute_value:
                {
                    if (valueString.length() == 0) {
                        editText.setText("0");
                        editText.setSelection(editText.getText().toString().length());
                        return;
                    }
                    else if (valueString.length() >= 2 && valueString.charAt(0) == '0') {
                        editText.setText(valueString.substring(1, valueString.length()));
                        editText.setSelection(editText.getText().toString().length());
                        return;
                    } else if (Double.parseDouble(valueString) > intMaxValue) {
                        editText.setText("" + intMaxValue);
                        editText.setSelection(editText.getText().toString().length());
                        return;
                    }
                    valueModel.setAbsoluteValue(Double.parseDouble(valueString));
                }
                    break;

                case R.id.edit_percent_value:
                {
                    if (valueString.length() == 0) {
                        editText.setText("0");
                        editText.setSelection(editText.getText().toString().length());
                        return;
                    }
                    else if (valueString.length() >= 2 && valueString.charAt(0) == '0' && valueString.charAt(1) != '.') {
                        editText.setText(valueString.substring(1, valueString.length()));
                        editText.setSelection(editText.getText().toString().length());
                        return;
                    }
                    else if (Double.parseDouble(valueString) > 100) {
                        editText.setText("" + 100);
                        editText.setSelection(editText.getText().toString().length());
                        return;
                    }
                    if (!isFirst) {
                        valueModel.setPercentValue(Double.parseDouble(valueString));
                    }
                    isFirst = false;
                }
                    break;
            }
        }

        public EditText getEditText() {
            return editText;
        }

        public void setEditText(EditText editText) {
            this.editText = editText;
            if (editText != null)
            editText.addTextChangedListener(this);
        }
    }
}
