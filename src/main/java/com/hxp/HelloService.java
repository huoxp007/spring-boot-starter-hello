package com.hxp;

/**
 * @author xinpeng.huo
 * @create 2020-06-14 10:58
 */
public class HelloService {
    private String msg;

    public String hello() {
        return "hello " + msg;
    }

    public String hello2() {
        return "hello " + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
