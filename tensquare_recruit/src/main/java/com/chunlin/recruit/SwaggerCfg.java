package com.chunlin.recruit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerCfg {

	
	@Bean
	public Docket createestApi(){
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.chunlin.recruit.controller")).paths(PathSelectors.any()).build();
	}
	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
		// TODO Auto-generated method stub
		return new  ApiInfoBuilder().title("对外提供接口").contact("chunlinj").version("").description("Spring boot +Swagger2 构建的RESful API").build();
	}
}
