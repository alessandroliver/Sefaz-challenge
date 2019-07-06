package br.com.desafiosefaz;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "telefones")
public class Telefones {
	
	private int ddd;
	private String numero;
	private String tipo;
	
	public Telefones(int ddd, String numero, String tipo) {
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
	}
	
	public int getDdd() {
		return ddd;
	}
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
