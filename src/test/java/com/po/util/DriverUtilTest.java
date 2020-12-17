package com.po.util;

import org.testng.annotations.Test;

public class DriverUtilTest {

    @Test
    public void openTest(){
        try {
            DriverUtil.open("Chrome");
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println("打开浏览器失败"+e.getMessage());
        }finally {
            DriverUtil.closeAll();
        }
    }
}
