package com.dsy.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Concurrent {
    public static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        map.put("1", "1");
        new Thread(new Runnable() {
            @Override
            public void run() {
                map.remove("1");
                map.put("1", "2");
                System.out.println(map.size());
            }
        }).start();
        Thread.sleep(3000);
        if (map.size() == 0){
            System.exit(0);
        }
        System.out.println(map.get("1"));
        System.out.println(1);
    }
}
