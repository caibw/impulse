package com.impulse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class ImpulseApplication {
  public static void main(final String[] args) {
    SpringApplication.run(ImpulseApplication.class, "--debug");
  }

}
