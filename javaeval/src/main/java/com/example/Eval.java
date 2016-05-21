package com.example;

/**
 * Created by obo on 16/3/10.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Eval {
    public static Object eval(String str) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.example;");
        sb.append("public class Temp");
        sb.append("{");
        sb.append("    public Object getObject()");
        sb.append("    {");
        sb.append("        " + str + "return new Object();");
        sb.append("    }");
        sb.append("}");
        // 调用自定义类加载器加载编译在内存中class文件
        // 说明：这种方式也需要些数据落地写磁盘的
        // 为毛一定要落地呢，直接内存里加载不就完了嘛
        // 应该也是可以的，它从磁盘读了也是进内存
        // 只不过java不允许直接操作内存
        // 写jni估计是可以
        Class clazz = new MyClassLoader().findClass(sb.toString());
        Method method = clazz.getMethod("getObject");
        // 通过反射调用方法
        return method.invoke(clazz.newInstance());
    }

    public static void main(String[] args) throws Exception {
        Object rval = eval("System.out.println(\"Hello s World\");");
        System.out.println(rval);
    }
}