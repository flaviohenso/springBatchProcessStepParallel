package com.example.demo.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import com.example.demo.cache.ManagerCache;
import com.example.demo.dominio.Chave;

@Component
public class MyTaskletCacheMcc implements Tasklet {

    private ManagerCache managerCache;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println((String) managerCache.getCacheManager().getCache("cacheMcc").get(new Chave(1l, "MCC").toString()).get());
        return RepeatStatus.FINISHED;
    }

    @Autowired
	public void setManagerCache(ManagerCache managerCache) {
		this.managerCache = managerCache;
	}
}