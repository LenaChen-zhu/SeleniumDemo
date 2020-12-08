package com.test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PhantomJSTest{
    //        无界面浏览器
    WebDriver webdriver;


    @BeforeMethod
    public void openChrome() throws InterruptedException {
//        设置Chrome浏览器驱动
        System.setProperty("phantomjs.binary.path","drivers/phantomjs.exe");
        webdriver = new PhantomJSDriver();
    }

    @Test
    public void sendKeysTest() throws InterruptedException{
        String expectedStr="Selenium automates browsers. That's it!";
        webdriver.get("https://www.baidu.com");
        Thread.sleep(1000);
        webdriver.findElement(By.id("kw")).sendKeys("selenium");
        Thread.sleep(1000);
        webdriver.findElement(By.id("su")).click();
        Thread.sleep(2000);
        String acutalText = webdriver.findElement(By.xpath("//*[@id=\"1\"]/h3/a[1]")).getText();
//        System.out.println("获取的实际文本为："+acutalText);
        Assert.assertEquals(expectedStr,acutalText);
    }

    @AfterMethod
    public void quitBrowser() throws InterruptedException {
        Thread.sleep(1000);
        webdriver.quit();
    }
}
