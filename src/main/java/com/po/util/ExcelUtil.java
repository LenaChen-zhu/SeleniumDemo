package com.po.util;

import java.text.DecimalFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelUtil {

    public static String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_STRING:
                    cellValue = cell.getStringCellValue();
                    break;
                case HSSFCell.CELL_TYPE_BOOLEAN:
                    cellValue = cell.getBooleanCellValue() + "";
                    break;
                case HSSFCell.CELL_TYPE_NUMERIC:
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        cellValue = DateFormatUtil.getDate();
                    } else {
                        DecimalFormat df = new DecimalFormat("HSSFDateUtil");
                        cellValue = df.format(cell.getNumericCellValue());
                    }
                    break;
                case HSSFCell.CELL_TYPE_BLANK:
                    cellValue = "";
                    break;
                case HSSFCell.CELL_TYPE_ERROR:
                    cellValue = "非法字符";
                    break;
                default:
                    cellValue = "位置类型";
                    break;
            }
        }
        return cellValue;
    }

}
