package com.example.demo.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.example.demo.dominio.Entrada;
import com.example.demo.mapper.AircraftFieldSetMapper;

@Component
public class ArquivoMassivaItemReader extends FlatFileItemReader<Entrada> {
 
  public ArquivoMassivaItemReader() {
    DefaultLineMapper<Entrada> defaultLineMapper = new DefaultLineMapper<>();
    defaultLineMapper.setLineTokenizer(new DelimitedLineTokenizer(";"));
    defaultLineMapper.setFieldSetMapper(new AircraftFieldSetMapper());
    this.setLineMapper(defaultLineMapper);
    this.setResource(new ClassPathResource("massa.csv"));
  }
}