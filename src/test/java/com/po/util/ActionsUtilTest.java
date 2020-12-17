package com.po.util;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ActionsUtilTest {
    private WebDriver driver;
    private String url = "https://www.baidu.com/";

    @Test
    public void actionEventTest(){
        try {
            driver = DriverUtil.open("Chrome");
            ActionsUtil.getURL(driver,url);
            ActionsUtil.sendText(driver,3, By.id("kw"),"Selenium");
            ActionsUtil.clickEvent(driver,3,By.id("su"));
            String text = ActionsUtil.getLinkText(driver,3,By.linkText("MeterSphere - 开源自动化测试平台"));
            Assert.assertEquals("MeterSphere - 开源自动化测试平台",text);
        }catch (Exception e){
            System.out.println("actionUtil错误"+e.getMessage());
            e.printStackTrace();
        }finally {
            DriverUtil.closeAll();
        }
    }
}
