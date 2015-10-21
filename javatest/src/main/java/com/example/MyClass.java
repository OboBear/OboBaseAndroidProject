package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyClass {

    public static void main(String[]args) throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
//        Pattern pattern = Pattern.compile("^Java.*");
//        Matcher matcher = pattern.matcher("Java不是人");
//        boolean b= matcher.matches();
//        //当条件满足时，将返回true，否则返回false
//        System.out.println(b);

//        Pattern pattern = Pattern.compile("[, |]+");
//        String[] strs = pattern.split("Java Hello World  Java,Hello,,World|Sun");
//        for (int i=0;i<strs.length;i++) {
//            System.out.println(strs[i]);
//        }

//        Pattern pattern = Pattern.compile("正则表达式");
//        Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World");
////替换第一个符合正则的数据
//        System.out.println(matcher.replaceFirst("Java"));
//
//        Pattern pattern = Pattern.compile("正则表达式");
//        Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World ");
//        StringBuffer sbr = new StringBuffer();
//        while (matcher.find()) {
//            matcher.appendReplacement(sbr, "Java");
//        }
//        matcher.appendTail(sbr);
//        System.out.println(sbr.toString());

//        Pattern pattern = Pattern.compile("<.+?>", Pattern.DOTALL);
//        Matcher matcher = pattern.matcher("<a href=\"index.html\">主页</a>");
//        String string = matcher.replaceAll("");
//        System.out.println(string);

//        Pattern pattern = Pattern.compile("href=\"(.+?)\"");
//        Matcher matcher = pattern.matcher("<a href=\"index.html\">主页</a>");
//        if(matcher.find())
//            System.out.println(matcher.group(1));


//        Pattern pattern = Pattern.compile("(http://|https://){1}[//w//.//-/:]+");
//        Matcher matcher = pattern.matcher("dsdsds<http://dsds//gfgffdfd>fdf");
//        StringBuffer buffer = new StringBuffer();
//        while(matcher.find()){
//            buffer.append(matcher.group());
//            buffer.append("/r/n");
//            System.out.println(buffer.toString());
//        }

//        Pattern pattern = Pattern.compile("hello (.+) jj");
//        Matcher matcher = pattern.matcher("nihao hello asdhi jj");
////        matcher.find();
//        if(matcher.find())
//        System.out.println(matcher.group(1));


//        File ff = new File("./");
//        System.out.println("路径：" + ff.getAbsolutePath());
//        ff.getAbsolutePath();





//        String path="/Users/apple/Desktop/Workspace/android/demos/OboBaseAndroidProject/javatest/src/main/java/com/example/index.txt";//相对路径
//        File filename= new File(path);
//        BufferedReader bufread= new BufferedReader(new FileReader(filename));
//        String read = "";
//        String readStr = "";
//
//        while((read=bufread.readLine())!=null){
//            readStr=(readStr+read);
//        }
//
//        Pattern pattern = Pattern.compile("<script>(.*?)</script>");
//        Matcher matcher = pattern.matcher(readStr);
//        if (matcher.find()) {
//            int i = 0;
//            while (matcher.find(i)) {
//                System.out.println(matcher.group() + " ");
//            }
//        }
//        bufread.close();




//        Pattern pattern = Pattern.compile("^(\\d{9})$");
//        Matcher matcher = pattern.matcher("1234567890");
//        System.out.println(""+matcher.find());


//        Pattern pattern = Pattern.compile("a+");
//        String [] spilit = pattern.split("abacadahaakjkjhaiuew");
//        for (String s:spilit)
//        {
//
//            System.out.println(s);
//
//        }


//        Pattern pattern = Pattern.compile("^0\\d{3}-\\d{7}$");
//        Matcher matcher = pattern.matcher("1379-7654321");
//        System.out.println(""+matcher.find());


//        Pattern pattern = Pattern.compile("[aeiou]+");
//        String [] spilit = pattern.split("ajhksdbfiowen");
//        for (String s:spilit)
//        {
//
//            System.out.println(s);
//
//        }




//        Pattern pattern = Pattern.compile("\\(?0\\d{2}[)-]?\\d{8}");
//        Matcher matcher = pattern.matcher("022-22334455");
//        System.out.println(""+matcher.find());


//        Pattern pattern = Pattern.compile("~~\\(*.*\\)");
//        Matcher matcher = pattern.matcher("~~(国庆节快乐!)");
//        System.out.println(""+matcher.find());


//        Pattern pattern = Pattern.compile("^(?!(.*?-){6,})(?!(.*?\\d){10,})[013-]{14}$");
//        Pattern pattern = Pattern.compile("hello (?!wor|wrd)");
//        Matcher matcher = pattern.matcher("hello werd");
//        System.out.println(""+matcher.find());

//         Pattern pattern = Pattern.compile("[1-9]\\d{0,3}+|[1-6]\\d(?<!6[6-9])\\d(?<!65[6-9])\\d(?<!655[4-9])\\d(?<!6553[6-9])");
//         Matcher matcher = pattern.matcher("75535");
//        String regex = "[1-9]\\d{0,3}+|[1-6]\\d(?<!6[6-9])\\d(?<!65[6-9])\\d(?<!655[4-9])\\d(?<!6553[6-9])";
//        System.out.println(""+matcher.matches());
//        System.out.println("75535" + " " + "75535".matches(regex));

        // 1~4095
//        String regex = "[1-9]\\d{0,2}+|[1-4]\\d(?<!4[1-9])\\d\\d(?<!409[6-9])";
//
//        String[] strArray = { "4094", "4095", "4096", "5000", "4000", "900", "10", "9", "0", "1", "-1", "a", "@" };
//
//        for (String str : strArray) {
//            System.out.println(str + " " + str.matches(regex));
//        }


//        readWriteFile();

//        String sourceString = "com.example.A.B.C";
//        StringBuffer stringBuffer = new StringBuffer();
//        String []splits = sourceString.split("[.]");
//
//        for (int i=0;i<splits.length - 2;i++)
//        {
//            if (i!=0)
//                stringBuffer.append(".");
//            stringBuffer.append(splits[i]);
//        }
//        stringBuffer.append("$");
//        stringBuffer.append(splits[splits.length-2]);
//
//        Class<?>cls = Class.forName(stringBuffer.toString());
//        int idValue =  cls.getField(splits[splits.length - 1]).getInt(splits[splits.length - 1]);
//        System.out.println("" +idValue);


//        try {
//            //packagename+sourceID,you should replace this String value to yours
//            String sourceString = "com.obo.R.drawable.splash";
//            StringBuffer stringBuffer = new StringBuffer();
//            String[] splits = sourceString.split("[.]");
//
//            for (int i = 0; i < splits.length - 2; i++) {
//                if (i != 0)
//                    stringBuffer.append(".");
//                stringBuffer.append(splits[i]);
//            }
//            stringBuffer.append("$");
//            stringBuffer.append(splits[splits.length - 2]);
//
//            Class<?> cls = Class.forName(stringBuffer.toString());
//
//            int idValue = cls.getField(splits[splits.length - 1]).getInt(splits[splits.length - 1]);
//
//            Bitmap image = BitmapFactory.decodeResource(context, idValue);
//            //this is what you want!
//            Drawable imageDrawable = new BitmapDrawable(image);
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }






//        Class classForName = Class.forName("com.example.A");
//        Field feild = A.class.getField("B");
//       Class b = feild.getClass();
//        Field c = b.getField("C");
//        System.out.println("" + c.getInt("C"));
    }






    static void readWriteFile() throws IOException {
        FileReader fr=new FileReader("/Users/apple/Desktop/Workspace/android/demos/OboBaseAndroidProject/javatest/src/main/java/com/example/road");
        BufferedReader br=new BufferedReader(fr);
        String line="";
        while ((line=br.readLine())!=null) {
            line = line.replace("\\\"","||||||");
            line = line.replace("\"","");
            line = line.replace("\\n","");
            line = line.replace("\\r","");
            line = line.replace("\\t","");
            line = line.replace("+","");
            line = line.replace("||||||","\"");
            System.out.println(line);
        }
        br.close();
        fr.close();
    }
}
