package com.dsy.util;

import org.apache.lucene.util.RamUsageEstimator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class MemoryUtils {
    public static void main(String[] args) {
    }

    /**
     * 添加自定义条件
     */
    private <T> void addCriterion(T criteria, String condition) {
        Method method;
        try {
            method = criteria.getClass().getSuperclass().getDeclaredMethod("addCriterion", String.class);
            method.setAccessible(true);
            method.invoke(criteria, condition);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(" add criterion error condition=[" + condition + "]");
        }
    }
}
