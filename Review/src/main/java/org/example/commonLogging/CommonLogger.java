package org.example.commonLogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Date: 2022/12/20
 * @Author: LTisme
 * @ClassName: CommonLogger
 * @Description: --->
 */

public class CommonLogger {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonLogger.class);

    public void PrintError(String msg){
        LOGGER.error(msg);
    }
    public void PrintWarn(String msg){
        LOGGER.warn(msg);
    }
    public void PrintInfo(String msg){
        LOGGER.info(msg);
    }
    public void PrintDebug(String msg){
        LOGGER.debug(msg);
    }
    public void PrintTrace(String msg){
        LOGGER.trace(msg);
    }

    public static void main(String[] args) {
        //打印日志信息
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.trace("trace");
    }
}
