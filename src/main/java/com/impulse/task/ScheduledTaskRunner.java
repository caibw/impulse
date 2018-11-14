package com.impulse.task;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

@Component
public class ScheduledTaskRunner {
  private static final Logger log = LoggerFactory.getLogger(ScheduledTaskRunner.class);

  @Scheduled(fixedRate = 5000)
  public void reportCurrentTime() {
    log.info("The time {}, in fixedRate, and thread name {}", LocalDateTime.now(),
        Thread.currentThread().getName());
  }

}


