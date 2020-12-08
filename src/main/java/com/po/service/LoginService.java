package com.po.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface LoginService {
    String Login(WebDriver driver, WebDriverWait wait, String browser, int time, String userName, String password) throws Exception;
}
