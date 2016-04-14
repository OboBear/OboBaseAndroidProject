package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

/**
 * Created by obo on 16/3/20.
 * Email:obo1993@gmail.com
 */
public class Main {


    private static void moveOneStep(StringBuffer stringBuffer,int start,int end){
        for (int i=end; i>start; i--) {
            stringBuffer.setCharAt(i,stringBuffer.charAt(i-1));
        }
    }


    public static void main(String args[]) throws IOException {
        String bigNum;
        Reader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        bigNum = bufferedReader.readLine();


        Scanner input = new Scanner(System.in);

        int k = input.nextInt();


        if (k >= bigNum.length()) {
            System.out.print("不合法的输入\n");
            return;
        }


        StringBuffer stringBuffer = new StringBuffer(bigNum);

        //核心代码
        for (int i=0; i<k; i++) {
            for (int j=i; j<bigNum.length(); j++) {
                if (j == bigNum.length() - 1 || stringBuffer.charAt(j) < stringBuffer.charAt(j+1) ) {
                    //使用了位移覆盖的方式来删除
                    moveOneStep(stringBuffer,i,j);
                    break;
                }
            }
        }

        //将字符串前移k位，也就是将原先后移的都移回来
        for (int i=0; i<bigNum.length() - k; i++) {
            stringBuffer.setCharAt(i,stringBuffer.charAt(i+k));
        }

        String result = stringBuffer.substring(0, bigNum.length() - k);
        System.out.print(result);

    }
}
