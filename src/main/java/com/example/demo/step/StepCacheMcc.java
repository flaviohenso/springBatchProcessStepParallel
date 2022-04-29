package com.example.demo.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.example.demo.listener.CachingMccStepExecutionListener;
import com.example.demo.tasklet.MyTaskletCacheMcc;

@Component
public class StepCacheMcc {
	
	private StepBuilderFactory stepBuilderFactory;
	private CachingMccStepExecutionListener cachingMccStepExecutionListener;
	private MyTaskletCacheMcc myTaskletCacheMcc;
	
    public Step stepCacheMccLoading() {
        return stepBuilderFactory.get("stepCacheMcc")
                .tasklet(myTaskletCacheMcc)
                .listener(cachingMccStepExecutionListener)
                .build();
    }

	@Autowired
	public void setStepBuilderFactory(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory;
	}

	@Autowired
	public void setCachingMccStepExecutionListener(CachingMccStepExecutionListener cachingMccStepExecutionListener) {
		this.cachingMccStepExecutionListener = cachingMccStepExecutionListener;
	}

	@Autowired
	public void setMyTaskletCacheMcc(MyTaskletCacheMcc myTaskletCacheMcc) {
		this.myTaskletCacheMcc = myTaskletCacheMcc;
	}
	
	
}
