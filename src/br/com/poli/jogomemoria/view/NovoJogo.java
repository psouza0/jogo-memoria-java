package br.com.poli.jogomemoria.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class NovoJogo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	private final JRadioButton rdoJogador = new JRadioButton("Jogador 1 VS Jogador 2");
	private final JRadioButton rdoCPU = new JRadioButton("Jogador VS CPU");

	private final JTextField txtJogador1 = new JTextField();
	private final JTextField txtJogador2 = new JTextField();

	private final JRadioButton rdo4x4 = new JRadioButton("Fácil (4x4");
	private final JRadioButton rdo6x6 = new JRadioButton("Médio (6x6");
	private final JRadioButton rdo8x8 = new JRadioButton("Difícil (8x8");

	public String getModoJogo() {
		return (rdoJogador.isSelected() ? "VS Jogador" : (rdoCPU.isSelected() ? "VS CPU" : ""));
	}

	public String getJogador1() {
		return txtJogador1.getText();
	}

	public String getJogador2() {
		return txtJogador2.getText();
	}

	public int getDificuldade() {
		if (rdo4x4.isSelected()) {
			return 1;
		} else if (rdo6x6.isSelected()) {
			return 2;
		} else if (rdo8x8.isSelected()) {
			return 3;
		} else{
			return 0;
}
	}

	public NovoJogo() {
		super();
		setType(Type.POPUP);
		iniciarComponentes();
	}

	public NovoJogo(Frame owner, boolean modo) {
		super(owner, modo);
		iniciarComponentes();
	}

	private void iniciarComponentes() {

		setBounds(50, 50, 545, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
		{

			// janela de modo de jogo, inserir nome e escolher dificudade
			JPanel pnlModoJogo = new JPanel(new BorderLayout());
			{
				JLabel lblModoJogo = new JLabel("Modo Jogo");
				pnlModoJogo.add(lblModoJogo, BorderLayout.NORTH);
				rdoJogador.setSelected(true); // opção do modo de jogo já fica setada em jogador1 vc jogador2
				pnlModoJogo.add(rdoJogador, BorderLayout.WEST);
				rdoCPU.addChangeListener(new ChangeListener() {

					public void stateChanged(ChangeEvent e) {
						if (rdoCPU.isSelected()) {
							txtJogador2.setEnabled(false);
							txtJogador2.setText("CPU");
						} else {
							txtJogador2.setEnabled(true);
							txtJogador2.setText("Jogador 2");
						}

					}
				});
				//painel modo do jogo
				pnlModoJogo.add(rdoCPU, BorderLayout.CENTER);

				ButtonGroup bgModoJogo = new ButtonGroup();
				bgModoJogo.add(rdoJogador);
				bgModoJogo.add(rdoCPU);
				contentPanel.add(pnlModoJogo);

			}

			// painel nome1
			JPanel pnlNome1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			{
				JLabel lblJogador1 = new JLabel("Jogador 1: ");
				txtJogador1.setText("Jogador 1");
				txtJogador1.setColumns(40); // tamanho do campoo nome
				pnlNome1.add(lblJogador1);
				pnlNome1.add(txtJogador1);
				contentPanel.add(pnlNome1);
			}
			// painel nome2
			JPanel pnlNome2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			{
				JLabel lblJogador2 = new JLabel("Jogador 2: ");
				txtJogador2.setText("Jogador 2");
				txtJogador2.setColumns(40); // tamanho do campoo nome
				pnlNome2.add(lblJogador2);
				pnlNome2.add(txtJogador2);
				contentPanel.add(pnlNome2);
			}
			// painel dificuldade
			JPanel pnlDificuldade = new JPanel(new GridLayout(2, 1));
			{
				JLabel lblDificuldade = new JLabel("Dificuldade");
				JPanel pnlDificuldade2 = new JPanel(new GridLayout(1, 3));

				{
					rdo4x4.setSelected(true); // nivel de dificuldade já fica setada
					pnlDificuldade2.add(rdo4x4);
					pnlDificuldade2.add(rdo6x6);
					pnlDificuldade2.add(rdo8x8);

					ButtonGroup bgDificuldade = new ButtonGroup();
					bgDificuldade.add(rdo4x4);
					bgDificuldade.add(rdo6x6);
					bgDificuldade.add(rdo8x8);
				}

				pnlDificuldade.add(lblDificuldade);
				pnlDificuldade.add(pnlDificuldade2);

				contentPanel.add(pnlDificuldade);
			}
			contentPanel.add(Box.createRigidArea(getMinimumSize())); // borda da janela
		}

		{	//botão jogar
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton jogarButton = new JButton("Jogar");
				jogarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				jogarButton.setActionCommand("Jogar");
				buttonPane.add(jogarButton);
				getRootPane().setDefaultButton(jogarButton);

			}
		}
	}
}