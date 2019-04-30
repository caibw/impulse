package com.impulse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.h2.H2ConsoleProperties;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Order(SecurityProperties.BASIC_AUTH_ORDER - 10)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  private H2ConsoleProperties console;

  @Override
  public void configure(final WebSecurity web) throws Exception {
    final String path = this.console.getPath();
    web.ignoring().antMatchers("/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html**",
        "/webjars/**", "/configuration/**", path + "/**", "/actuator/**");
    web.ignoring().antMatchers(HttpMethod.OPTIONS);


    super.configure(web);
  }

  // TBD....
  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    http.csrf().disable();
    super.configure(http);
  }


}
