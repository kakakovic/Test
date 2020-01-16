package com.dsy.springTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Order(1)
public class G {
    @Autowired
    private F f;

    @PostConstruct
    public void init(){
        f.init();
        System.out.println(3);
    }
}
