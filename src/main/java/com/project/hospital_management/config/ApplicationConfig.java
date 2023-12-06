package com.project.hospital_management.config;
//url of swagger : http://localhost:8080/swagger-ui.html#
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {
@Bean
    public Docket getDocket() {
	Contact contact=new Contact("Sanjog Harinkhede", "https://www.hospitalManagement.com", "hospitalmanage@gmail.com");
	List<VendorExtension> vendorExtensions=new ArrayList<VendorExtension>();
	ApiInfo apiInfo=new ApiInfo("Hospital Management", "This application is built to better manage the routine need of the hospital",
		"0.0.0.0.1", "---FREE OF COST--- Just Buy A coffee For Me", contact, "ISO2100", "https://www.isoCertification.co.in/2100/fake", vendorExtensions);
    return new Docket(DocumentationType.SWAGGER_2).select()
	    .apis(RequestHandlerSelectors.basePackage("com.project.hospital_management")).build().apiInfo(apiInfo).useDefaultResponseMessages(false);
    }
}
