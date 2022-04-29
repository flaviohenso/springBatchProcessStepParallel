package com.example.demo.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.example.demo.listener.CachingProdutoStepExecutionListener;
import com.example.demo.tasklet.MyTaskletCacheProduto;

@Component
public class StepCacheProduto {

	private StepBuilderFactory stepBuilderFactory;
	private MyTaskletCacheProduto myTaskletCacheProduto;
	private CachingProdutoStepExecutionListener cachingProdutoStepExecutionListener;

    public Step stepCacheProdutoLoading() {
        return stepBuilderFactory.get("stepCacheProduto")
                .tasklet(myTaskletCacheProduto)
                .listener(cachingProdutoStepExecutionListener)
                .build();
    }

	@Autowired
	public void setStepBuilderFactory(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory;
	}

	@Autowired
	public void setMyTaskletCacheProduto(MyTaskletCacheProduto myTaskletCacheProduto) {
		this.myTaskletCacheProduto = myTaskletCacheProduto;
	}

	@Autowired
	public void setCachingProdutoStepExecutionListener(
			CachingProdutoStepExecutionListener cachingProdutoStepExecutionListener) {
		this.cachingProdutoStepExecutionListener = cachingProdutoStepExecutionListener;
	}
	
}
