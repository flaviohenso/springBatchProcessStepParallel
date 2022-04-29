package com.example.demo.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.example.demo.tasklet.MyTaskletTestCache;

@Component
public class StepTestCache {

	private StepBuilderFactory stepBuilderFactory;
	private MyTaskletTestCache myTaskletTestCache;
	
    public Step stepTestCacheExecution() {
        return stepBuilderFactory.get("stepTestCache")
                .tasklet(myTaskletTestCache)
                .build();
    }

	@Autowired
	public void setStepBuilderFactory(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory;
	}

	@Autowired
	public void setMyTaskletTestCache(MyTaskletTestCache myTaskletTestCache) {
		this.myTaskletTestCache = myTaskletTestCache;
	}
	
	
	
}
