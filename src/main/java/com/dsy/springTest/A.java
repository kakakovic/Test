//package com.dsy.springTest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//
//@Order(1)
//@Component
//public class A {
//    static int sssss;
//
//    @PostConstruct
//    public void init(){
//        sssss = 16;
//        DB b = BeanUtils.getBean(DB.class);
//        b.bbbb();
//    }
//
//    void a(){
//        System.out.println(1);
//    }
//}