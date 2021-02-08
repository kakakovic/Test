package com.dsy.springTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("g")
public class F {
    @Autowired
    private G g;

    public void init(){
        if (g == null){
            System.out.println(1);
        }
        System.out.println(2);
    }

    void f(){
        System.out.println("ffff");
    }
}
