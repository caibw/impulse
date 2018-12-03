package com.impulse.batch;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeJob;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.stereotype.Component;

@Component
public class PreJobRunner {
  private static final Logger log = LoggerFactory.getLogger(PreJobRunner.class);

  @BeforeJob
  public void beforeJob() {
    log.info("before job at:  {}", LocalDateTime.now());
  }

  @BeforeStep
  public void beforeStep() {
    log.info("before step at:  {}", LocalDateTime.now());
  }

  @AfterStep
  public void afterStep() {
    log.info("after step at:  {}", LocalDateTime.now());
  }

  @AfterJob
  public void afterJob() {
    log.info("after job at:  {}", LocalDateTime.now());
  }



}
