package com.impulse.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.listener.JobListenerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchJobConfig {

  @Autowired
  private JobBuilderFactory jobs;

  @Autowired
  private StepBuilderFactory steps;

  @Autowired
  private JobRunner jobRunner;

  @Autowired
  private PreJobRunner delgate;

  @Bean
  protected JobExecutionListener listener() {
    final JobListenerFactoryBean factoryBean = new JobListenerFactoryBean();
    factoryBean.setDelegate(this.delgate);
    final JobExecutionListener listener = (JobExecutionListener) factoryBean.getObject();
    return listener;
  }

  @Bean
  public Job job() throws Exception {
    return this.jobs.get("job").listener(this.listener()).start(this.step1()).build();
  }

  @Bean
  protected Step step1() throws Exception {
    return this.steps.get("step1").listener(this.delgate).tasklet(this.jobRunner).build();
  }
}
