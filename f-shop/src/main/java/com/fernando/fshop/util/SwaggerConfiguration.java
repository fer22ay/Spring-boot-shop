/**
 * 
 */
package com.fernando.fshop.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Clase para configurar Swagger para proyecto shop.
 * 
 * @author Fernando Ambrosio
 * @since 18 de marzo del 2020
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	public Docket documentation() {
		
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
				.build();
		
	}
	
}






