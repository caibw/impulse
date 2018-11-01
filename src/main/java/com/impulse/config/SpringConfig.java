package com.impulse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringConfig {

  @Bean
  public WebSecurityConfigurerAdapter webSecurityConfiguration() {
    return new WebSecurityConfigurerAdapter() {
      @Override
      public void configure(final WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html**",
            "/webjars/**");
      }
    };
  }

}
