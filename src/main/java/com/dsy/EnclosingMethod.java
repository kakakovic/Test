package com.dsy;

/**
 * @author siye.dsy
 */
public class EnclosingMethod {
    public static void main(String[] args) {
        System.out.println(new Object(){}.getClass().getEnclosingMethod());
    }
}
