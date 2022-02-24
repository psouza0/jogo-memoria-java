package br.com.poli.jogomemoria;

import java.awt.BorderLayout; 
//import br.com.poli.jogomemoria.dominio.Tabuleiro;
import java.awt.Color; 
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import br.com.poli.jogomemoria.dominio.Jogador;
import br.com.poli.jogomemoria.dominio.Partida;
import br.com.poli.jogomemoria.view.NovoJogo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class MainInterface {
	
	private JFrame frmJogoDaMemoria; 
	private final JPanel pnlJogo = new JPanel(new BorderLayout());
	private final JPanel pnlNome = new JPanel(new GridLayout(1, 3));
	private final JPanel pnlPeca = new JPanel();
	private JToggleButton btnPecaAnterior;
	private static final Font FONT_PADRAO = new Font("Arial", Font.BOLD, 14); 
	private static final Font FONT_DESTAQUE = new Font("Arial", Font.BOLD, 20); // fonte para jog atual
	private static final Color COR_PADRAO = Color.WHITE;
	private static final Color COR_DESTAQUE = Color.YELLOW;//cor para jog atual
	private final NovoJogo dialog = new NovoJogo(frmJogoDaMemoria, true);
	private final Jogador jogador1 = new Jogador(null, 0, 1);
	private final Jogador jogador2 = new Jogador(null, 0, 2);
	private int nivel; 
	//private Tabuleiro tabuleiro = new Tabuleiro(nivel);
	private Map<String, ImageIcon> map = new HashMap<String, ImageIcon>(36);
	private Partida partida;
	private String[][] mapaPecas;
	private boolean controleVez;
	private final Random r = new Random();
	private final Timer tempoCpu = new Timer();
	private String letraCpu;
	
	/**
	 * launch
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					MainInterface window = new MainInterface();
					window.frmJogoDaMemoria.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * criação da aplicação
	 */
	public MainInterface() {
		inicializar();
	}
	
	/**
	 * inicializar os conteudos do frame
	 */
	private void inicializar() {
		frmJogoDaMemoria = new JFrame();
		frmJogoDaMemoria.setTitle("Jogo da Memória - Copa 2018 Rússia"); //titulo da janela, apos setar modo, nome e dificuldade
		frmJogoDaMemoria.setBounds(0, 0, 1000, 600); //tamanho da janela do jogo
		frmJogoDaMemoria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		carregarPecas(); 		
		//	tabuleiro.carregarPecas();
		configurarPartida();	
		//	map = tabuleiro.carregarPecas();

		if(dialog.getModoJogo().equals("VS CPU")) {
			tempoCpu.schedule(new RemindTask(), 2000, 2000); //agenda a tarefa da cpu jogar
		}
		
	}
	
	class RemindTask extends TimerTask{

		
		public void run() {
			// quando for a vez da cpu jogar
			if(partida.getJogadorA().getNome().equals("CPU")) {
				int chanceAcertar = r.nextInt(100);
				int qtdClick = 0;
				Component[] cs = pnlPeca.getComponents();
				
				for(int i = 0; i < cs.length; i++) {
					JToggleButton btnCpu = (JToggleButton)cs[i];
					if(qtdClick == 0 && !btnCpu.isSelected()) {
						letraCpu = (String)btnCpu.getClientProperty("letra");
						
						btnCpu.doClick();
						try {
							Thread.sleep(1000); //tempo para a cpu fazer a sua jogada
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
						qtdClick++;
					} else if(qtdClick == 1) {

						if(chanceAcertar < 35) {
							if(letraCpu.equals((String)btnCpu.getClientProperty("letra"))){
								
								btnCpu.doClick();
								
								qtdClick++;
								break;
							}
							
						} else if (!btnCpu.isSelected()) {
							
							btnCpu.doClick();
							
							qtdClick++;
							break;
							
						}
					}
				}	
			}
		
		}
		
	}
	
	private void carregarPecas() {
		
		map.put("A", getImageIcon("/br/com/poli/jogomemoria/imagens/arabia.png"));
		map.put("B", getImageIcon("/br/com/poli/jogomemoria/imagens/argentina_new.png"));
		map.put("C", getImageIcon("/br/com/poli/jogomemoria/imagens/australia_new.png"));
		map.put("D", getImageIcon("/br/com/poli/jogomemoria/imagens/belg.png"));
		map.put("E", getImageIcon("/br/com/poli/jogomemoria/imagens/cbf.png"));
		map.put("F", getImageIcon("/br/com/poli/jogomemoria/imagens/col.png"));
		map.put("G", getImageIcon("/br/com/poli/jogomemoria/imagens/costarica.png"));
		map.put("H", getImageIcon("/br/com/poli/jogomemoria/imagens/croatia.png"));
		map.put("I", getImageIcon("/br/com/poli/jogomemoria/imagens/dina.png"));
		map.put("J", getImageIcon("/br/com/poli/jogomemoria/imagens/egito.png"));
		map.put("K", getImageIcon("/br/com/poli/jogomemoria/imagens/eng_new.png"));
		map.put("L", getImageIcon("/br/com/poli/jogomemoria/imagens/fra_new.png"));
		map.put("M", getImageIcon("/br/com/poli/jogomemoria/imagens/ger.png"));
		map.put("N", getImageIcon("/br/com/poli/jogomemoria/imagens/iceland_new.png"));
		map.put("O", getImageIcon("/br/com/poli/jogomemoria/imagens/iran.png"));
		map.put("P", getImageIcon("/br/com/poli/jogomemoria/imagens/japao.png"));
		map.put("a", getImageIcon("/br/com/poli/jogomemoria/imagens/marrocos_new.png"));
		map.put("b", getImageIcon("/br/com/poli/jogomemoria/imagens/mexico.png"));
		map.put("c", getImageIcon("/br/com/poli/jogomemoria/imagens/nigeria.png"));
		map.put("d", getImageIcon("/br/com/poli/jogomemoria/imagens/panama.png"));
		map.put("e", getImageIcon("/br/com/poli/jogomemoria/imagens/per.png"));
		map.put("f", getImageIcon("/br/com/poli/jogomemoria/imagens/polonia.png"));
		map.put("g", getImageIcon("/br/com/poli/jogomemoria/imagens/port.png"));
		map.put("h", getImageIcon("/br/com/poli/jogomemoria/imagens/russia.png"));
		map.put("i", getImageIcon("/br/com/poli/jogomemoria/imagens/senegal_2.png"));
		map.put("j", getImageIcon("/br/com/poli/jogomemoria/imagens/servia.png"));
		map.put("k", getImageIcon("/br/com/poli/jogomemoria/imagens/skorea.png"));
		map.put("l", getImageIcon("/br/com/poli/jogomemoria/imagens/spa.png"));
		map.put("m", getImageIcon("/br/com/poli/jogomemoria/imagens/suica.png"));
		map.put("n", getImageIcon("/br/com/poli/jogomemoria/imagens/swe_new.png"));
		map.put("o", getImageIcon("/br/com/poli/jogomemoria/imagens/tunisia.png"));
		map.put("p", getImageIcon("/br/com/poli/jogomemoria/imagens/uru.png"));

		map.put("z", getImageIcon("/br/com/poli/jogomemoria/imagens/verso_russia_worlcup_2018.png"));
		
	}
			
	private void configurarPartida() {
		dialog.setVisible(true);
		
		nivel = dialog.getDificuldade();
		partida = new Partida(jogador1, jogador2, nivel);
		mapaPecas = partida.getMapaPecas();
		controleVez = false;
		
		Container contentPane = frmJogoDaMemoria.getContentPane();
		contentPane.setLayout(null);
		{
			atualizaNome();
			atualizaPlacar();
			embaralhar();
			contentPane.add(pnlJogo);
			pnlJogo.add(pnlNome, BorderLayout.NORTH);
			pnlJogo.add(pnlPeca, BorderLayout.CENTER);
		}
		
		destacaJogadorA();
	}
	
	private void embaralhar() {
		int distancia = 5;
		int qtd = 0;
		
		pnlJogo.setBounds(50, 50, 800, 500); //tamanho do tabuleiro
		pnlJogo.setBackground(Color.black);
		
		switch(dialog.getDificuldade()) {
		case 1:
			qtd = 4;
			pnlPeca.setLayout(new GridLayout(qtd, qtd, distancia, distancia));
			break;
		case 2:
			qtd = 6;
			pnlPeca.setLayout(new GridLayout(qtd, qtd, distancia, distancia));
			
			break;
		case 3: 
			qtd = 8;
			pnlPeca.setLayout(new GridLayout(qtd, qtd, distancia, distancia));
			break;
		}
		
		
		for(int i = 0; i < qtd; i++) {
			for(int j = 0; j < qtd; j++) {
				JToggleButton btn = new JToggleButton(map.get("z")); //verso da peca
				btn.setBackground(Color.white);
				btn.putClientProperty("x", i);
				btn.putClientProperty("y", j);
				btn.putClientProperty("letra", mapaPecas[i][j]);
				btn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int y = (int)btn.getClientProperty("y");
						int x = (int)btn.getClientProperty("x");
						
						if(btn.getIcon().equals(map.get("z"))) {
							btn.setIcon(map.get(mapaPecas[x][y]));
					
							partida.fazerJogada(x, y);
							controleVez = !controleVez; //se true, selecionou uma peca, do contrario um par
							
							//se true, continuar para verificar
							if(controleVez) {
								btnPecaAnterior = btn;
								
							}else {
								if(!partida.verifica()) { 
									// verifica e atualiza a pontuação dos jogadores
									//passa a vez e desvira as carta
									btn.setIcon(map.get("z"));
									btnPecaAnterior.setIcon(map.get("z"));
									btn.setSelected(false);
									btnPecaAnterior.setSelected(false);
									
								} else {
									btn.setEnabled(false);
									btnPecaAnterior.setEnabled(false);
									
									if(partida.fimDeJogo(0)) {
										String msg;
										if(jogador1.getScore() > jogador2.getScore()) {
											msg = "Vitória do " + jogador1.getNome();
										} else if (jogador2.getScore() > jogador1.getScore()) {
											msg = "Viória do " + jogador2.getNome();
										} else {
											msg = "A partida deu empate.";
										}
										JOptionPane.showMessageDialog(btn, msg, "Fim de jogo", JOptionPane.INFORMATION_MESSAGE);
									}
								}
								destacaJogadorA();
								atualizaPlacar();
							}
							
						}	
					}
				});
				pnlPeca.add(btn);
			}
		}
		
		pnlJogo.add(pnlPeca, BorderLayout.CENTER);
		
		
	}
	
	
	private void destacaJogadorA() {
		if(partida.getJogadorA().equals(jogador1)) {
			pnlNome.getComponent(0).setForeground(COR_DESTAQUE);
			pnlNome.getComponent(0).setFont(FONT_DESTAQUE);
			
			pnlNome.getComponent(2).setForeground(COR_PADRAO);
			pnlNome.getComponent(2).setFont(FONT_PADRAO);
			
		} else {
			pnlNome.getComponent(2).setForeground(COR_DESTAQUE);
			pnlNome.getComponent(2).setFont(FONT_DESTAQUE);
			
			pnlNome.getComponent(0).setForeground(COR_PADRAO);
			pnlNome.getComponent(0).setFont(FONT_PADRAO);
			
		}
	}
	
	
	private void atualizaPlacar() {
		((JLabel)pnlNome.getComponent(1)).setText(jogador1.getScore() + " x " + jogador2.getScore());
		
	}
	
	private void atualizaNome() {
		jogador1.setNome(dialog.getJogador1());
		jogador1.setScore(0);
		jogador2.setNome(dialog.getJogador2());
		jogador2.setScore(0);
		
		pnlNome.setBackground(Color.black);
		pnlNome.setForeground(COR_PADRAO);
		
		pnlNome.removeAll();
		
		JLabel label = new JLabel(jogador1.getNome());
		label.setForeground(COR_PADRAO);
		label.setFont(FONT_PADRAO);
		pnlNome.add(label);
		
		label = new JLabel();
		label.setForeground(COR_PADRAO);
		label.setFont(FONT_PADRAO);
		pnlNome.add(label);
		atualizaPlacar();
		
		label = new JLabel(jogador2.getNome());
		label.setForeground(COR_PADRAO);
		label.setFont(FONT_PADRAO);
		pnlNome.add(label);
		
	}
	
	private ImageIcon getImageIcon(String path) {
		InputStream stream = getClass().getResourceAsStream(path);
		ImageIcon ico = null;
		try {
			ico = new ImageIcon(ImageIO.read(stream));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ico;

	}
}