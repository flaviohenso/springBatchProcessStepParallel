package com.example.demo.processor;

import java.util.Optional;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.example.demo.cache.ManagerCache;
import com.example.demo.dominio.Chave;
import com.example.demo.dominio.Entrada;
import com.example.demo.dominio.Pessoa;

@Component
public class ValidacaoItemProcessor implements ItemProcessor<Entrada, Entrada> {

	@Override
	public Entrada process(final Entrada aircraft) {
		
		String recordKey = !StringUtils.isEmpty(aircraft.getIataCode()) ? aircraft.getIataCode()
				: aircraft.getIcaoCode();
		if (StringUtils.isEmpty(recordKey)) {
			return null;
		} else {
			aircraft.setRecordKey(recordKey);
			aircraft.setIataCode(Optional.ofNullable(aircraft.getIataCode()).map(String::toUpperCase).orElse(null));
			aircraft.setIcaoCode(Optional.ofNullable(aircraft.getIcaoCode()).map(String::toUpperCase).orElse(null));
			return aircraft;
		}
	}
}
