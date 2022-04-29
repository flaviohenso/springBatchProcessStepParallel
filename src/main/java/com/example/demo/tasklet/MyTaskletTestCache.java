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
import com.example.demo.dominio.Pessoa;

@Component
public class MyTaskletTestCache implements Tasklet {

	private ManagerCache managerCache;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		//System.out.println("Depois que carregou as cache: " + (String) cacheManager.getCache("cacheProduto").get("PRODUTO").get());
		Pessoa pessoa = (Pessoa) managerCache.getCacheManager().getCache("cacheProduto").get(new Chave(1l, "PRODUTO").toString()).get();
		System.out.println("Depois que carregou as cache: " + pessoa.getNome());
		return null;
	}

	@Autowired
	public void setManagerCache(ManagerCache managerCache) {
		this.managerCache = managerCache;
	}

}
