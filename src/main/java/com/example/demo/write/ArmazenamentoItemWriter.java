package com.example.demo.write;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.example.demo.dominio.Entrada;

@Component
public class ArmazenamentoItemWriter {

	public ItemWriter<Entrada> writerImprime() {
		return itens -> itens.forEach(item ->
				System.out.println(item)
				);
	}

}
