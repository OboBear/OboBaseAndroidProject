package com.obo.reverseview.GLSurfaceView;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by obo on 16/3/10.
 */
public class MyGLRender implements GLSurfaceView.Renderer {
    Context context;
    private GLBitmap glBitmap;

    int width;
    int height;

    private float[] mTriangleArray = {
            0f, 1f, 0f,
            -1f, -1f, 0f,
            1f, -1f, 0f
    };
    private FloatBuffer mTriangleBuffer;


    private float[] mColorArray = {
            1f, 0f, 0f, 1f,     //红
            0f, 1f, 0f, 1f,     //绿
            0f, 0f, 1f, 1f      //蓝
    };
    private FloatBuffer mColorBuffer;

    //正方形的四个顶点
    private FloatBuffer quateBuffer;
    private float[] mQuateArray = {
            -1f, -1f, 0f,
            1f, -1f, 0f,
            -1f, 1f, 0f,
            1f, 1f, 0f,
    };

    public MyGLRender(Context context) {
        this.context = context;
        glBitmap = new GLBitmap();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        // TODO Auto-generated method stub


        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

//        gl.glRotatef(30, 1, 0, 0);

        //使用数组作为颜色
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, mColorBuffer);

        //绘制小三角形
        gl.glLoadIdentity();
        gl.glTranslatef(-1.5f, 0.0f, -6.0f);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mTriangleBuffer);//数组指向三角形顶点buffer
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);
        gl.glFinish();

        //绘制正方形
        gl.glLoadIdentity();
        gl.glTranslatef(1.5f, 0.0f, -6.0f);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, quateBuffer);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
        gl.glFinish();




//        int screenshotSize = width * height;
//        ByteBuffer bb = ByteBuffer.allocateDirect(screenshotSize * 4);
//        bb.order(ByteOrder.nativeOrder());
//        gl.glReadPixels(0, 0, width, height, GL10.GL_RGBA,
//                GL10.GL_UNSIGNED_BYTE, bb);
//        int pixelsBuffer[] = new int[screenshotSize];
//        bb.asIntBuffer().get(pixelsBuffer);
//        bb = null;
//        Bitmap bitmap = Bitmap.createBitmap(width, height,
//                Bitmap.Config.RGB_565);
//        bitmap.setPixels(pixelsBuffer, screenshotSize - width, -width, 0,
//                0, width, height);
//        pixelsBuffer = null;
//        short sBuffer[] = new short[screenshotSize];
//        ShortBuffer sb = ShortBuffer.wrap(sBuffer);
//        bitmap.copyPixelsToBuffer(sb);


        gl.glEnable(GL10.GL_TEXTURE_2D);
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);
        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, 0.0f, -5.0f); // move 5 units INTO the screen is
        glBitmap.draw(gl);
        gl.glFinish();
    }



    @Override
    public void onSurfaceChanged(GL10 gl, int w, int h) {
        this.width = w;
        this.height = h;
        // TODO Auto-generated method stub
        gl.glViewport(0, 0, w, h);

//        float ratio = (float) w / h;
//        gl.glMatrixMode(GL10.GL_PROJECTION);
//        gl.glLoadIdentity();
//        gl.glFrustumf(-ratio, ratio, -1, 1, 1, 10);
//        gl.glMatrixMode(GL10.GL_MODELVIEW);
//        gl.glLoadIdentity();


        gl.glMatrixMode(GL10.GL_PROJECTION); // Select The Projection Matrix
        gl.glLoadIdentity(); // Reset The Projection Matrix

        // Calculate The Aspect Ratio Of The Window
        GLU.gluPerspective(gl, 45.0f, (float) width / (float) height, 0.1f,
                100.0f);

        gl.glMatrixMode(GL10.GL_MODELVIEW); // Select The Modelview Matrix
        gl.glLoadIdentity();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        // TODO Auto-generated method stub

        glBitmap.loadGLTexture(gl, this.context);

        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glClearColor(1.0f, 1.0f, 1.0f, 0f);
        gl.glClearDepthf(1.0f);
        gl.glEnable(GL10.GL_DEPTH_TEST);

        gl.glDepthFunc(GL10.GL_LEQUAL);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

        mTriangleBuffer = BufferUtil.floatToBuffer(mTriangleArray);
        mColorBuffer = BufferUtil.floatToBuffer(mColorArray);
        quateBuffer = BufferUtil.floatToBuffer(mQuateArray);
    }
}
