package com.example;
//in ExcelOperater

import java.io.File;

import java.io.FileInputStream;

import java.io.InputStream;

import jxl.Cell;

import jxl.CellType;

import jxl.Sheet;

import jxl.Workbook;

import jxl.write.Label;



public class Test
{

    public static void main(String[] args)
    {

        jxl.Workbook readwb = null;

        try

        {

            //构建Workbook对象, 只读Workbook对象

            //直接从本地文件创建Workbook

            InputStream instream = new FileInputStream("/Users/apple/Desktop/Workspace/android/demos/OboBaseAndroidProject/javatest/src/main/java/com/example/Test.xls");

            readwb = Workbook.getWorkbook(instream);



            //Sheet的下标是从0开始

            //获取第一张Sheet表

            Sheet readsheet = readwb.getSheet(0);

            //获取Sheet表中所包含的总列数

            int rsColumns = readsheet.getColumns();

            //获取Sheet表中所包含的总行数

            int rsRows = readsheet.getRows();

            //获取指定单元格的对象引用

            for (int i = 0; i < rsRows; i++)

            {

                for (int j = 0; j < rsColumns; j++)

                {

                    Cell cell = readsheet.getCell(j, i);

                    System.out.print(cell.getContents() + " ");

                }

                System.out.println();

            }



            //利用已经创建的Excel工作薄,创建新的可写入的Excel工作薄

            jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(new File(

                    "Test.xls"), readwb);

            //读取第一张工作表

            jxl.write.WritableSheet ws = wwb.getSheet(0);

            //获得第一个单元格对象

            jxl.write.WritableCell wc = ws.getWritableCell(0, 0);

            //判断单元格的类型, 做出相应的转化

            if (wc.getType() == CellType.LABEL)

            {

                Label l = (Label) wc;

                l.setString("新姓名");

            }

            //写入Excel对象

            wwb.write();

            wwb.close();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            readwb.close();

        }

    }



//    public static void main(String[] args) {
//        int i,j;
//        Sheet sheet;
//        jxl.Workbook book;
//        int num = 0;
//        try {
//            //”√Worbook∂‘œÛ∂¡»°XLS±Ì∏Ò
//            book= jxl.Workbook.getWorkbook(new File("/Users/apple/Desktop/Workspace/android/demos/OboBaseAndroidProject/javatest/src/main/java/com/example/Test.xls"));
//
//            //ªÒµ√π§◊˜±Ì∂‘œÛ(Ecxel÷–sheetµƒ±‡∫≈¥”0ø™ º,0,1,2,3,....)
//            sheet=book.getSheet(0);
//
//            String wel="Welcome";
//            System.out.println(wel);
//            //ªÒ»°√ø“ª¡–µƒ Ù–‘√˚
//            for(i=0;;){
//                Cell AttrCell = sheet.getCell(i,0);
//                //if("".equals(AttrCell.getContents())==true || AttrCell.getContents() == null){
//                if("".equals(AttrCell.getContents())==true || i==5){
//                    System.out.print("End");
//                    break;
//                }
//                else{
//                    String AttrCellStr = AttrCell.getContents();
//                    if(i!=0){ System.out.print("\t");}
//                    System.out.print(AttrCellStr);
//                    i++;
//                    num++;
//                }
//            }
//            System.out.println("");
//
//            Cell cell1,cell2,cell3;
//
//            i=1;
//            Cell cellItem;
//            while(true)
//            {
//                j=0;
//                while(true){
//                    cellItem = sheet.getCell(j,i);
//                    if(j==(num)){break;}
//                    if(j!=0){System.out.print("\t");}
//                    System.out.print(cellItem.getContents());
//                    j++;
//                }
//                System.out.println("");
//                if("".equals(cellItem.getContents())==true)    //»Áπ˚∂¡»°µƒ ˝æ›Œ™ø’
//                {break;}
//                i++;
//            }
//            book.close();
//        }
//        catch(Exception e){ }
//    }


}