package com.example.demo.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.cache.ManagerCache;
import com.example.demo.dominio.Chave;

@Component
public class CachingParcelaStepExecutionListener implements StepExecutionListener {

    private ManagerCache managerCache;

    @Override
	public void beforeStep(StepExecution stepExecution) {
		// populate cache as needed. Can use a jdbcTemplate to query the db here and populate the cache
    	managerCache.builderCache("cacheParcela",new Chave(1l, "PARCELA").toString(), "Carregando Cache Parcela");

	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		 // clear cache when the job is finished
        //cacheManager.getCache("cacheParcela").clear();
        System.out.println("Afert Job");
		return ExitStatus.COMPLETED;
	}

	@Autowired
	public void setManagerCache(ManagerCache managerCache) {
		this.managerCache = managerCache;
	}

}