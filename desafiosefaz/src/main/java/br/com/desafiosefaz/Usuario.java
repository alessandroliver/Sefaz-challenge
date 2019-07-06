package br.com.desafiosefaz;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "usuario")
public class Usuario {
	
	private String nome;
	private String email;
	private String senha;
	private ArrayList<Telefones> telefones;
	
	public Usuario(String nome, String email, String senha, ArrayList<Telefones> telefones) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefones = telefones;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ArrayList<Telefones> getTelefones() {
		return telefones;
	}

	public void setTelefones(ArrayList<Telefones> telefones) {
		this.telefones = telefones;
	}
	

}
