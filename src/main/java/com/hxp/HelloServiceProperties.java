package com.hxp;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author xinpeng.huo
 * @create 2020-06-14 11:31
 */
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {
    private String msg = "world";

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
