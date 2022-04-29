package com.example.demo.flow;

import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.step.StepCacheProduto;

@Component
public class FlowCacheProduto {

	private StepCacheProduto stepCacheProduto;
	 
	public Flow flowCacheProduto() {
	    return new FlowBuilder<SimpleFlow>("flowCacheProduto")
	        .start(stepCacheProduto.stepCacheProdutoLoading())
	        .build();
	}

	@Autowired
	public void setStepCacheProduto(StepCacheProduto stepCacheProduto) {
		this.stepCacheProduto = stepCacheProduto;
	}
}
