package com.dsy;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Excel {
    public static void main(String[] args) {
        Workbook wb = loadExcel("/Users/dingsiye/Desktop/label.xlsx");
        analyzeExcel(wb);
    }

    public static Workbook loadExcel (String filePath){
        Workbook wb = null;
        File file = new File(filePath);
        if(!file.exists()){
            System.out.println("文件不存在");
            wb=null;
        }
        else {
            try {
                InputStream is = new FileInputStream(filePath);
                    wb = new XSSFWorkbook(is);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return wb;
    }

    public static void analyzeExcel(Workbook wb){
        Sheet sheet=wb.getSheetAt(0);//读取sheet(从0计数)
        int rowNum=sheet.getLastRowNum();//读取行数(从0计数)
        System.out.println(rowNum);
        for(int i=0;i<=1000;i++){
            Row row=sheet.getRow(i);//获得行
            int colNum=row.getLastCellNum();//获得当前行的列数
            for(int j=0;j<colNum;j++){
                Cell cell=row.getCell(j);//获取单元格
                System.out.print(cell.toString()+"     ");
            }
        }
    }

}