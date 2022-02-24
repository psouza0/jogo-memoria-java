package br.com.poli.jogomemoria.dominio;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.ImageIcon;

import br.com.poli.jogomemoria.MainInterface;

public class Tabuleiro {

	// atributos

	private String[][] tabuleiro = tabD();
	private String[][] tabuleiroAux = aux();
	private ArrayList<String> listaPecas = new ArrayList<String>();
	private ArrayList<Integer> listaCoordenadas = new ArrayList<Integer>();
	private Map<String, ImageIcon> peca = new HashMap<String, ImageIcon>(36);

	int nivel;

	// construtor
	public Tabuleiro(int nivel) {
		super();
		this.nivel = nivel;
	}

	@SuppressWarnings("unused")
	private Image getImage(final String path) {
		return Toolkit.getDefaultToolkit().getImage(MainInterface.class.getResource(path));
	}

	private ImageIcon getImageIcon(String path) {

		@SuppressWarnings("unused")
		InputStream stream = getClass().getResourceAsStream(path);
		ImageIcon ico = null;

		return ico;
	}

	public Map<String, ImageIcon> carregarPecas() {

		peca.put(tabuleiro[0][0], getImageIcon("/br/com/poli/jogomemoria/imagens/arabia.png"));
		peca.put(tabuleiro[0][1], getImageIcon("/br/com/poli/jogomemoria/imagens/argentina_new.png"));
		peca.put(tabuleiro[0][2], getImageIcon("/br/com/poli/jogomemoria/imagens/australia_new.png"));
		peca.put(tabuleiro[0][3], getImageIcon("/br/com/poli/jogomemoria/imagens/belg.png"));
		peca.put(tabuleiro[1][0], getImageIcon("/br/com/poli/jogomemoria/imagens/cbf.png"));
		peca.put(tabuleiro[1][1], getImageIcon("/br/com/poli/jogomemoria/imagens/col.png"));
		peca.put(tabuleiro[1][2], getImageIcon("/br/com/poli/jogomemoria/imagens/costarica.png"));
		peca.put(tabuleiro[1][3], getImageIcon("/br/com/poli/jogomemoria/imagens/croatia.png"));
		peca.put(tabuleiro[0][4], getImageIcon("/br/com/poli/jogomemoria/imagens/dina.png"));
		peca.put(tabuleiro[0][5], getImageIcon("/br/com/poli/jogomemoria/imagens/egito.png"));
		peca.put(tabuleiro[1][4], getImageIcon("/br/com/poli/jogomemoria/imagens/eng_new.png"));
		peca.put(tabuleiro[1][5], getImageIcon("/br/com/poli/jogomemoria/imagens/fra_new.png"));
		peca.put(tabuleiro[2][4], getImageIcon("/br/com/poli/jogomemoria/imagens/ger.png"));
		peca.put(tabuleiro[2][5], getImageIcon("/br/com/poli/jogomemoria/imagens/iceland_new.png"));
		peca.put(tabuleiro[3][4], getImageIcon("/br/com/poli/jogomemoria/imagens/iran.png"));
		peca.put(tabuleiro[3][5], getImageIcon("/br/com/poli/jogomemoria/imagens/japao.png"));
		peca.put(tabuleiro[4][0], getImageIcon("/br/com/poli/jogomemoria/imagens/marrocos_new.png"));
		peca.put(tabuleiro[4][1], getImageIcon("/br/com/poli/jogomemoria/imagens/mexico.png"));
		peca.put(tabuleiro[0][6], getImageIcon("/br/com/poli/jogomemoria/imagens/nigeria.png"));
		peca.put(tabuleiro[0][7], getImageIcon("/br/com/poli/jogomemoria/imagens/panama.png"));
		peca.put(tabuleiro[1][6], getImageIcon("/br/com/poli/jogomemoria/imagens/per.png"));
		peca.put(tabuleiro[1][7], getImageIcon("/br/com/poli/jogomemoria/imagens/polonia.png"));
		peca.put(tabuleiro[2][6], getImageIcon("/br/com/poli/jogomemoria/imagens/port.png"));
		peca.put(tabuleiro[2][7], getImageIcon("/br/com/poli/jogomemoria/imagens/russia.png"));
		peca.put(tabuleiro[3][6], getImageIcon("/br/com/poli/jogomemoria/imagens/senegal_2.png"));
		peca.put(tabuleiro[3][7], getImageIcon("/br/com/poli/jogomemoria/imagens/servia.png"));
		peca.put(tabuleiro[4][6], getImageIcon("/br/com/poli/jogomemoria/imagens/skorea.png"));
		peca.put(tabuleiro[4][7], getImageIcon("/br/com/poli/jogomemoria/imagens/spa.png"));
		peca.put(tabuleiro[5][6], getImageIcon("/br/com/poli/jogomemoria/imagens/suica.png"));
		peca.put(tabuleiro[5][7], getImageIcon("/br/com/poli/jogomemoria/imagens/swe_new.png"));
		peca.put(tabuleiro[6][0], getImageIcon("/br/com/poli/jogomemoria/imagens/tunisia.png"));
		peca.put(tabuleiro[6][1], getImageIcon("/br/com/poli/jogomemoria/imagens/uru.png"));

		peca.put("z", getImageIcon("/br/com/poli/jogomemoria/imagens/verso_russia_worlcup_2018.png"));

		return peca;
	}

