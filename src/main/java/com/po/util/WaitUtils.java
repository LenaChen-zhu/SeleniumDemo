package com.po.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
    private WebDriverWait wait;
    public WebDriverWait waitTime(WebDriver driver, int time){
        return new WebDriverWait(driver,time);
    }
}
