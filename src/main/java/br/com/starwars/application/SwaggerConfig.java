package br.com.starwars.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Star Wars Resistencia network")
        .description("Prover solução para auxiliar na conquista do imperio.")
        .contact(new Contact("Arthur Silva", null, "arthurclaudio19@gmail.com"))
        .version("1.0.0")
        .build();
  }

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("br.com.starwars.integration.endpoint"))
        .build()
        .apiInfo(apiInfo())
        .useDefaultResponseMessages(false);
  }
}