	public String[][] tabD() {

		String[][] tabuleiro = new String[8][8];

		tabuleiro[0][0] = "A";
		tabuleiro[0][1] = "B";
		tabuleiro[0][2] = "C";
		tabuleiro[0][3] = "D";
		tabuleiro[1][0] = "E";
		tabuleiro[1][1] = "F";
		tabuleiro[1][2] = "G";
		tabuleiro[1][3] = "H";

		tabuleiro[2][0] = "A";
		tabuleiro[2][1] = "B";
		tabuleiro[2][2] = "C";
		tabuleiro[2][3] = "D";
		tabuleiro[3][0] = "E";
		tabuleiro[3][1] = "F";
		tabuleiro[3][2] = "G";
		tabuleiro[3][3] = "H";

		tabuleiro[0][4] = "I";
		tabuleiro[0][5] = "J";
		tabuleiro[1][4] = "K";
		tabuleiro[1][5] = "L";
		tabuleiro[2][4] = "M";
		tabuleiro[2][5] = "N";
		tabuleiro[3][4] = "O";
		tabuleiro[3][5] = "P";
		tabuleiro[4][0] = "Q";
		tabuleiro[4][1] = "R";

		tabuleiro[4][2] = "I";
		tabuleiro[4][3] = "J";
		tabuleiro[4][4] = "K";
		tabuleiro[4][5] = "L";
		tabuleiro[5][0] = "M";
		tabuleiro[5][1] = "N";
		tabuleiro[5][2] = "O";
		tabuleiro[5][3] = "P";
		tabuleiro[5][4] = "Q";
		tabuleiro[5][5] = "R";

		tabuleiro[0][6] = "a";
		tabuleiro[0][7] = "b";
		tabuleiro[1][6] = "c";
		tabuleiro[1][7] = "d";
		tabuleiro[2][6] = "e";
		tabuleiro[2][7] = "f";
		tabuleiro[3][6] = "g";
		tabuleiro[3][7] = "h";
		tabuleiro[4][6] = "i";
		tabuleiro[4][7] = "j";
		tabuleiro[5][6] = "k";
		tabuleiro[5][7] = "l";
		tabuleiro[6][0] = "m";
		tabuleiro[6][1] = "n";

		tabuleiro[6][2] = "a";
		tabuleiro[6][3] = "b";
		tabuleiro[6][4] = "c";
		tabuleiro[6][5] = "d";
		tabuleiro[6][6] = "e";
		tabuleiro[6][7] = "f";
		tabuleiro[7][0] = "g";
		tabuleiro[7][1] = "h";
		tabuleiro[7][2] = "i";
		tabuleiro[7][3] = "j";
		tabuleiro[7][4] = "k";
		tabuleiro[7][5] = "l";
		tabuleiro[7][6] = "m";
		tabuleiro[7][7] = "n";

		// embaralha o tabuleiro depois de inicializado
		Random r = new Random();
		for (int i1 = 0; i1 < tabuleiro.length; i1++) {
			for (int k = 0; k < tabuleiro.length; k++) {
				int j = r.nextInt(tabuleiro.length);
				int i = r.nextInt(tabuleiro.length);
				String temp = tabuleiro[i][j];
				tabuleiro[i][j] = tabuleiro[j][i];
				tabuleiro[j][i] = temp;
			}
		}

		return tabuleiro;
	}

