package com.example.demo.dominio;

import java.io.Serializable;

public class Entrada implements Serializable {

	private static final long serialVersionUID = 9058350955651091145L;

	private String recordKey;

	private String name;

	private String iataCode;

	private String icaoCode;

	public String getRecordKey() {
		return recordKey;
	}

	public void setRecordKey(String recordKey) {
		this.recordKey = recordKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	public String getIcaoCode() {
		return icaoCode;
	}

	public void setIcaoCode(String icaoCode) {
		this.icaoCode = icaoCode;
	}

	@Override
	public String toString() {
		return "Aircraft [recordKey=" + recordKey + ", name=" + name + ", iataCode=" + iataCode + ", icaoCode="
				+ icaoCode + "]";
	}

}