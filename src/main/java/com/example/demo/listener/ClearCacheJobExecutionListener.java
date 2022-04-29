package com.example.demo.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import com.example.demo.cache.ManagerCache;


@Component
public class ClearCacheJobExecutionListener implements JobExecutionListener {

    private ManagerCache managerCache;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        // populate cache as needed. Can use a jdbcTemplate to query the db here and populate the cache
        System.out.println("Iniciando Jon de Validação Massiva");
        
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        // clear cache when the job is finished
    	System.out.println("Clearning cache Produto");
    	managerCache.clearCache("cacheProduto");
        System.out.println("Clearning cache Parcela");
        managerCache.clearCache("cacheParcela");
        System.out.println("Clearning cache Mcc");
        managerCache.clearCache("cacheMcc");
    }

    @Autowired
	public void setManagerCache(ManagerCache managerCache) {
		this.managerCache = managerCache;
	}
}
