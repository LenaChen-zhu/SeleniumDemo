package com.po.util;

import lombok.extern.log4j.Log4j2;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@Log4j2
public class FindElementsUtil {
    private static WebElement element = null;
    private static List<WebElement> elementList = null;

    //查找单个元素，并等待指定时间
    public static WebElement findElement(WebDriver driver, long timeout, final By by){
        element = new WebDriverWait(driver,timeout).until(new ExpectedCondition<WebElement>(){
            @NullableDecl
            public WebElement apply(@NullableDecl WebDriver driver) {
                try {
                    return driver.findElement(by);
                } catch (StaleElementReferenceException var3) {
                    log.error("无法找到该元素，没有driver");
                    return null;
                }
            };
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
                    log.error("无法找到该元素，没有driver");
                    return null;
                }
            };
        });
        return elementList;
    }
}
