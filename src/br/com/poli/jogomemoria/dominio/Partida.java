package br.com.poli.jogomemoria.dominio;

public class Partida {

	private Jogador jogador1, jogador2, jogadorA;
	private Tabuleiro tabuleiro;
	private int nivel;
	private int controle = 0;

	public Partida(Jogador jog1, Jogador jog2, int nivel) {
		super();
		this.jogador1 = jog1;
		this.jogador2 = jog2;
		this.jogadorA = jogador1;
		this.tabuleiro = new Tabuleiro(nivel);
		this.nivel = nivel;
	}

	/**
	 * valida a coordenada informada pelo usuário
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int validarJogada(int x, int y) {

		if ((x < 0 || y < 0 || x >= 4 || y >= 4) && nivel == 1) {
			return -1;
		} else if ((x < 0 || y < 0 || x >= 6 || y >= 6) && nivel == 2) {
			return -2;
		} else if ((x < 0 || y < 0 || x >= 8 || y >= 8) && nivel == 3)
			return -3;
		else
			return 0;
	}

	/**
	 * faz a jogada em Tabuleiro
	 * 
	 * @param x
	 * @param y
	 * @param nome
	 * @return
	 */
	public boolean fazerJogada(int x, int y) {

		if (tabuleiro.fazerJogada(x, y)) {
			return true;
		} else
			return false;
	}

	/**
	 * vai denifir quem é o próximo jogador e setar o score
	 * 
	 * @return
	 */
	public boolean verifica() {

		if (tabuleiro.verifica()) {
			controle++; // controle para qtd de jogadas com pares iguais
			setJogadorA(jogadorA);

			if (this.jogadorA.getNome().equals(this.jogador1.getNome())) {
				this.jogador1.setScore(this.jogador1.getScore() + 1);
			} else
				this.jogador2.setScore(this.jogador2.getScore() + 1);

			return true; // jogador joga de novo
		} else {
			if (this.jogadorA.equals(this.jogador1)) {
				setJogadorA(jogador2);
			} else
				setJogadorA(jogador1);
			return false; // jogador passa a vez
		}
	}

	/**
	 * verifica se ainda tem jogadas disponíveis
	 * 
	 * @return
	 */
	public boolean fimDeJogo(int verificador) {
		if (nivel == 1 && controle == 8) {
			return true;
		} else if (nivel == 2 && controle == 18) {
			return true;
		} else if (nivel == 3 && controle == 32) {
			return true;
		} else if (verificador == -1) {
			return true;
		}
		return false;
	}

	/**
	 * mostra o tabuleiro de acordo com o nível
	 */
	public void mostraAux() {

		tabuleiro.mostraAux(nivel);
	}

	public Jogador getJogadorA() {
		return jogadorA;
	}

	public void setJogadorA(Jogador jogadorA) {
		this.jogadorA = jogadorA;
	}

	public String[][] getMapaPecas() {
		return tabuleiro.getTabuleiro();
	}

}
