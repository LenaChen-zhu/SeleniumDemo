package com.po.page;

import org.openqa.selenium.By;


public class LoginPage {
    //获取账户密码登录链接
    public By getUserPwd = By.id("switcher_plogin");
    //获取邮箱名输入框
    public By getEmailName = By.id("u");
    //获取邮箱密码输入框
    public By getEmailPwd = By.id("p");
    //获取登录按钮
    public By getLoginBtn = By.id("login_button");
    //获取退出按钮
    public By exitBtn = By.linkText("退出");
}
