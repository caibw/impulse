package com.impulse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.h2.H2ConsoleProperties;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SpringConfig {

  @Configuration
  @Order(SecurityProperties.BASIC_AUTH_ORDER - 10)
  public static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private H2ConsoleProperties console;

    @Override
    public void configure(final WebSecurity web) throws Exception {
      final String path = this.console.getPath();
      web.ignoring().antMatchers("/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html**",
          "/webjars/**", "/configuration/**", path + "/**");
      super.configure(web);
    }

  }
}
