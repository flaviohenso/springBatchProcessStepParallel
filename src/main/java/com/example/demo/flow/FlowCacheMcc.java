package com.example.demo.flow;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.step.StepCacheMcc;

@Component
public class FlowCacheMcc {

	private StepCacheMcc stepCacheMcc;
	
	public Flow flowCacheMcc() {
	    return new FlowBuilder<SimpleFlow>("flowCacheMcc")
	        .start(stepCacheMcc.stepCacheMccLoading())
	        .build();
	}

	@Autowired
	public void setStepCacheMcc(StepCacheMcc stepCacheMcc) {
		this.stepCacheMcc = stepCacheMcc;
	}	
}
