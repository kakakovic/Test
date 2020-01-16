package com.dsy.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Concurrent2 {
    public static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (map.size() == 0){
                    i++;
                    //System.out.println(i);
                }
            }
        }).start();

        Thread.sleep(3000);
        map.put("1","1");
    }
}
