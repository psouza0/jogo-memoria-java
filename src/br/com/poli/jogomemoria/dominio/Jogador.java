package br.com.poli.jogomemoria.dominio;

public class Jogador extends Pessoa {
	// atributos
	protected int score;
	private int numero;

	// constutor
	public Jogador(String nome, int score, int numero) {
		super(nome);
		this.score = score;
		this.numero = numero;
	}

	// sobreescreve o metodo toString
	@Override
	public String toString() {
		return "Jogador " + numero + " " + super.toString();
	}

	public int getNumero() {
		return numero;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}