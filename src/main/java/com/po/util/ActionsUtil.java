package com.po.util;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ActionsUtil {
    //打开url网址
    public static void getURL(WebDriver driver,String url){
        if(!StringUtils.isEmpty(url)){
            driver.get(url);
        }else {
            System.out.println("url地址为空");;
        }
    }

    //输入文本
    public static void sendText(WebDriver driver, long timeout, By by, String text){
        FindElementsUtil.findElement(driver,timeout,by).clear();
        FindElementsUtil.findElement(driver,timeout,by).sendKeys(text);
    }

    //点击事件
    public static void clickEvent(WebDriver driver,long timeout,By by){
        FindElementsUtil.findElement(driver,timeout,by).click();
    }

    //获取文本
    public static String getText(WebDriver driver,long timeout,By by){
        return FindElementsUtil.findElement(driver,timeout,by).getText();
    }

    //获取一系列空间的文本
    public static ArrayList getAllText(WebDriver driver, long timeout, By by){
        List<WebElement> elementList = FindElementsUtil.findElements(driver,timeout,by);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < elementList.size(); i++) {
            arrayList.add(elementList.get(i).getText());
        }
        return arrayList;
    }

    //获取指定位置的文本
    public static String getIndexText(WebDriver driver,long timeout,By by,int index){
        List<WebElement> elementList = FindElementsUtil.findElements(driver,timeout,by);
        return elementList.get(index).getText();
    }







}
