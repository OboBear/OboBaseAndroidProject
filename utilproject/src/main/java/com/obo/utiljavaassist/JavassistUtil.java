package com.obo.utiljavaassist;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Vector;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

/**
 * Created by obo on 15/12/14.
 */
public class JavassistUtil {

    public static void main(String [] args) throws IOException, CannotCompileException, NotFoundException {


//        modifyConstructor();
//
//        modifyMethod();

//        modifyAndroid();

//        try {
//            createNewClass();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }


        try {
            createNewSurface();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    //修改构造方法
    static void modifyConstructor() throws NotFoundException, CannotCompileException, IOException {

        ClassPool pool = ClassPool.getDefault();
        pool.insertClassPath("/Users/apple/Desktop/Workspace/android/demos/ReverseView/reverseview/AMap_Android_3DMapSDK_V3.1.0.jar");
        CtClass cc1 = pool.get("com.amap.api.mapcore.AMapDelegateImp");

        CtConstructor[]constructor = cc1.getConstructors();
        CtConstructor constructor0 = constructor[0];
        System.out.println(constructor0.getName());

        MethodInfo methodInfo = constructor0.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();

        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);

        System.out.println("attr:" + constructor0.getName());

        constructor0.insertBefore("{System.out.println(\"hellow\"+$1);}");

//        constructor0.insertAfter("{this.g.setBackgroundColor(android.graphics.Color.argb(255, 255, 0, 0));" +
//                "this.G.setBackgroundColor(android.graphics.Color.argb(255, 235, 0, 0));\n" +
//                "        this.J.setBackgroundColor(android.graphics.Color.argb(255, 235, 0, 0));\n" +
//                "        this.F.setBackgroundColor(android.graphics.Color.argb(255, 235, 0, 0));\n" +
//                "        this.d.setBackgroundColor(android.graphics.Color.argb(255, 235, 0, 0));\n" +
//                "        this.c.setBackgroundColor(android.graphics.Color.argb(255, 235, 0, 0));\n" +
//                "        this.a.setBackgroundColor(android.graphics.Color.argb(255, 235, 0, 0));\n" +
//                "        this.H.setBackgroundColor(android.graphics.Color.argb(255, 235, 0, 0));}");

        constructor0.insertAfter("{ this.F.removeView((android.view.View)this.g);}");


        cc1.writeFile();

        cc1.defrost();



    }



    //修改一般
    static void modifyMethod() throws NotFoundException, CannotCompileException, IOException {

        ClassPool pool = ClassPool.getDefault();
        pool.insertClassPath("/Users/apple/Desktop/Workspace/android/demos/ReverseView/reverseview/AMap_Android_3DMapSDK_V3.1.0.jar");
        CtClass cc1 = pool.get("com.amap.api.mapcore.AMapDelegateImp");

//        cc1.setSuperclass(pool.get("com.obo.javassisttool.MyClass"));

        System.out.println("super:" + cc1.getSuperclass().getName());

//        LinearLayout ll = new LinearLayout(new Activity());
//        ll.removeAllViews();
//        ll.removeView();


        CtClass[] paramTypes = {pool.get("int"),pool.get("int"),pool.get("int"),pool.get("int"),pool.get("javax.microedition.khronos.opengles.GL10")};
        CtMethod method = cc1.getDeclaredMethod("a", paramTypes);



        System.out.println("a:" + method.getName());

        method.insertBefore("{System.out.println(\"hello\");}");
        method.insertAfter("{android.graphics.Bitmap var6 = android.graphics.Bitmap.createBitmap($3, $4, android.graphics.Bitmap.Config.ARGB_8888);return var6;}");

        cc1.writeFile();
    }




    static void modifyAndroid () throws NotFoundException, CannotCompileException, IOException {

        ClassPool pool = ClassPool.getDefault();
        pool.insertClassPath("/Users/apple/Desktop/Workspace/android/反编译/demos/android/android.jar");
        CtClass cc1 = pool.get("android.view.SurfaceView");

        CtMethod method = cc1.getDeclaredMethod("onWindowVisibilityChanged");

        method.insertBefore("{System.out.println(\"this is my android\");}");


        cc1.writeFile();



//        System.out.println("method:" + method.getName());

    }




    static void  test() throws NotFoundException, CannotCompileException {

        ClassPool pool = ClassPool.getDefault();
        CtClass cc1 = pool.get("java.util.ArrayList");
        CtMethod methodmmmm = cc1.getDeclaredMethod("size");
        methodmmmm.insertAfter("{System.out.println(\"000000\");}");

        ArrayList<Intent> arrayList = new ArrayList<Intent>();

        int a = arrayList.size();

        System.out.print("a:" + a);

    }



    static void  test2() throws NotFoundException, CannotCompileException {

        ClassPool pool = ClassPool.getDefault();
        CtClass cc1 = pool.get("java.util.ArrayList");
        CtMethod methodmmmm = cc1.getDeclaredMethod("size");
        methodmmmm.insertAfter("{System.out.println(\"000000\");}");


        ArrayList<Intent> arrayList = new ArrayList<Intent>();

        int a = arrayList.size();

        System.out.print("a:" + a);

        SurfaceView s = new SurfaceView(new Activity());

    }


    /**
     *  创建新类
     */
    static void createNewClass() throws NotFoundException, CannotCompileException, NoSuchMethodException, IllegalAccessException, InstantiationException, IOException, InvocationTargetException {

        //ClassPool：CtClass对象的容器
        ClassPool pool = ClassPool.getDefault();

        //通过ClassPool生成一个public新类Emp.java
        CtClass ctClass = pool.makeClass("com.study.javassist.Emp");

        //添加字段
        //首先添加字段private String ename
        CtField enameField = new CtField(pool.getCtClass("java.lang.String"),"ename",ctClass);
        enameField.setModifiers(Modifier.PRIVATE);
        ctClass.addField(enameField);

        //其次添加字段privtae int eno
        CtField enoField = new CtField(pool.getCtClass("int"),"eno",ctClass);
        enoField.setModifiers(Modifier.PRIVATE);
        ctClass.addField(enoField);

        //为字段ename和eno添加getXXX和setXXX方法
        ctClass.addMethod(CtNewMethod.getter("getEname", enameField));
        ctClass.addMethod(CtNewMethod.setter("setEname", enameField));
        ctClass.addMethod(CtNewMethod.getter("getEno", enoField));
        ctClass.addMethod(CtNewMethod.setter("setEno", enoField));

        //添加构造函数
        CtConstructor ctConstructor = new CtConstructor(new CtClass[]{}, ctClass);
        //为构造函数设置函数体
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\n")
                .append("ename=\"yy\";\n")
                .append("eno=001;\n}");
        ctConstructor.setBody(buffer.toString());
        //把构造函数添加到新的类中
        ctClass.addConstructor(ctConstructor);

        //添加自定义方法
        CtMethod ctMethod = new CtMethod(CtClass.voidType,"printInfo",new CtClass[]{},ctClass);
        //为自定义方法设置修饰符
        ctMethod.setModifiers(Modifier.PUBLIC);
        //为自定义方法设置函数体
        StringBuffer buffer2 = new StringBuffer();
        buffer2.append("{\nSystem.out.println(\"begin!\");\n")
                .append("System.out.println(ename);\n")
                .append("System.out.println(eno);\n")
                .append("System.out.println(\"over!\");\n")
                .append("}");
        ctMethod.setBody(buffer2.toString());
        ctClass.addMethod(ctMethod);

        //为了验证效果，下面使用反射执行方法printInfo
        Class<?> clazz = ctClass.toClass();
        Object obj = clazz.newInstance();
        obj.getClass().getMethod("printInfo", new Class[]{}).invoke(obj, new Object[]{});

        //把生成的class文件写入文件
        byte[] byteArr = ctClass.toBytecode();
        FileOutputStream fos = new FileOutputStream(new File("/Users/apple/Desktop/Workspace/android/demos/OboBaseAndroidProject/utilproject/build/classStore/Emp.class"));
        fos.write(byteArr);
        fos.close();
    }


    /**
     *  创建Surface
     */
    static void createNewSurface() throws NotFoundException, CannotCompileException, NoSuchMethodException, IllegalAccessException, InstantiationException, IOException, InvocationTargetException {

        //ClassPool：CtClass对象的容器
        ClassPool pool = ClassPool.getDefault();

        //通过ClassPool生成一个public新类Emp.java
        CtClass ctClass = pool.makeClass("com.obo.view.SurfaceView");


        //添加构造函数
        CtConstructor ctConstructor = new CtConstructor(new CtClass[]{}, ctClass);
        //为构造函数设置函数体
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\n")
                .append("int a=0;\n")
                .append("int b=1;\n}");
        ctConstructor.setBody(buffer.toString());
        //把构造函数添加到新的类中
        ctClass.addConstructor(ctConstructor);


        //添加字段
        //首先添加字段private String ename
        CtField enameField = new CtField(pool.getCtClass("java.lang.String"),"ename",ctClass);
        enameField.setModifiers(Modifier.PRIVATE);
        ctClass.addField(enameField);

        CtField holderField = new CtField(pool.getCtClass("android.view.SurfaceHolder"),"z",ctClass);
        holderField.setModifiers(Modifier.PRIVATE);
        ctClass.addField(holderField);



        StringBuffer surfaceHolder = new StringBuffer();
        surfaceHolder.append("com.obo.utiljavaassist.AA a;");
//        surfaceHolder.append("=new com.obo.utiljavaassist.aa();");
//        surfaceHolder.append("{" +
//                "            public void addCallback(Callback callback) {\n" +
//                "                \n" +
//                "            }\n" +
//                "\n" +
//                "            public void removeCallback(Callback callback) {\n" +
//                "\n" +
//                "            }\n" +
//                "\n" +
//                "            public boolean isCreating() {\n" +
//                "                return false;\n" +
//                "            }\n" +
//                "\n" +
//                "            public void setType(int type) {\n" +
//                "\n" +
//                "            }\n" +
//                "\n" +
//                "            public void setFixedSize(int width, int height) {\n" +
//                "\n" +
//                "            }\n" +
//                "\n" +
//                "            public void setSizeFromLayout() {\n" +
//                "\n" +
//                "            }\n" +
//                "\n" +
//                "            public void setFormat(int format) {\n" +
//                "\n" +
//                "            }\n" +
//                "\n" +
//                "            public void setKeepScreenOn(boolean screenOn) {\n" +
//                "\n" +
//                "            }\n" +
//                "\n" +
//                "            public Canvas lockCanvas() {\n" +
//                "                return null;\n" +
//                "            }\n" +
//                "\n" +
//                "            public Canvas lockCanvas(Rect dirty) {\n" +
//                "                return null;\n" +
//                "            }\n" +
//                "\n" +
//                "            public void unlockCanvasAndPost(Canvas canvas) {\n" +
//                "\n" +
//                "            }\n" +
//                "\n" +
//                "            public Rect getSurfaceFrame() {\n" +
//                "                return null;\n" +
//                "            }\n" +
//                "\n" +
//                "            public Surface getSurface() {\n" +
//                "                return null;\n" +
//                "            }" +
//                "};");


        System.out.print(surfaceHolder.toString());
        CtField f = CtField.make(surfaceHolder.toString(), ctClass);
        ctClass.addField(f);

        //把生成的class文件写入文件
        byte[] byteArr = ctClass.toBytecode();
        FileOutputStream fos = new FileOutputStream(new File("/Users/apple/Desktop/Workspace/android/demos/OboBaseAndroidProject/utilproject/build/classStore/SurfaceView.class"));
        fos.write(byteArr);
        fos.close();




    }


    public interface AA {
        public void b();
    }


}
