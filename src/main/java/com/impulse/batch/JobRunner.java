package com.impulse.batch;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.CallableTaskletAdapter;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class JobRunner extends CallableTaskletAdapter {
  private static final Logger log = LoggerFactory.getLogger(JobRunner.class);

  final Callable<RepeatStatus> callable = () -> {
    log.info("callable executed:  {}", LocalDateTime.now());
    return RepeatStatus.FINISHED;
  };

  public JobRunner() {
    super();
    super.setCallable(this.callable);
  }

  @Override
  public RepeatStatus execute(final StepContribution contribution, final ChunkContext chunkContext)
      throws Exception {
    log.info("job setp executed:  {}", LocalDateTime.now());
    return super.execute(contribution, chunkContext);
  }

}
