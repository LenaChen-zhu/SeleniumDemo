package com.test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserActionTest {

/*    1.打开Chrome浏览器
    2.输入百度网址，打开百度首页
    3.停留5秒钟
    4.退出Chrome浏览器*/
    @Test
    public void chromeAction() throws InterruptedException {
//        设置Chrome浏览器驱动
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
//        打开Chrome浏览器
        ChromeDriver chromeDriver = new ChromeDriver();
//        打开百度网址
        chromeDriver.get("https://www.baidu.com");
//        停留5秒钟
        Thread.sleep(5000);
//        退出Chrome浏览器
        chromeDriver.quit();
    }

   /* 1.打开FireFox浏览器
    2.输入百度网址，打开百度首页
    3.停留5秒钟
    4.退出Firefox浏览器*/
    @Test
    public void firefoxAction() throws InterruptedException {
//        设置FireFox浏览器驱动
        System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
//        打开火狐浏览器
        FirefoxDriver firefoxDriver = new FirefoxDriver();
//        打开百度网址
        firefoxDriver.get("https://www.baidu.com");
//        停留5秒
        Thread.sleep(5000);
//        退出FireFox浏览器
        firefoxDriver.quit();
    }

/*    1.打开IE浏览器
    2.输入百度网址，打开百度首页
    3.停留5秒钟
    4.退出IE浏览器*/
    @Test
    public void IEAction() throws InterruptedException {
//        设置IE浏览器驱动
        System.setProperty("webdriver.ie.driver","drivers/IEDriverServer.exe");
//        打开IE浏览器
        InternetExplorerDriver internetExplorerDriverDriver = new InternetExplorerDriver();
//        打开百度网址
        internetExplorerDriverDriver.get("https://www.baidu.com");
//        停留5秒
        Thread.sleep(5000);
//        退出IE浏览器
        internetExplorerDriverDriver.quit();
    }
/*    1.打开Chrome浏览器
    2.输入百度网址
    3.停留3秒钟
    4.浏览器后退操作
    5.停留3秒钟
    5.退出浏览器*/
    @Test
    public void chromeBack() throws InterruptedException {
//        设置Chrome浏览器驱动
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
//        打开Chrome浏览器
        ChromeDriver chromeDriver = new ChromeDriver();
//        打开百度网址
        chromeDriver.get("https://www.baidu.com");
//        停留3秒钟
        Thread.sleep(3000);
//        浏览器后退操作
        chromeDriver.navigate().back();
//        停留3秒钟
        Thread.sleep(3000);
//        退出Chrome浏览器
        chromeDriver.quit();
    }

/*    1.打开Chrome浏览器
    2.输入百度网址
    3.停留3秒钟
    4.浏览器后退操作
    5.停留3秒钟
    6.浏览器前进操作
    7.停留3秒钟
    8.退出浏览器*/
    @Test
    public void chromeForward() throws InterruptedException {
//        设置Chrome浏览器驱动
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
//        打开Chrome浏览器
        ChromeDriver chromeDriver = new ChromeDriver();
//        打开百度网址
        chromeDriver.get("https://www.baidu.com");
//        停留3秒钟
        Thread.sleep(3000);
//        浏览器后退操作
        chromeDriver.navigate().back();
//        停留3秒钟
        Thread.sleep(3000);
//        浏览器前进操作
        chromeDriver.navigate().forward();
//        停留3秒钟
        Thread.sleep(3000);
//        退出Chrome浏览器
        chromeDriver.quit();
    }

/*    1.打开Chrome浏览器
    2.输入百度首页
    3.停留3秒钟
    4.刷新页面
    5.停留3秒钟
    6.退出浏览器*/
    @Test
    public void chromeRefresh() throws InterruptedException {
//        设置Chrome浏览器驱动
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
//        打开Chrome浏览器
        ChromeDriver chromeDriver = new ChromeDriver();
//        打开百度网址
        chromeDriver.get("https://www.baidu.com");
//        停留3秒钟
        Thread.sleep(3000);
//        刷新页面
        chromeDriver.navigate().refresh();
//        停留3秒钟
        Thread.sleep(3000);
//        退出浏览器
        chromeDriver.quit();
    }

/*    1.打开Chrome浏览器
    2.设置浏览器大小为300*300
    3.停留2秒钟
    4.设置浏览器页面最大化
    5.停留2秒钟
    6.退出浏览器*/
    @Test
    public void chromeSetSize() throws InterruptedException {
//        设置Chrome浏览器驱动
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
//        打开Chrome浏览器
        ChromeDriver chromeDriver = new ChromeDriver();
//        设置浏览器大小为300*300
        Dimension dimension = new Dimension(300,300);
//        停留2秒
        Thread.sleep(2000);
//        设置窗口最大化
        chromeDriver.manage().window().maximize();
//        停留2秒
        Thread.sleep(2000);
//        退出浏览器
        chromeDriver.quit();
    }

/*    1.打开Chrome浏览器
    2.打开百度网址
    3.获取当前URL
    4.停留2秒钟
    5.判断当前网址和预期网址是否一致
    6.退出浏览器*/
    @Test
    public void getCurrentURL()throws InterruptedException{
        String url = "https://www.baidu.com/";
//        设置Chrome浏览器驱动
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
//        打开Chrome浏览器
        ChromeDriver chromeDriver = new ChromeDriver();
//        打开百度
        chromeDriver.get(url);
//        获得当前打开的网址
        String currentURL = chromeDriver.getCurrentUrl();
        Thread.sleep(2000);
//        判断当前网址和预期网址是否一致
        Assert.assertEquals(currentURL,url);
        Thread.sleep(2000);
//        退出浏览器
        chromeDriver.quit();
    }



}
