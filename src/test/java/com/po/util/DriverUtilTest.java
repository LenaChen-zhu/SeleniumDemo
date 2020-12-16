package com.po.util;

import org.testng.annotations.Test;

public class DriverUtilTest {

    @Test
    public void openTest() throws Exception {
        DriverUtil.open("Chrome");
        Thread.sleep(2000);
        DriverUtil.closeAll();
    }
}
