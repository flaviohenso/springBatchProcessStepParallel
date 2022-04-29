package com.example.demo.flow;

import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.step.StepCacheParcela;

@Component
public class FlowCacheParcelas {
	
	private StepCacheParcela stepCacheParcela;

	public Flow flowCacheParcelas() {
	    return new FlowBuilder<SimpleFlow>("flowCacheParcelas")
	        .start(stepCacheParcela.stepCacheParcelaLoading())
	        .build();
	}

	@Autowired
	public void setStepCacheParcela(StepCacheParcela stepCacheParcela) {
		this.stepCacheParcela = stepCacheParcela;
	}
	
}
