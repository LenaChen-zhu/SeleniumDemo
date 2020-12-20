package com.po.service;

import com.po.page.LoginPage;
import com.po.util.DriverUtil;
import com.po.util.FindElementsUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginImpl implements LoginService{

    @Autowired
    private LoginPage loginPage;
    private DriverUtil driverUtil;
    private WebDriver driver;
    private FindElementsUtil waitUtils;
    private WebDriverWait wait;

    public String Login(WebDriver driver,WebDriverWait wait,String webDriverName,int time,String userName, String password) throws Exception {
        loginPage = new LoginPage();
        driver.switchTo().frame("login_frame");
        driver.findElement(loginPage.getUserPwd).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailName));
        driver.findElement(loginPage.getEmailName).sendKeys(userName);
        driver.findElement(loginPage.getEmailPwd).sendKeys(password);
        driver.findElement(loginPage.getLoginBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.exitBtn));
        String text = driver.findElement(loginPage.exitBtn).getText();
        return text;
    }

}
