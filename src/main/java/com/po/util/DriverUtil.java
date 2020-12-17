package com.po.util;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.slf4j.LoggerFactory;


public class DriverUtil {
    private static WebDriver driver = null;
    //简单单例模式
    //根据所传入不同的浏览器名称，来配置浏览器，
    public static WebDriver open(String browser){
        try
        {
            if(browser.equals("Firefox")){
                System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            }else if(browser.equals("Chrome")){
                System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
                driver = new ChromeDriver();
            }else if(browser.equals("IE")){
                System.setProperty("webdriver.ie.driver","drivers/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }else if(browser.equals("PhantomJs")){
                System.setProperty("phantomjs.binary.path","drivers/phantomjs.exe");
                driver = new PhantomJSDriver();
            }

        }catch (Exception e){
            System.out.println("异常信息为"+e.getMessage());
            e.printStackTrace();
        }
        return driver;
    }

    //关闭浏览器及其进程
    public static void closeAll(){
        if(driver != null)
            driver.quit();
    }

    //关闭当前浏览器
    public static void close(){
        if(driver != null)
            driver.close();
    }

}
