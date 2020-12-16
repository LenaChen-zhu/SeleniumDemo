package com.po.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FindElementsUtilTest {
    private WebDriver driver;
    private String url = "https://www.baidu.com/";

    @Test
    public void findElementTest() throws InterruptedException {
        driver = DriverUtil.open("Chrome");
        driver.get(url);
        FindElementsUtil.findElement(driver,3, By.id("kw")).sendKeys("Selenium");
        Thread.sleep(3000);
        DriverUtil.closeAll();
    }
}
