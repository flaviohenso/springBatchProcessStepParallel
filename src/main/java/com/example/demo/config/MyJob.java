package com.example.demo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.chunk.ChunkImportacaoArquivo;
import com.example.demo.flow.SplitFlow;
import com.example.demo.listener.ClearCacheJobExecutionListener;

@Configuration
@EnableBatchProcessing
public class MyJob {

	private JobBuilderFactory jobBuilderFactory; //para criar job com spring batch
	private ClearCacheJobExecutionListener clearCacheJobExecutionListener;	
	private SplitFlow splitFlow;
	private ChunkImportacaoArquivo stepImportacaoArquivo; 

    @Bean
    public Job job() {
        return jobBuilderFactory.get("job")
        		.incrementer(new RunIdIncrementer())
                .start(splitFlow.splitFlowExecution())
                .next(stepImportacaoArquivo.importarArquivoStep())
                .build()
                .listener(clearCacheJobExecutionListener)
                .build();
    }
    
    
    
    @Autowired
	public void setStepImportacaoArquivo(ChunkImportacaoArquivo stepImportacaoArquivo) {
		this.stepImportacaoArquivo = stepImportacaoArquivo;
	}

	@Autowired
	public void setClearCacheJobExecutionListener(ClearCacheJobExecutionListener clearCacheJobExecutionListener) {
		this.clearCacheJobExecutionListener = clearCacheJobExecutionListener;
	}

	@Autowired
	public void setSplitFlow(SplitFlow splitFlow) {
		this.splitFlow = splitFlow;
	}
	
	@Autowired
	public void setJobBuilderFactory(JobBuilderFactory jobBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory;
	}
}