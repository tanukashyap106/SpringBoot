package com.mycode.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {
    @Bean
    public MyComponent myComponent(){
        return new MyComponent();
    }
}
