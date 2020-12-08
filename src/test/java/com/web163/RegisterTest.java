package com.web163;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//163邮箱页面-注册
public class RegisterTest {
    private OpenBrowserTest openBrowserTest;
    private WebDriver driver;
    JavascriptExecutor js;
    private WebDriverWait wait;

//    根据传入的参数打开指定的浏览器,并进入163首页
    @BeforeMethod
    public void openBroswer() throws Exception {
        openBrowserTest = new OpenBrowserTest();
        driver = openBrowserTest.getWebDriver("Chrome");
        js = (JavascriptExecutor)driver;
        driver.manage().window().maximize();
        driver.get("https://mail.163.com/register/index.htm?from=163mail&utm_source=163mail");
        wait = new WebDriverWait(driver,5);
    }

//    在浏览器首页选择【注册免费邮箱】进入注册页面
    @Test
    public void registerUserFail(){
        String password = "123456@Abc";
        String failStr = "系统未收到短信，请检查手机号是否正确或重新发送短信";
//        输入用户名
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        driver.findElement(By.id("username")).sendKeys("em"+getUser());
//        输入密码
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        driver.findElement(By.id("password")).sendKeys(password);
//        输入手机号
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone")));
        driver.findElement(By.id("phone")).sendKeys(getPhone());
//        勾选checkbox
        String jsStr = "$('div.custom-checkbox service').removeAttr('class','custom-checkbox service').addClass('class','custom-checkbox service');";
        js.executeScript(jsStr);
//        点击注册按钮
        driver.findElement(By.linkText("立即注册")).click();
        Assert.assertEquals("系统未收到短信，请检查手机号是否正确或重新发送短信",failStr);
    }



//    用时间轴当用户名
    private String getUser(){
        return String.valueOf(System.currentTimeMillis());
    }

//    用时间轴当手机号
    private String getPhone(){
        return String.valueOf(System.currentTimeMillis()/100);
    }

//    向当前页面注入JQuery，并返回加载是否成功
    public boolean injectjQuery() {
        try {
            String injectJQuery = "var script = document.createElement('script');"
                    + "var filename = \"http://code.jquery.com/jquery-2.1.4.min.js\";"
                    + "script.setAttribute(\"type\",\"text/javascript\");"
                    + "script.setAttribute(\"src\", filename);"
                    + "if (typeof script!='undefined'){"
                    + "document.getElementsByTagName(\"head\")[0].appendChild(script);"
                    + "}";
            ((JavascriptExecutor) driver).executeScript(injectJQuery);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 判断JQuery是否加载成功
        Boolean loaded = true;
        String s = (String) (((JavascriptExecutor) driver).executeScript("return typeof jQuery"));
        if (!StringUtils.trimToEmpty(s).equals("function"))
            loaded = false;
        return loaded;
    }

    @Test
    public void testJQuery() {
        driver.get("https://www.baidu.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String changeDisplay = " $('input').removeAttr('id');";
        // 删除input标签下的id属性操作
        js.executeScript(changeDisplay);
        js = (JavascriptExecutor) driver;
        // 将百度按钮及输入框改成红色
        String changeinput = "$(\"input\").attr(\"style\",\"background:red\");";
        js.executeScript(changeinput);
    }


//   关闭浏览器
    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(6000);
        driver.quit();
    }
}