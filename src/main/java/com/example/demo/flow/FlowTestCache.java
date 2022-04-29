package com.example.demo.flow;

import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.step.StepTestCache;

@Component
public class FlowTestCache {
	
	private StepTestCache stepTestCache;

	public Flow flowTestCache() {
	    return new FlowBuilder<SimpleFlow>("flowTestCache")
	        .start(stepTestCache.stepTestCacheExecution())
	        .build();
	}

	@Autowired
	public void setStepTestCache(StepTestCache stepTestCache) {
		this.stepTestCache = stepTestCache;
	}	
	
	
}
