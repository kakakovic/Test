package com.dsy.enums;

import com.alibaba.fastjson.JSON;

public class Main {
    public static void main(String[] args) {
        A a = A.B;
        System.out.println(JSON.toJSONString(a));
        String json = "\"C\"";
        A b = JSON.parseObject(json, A.class);
    }
}
