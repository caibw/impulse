package com.impulse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.task.TaskSchedulingProperties;
import org.springframework.boot.task.TaskSchedulerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class ScheduledTaskConfig {
  @Autowired
  private TaskSchedulingProperties properties;

  @Bean
  public TaskSchedulerCustomizer taskSchedulerCustomizer() {
    return (taskScheduler) -> {
      taskScheduler.setPoolSize(this.properties.getPool().getSize());
      taskScheduler.setThreadNamePrefix(this.properties.getThreadNamePrefix());
      taskScheduler.afterPropertiesSet();
    };
  }
}
