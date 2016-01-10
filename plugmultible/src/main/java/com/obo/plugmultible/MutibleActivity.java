package com.obo.plugmultible;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

public class MutibleActivity extends AppCompatActivity implements View.OnClickListener{
    public final String TAG = MutibleActivity.class.getSimpleName();
    RelativeLayout layout;
    RelativeLayout root_layout;
    View coverView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_mutible);
        layout = (RelativeLayout) findViewById(R.id.layout);
        root_layout = (RelativeLayout) findViewById(R.id.root_layout);
        coverView = findViewById(R.id.coverView);
        coverView.setVisibility(View.INVISIBLE);
    }

    int buttonId = 1;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_button:

                DragScaleRelativeLayout button = new DragScaleRelativeLayout(this);
                button.setId(buttonId++);
                button.setDragScale(new DragScaleImpl(DragScaleRelativeLayout.viewType));
                layout.addView(button);
                button.setBackgroundColor(UtilColor.COLOR_VIEW_TOUCH_DOWN);
                button.setLayoutParams(new RelativeLayout.LayoutParams(100, 100));
                button.setX(50);
                button.setY(50);
                button.setClickable(true);

                break;
        }
    }

}
