package com.dsy.junit;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MainTest {
    @Before
    public void init(){
        Long a = 1L;
    }

    @Test
    @Ignore("no reason")
    public void testAdd(){
        Long a = 1L;
        System.out.println(a);
    }

    @Test(timeout =  100)
    public void testSub(){}
}
