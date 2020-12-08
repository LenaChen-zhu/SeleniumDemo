package com.test;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class FindElementsTest {
    ChromeDriver chromeDriver;

    @BeforeMethod
    public void openChrome() throws InterruptedException {
//        设置Chrome浏览器驱动
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
//        打开Chrome浏览器
        chromeDriver = new ChromeDriver();
    }

 /*   1.打开百度网址
    2.停留1秒
    3.再输入狂输入"selenium"
    4.停留1秒
    5.点击【百度一下】按钮
    6.停留2秒
    7.获取新页面第一个链接文本
    8.Assert一下实际值和预期值*/
    @Test
    public void sendKeysTest() throws InterruptedException{
        String expectedStr="Selenium automates browsers. That's it!";
        chromeDriver.get("https://www.baidu.com");
        Thread.sleep(1000);
        chromeDriver.findElement(By.id("kw")).sendKeys("selenium");
        Thread.sleep(1000);
        chromeDriver.findElement(By.id("su")).click();
        Thread.sleep(2000);
        String acutalText = chromeDriver.findElement(By.xpath("//*[@id=\"1\"]/h3/a[1]")).getText();
//        System.out.println("获取的实际文本为："+acutalText);
        Assert.assertEquals(expectedStr,acutalText);
       /* if(expectedStr.contains(acutalText)){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }*/
    }

/*    1.打开百度网址
    2.停留1秒
    3.获取输入框的tagname
    4.断言tagname是否是input*/
    @Test
    public void getTagName() throws InterruptedException {
        chromeDriver.get("https://www.baidu.com");
        Thread.sleep(1000);
        String tagname = chromeDriver.findElementById("kw").getTagName();
        Assert.assertEquals("input",tagname);
    }

/*    1.打开百度网址
    2.停留1秒
    3.获取【百度一下】按钮的attribute
    4.断言attribute的值是否是“百度一下”*/
    @Test
    public void getAttribute() throws InterruptedException {
        chromeDriver.get("https://www.baidu.com");
        Thread.sleep(1000);
        String attribute = chromeDriver.findElementById("su").getAttribute("value");
        Assert.assertEquals("百度一下",attribute);
    }

   /* 1.打开百度网址
    2.停留1秒
    3.获取【百度一下】按钮是否显示
    4.判断【百度一下】按钮是否显示*/
    @Test
    public void isDisplay() throws InterruptedException{
        chromeDriver.get("https://www.baidu.com");
        Thread.sleep(1000);
        boolean displayed = chromeDriver.findElementById("su").isDisplayed();
        Assert.assertTrue(displayed);
    }

/*    1.打开百度网址
    2.停留2秒
    3.截取百度首页图片
    4.保存到D:\project文件夹下*/
    @Test
    public void getScreen() throws InterruptedException {
        chromeDriver.get("https://www.baidu.com");
        Thread.sleep(2000);
//        截取百度图片
        File screenFile = ((TakesScreenshot)chromeDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenFile,new File("D:\\project\\picture\\baidu.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/*    1.打开本地select.html文件
    2.定位到下拉框位置
    3.new一个Select对象
    4.通过select对象的索引方法选择vivo
    5.通过select对象的value方法选择huwei
    6.通过select对象的text方法选择iphone*/
    @Test
    public void getSelect() throws InterruptedException{
        chromeDriver.get("D:\\project\\webauto\\src\\main\\resources\\template\\select.html");
        Thread.sleep(1000);
        WebElement selectElement = chromeDriver.findElement(By.id("moreSelect"));
        Select select = new Select(selectElement);
//        通过select对象的索引方法选择vivo
        select.selectByIndex(2);
        Thread.sleep(2000);
//        通过select对象的value方法选择huwei
        select.selectByValue("huawei");
        Thread.sleep(2000);
//        通过select对象的text方法选择iphone
        select.selectByVisibleText("iphone");
    }

/*    1.打开百度首页
    2.定位到百度按钮
    3.显示等待2秒
    4.new Actions对象
    5.使用Action的右键单击功能*/
    @Test
    public void testRightClick() throws InterruptedException {
        chromeDriver.get("https://www.baidu.com");
        WebElement element = chromeDriver.findElement(By.id("su"));
//        显示等待
        WebDriverWait wait = new WebDriverWait(chromeDriver,2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("su")));
//        new鼠标事件的Actions
        Actions action = new Actions(chromeDriver);
        action.contextClick(element).build().perform();
    }

  /*  1.打开百度首页
    2.new Actions对象
    3.定位到百度按钮
    4.显示等待1分钟
    3.使用Action的双击功能*/
    @Test
    public void testDoubleClick() throws InterruptedException {
        chromeDriver.get("https://www.baidu.com");
        chromeDriver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement element = chromeDriver.findElement(By.xpath("//*[@id='su']"));
//        显示等待
        WebDriverWait wait = new WebDriverWait(chromeDriver,2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='su']")));
//        new鼠标事件的Actions
        Actions action = new Actions(chromeDriver);
        action.doubleClick(element).build().perform();
        Thread.sleep(1000);
    }
/*    1.打开select.html
    2.new Actions对象
    3.按住Shift键选择前3个选项*/
    @Test
    public void testShiftSelect() throws InterruptedException {
        chromeDriver.get("D:\\project\\webauto\\src\\main\\resources\\template\\select.html");
//        定位多选框
        WebElement select = chromeDriver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        //显示等待
        WebDriverWait wait = new WebDriverWait(chromeDriver,2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectWithMultipleEqualsMultiple")));
//        取出多选框的内容
        List<WebElement> elementList = chromeDriver.findElements(By.xpath("//*[@id='selectWithMultipleEqualsMultiple']/option"));
        Actions mouse = new Actions(chromeDriver);
        mouse.keyDown(Keys.SHIFT).click(elementList.get(0)).click(elementList.get(2)).keyUp(Keys.SHIFT).release().perform();
        Thread.sleep(2000);
    }

/*    1.打开select.html
    2.new Actions对象
    3.按住Shift键选择前3个选项*/
    @Test
    public void testCtrlSelect() throws InterruptedException {
        chromeDriver.get("D:\\project\\webauto\\src\\main\\resources\\template\\select.html");
//        定位多选框
        WebElement select = chromeDriver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        //显示等待
        WebDriverWait wait = new WebDriverWait(chromeDriver,2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectWithMultipleEqualsMultiple")));
//        取出多选框的内容
        List<WebElement> elementList = chromeDriver.findElements(By.xpath("//*[@id='selectWithMultipleEqualsMultiple']/option"));
        Actions mouse = new Actions(chromeDriver);
        mouse.keyDown(Keys.CONTROL).click(elementList.get(0)).click(elementList.get(2)).keyUp(Keys.CONTROL).release().perform();
        Thread.sleep(2000);
    }

   /* 1.打开百度网址
    2.使用java本身的robot类模拟键盘操作
    3.保存当前html页到默认位置*/
    @Test
    public void testRobotSaveHtml() throws InterruptedException {
        chromeDriver.get("https://www.baidu.com");
        Thread.sleep(2000);
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_S);
            robot.keyRelease(KeyEvent.VK_S);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);
            Thread.sleep(1000);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_DOWN);
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    /* 1.打开百度网址
     2.使用java本身的robot类模拟键盘操作
     3.保存到autoit3设置的路径
     可能是autoit3脚本不对，哎*/
    @Test
    public void testRobotAutoitSaveHtml() throws AWTException, InterruptedException {
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://www.baidu.com");

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(1000);

        //使用第三方控件autoit3，但是不起作用
        try {
            Runtime.getRuntime().exec("D:\\autoit3\\Aut2Exe\\Aut2Exe.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/*    1.打开百度网址
    2.使用Chrome配置对象option把当前页面保存到指定目录
    不起作用，哎*/
    @Test
    public void testChromeOption() throws AWTException, InterruptedException {
        String downloadsPath="D:\\dataSource\\baidu.html";
        HashMap<String,Object> chromePrefsc  = new HashMap<String, Object>();
        chromePrefsc.put("profile.default_content_settings.popus",2);
        chromePrefsc.put("download.default_directory",downloadsPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs",chromePrefsc);
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.baidu.com");

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_DOWN);
        driver.quit();
    }

/*    1.打开百度网页
    2.把chromeDriver变成JS对象
    3.使用JS对象的方法，在输入框里面输入信息*/
    @Test
    public void testJS() throws InterruptedException {
        chromeDriver.get("https://www.baidu.com");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)chromeDriver;
        javascriptExecutor.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"selenium\")");
        Thread.sleep(2000);
    }


    @AfterMethod
    public void closeChrome() throws InterruptedException {
        Thread.sleep(1000);
        chromeDriver.quit();
    }

}
