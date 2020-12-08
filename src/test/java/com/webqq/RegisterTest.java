package com.webqq;

import com.test.OpenBrowserTest;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {
    private OpenBrowserTest openBrowserTest;
    private WebDriver driver;
    JavascriptExecutor js;
    private WebDriverWait wait;

    //    根据传入的参数打开指定的浏览器,并进入163首页
    @BeforeMethod
    public void openBroswer() throws Exception{
        String qqAddress = "https://mail.qq.com/";
        openBrowserTest = new OpenBrowserTest();
//        driver = openBrowserTest.getWebDriver("Chrome");
        js = (JavascriptExecutor)driver;
        driver.manage().window().maximize();
        driver.get(qqAddress);
        wait = new WebDriverWait(driver,3);
    }

//    注册QQ邮箱
    @Test
    public void RegisterTest() throws InterruptedException {
        driver.switchTo().frame("login_frame");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("switcher_plogin")));
        driver.findElement(By.id("switcher_plogin")).click();
        driver.findElement(By.id("u")).clear();
        driver.findElement(By.id("u")).sendKeys("email_"+getUser());
        Thread.sleep(2000);
        driver.findElement(By.id("p")).sendKeys("pw_"+getPwd());
        driver.findElement(By.id("p_low_login_enable")).click();
        driver.findElement(By.id("login_button")).click();
        if(StringUtils.isEmpty(driver.findElement(By.id("p")).getText())){
            Assert.assertTrue(true);
        }

    }
    //    用时间轴当用户名
    private String getUser(){
        return String.valueOf(System.currentTimeMillis());
    }

    //    用时间轴当手机号
    private String getPwd(){
        return String.valueOf(System.currentTimeMillis()/100);
    }
//    关闭浏览器
    @AfterMethod
    public void closeBroswer() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