	public String[][] aux() {

		String[][] tabuleiroAux = new String[8][8];

		tabuleiroAux[0][0] = " ";
		tabuleiroAux[0][1] = " ";
		tabuleiroAux[0][2] = " ";
		tabuleiroAux[0][3] = " ";
		tabuleiroAux[0][4] = " ";
		tabuleiroAux[0][5] = " ";
		tabuleiroAux[0][6] = " ";
		tabuleiroAux[0][7] = " ";
		tabuleiroAux[1][0] = " ";
		tabuleiroAux[1][1] = " ";
		tabuleiroAux[1][2] = " ";
		tabuleiroAux[1][3] = " ";
		tabuleiroAux[1][4] = " ";
		tabuleiroAux[1][5] = " ";
		tabuleiroAux[1][6] = " ";
		tabuleiroAux[1][7] = " ";
		tabuleiroAux[2][0] = " ";
		tabuleiroAux[2][1] = " ";
		tabuleiroAux[2][2] = " ";
		tabuleiroAux[2][3] = " ";
		tabuleiroAux[2][4] = " ";
		tabuleiroAux[2][5] = " ";
		tabuleiroAux[2][6] = " ";
		tabuleiroAux[2][7] = " ";
		tabuleiroAux[3][0] = " ";
		tabuleiroAux[3][1] = " ";
		tabuleiroAux[3][2] = " ";
		tabuleiroAux[3][3] = " ";
		tabuleiroAux[3][4] = " ";
		tabuleiroAux[3][5] = " ";
		tabuleiroAux[3][6] = " ";
		tabuleiroAux[3][7] = " ";

		tabuleiroAux[4][0] = " ";
		tabuleiroAux[4][1] = " ";
		tabuleiroAux[4][2] = " ";
		tabuleiroAux[4][3] = " ";
		tabuleiroAux[4][4] = " ";
		tabuleiroAux[4][5] = " ";
		tabuleiroAux[4][6] = " ";
		tabuleiroAux[4][7] = " ";
		tabuleiroAux[5][0] = " ";
		tabuleiroAux[5][1] = " ";
		tabuleiroAux[5][2] = " ";
		tabuleiroAux[5][3] = " ";
		tabuleiroAux[5][4] = " ";
		tabuleiroAux[5][5] = " ";
		tabuleiroAux[5][6] = " ";
		tabuleiroAux[5][7] = " ";
		tabuleiroAux[6][0] = " ";
		tabuleiroAux[6][1] = " ";
		tabuleiroAux[6][2] = " ";
		tabuleiroAux[6][3] = " ";
		tabuleiroAux[6][4] = " ";
		tabuleiroAux[6][5] = " ";
		tabuleiroAux[6][6] = " ";
		tabuleiroAux[6][7] = " ";
		tabuleiroAux[7][0] = " ";
		tabuleiroAux[7][1] = " ";
		tabuleiroAux[7][2] = " ";
		tabuleiroAux[7][3] = " ";
		tabuleiroAux[7][4] = " ";
		tabuleiroAux[7][5] = " ";
		tabuleiroAux[7][6] = " ";
		tabuleiroAux[7][7] = " ";

		return tabuleiroAux;
	}

	/**
	 * verifica se a jogada é valida no tabuleiro
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean fazerJogada(int x, int y) {
		if (nivel == 1) {
			if (tabuleiro[x][y] == null) {
				return false;
			} else {
				// a peca do tabueliro é setada em Peca e as respectivas coordenadas salvas numa
				// lista
				String peca = this.tabuleiro[x][y];
				this.tabuleiro[x][y] = null;
				this.tabuleiroAux[x][y] = peca;
				addPeca(peca);
				listaCoordenadas.add(x);
				listaCoordenadas.add(y);
			}
		} else if (nivel == 2) {
			if (tabuleiro[x][y] == null) { // mudar para tabuleiroM
				return false;
			} else {
				// a peca do tabueliro é setada em Peca e as respectivas coordenadas salvas numa
				// lista
				String peca = this.tabuleiro[x][y];
				this.tabuleiro[x][y] = null;
				this.tabuleiroAux[x][y] = peca;
				addPeca(peca);
				listaCoordenadas.add(x);
				listaCoordenadas.add(y);
			}
		} else if (nivel == 3) {
			if (tabuleiro[x][y] == null) {
				return false;
			} else {
				// a peca do tabuleiro é setada em Peca e as respectivas coordenadas salvas numa
				// lista
				String peca = this.tabuleiro[x][y];
				this.tabuleiro[x][y] = null;
				this.tabuleiroAux[x][y] = peca;
				addPeca(peca);
				listaCoordenadas.add(x);
				listaCoordenadas.add(y);
			}
		}
		return true;
	}

	/**
	 * salva as pecas no array list para posterior verificação de igualdade
	 * 
	 * @param peca
	 */

	// guardar as pecas numa lista para comparar depois
	public void addPeca(String peca) {
		this.listaPecas.add(peca);
	}

