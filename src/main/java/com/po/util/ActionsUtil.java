package com.po.util;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    //文本超链接
    public static String getLinkText(WebDriver driver,long timeout,By by){
        return FindElementsUtil.findElement(driver,timeout,by).getText();
    }


}
