package com.test;


import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class LogTest {
    private static Logger logger = Logger.getLogger(LogTest.class);

    @Test
    public void testDebugMsg(){
        logger.debug("log输出debug信息");
    }

    @Test
    public void testInfoMsg(){
        logger.info("log输出info信息");
    }

    @Test
    public void testWarnMsg(){
        logger.warn("log输出warn信息");
    }
    @Test
    public void testErrorMsg(){
        logger.error("log输出error信息");
    }

}
