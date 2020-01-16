package com.dsy.guava;

import com.google.common.cache.CacheBuilder;
import org.apache.lucene.util.RamUsageEstimator;
import org.springframework.scheduling.annotation.Scheduled;

import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Cache {
    private static com.google.common.cache.Cache<Integer, String> materialCache = CacheBuilder.newBuilder().
        recordStats().maximumSize(30000L).expireAfterAccess(3L, TimeUnit.HOURS).build();

    private static Map<Integer, String> cache = new HashMap<>();

    public static void main(String[] args) {
        Object a = new ArrayList<String>();
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedRate = 1000)
    public static void help(){
        System.out.println(111);
    }
}

