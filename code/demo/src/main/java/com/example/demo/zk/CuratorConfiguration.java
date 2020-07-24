package com.example.demo.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author mubi
 * @Date 2020/7/23 19:28
 */
@Component
public class CuratorConfiguration {

    @Bean(initMethod = "start")
    public CuratorFramework curatorFramework() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                "127.0.0.1:2181", retryPolicy);
        return client;
    }

}
