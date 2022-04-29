package com.example.demo.mapper;

import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

import com.example.demo.dominio.Entrada;

public class AircraftFieldSetMapper implements FieldSetMapper<Entrada> {
	 
	  public Entrada mapFieldSet(FieldSet fieldSet) throws ParseException {
	    Entrada aircraft = new Entrada();
	    aircraft.setIataCode(fieldSet.readString(0));
	    aircraft.setIcaoCode(fieldSet.readString(1));
	    aircraft.setName(fieldSet.readString(2));
	    return aircraft;
	  }
	}
