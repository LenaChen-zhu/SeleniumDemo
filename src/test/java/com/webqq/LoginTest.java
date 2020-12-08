package com.webqq;

import com.po.service.LoginImpl;
import com.po.util.DriverUtil;
import com.po.util.WaitUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private String url = "https://mail.qq.com/cgi-bin/loginpage";
    String userName = "qiangxiao_1984@qq.com";
    String password = "lenachen1980";

    @BeforeTest
    public void initBrowser() throws Exception {
        DriverUtil driverUtil = new DriverUtil();
        driver = driverUtil.getWebDriver("Chrome");
        WaitUtils waitUtils = new WaitUtils();
        wait = waitUtils.waitTime(driver,5);
    }

    //    根据传入的参数打开指定的浏览器,并进入qq邮箱首页
    @BeforeMethod
    public void openBroswer() throws Exception {
        driver.get(url);
    }
//    进入登录页面，输入邮箱和密码
    @Test
    public void loginTest() throws Exception {
//        LoginPage loginPage = new LoginPage();
//        driver.switchTo().frame("login_frame");
//        driver.findElement(loginPage.getUserPwd).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getEmailName));
//        driver.findElement(loginPage.getEmailName).sendKeys(userName);
//        driver.findElement(loginPage.getEmailPwd).sendKeys(password);
//        driver.findElement(loginPage.getLoginBtn).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.exitBtn));
//        String text = driver.findElement(loginPage.exitBtn).getText();
        LoginImpl login = new LoginImpl();
        String text = login.Login(driver,wait,"Chrome",10,userName,password);
        System.out.println("text="+text);
        Assert.assertEquals("退出",text);
    }

    //   关闭浏览器
    @AfterMethod
    public void closeBrowser() throws InterruptedException {
       Thread.sleep(6000);
        driver.quit();
    }
}
