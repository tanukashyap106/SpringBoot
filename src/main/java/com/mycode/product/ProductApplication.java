package com.mycode.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductApplication.class, args);
		//MyComponent myComponent = context.getBean(MyComponent.class);
		//myComponent.getMessage();
		//MyApp myComponent = context.getBean(MyApp.class);
		//myComponent.run();


	}

}
