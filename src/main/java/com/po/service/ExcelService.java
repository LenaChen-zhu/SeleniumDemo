package com.po.service;

import com.po.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class ExcelService {
    private Workbook workbook = null;
    private FileInputStream fis = null;
    private String cellValue;
    private Row row;
    private Cell cell;


    public String readAllExcel(String filePath) {
        try {
            fis = new FileInputStream(filePath);
            if (filePath.endsWith(".xls")) {
                workbook = new HSSFWorkbook(fis);
            } else if (filePath.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(fis);
            }
            fis.close();
            //读取excel内容,获取第一个Sheet页内容
            Sheet sheet = workbook.getSheetAt(0);
            //获取总行数
            Iterator<Row> rows = sheet.rowIterator();
            while (rows.hasNext()) {
                row = rows.next();
                // 获取单元格
                Iterator<Cell> cells = row.cellIterator();
                while (cells.hasNext()) {
                    cell = cells.next();
                    cellValue = ExcelUtil.getCellValue(cell);
                    System.out.print(cellValue + " ");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fis) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return cellValue;
    }

    public String readExcle(String filePath,String sheetName,int rowNum,int cellNum){
        try {
            fis = new FileInputStream(filePath);
            if(filePath.endsWith(".xls")){
                workbook = new HSSFWorkbook(fis);
            }else if(filePath.endsWith(".xlsx")){
                workbook = new XSSFWorkbook(fis);
            }
            fis.close();
            //读取excel内容,获取第一个Sheet页内容
            Sheet sheet = workbook.getSheet(sheetName);
            //获取指定行数
            row = sheet.getRow(rowNum);
            //获取指单元格value
            cell = row.getCell(cellNum);
            String cellValue = ExcelUtil.getCellValue(cell);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            if (null != fis) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return cellValue;
    }
}
