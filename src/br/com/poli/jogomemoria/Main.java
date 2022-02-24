package br.com.poli.jogomemoria;

import java.util.Random;
import java.util.Scanner;

import br.com.poli.jogomemoria.dominio.Jogador;
import br.com.poli.jogomemoria.dominio.Partida;
import br.com.poli.jogomemoria.dominio.Tabuleiro;

public class Main {

	private Jogador jogador1, jogador2, jogadorA;
	private Partida partida;
	private int nivel;
	private Tabuleiro tabuleiro;

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		int contador = 0;
		int verificador = 0;
		int opcaoDeJogo = 0;

		Main main = new Main();
		Scanner in;
		Random r = new Random();

		A0: while (opcaoDeJogo != 1 && opcaoDeJogo != 2) {
			System.out.println("Escolha a opção de jogo:");
			System.out.println("Player 1 vs CPU - Digite 1");
			System.out.println("Player 1 vs Player 2 - Digite 2");
			in = new Scanner(System.in);
			opcaoDeJogo = in.nextInt();
			if (opcaoDeJogo != 1 && opcaoDeJogo != 2) {
				System.out.println("Opção inválida!");
				System.out.println("Tente novamente.");
				continue A0;
			}
		}

		System.out.print("Digite o nome do Jogador 1: ");
		in = new Scanner(System.in);
		main.jogador1 = new Jogador(in.next(), 0, 1);

		if (opcaoDeJogo == 2) {
			System.out.print("Digite o nome do Jogador 2: ");
			in = new Scanner(System.in);
			main.jogador2 = new Jogador(in.next(), 0, 2);
			System.out.println();
		} else {
			main.jogador2 = new Jogador("CPU", 0, 2);
			System.out.println();
		}

		A01: while (main.nivel <= 0 || main.nivel >= 4) {
			System.out.print("Digite o nivel de dificuldade: \n");
			System.out.println("1 - Fácil : 4x4");
			System.out.println("2 - Médio : 6x6");
			System.out.println("3 - Difícil : 8x8");
			in = new Scanner(System.in);
			main.nivel = in.nextInt();
			if (main.nivel != 1 && main.nivel != 2 && main.nivel != 3) {
				System.out.println("Opção inválida!");
				System.out.println("Tente novamente");
				continue A01;
			}
		}

		main.partida = new Partida(main.jogador1, main.jogador2, main.nivel);
		main.jogadorA = main.jogador1;
		main.tabuleiro = new Tabuleiro(main.nivel);

