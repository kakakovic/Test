package com.dsy;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.StringJoiner;

public class Excel {
    public static void main(String[] args) {
        Workbook wb = loadExcel("/Users/dingsiye/Downloads/体育AB修改.xlsx");
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
        StringJoiner stringJoiner = new StringJoiner(",");
        Sheet sheet=wb.getSheetAt(0);//读取sheet(从0计数)
        int rowNum=sheet.getLastRowNum();//读取行数(从0计数)
        for(int i = 0 ; i <= rowNum ; i++) {
            Row row=sheet.getRow(i);//获得行
            Cell cell = row.getCell(0);
            CellType cellType  = cell.getCellTypeEnum();
            if (cellType == CellType.NUMERIC){
                DecimalFormat df = new DecimalFormat("0");
                String a =   String.valueOf(df.format(cell.getNumericCellValue()));
                stringJoiner.add(a);

            }else {
                stringJoiner.add(cell.toString());
            }

        }
        System.out.println(stringJoiner.toString());
    }

}