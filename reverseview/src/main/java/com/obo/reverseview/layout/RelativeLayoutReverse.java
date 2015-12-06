package com.obo.reverseview.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by obo on 15/12/4.
 */
public class RelativeLayoutReverse extends TextView {

    Matrix matrix;

    public RelativeLayoutReverse(Context context, AttributeSet attrs) {
        super(context, attrs);

        matrix = new Matrix();
//        matrix.postScale(-1, 1);   //镜像水平翻转
//        matrix.postSc
    }

    @Override
    public void onDraw(Canvas canvas) {
//        canvas.setMatrix(matrix);
//        matrix.setTranslate(-this.getWidth()/2,-this.getHeight()/2);
//        matrix.setScale(-1,1);
//        matrix.postTranslate(this.getWidth()/2,this.getHeight()/2);
        canvas.setMatrix(matrix);
        super.onDraw(canvas);
    }


}
