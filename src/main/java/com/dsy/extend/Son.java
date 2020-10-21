package com.dsy.extend;

import javax.crypto.spec.PSource;

public class Son extends Father{
    public static void main(String[] args) {
        String x = "ttt.sdfa";
        String[] xxx = x.split("\\.");
        System.out.println(x.split("."));
        Son son = new Son();
        son.s();
    }

    void s(){
        this.a();
        super.a();
    }

    void a(){
        System.out.println(123);
    }
}
