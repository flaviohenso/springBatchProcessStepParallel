package com.example.demo.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import com.example.demo.cache.ManagerCache;
import com.example.demo.dominio.Chave;

@Component
public class CachingMccStepExecutionListener implements StepExecutionListener {

        private ManagerCache managerCache;

		@Override
		public void beforeStep(StepExecution stepExecution) {
			// populate cache as needed. Can use a jdbcTemplate to query the db here and populate the cache
			//managerCache.getCache("cacheMcc").put("MCC", "Carregando Cache MCC");
			managerCache.builderCache("cacheMcc", new Chave(1l, "MCC").toString(), "Carregando Cache MCC");
		}

		@Override
		public ExitStatus afterStep(StepExecution stepExecution) {
			 // clear cache when the job is finished
            //cacheManager.getCache("cacheMcc").clear();
            System.out.println("Afert Job");
			return ExitStatus.COMPLETED;
		}

		@Autowired
		public void setManagerCache(ManagerCache managerCache) {
			this.managerCache = managerCache;
		}
    }