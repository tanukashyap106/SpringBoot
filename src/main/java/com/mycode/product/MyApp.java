package com.mycode.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MyApp {

    private final MyComponent myComponent;

    @Autowired
   public MyApp(MyComponent myComponent){
        this.myComponent = myComponent;
    }
    public void run(){
       myComponent.getMessage();

    }
}