	/**
	 * verifica se pecas do array list são iguais
	 * 
	 * @return
	 */
	public boolean verifica() {
		if (listaPecas.get(0).equals(listaPecas.get(1))) {
			listaCoordenadas.removeAll(listaCoordenadas);
			listaPecas.removeAll(listaPecas);
			return true;

		} else {

			if (nivel == 1) {
				this.tabuleiro[listaCoordenadas.get(0)][listaCoordenadas.get(1)] = listaPecas.get(0).toString();
				this.tabuleiro[listaCoordenadas.get(2)][listaCoordenadas.get(3)] = listaPecas.get(1).toString();

				this.tabuleiroAux[listaCoordenadas.get(0)][listaCoordenadas.get(1)] = " ";
				this.tabuleiroAux[listaCoordenadas.get(2)][listaCoordenadas.get(3)] = " ";

				listaCoordenadas.removeAll(listaCoordenadas);
				listaPecas.removeAll(listaPecas);
			} else if (nivel == 2) {
				this.tabuleiro[listaCoordenadas.get(0)][listaCoordenadas.get(1)] = listaPecas.get(0).toString();
				this.tabuleiro[listaCoordenadas.get(2)][listaCoordenadas.get(3)] = listaPecas.get(1).toString();

				this.tabuleiroAux[listaCoordenadas.get(0)][listaCoordenadas.get(1)] = " ";
				this.tabuleiroAux[listaCoordenadas.get(2)][listaCoordenadas.get(3)] = " ";

				listaCoordenadas.removeAll(listaCoordenadas);
				listaPecas.removeAll(listaPecas);
			} else if (nivel == 3) {
				this.tabuleiro[listaCoordenadas.get(0)][listaCoordenadas.get(1)] = listaPecas.get(0).toString();
				this.tabuleiro[listaCoordenadas.get(2)][listaCoordenadas.get(3)] = listaPecas.get(1).toString();

				this.tabuleiroAux[listaCoordenadas.get(0)][listaCoordenadas.get(1)] = " ";
				this.tabuleiroAux[listaCoordenadas.get(2)][listaCoordenadas.get(3)] = " ";

				listaCoordenadas.removeAll(listaCoordenadas);
				listaPecas.removeAll(listaPecas);
			}

			return false;
		}
	}

	/**
	 * exibe o tabuleiroAux já com as peças
	 */
	public void mostraAux(int nivel) {

		if (nivel == 1) {
			for (int i = 0; i <= 3; i++) {
				for (int j = 0; j <= 3; j++) {
					System.out.print(getTabuleiroAux()[i][j] + ",");
				}
				System.out.println();
			}
		}

		else if (nivel == 2) {
			for (int i = 0; i <= 5; i++) {
				for (int j = 0; j <= 5; j++) {
					System.out.print(getTabuleiroAux()[i][j] + ",");
				}
				System.out.println();
			}
		}

		else if (nivel == 3) {
			for (int i = 0; i <= 7; i++) {
				for (int j = 0; j <= 7; j++) {
					System.out.print(getTabuleiroAux()[i][j] + ",");
				}
				System.out.println();
			}
		}

	}

	/**
	 * resolve o jogo, insere as pecas faltantes no tab aux do respectivo nível e
	 * imprime na tela
	 * 
	 * @param nivel
	 */

	public void resolveJogo(int nivel) {

		if (nivel == 1) {
			for (int i = 0; i <= 3; i++) {
				for (int j = 0; j <= 3; j++) {
					if (this.tabuleiro[i][j] != null) {
						this.tabuleiroAux[i][j] = this.tabuleiro[i][j];
					}
				}
			}
			mostraAux(nivel);
		} else if (nivel == 2) {
			for (int i = 0; i <= 5; i++) {
				for (int j = 0; j <= 5; j++) {
					if (this.tabuleiro[i][j] != null) {
						this.tabuleiroAux[i][j] = this.tabuleiro[i][j];
					}
				}
			}
			mostraAux(nivel);
		} else if (nivel == 3) {
			for (int i = 0; i <= 7; i++) {
				for (int j = 0; j <= 7; j++) {
					if (this.tabuleiro[i][j] != null) {
						this.tabuleiroAux[i][j] = this.tabuleiro[i][j];
					}
				}
			}
			mostraAux(nivel);
		}
	}

	public String[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiroD(String[][] tabuleiroD) {
		this.tabuleiro = tabuleiroD;
	}

	public String[][] getTabuleiroAux() {
		return tabuleiroAux;
	}

	public void setTabuleiroAux(String[][] tabuleiroAux) {
		this.tabuleiroAux = tabuleiroAux;
	}

}