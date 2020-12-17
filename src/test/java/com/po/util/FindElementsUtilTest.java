package com.po.util;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class FindElementsUtilTest {
    private WebDriver driver;
    private String url = "https://www.baidu.com/";

    @Test
    public void findElementTest() {
        try{
            driver = DriverUtil.open("Chrome");
            driver.get(url);
            FindElementsUtil.findElement(driver,3, By.id("kw")).sendKeys("Selenium");
            FindElementsUtil.findElement(driver,2,By.id("su")).click();
            String text = FindElementsUtil.findElement(driver,2,By.linkText("MeterSphere - 开源自动化测试平台")).getText();
            Assert.assertEquals("MeterSphere - 开源自动化测试平台",text);
        }catch (Exception e){
            System.out.println("没有找到对应的元素"+e.getMessage());
            e.printStackTrace();
        }finally {
            DriverUtil.closeAll();
        }



    }
}
