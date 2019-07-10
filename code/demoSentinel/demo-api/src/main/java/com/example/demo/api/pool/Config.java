package com.example.demo.api.pool;

/**
 * @Author mubi
 * @Date 2019/6/4 2:46 PM
 */
public class Config {
    static int httpConnectTimeout = 3000;

    static int httpSocketTimeout = 3000;

    static int httpMaxPoolSize = 100;

    static int httpMonitorInterval = 3000;

    static int httpIdelTimeout = 2000;

    public static int getHttpIdelTimeout() {
        return httpIdelTimeout;
    }

    public static int getHttpSocketTimeout() {
        return httpSocketTimeout;
    }

    public static int getHttpMaxPoolSize() {
        return httpMaxPoolSize;
    }

    public static int getHttpMonitorInterval() {
        return httpMonitorInterval;
    }

    public static int getHttpConnectTimeout() {
        return httpConnectTimeout;
    }

}