		A1: while (!main.partida.fimDeJogo(verificador)) { // verifica se ainda tem jogadas disponíveis

			System.out.println();
			System.out.println("Vez do Jogador: " + main.jogadorA.getNumero());
			System.out.println(main.jogadorA + ", informe sua jogada: ");

			int x1 = 9, y1 = 9;

			J1: while (x1 > 7 || y1 > 7 || x1 < 0 || y1 < 0) {
				main.partida.mostraAux();

				System.out.println("Digite a primeira coordenada x: ");
				if (opcaoDeJogo == 2) {
					in = new Scanner(System.in);
					x1 = in.nextInt();
				} else {
					if (main.jogadorA.getNome().equals("CPU")) {
						if (main.nivel == 1) {
							x1 = r.nextInt(4);
						} else if (main.nivel == 2) {
							x1 = r.nextInt(5);
						} else if (main.nivel == 3) {
							x1 = r.nextInt(7);
						}
					} else {
						in = new Scanner(System.in);
						x1 = in.nextInt();
					}
					System.out.println(x1);
				}

				System.out.println("Digite a primeira coordenada y: ");
				if (opcaoDeJogo == 2) {
					in = new Scanner(System.in);
					y1 = in.nextInt();
				} else {
					if (main.jogadorA.getNome().equals("CPU")) {
						if (main.nivel == 1) {
							y1 = r.nextInt(4);
						} else if (main.nivel == 2) {
							y1 = r.nextInt(5);
						} else if (main.nivel == 3) {
							y1 = r.nextInt(7);
						}
					} else {
						in = new Scanner(System.in);
						y1 = in.nextInt();
					}
					System.out.println(y1);
				}

				if (x1 == -1 && y1 == -1) {
					verificador = -1;
					System.out.println();
					main.tabuleiro.resolveJogo(main.nivel);
					System.out.println();
					main.partida.fimDeJogo(verificador);
					continue A1;
				}

				if (main.partida.validarJogada(x1, y1) == -1 || main.partida.validarJogada(x1, y1) == -2
						|| main.partida.validarJogada(x1, y1) == -3) {
					System.out.println("Jogada inválida!");
					System.out.println("Coordenadas inválidas.");
					x1 = y1 = 9;
					continue J1;
				} else if (!main.partida.fazerJogada(x1, y1)) {
					System.out.println("Jogada inválida!");
					System.out.println("Peça já aparece no Tabuleiro. ");
					x1 = y1 = 9;
					continue J1;
				}
			}

			int x2 = 9, y2 = 9;
			J2: while (x2 > 7 || y2 > 7 || x2 < 0 || y2 < 0) {
				main.partida.mostraAux();
				System.out.println();
				System.out.println("Vez do Jogador: " + main.jogadorA.getNumero());
				System.out.print(main.jogadorA + ", informe sua jogada: ");
				System.out.println();

				System.out.println("Digite a segunda coordenada x: ");
				if (opcaoDeJogo == 2) {
					in = new Scanner(System.in);
					x2 = in.nextInt();
				} else {
					if (main.jogadorA.getNome().equals("CPU")) {
						if (main.nivel == 1) {
							x2 = r.nextInt(4);
						} else if (main.nivel == 2) {
							x2 = r.nextInt(5);
						} else if (main.nivel == 3) {
							x2 = r.nextInt(7);
						}
					} else {
						in = new Scanner(System.in);
						x2 = in.nextInt();
					}
					System.out.println(x2);
				}

				System.out.println("Digite a segunda coordenada y: ");
				if (opcaoDeJogo == 2) {
					in = new Scanner(System.in);
					y2 = in.nextInt();
				} else {
					if (main.jogadorA.getNome().equals("CPU")) {
						if (main.nivel == 1) {
							y2 = r.nextInt(4);
						} else if (main.nivel == 2) {
							y2 = r.nextInt(5);
						} else if (main.nivel == 3) {
							y2 = r.nextInt(7);
						}
					} else {
						in = new Scanner(System.in);
						y2 = in.nextInt();
					}
					System.out.println(y2);
				}

				if (x2 == -1 && y2 == -1) {
					verificador = -1;
					System.out.println();
					main.tabuleiro.resolveJogo(main.nivel);
					System.out.println();
					main.partida.fimDeJogo(verificador);
					continue A1;
				}

				if (x2 == x1 && y2 == y1) {
					System.out.println("Jogada inválida!");
					System.out.println("Coordenadas inguais a primeira jogada.");
					x2 = y2 = 9;
					continue J2;
				} else if (main.partida.validarJogada(x2, y2) == -1 || main.partida.validarJogada(x2, y2) == -2
						|| main.partida.validarJogada(x2, y2) == -3) {
					System.out.println("Jogada inválida!");
					System.out.println("Coordenadas inválidas.");
					x2 = y2 = 9;
					continue J2;
				} else if (!main.partida.fazerJogada(x2, y2)) {
					System.out.println("Jogada inválida!");
					System.out.println("Peça já aparece no Tabuleiro. ");
					x2 = y2 = 9;
					continue J2;
				}
			}
			main.partida.mostraAux();

			if (main.partida.verifica()) {
				System.out.println();
				System.out.println("Somou 1 ponto!");
				System.out.println();
				contador++;
				main.jogadorA = main.partida.getJogadorA();
				continue A1;
			} else
				contador++;
			System.out.println();
			System.out.println("Perdeu a vez.");
			System.out.println();
			main.jogadorA = main.partida.getJogadorA();

			continue A1;
		}

		System.out.println();

		if (main.jogador1.getScore() > main.jogador2.getScore()) {
			System.out.println("O vencedor é o jogador " + main.jogador1.getNumero() + " com "
					+ main.jogador1.getScore() + " pontos.");
		} else if (main.jogador1.getScore() < main.jogador2.getScore()) {
			System.out.println("O vencedor é o jogador " + main.jogador2.getNumero() + " com "
					+ main.jogador2.getScore() + " pontos.");
		} else {
			System.out.println("Houve empate!");
			System.out.println("Pontuação do Jogador 1: " + main.jogador1.getNome() + " = " + main.jogador1.getScore()
					+ " pontos.");
			System.out.println("Pontuação do Jogador 2: " + main.jogador2.getNome() + " = " + main.jogador2.getScore()
					+ " pontos.");
		}
		System.out.println();
		System.out.println("Fim de jogo!");
		System.out.println("Quantidade de jogadas: " + contador);

		in.close();
	}
}
