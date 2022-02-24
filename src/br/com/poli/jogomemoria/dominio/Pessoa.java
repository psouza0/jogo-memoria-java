package br.com.poli.jogomemoria.dominio;

public class Pessoa {

	private String nome;

	public Pessoa(String nome) {
		this.nome = nome;
	}

	@Override // Sobrescreve o metodo toString
	public String toString() {
		return "de nome: " + nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
