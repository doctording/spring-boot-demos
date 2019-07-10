package com.example.demo.api.controller;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * @Author mubi
 * @Date 2019/6/5 5:56 PM
 */
//@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(TestControl.class);
    }
}