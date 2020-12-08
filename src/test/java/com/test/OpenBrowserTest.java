package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class OpenBrowserTest {

//    启动火狐浏览器
    @Test
    public void openFireFox(){
//        System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
//        设置FireFox浏览器驱动
        System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
        FirefoxDriver firefoxDriver = new FirefoxDriver();
    }

//    启动Chrome浏览器
    @Test
    public void openChrome(){
//        设置Chrome浏览器驱动
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
    }

//    启动IE浏览器
    @Test
    public void openIE(){
//        设置IE浏览器驱动
        System.setProperty("webdriver.ie.driver","drivers/IEDriverServer.exe");
        InternetExplorerDriver internetExplorerDriverDriver = new InternetExplorerDriver();
    }

    @Test
    public void openPhantomJs(){
        System.setProperty("phantomjs.binary.path","drivers/phantomjs.exe");
        WebDriver webdriver = new PhantomJSDriver();
    }
}
