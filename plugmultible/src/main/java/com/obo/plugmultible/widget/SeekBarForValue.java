package com.obo.plugmultible.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.obo.plugmultible.R;
import com.obo.plugmultible.model.ValueModel;

/**
 * Created by obo on 16/1/17.
 */
public class SeekBarForValue extends RelativeLayout implements SeekBar.OnSeekBarChangeListener{


    SeekBar seekBar;
    TextView textView;

    private ValueModel valueModel;

    public SeekBarForValue(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public void bindViews() {
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textView = (TextView) findViewById(R.id.text_alpath_value);

        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(this);
    }


    public ValueModel getValueModel() {
        return valueModel;
    }

    public void setValueModel(ValueModel valueModel) {
        this.valueModel = valueModel;
        seekBar.setProgress((int) (valueModel.getPercentValue() * 100));
        textView.setText(""+(int) (valueModel.getPercentValue() * 100));
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (this.valueModel != null) {
            this.valueModel.setPercentValue(progress * 1.0 / 100);
        }
        textView.setText(""+progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
