package com.example.demo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.flow.SplitFlow;
import com.example.demo.listener.ClearCacheJobExecutionListener;

@Configuration
@EnableBatchProcessing
public class MyJob {

	private JobBuilderFactory jobBuilderFactory; //para criar job com spring batch
	private ClearCacheJobExecutionListener clearCacheJobExecutionListener;	
	private SplitFlow splitFlow;	

    @Bean
    public Job job() {
        return jobBuilderFactory.get("job")
                .start(splitFlow.splitFlowExecution()).build()
                .listener(clearCacheJobExecutionListener)
                .build();
    }
	
	@Autowired
	public void setClearCacheJobExecutionListener(ClearCacheJobExecutionListener clearCacheJobExecutionListener) {
		this.clearCacheJobExecutionListener = clearCacheJobExecutionListener;
	}

	@Autowired
	public void setSplitFlow(SplitFlow splitFlow) {
		this.splitFlow = splitFlow;
	}
	
	@Autowired
	public void setJobBuilderFactory(JobBuilderFactory jobBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory;
	}
}