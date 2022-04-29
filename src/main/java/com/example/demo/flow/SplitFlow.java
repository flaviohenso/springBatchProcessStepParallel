package com.example.demo.flow;

import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.flow.executor.TaskExecutorFlow;

@Component
public class SplitFlow {
	
	private TaskExecutorFlow taskExecutorFlow;
	
	private FlowCacheProduto flowCacheProduto;
	private FlowCacheParcelas flowCacheParcelas;
	private FlowCacheMcc flowCacheMcc;
	private FlowTestCache flowTestCache;

	public Flow splitFlowExecution() {
	    return new FlowBuilder<SimpleFlow>("splitFlow")
	        .split(taskExecutorFlow.taskExecutor())
	        .add(flowCacheProduto.flowCacheProduto(), flowCacheParcelas.flowCacheParcelas(), flowCacheMcc.flowCacheMcc())
	        .next(flowTestCache.flowTestCache())
	        .build();
	}
	
	@Autowired
	public void setFlowCacheProduto(FlowCacheProduto flowCacheProduto) {
		this.flowCacheProduto = flowCacheProduto;
	}

	@Autowired
	public void setFlowCacheParcelas(FlowCacheParcelas flowCacheParcelas) {
		this.flowCacheParcelas = flowCacheParcelas;
	}

	@Autowired
	public void setFlowCacheMcc(FlowCacheMcc flowCacheMcc) {
		this.flowCacheMcc = flowCacheMcc;
	}

	@Autowired
	public void setFlowTestCache(FlowTestCache flowTestCache) {
		this.flowTestCache = flowTestCache;
	}
	
	@Autowired
	public void setTaskExecutorFlow(TaskExecutorFlow taskExecutorFlow) {
		this.taskExecutorFlow = taskExecutorFlow;
	}
}
