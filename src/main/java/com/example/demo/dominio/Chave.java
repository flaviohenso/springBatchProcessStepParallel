package com.example.demo.dominio;

public class Chave {

	private long id;
	private String tipo;
	
	public Chave(long id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Chave [id=" + id + ", tipo=" + tipo + "]";
	}
	
	
}
