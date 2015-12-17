package com.obo.utiljavaassist;

import android.content.Intent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtMethod;
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

        modifyAndroid();

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


}
