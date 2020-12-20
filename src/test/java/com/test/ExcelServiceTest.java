package com.test;

import com.po.service.ExcelService;
import org.testng.annotations.Test;

public class ExcelServiceTest {
    @Test
    public void ExcelTest(){
        String filePath = "/Users/chenqiang/project/testcase.xlsx";
        ExcelService excelService = new ExcelService();
        excelService.readExcel(filePath);
    }
}
