package com.po.util;

import org.apache.log4j.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FindElementsUtil {
    private static Logger logger = Logger.getLogger(DriverUtil.class);
    private static WebElement element;
    private static List<WebElement> elementList;

    //查找单个元素，并等待指定时间
    public static WebElement findElement(WebDriver driver, long timeout, final By by){
        element = new WebDriverWait(driver,timeout).until(new ExpectedCondition<WebElement>(){
            @NullableDecl
            public WebElement apply(@NullableDecl WebDriver driver) {
                try{
                    return driver.findElement(by);
                } catch (StaleElementReferenceException var3) {
                    logger.info("异常信息为："+var3.getMessage());
                    return null;
                }
            }
        });
        return element;
    }

    //查找多个元素，并等待指定时间
    public static List<WebElement> findElements(WebDriver driver, long timeout, final By by){
        elementList = new WebDriverWait(driver,timeout).until(new ExpectedCondition<List<WebElement>>(){
            @NullableDecl
            public List<WebElement> apply(@NullableDecl WebDriver driver) {
                try {
                    return driver.findElements(by);
                } catch (StaleElementReferenceException var3) {
                    logger.info("异常信息为："+var3.getMessage());
                    return null;
                }
            }
        });
        return elementList;
    }
}
