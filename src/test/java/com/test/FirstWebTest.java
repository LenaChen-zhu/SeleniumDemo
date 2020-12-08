package com.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FirstWebTest {
    private static ChromeDriver chromeDriver;
    public static void main(String[] args) throws InterruptedException {
        //设置Chrome浏览器驱动
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        //打开Chrome浏览器
        chromeDriver = new ChromeDriver();
        //打开www.baidu.com网址
        //chromeDriver.get("https://www.baidu.com");
        //设置全局隐式等待时间,全局生效，每个查找控件都起作用
        //chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //获取alert弹出框，使用了内部的html
        getAlert();
        //获取confirm弹出框，使用了内部的html
//        getConfirm();



    }

    public static void getId() throws InterruptedException{
        //通过id定位百度输入框并输入“Kong官网”
        //chromeDriver.findElementById("kw").sendKeys("Kong官网");
        chromeDriver.findElement(By.id("kw")).sendKeys("Kong官网");
        //停留1秒
        Thread.sleep(1000);
        //定位到百度button并且点击
        chromeDriver.findElement(By.id("su")).click();
    }

    public static void getName() throws InterruptedException{
        //通过name定位百度输入框并输入“腾讯视频”
        chromeDriver.findElement(By.name("wd")).sendKeys("腾讯视频");
        //chromeDriver.findElementByName("wd").sendKeys("腾讯视频");
        //停留1秒
        Thread.sleep(1000);
        //定位到百度button并且点击
        chromeDriver.findElement(By.id("su")).click();
    }

    public static void getClassName() throws InterruptedException{
        //通过classname定位百度输入框并输入“Java”
        chromeDriver.findElement(By.className("s_ipt")).sendKeys("Java");
        //chromeDriver.findElementByClassName("s_ipt").sendKeys("Java");
        Thread.sleep(1000);
        //定位到百度button并且点击
        chromeDriver.findElement(By.className("s_btn")).click();
    }

    public static void getNews() {
        //通过linktext定位到新闻
        chromeDriver.findElement(By.linkText("新闻")).click();
    }

    public static void getCssId() throws InterruptedException {
        //通过cssSelector定位到百度输入框 id
        chromeDriver.findElement(By.cssSelector("#kw")).sendKeys("CSSSelector");
        Thread.sleep(1000);
        //通过cssSelector定位到百度button id并点击
        chromeDriver.findElement(By.cssSelector("#su")).click();
    }

    public static void getCssClassName() throws InterruptedException{
        //通过cssSelector定位到百度输入框的classname
        chromeDriver.findElement(By.cssSelector(".s_ipt")).sendKeys("CssSelector-ClassName");
        Thread.sleep(1000);
        //通过cssSelector定位到button classname并点击
        chromeDriver.findElement(By.cssSelector(".bg.s_btn")).click();
    }

    public static void getCssprecise() throws InterruptedException{
        //通过cssSelector精确定位到百度输入框
        chromeDriver.findElement(By.cssSelector("input[name='wd']")).sendKeys("css精确定位");
        Thread.sleep(1000);
        chromeDriver.findElement(By.cssSelector("input[class='bg s_btn']")).click();
    }

    public static void getMutilCssprecise() throws InterruptedException{
        //通过cssSelector精确定位到百度输入框
        chromeDriver.findElement(By.cssSelector("input[maxlength='255'][autocomplete='off']")).sendKeys("css多属性定位");
        Thread.sleep(1000);
        chromeDriver.findElement(By.cssSelector("input[class='bg s_btn']")).click();
    }

    public static void getrelativeXpath() throws InterruptedException{
        //通过Xpath的相对路径来定位到百度输入框
        chromeDriver.findElement(By.xpath("//*[@name='wd']")).sendKeys("通过Xpath定位相对路径");
        Thread.sleep(1000);
        chromeDriver.findElement(By.xpath("//*[@class='bg s_btn']")).click();
    }

    public static void getrelativeXpathText(){
        //通过Xpath的相对路径来定位到百度输入框
        //chromeDriver.findElement(By.xpath("//a[text()='新闻']")).click();
        chromeDriver.findElement(By.xpath("//a[contains(text(),'闻')]")).click();
    }

    public static void getElements(){
        WebElement webElement1 = chromeDriver.findElement(By.xpath("//*[@name='wd']"));
        System.out.println("tagName is " + webElement1.getTagName());
        System.out.println("maxlength属性值为 " + webElement1.getAttribute("maxlength"));
        WebElement webElement2 = chromeDriver.findElement(By.xpath("//a[contains(text(),'闻')]"));
        System.out.println("文本名为 " + webElement2.getText());
        System.out.println("是否显示 " + webElement2.isDisplayed());
    }

    public static void closeWindow() throws InterruptedException {
        //通过name定位百度输入框并输入“腾讯视频”
        chromeDriver.findElement(By.name("wd")).sendKeys("腾讯视频");
        //定位到百度button并且点击
        chromeDriver.findElement(By.className("s_btn")).click();
        Thread.sleep(3000);
        //点击第一个链接
        chromeDriver.findElement(By.xpath("//a[text()='官方']")).click();
        Thread.sleep(3000);
        //关闭Chrome浏览器Tab页
        chromeDriver.close();
        //退出Chrome浏览器
        chromeDriver.quit();
    }

    public static void getManage() throws InterruptedException {
        //获取manager对象,浏览器菜单操作对象
        Options options = chromeDriver.manage();
        //将当前浏览器最大化
        options.window().fullscreen();
        Thread.sleep(2000);
        //通过name定位百度输入框并输入“腾讯视频”
        chromeDriver.findElement(By.name("wd")).sendKeys("腾讯视频");
        //定位到百度button并且点击
        chromeDriver.findElement(By.className("s_btn")).click();
        Thread.sleep(2000);
        //点击第一个链接
        chromeDriver.findElement(By.xpath("//a[text()='官方']")).click();
        System.out.println("x轴" + options.window().getPosition().x);
        System.out.println("y轴" + options.window().getPosition().y);
    }

    public static void getNavigate() throws InterruptedException{
        //获取navigate对象，浏览器控制对象
        Navigation navigation = chromeDriver.navigate();
        //进入到京东网页
        navigation.to("http://www.jd.com");
        Thread.sleep(2000);
        navigation.refresh();
        Thread.sleep(2000);
        navigation.back();
        Thread.sleep(2000);
        navigation.forward();
    }

    public static void getTimeout(){
        //通过name定位百度输入框并输入“腾讯视频”
        chromeDriver.findElement(By.name("wd")).sendKeys("腾讯视频");
        //定位到百度button并且点击
        chromeDriver.findElement(By.className("s_btn")).click();
        chromeDriver.findElement(By.xpath("//a[text()='官方']")).click();
    }

    public static void getWebDriverWait(){
        //通过name定位百度输入框并输入“腾讯视频”
        chromeDriver.findElement(By.name("wd")).sendKeys("腾讯视频");
        //定位到百度button并且点击
        chromeDriver.findElement(By.className("s_btn")).click();
        //首先new显示等待的对象
        WebDriverWait webDriverWait = new WebDriverWait(chromeDriver,20);
        //使用webDriverWait的api
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='官方']")));
        chromeDriver.findElement(By.xpath("//a[text()='官方']")).click();
    }

    public static void getAlert(){
        chromeDriver.get("D:\\project\\webauto\\src\\main\\resources\\template\\alert.html");
        //点击按钮
        chromeDriver.findElement(By.id("btn")).click();
        //获取alert弹出框
        Alert alert = chromeDriver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    public static void getConfirm(){
        chromeDriver.get("D:\\project\\webauto\\src\\main\\resources\\template\\confirm.html");
        //点击按钮
        chromeDriver.findElement(By.id("btn")).click();
        //获取confirm弹出框
        Alert alert = chromeDriver.switchTo().alert();
        alert.accept();
        //alert.dismiss();
    }





}
