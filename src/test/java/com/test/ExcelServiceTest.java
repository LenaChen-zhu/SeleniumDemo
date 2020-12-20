package com.test;

import com.po.service.ExcelService;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Map;

public class ExcelServiceTest {
    @Test
    public void ExcelTest(){
        String filePath = "/Users/chenqiang/project/testcase.xlsx";
        ExcelService excelService = new ExcelService();
        String value = excelService.readAllExcel(filePath);
    }
}
