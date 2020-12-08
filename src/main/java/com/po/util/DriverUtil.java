package com.po.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class DriverUtil {
    private WebDriver webDriver;
    //简单单例模式
    //根据所传入不同的浏览器名称，来配置浏览器，
    public WebDriver getWebDriver(String webDriverName)throws Exception {
        if(webDriverName.equals("Firefox")){
            System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
            webDriver = new FirefoxDriver();
        }else if(webDriverName.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
            webDriver = new ChromeDriver();
        }else if(webDriverName.equals("IE")){
            System.setProperty("webdriver.ie.driver","drivers/IEDriverServer.exe");
            webDriver = new InternetExplorerDriver();
        }else if(webDriverName.equals("PhantomJs")){
            System.setProperty("phantomjs.binary.path","drivers/phantomjs.exe");
            webDriver = new PhantomJSDriver();
        }else {
            throw new Exception("没有该浏览器打开方法");
        }
        return webDriver;
    }

}
