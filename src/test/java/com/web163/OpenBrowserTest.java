package com.web163;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

//打开各个浏览器，Chrome，IE，FireFox
public class OpenBrowserTest {
    private WebDriver webDriver;

//    根据所传入不同的浏览器名称，来配置浏览器，并返回webdriver
    public WebDriver getWebDriver(String webDriverName) throws Exception {
        if(webDriverName.equals("Firefox")){
            System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
            webDriver = new FirefoxDriver();
        }else if(webDriverName.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
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