package com.impulse.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket testApi() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("version-api").apiInfo(this.apiInfo())
        .select().paths(this.testPath()).build().ignoredParameterTypes(ApiIgnore.class)
        .enableUrlTemplating(true);
  }

  private Predicate<String> testPath() {
    return regex("/version");
  }

  @Bean
  public Docket studentApi() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("student-api").apiInfo(this.apiInfo())
        .select().paths(this.studentPaths()).build().ignoredParameterTypes(ApiIgnore.class)
        .enableUrlTemplating(true);
  }

  private Predicate<String> studentPaths() {
    return or(regex("/student.*"), regex("/student"));
  }

  @Bean
  public Docket coursetApi() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("course-api").apiInfo(this.apiInfo())
        .select().paths(this.coursePaths()).build().ignoredParameterTypes(ApiIgnore.class)
        .enableUrlTemplating(true);
  }

  private Predicate<String> coursePaths() {
    return or(regex("/course.*"), regex("/course"));
  }


  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Open api using swagger.")
        .description("The sample project base on the spring boot and Its api show in swagger.")
        .termsOfServiceUrl("http://springfox.io").license("Apache License Version 2.0")
        .version("2.0").build();
  }
}
