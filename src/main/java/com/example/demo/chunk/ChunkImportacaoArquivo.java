package com.example.demo.chunk;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.example.demo.dominio.Entrada;
import com.example.demo.listener.CachingMccStepExecutionListener;
import com.example.demo.processor.ValidacaoItemProcessor;
import com.example.demo.reader.ArquivoMassivaItemReader;
import com.example.demo.tasklet.MyTaskletCacheMcc;
import com.example.demo.write.ArmazenamentoItemWriter;

@Component
public class ChunkImportacaoArquivo {
	
	private StepBuilderFactory stepBuilderFactory;
	private ArquivoMassivaItemReader arquivoMassivaItemReader;
	private ValidacaoItemProcessor validacaoItemProcessor;
	private ArmazenamentoItemWriter armazenamentoItemWriter;
	
    public Step importarArquivoStep() {
      return stepBuilderFactory.get("importacaoArquivoStep")
          .<Entrada, Entrada>chunk(10)
          .reader(arquivoMassivaItemReader)
          .processor(validacaoItemProcessor)
          .writer(armazenamentoItemWriter.writerImprime())
          .build();
    }

	@Autowired
	public void setStepBuilderFactory(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory;
	}

	@Autowired
	public void setAircraftItemReader(ArquivoMassivaItemReader aircraftItemReader) {
		this.arquivoMassivaItemReader = aircraftItemReader;
	}

	@Autowired
	public void setAircraftItemProcessor(ValidacaoItemProcessor aircraftItemProcessor) {
		this.validacaoItemProcessor = aircraftItemProcessor;
	}

	@Autowired
	public void setAircraftItemWriter(ArmazenamentoItemWriter aircraftItemWriter) {
		this.armazenamentoItemWriter = aircraftItemWriter;
	}
}
