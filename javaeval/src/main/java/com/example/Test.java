package com.example;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by obo on 16/3/13.
 * Email:obo1993@gmail.com
 */
public class Test {

//    public static void main(String []args) throws IOException {
//        String inputNumber;
//
//        Scanner sc = new Scanner(System.in);
//
//        inputNumber = sc.next();
//
//        //位数
//
//        System.out.println("位数 =" + inputNumber.length());
//
//        //各位数相加
//        int sum=0;
//        for (int i=0;i<inputNumber.length();i++) {
//            sum += inputNumber.charAt(i) - '0';
//        }
//        System.out.println("和 = " + sum);
//
//        // 倒序输出
//        StringBuffer stringBuffer = new StringBuffer(inputNumber);
//        System.out.println("倒序 = " + Integer.parseInt(stringBuffer.reverse()+""));
//
//        //回文
//        boolean isReverse = true;
//        for (int i=0;i<inputNumber.length()/2;i++) {
//            if (inputNumber.charAt(i) != inputNumber.charAt(inputNumber.length() - i -1)) {
//                isReverse = false;
//                break;
//            }
//        }
//        if (isReverse) {
//            System.out.println("是回文数");
//        } else  {
//            System.out.println("不是回文数");
//        }
//    }

    public static void main(String []args) throws NoSuchFieldException, NoSuchMethodException, UnsupportedEncodingException {

//        int array [] = {
//          2,1,3,4,4,4,9,9,1,0,1,1,2
//        };
//
//        //只输出连续的数字
//        System.out.print("连续数字:");
//        for (int i=0;i<array.length;i++) {
//            if (i>0 ) {
//                if (array[i] == array[i-1]) {
//                    System.out.print(" "+array[i]);
//                    continue;
//                }
//            }
//            if (i<array.length - 1) {
//                if (array[i] == array[i+1]) {
//                    System.out.print(" "+array[i]);
//                    continue;
//                }
//            }
//        }


//        Class c = "实时".getClass();
//        System.out.println(""+c);
//        System.out.println(c.getName());

        byte[]re = {
                67,82,80, 0, -52, -52, -52, -52, -52,-52
        };

//        String isoString = new String(re,"ISO-8859-1");
//        String srt2=new String(isoString,"UTF-8");

        String s = new String(re,"GB2312");
        System.out.print(s);



    }
}
