package com.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class CloseBrowserTest {
//    退出Chrome浏览器
    @Test
    public void closeChrome() throws InterruptedException {
//        设置Chrome浏览器驱动
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        //页面停留5秒钟
        Thread.sleep(5000);
        //关闭浏览器当前页面
        chromeDriver.close();
        //退出浏览器
        chromeDriver.quit();
    }
//   退出FireFox浏览器
    @Test
    public void closeFireFox() throws InterruptedException {
//        设置FireFox浏览器驱动
        System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        //页面停留5秒钟
        Thread.sleep(5000);
        //关闭浏览器当前页面
        firefoxDriver.close();
        //退出浏览器
        firefoxDriver.quit();
    }

//    退出IE浏览器
    @Test
    public void closeIE() throws InterruptedException {
//        设置IE浏览器驱动
        System.setProperty("webdriver.ie.driver","drivers/IEDriverServer.exe");
        InternetExplorerDriver internetExplorerDriverDriver = new InternetExplorerDriver();
        //页面停留5秒钟
        Thread.sleep(5000);
        //关闭浏览器当前页面
        internetExplorerDriverDriver.close();
        //退出浏览器
        internetExplorerDriverDriver.quit();
    }


}
