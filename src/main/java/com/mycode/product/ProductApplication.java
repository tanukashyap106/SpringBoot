package com.mycode.product;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@OpenAPIDefinition(
		info = @Info(
				title = "Product Service REST API documentation",
				description = "Product service REST API",
				version = "v1",
				contact = @Contact(
						name="Tanu Kashyap",
						email="tanu@gmail.com"

				)

		),
		externalDocs = @ExternalDocumentation(
				description = "sharepoint URL Product Service API",
				url = "example.com"
		)
)
@SpringBootApplication
@Slf4j
public class ProductApplication {
//	private static final Logger log = LoggerFactory.getLogger(ProductApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductApplication.class, args);

		String str = "test";
		log.info("Product Service {} started successfully!",str);
		/*log.warn("This is a warning message");
		log.debug("This is a debug message");
		log.error("This is an error message");
		log.trace("This is a trace message");*/



	}

}
