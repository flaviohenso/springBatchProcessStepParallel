package com.example.demo.flow.executor;

import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class TaskExecutorFlow {
	
	public TaskExecutor taskExecutor() {
	    return new SimpleAsyncTaskExecutor("spring_batch");
    }

}
