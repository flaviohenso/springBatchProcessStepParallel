package com.example.demo.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.example.demo.listener.CachingParcelaStepExecutionListener;
import com.example.demo.tasklet.MyTaskletCacheParcela;

@Component
public class StepCacheParcela {

	private StepBuilderFactory stepBuilderFactory;
	private MyTaskletCacheParcela myTaskletCacheParcela;
	private CachingParcelaStepExecutionListener cachingParcelaStepExecutionListener;
	
    public Step stepCacheParcelaLoading() {
        return stepBuilderFactory.get("stepCacheParcela")
                .tasklet(myTaskletCacheParcela)
                .listener(cachingParcelaStepExecutionListener)
                .build();
    }

	@Autowired
	public void setStepBuilderFactory(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory;
	}

	@Autowired
	public void setMyTaskletCacheParcela(MyTaskletCacheParcela myTaskletCacheParcela) {
		this.myTaskletCacheParcela = myTaskletCacheParcela;
	}

	@Autowired
	public void setCachingParcelaStepExecutionListener(
			CachingParcelaStepExecutionListener cachingParcelaStepExecutionListener) {
		this.cachingParcelaStepExecutionListener = cachingParcelaStepExecutionListener;
	}
	
	
}
