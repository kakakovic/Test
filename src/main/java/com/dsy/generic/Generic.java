package com.dsy.generic;

import com.dsy.demo.Fruit;
import com.dsy.demo.*;

public class Generic {
    private boolean handleMessage(){
        Plate<? extends Fruit> plate = new Plate<>();
        Box<? extends Fruit> box = new Box<>();

        plate.handle(box);
        return false;
    }

}
