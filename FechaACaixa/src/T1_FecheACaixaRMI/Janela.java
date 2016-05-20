package T1_FecheACaixaRMI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Janela extends JPanel {
	static JFrame frame;
	static int somaselecionados = 0;
	// static int dados = 2;
	int[] dados;
	// boolean[] botoesSelec = new boolean[9];
	public JTextField somaSelecionados;
	private JTextField dado1;
	private JTextField dado2;
	private JButton btnJogarDados;
	static Random gerador = new Random();
	static FechaACaixaClient client;
	private JTextField subtotal;
	private JButton btn_desistir;

	public static void main(String args[])
			throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException, MalformedURLException, RemoteException, NotBoundException {

		client = new FechaACaixaClient();

		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			if ("Windows".equals(info.getName())) {
				javax.swing.UIManager.setLookAndFeel(info.getClassName());
				break;
			}
		}

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Object result;
				Janela gui = new Janela();
				gui.somaSelecionados.setText("0");
				show(gui);
				JanelaAux gui2 = new JanelaAux();
				result = gui2.show();
				if (result == null) {
					JOptionPane.showConfirmDialog(null, "Um nome deve ser informado. O jogo será encerrado.", "Erro",
							JOptionPane.DEFAULT_OPTION);
					frame.dispose();
				} else {
					try {
						client.setNomeJogador(result.toString());
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}

	private static void show(Janela ui) {
		frame = new JFrame();
		frame.setTitle("T1 ... Sistemas distribuidos - Leandro Oliveira e Nathan Dal Ben");
		frame.getContentPane().setBackground(Color.white);
		frame.setSize(614, 603);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(ui, BorderLayout.CENTER);
		frame.setLocationRelativeTo(null); // position in the center of the
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * Create the panel.
	 */
	public Janela() {
		setLayout(null);
		JLabel lblFechaACaixa = new JLabel("FECHA A CAIXA");
		lblFechaACaixa.setBounds(10, 5, 580, 63);
		lblFechaACaixa.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaACaixa.setFont(new Font("Tahoma", Font.BOLD, 40));
		add(lblFechaACaixa);

		JButton botao1 = new JButton("1");
		botao1.setLocation(10, 241);
		botao1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		botao1.setSize(55, 93);
		add(botao1);
		botao1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (botao1.isEnabled()) {
					if (botao1.getForeground() == Color.red) {
						botao1.setForeground(Color.black);
						somaSelecionados.setText(Integer.toString(client.casaDeselecionada(0)));
					} else {
						botao1.setForeground(Color.red);
						somaSelecionados.setText(Integer.toString(client.casaSelecionada(0)));
					}
				}
			}
		});

		JButton botao2 = new JButton("2");
		botao2.setBounds(75, 241, 55, 93);
		add(botao2);
		botao2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		botao2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (botao2.isEnabled()) {
					if (botao2.getForeground() == Color.red) {
						botao2.setForeground(Color.black);
						somaSelecionados.setText(Integer.toString(client.casaDeselecionada(1)));
					} else {
						botao2.setForeground(Color.red);
						somaSelecionados.setText(Integer.toString(client.casaSelecionada(1)));
					}
				}
			}
		});

		JButton botao3 = new JButton("3");
		botao3.setBounds(139, 241, 55, 93);
		add(botao3);
		botao3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		botao3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (botao3.isEnabled()) {
					if (botao3.isEnabled()) {
						if (botao3.getForeground() == Color.red) {
							botao3.setForeground(Color.black);
							somaSelecionados.setText(Integer.toString(client.casaDeselecionada(2)));
						} else {
							botao3.setForeground(Color.red);
							somaSelecionados.setText(Integer.toString(client.casaSelecionada(2)));
						}
					}
				}
			}
		});

		JButton botao4 = new JButton("4");
		botao4.setBounds(204, 241, 55, 93);
		add(botao4);
		botao4.setFont(new Font("Tahoma", Font.PLAIN, 40));
		botao4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (botao4.isEnabled()) {
					if (botao4.getForeground() == Color.red) {
						botao4.setForeground(Color.black);
						somaSelecionados.setText(Integer.toString(client.casaDeselecionada(3)));
					} else {
						botao4.setForeground(Color.red);
						somaSelecionados.setText(Integer.toString(client.casaSelecionada(3)));
					}
				}
			}
		});

		JButton botao5 = new JButton("5");
		botao5.setBounds(269, 241, 55, 93);
		add(botao5);
		botao5.setFont(new Font("Tahoma", Font.PLAIN, 40));
		botao5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (botao5.isEnabled()) {
					if (botao5.getForeground() == Color.red) {
						botao5.setForeground(Color.black);
						somaSelecionados.setText(Integer.toString(client.casaDeselecionada(4)));
					} else {
						botao5.setForeground(Color.red);
						somaSelecionados.setText(Integer.toString(client.casaSelecionada(4)));
					}
				}
			}
		});

		JButton botao6 = new JButton("6");
		botao6.setBounds(334, 241, 55, 93);
		add(botao6);
		botao6.setFont(new Font("Tahoma", Font.PLAIN, 40));
		botao6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (botao6.isEnabled()) {
					if (botao6.getForeground() == Color.red) {
						botao6.setForeground(Color.black);
						somaSelecionados.setText(Integer.toString(client.casaDeselecionada(5)));
					} else {
						botao6.setForeground(Color.red);
						somaSelecionados.setText(Integer.toString(client.casaSelecionada(5)));
					}
				}
			}
		});

		JButton botao7 = new JButton("7");
		botao7.setBounds(399, 241, 55, 93);
		add(botao7);
		botao7.setFont(new Font("Tahoma", Font.PLAIN, 40));
		botao7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (botao7.isEnabled()) {
					if (botao7.getForeground() == Color.red) {
						botao7.setForeground(Color.black);
						somaSelecionados.setText(Integer.toString(client.casaDeselecionada(6)));
					} else {
						botao7.setForeground(Color.red);
						somaSelecionados.setText(Integer.toString(client.casaSelecionada(6)));
					}
				}
			}
		});

		JButton botao8 = new JButton("8");
		botao8.setBounds(464, 241, 55, 93);
		add(botao8);
		botao8.setFont(new Font("Tahoma", Font.PLAIN, 40));
		botao8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (botao8.isEnabled()) {
					if (botao8.getForeground() == Color.red) {
						botao8.setForeground(Color.black);
						somaSelecionados.setText(Integer.toString(client.casaDeselecionada(7)));
					} else {
						botao8.setForeground(Color.red);
						somaSelecionados.setText(Integer.toString(client.casaSelecionada(7)));
					}
				}
			}
		});

		JButton botao9 = new JButton("9");
		botao9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (botao9.isEnabled()) {
					if (botao9.getForeground() == Color.red) {
						botao9.setForeground(Color.black);
						somaSelecionados.setText(Integer.toString(client.casaDeselecionada(8)));
					} else {
						botao9.setForeground(Color.red);
						somaSelecionados.setText(Integer.toString(client.casaSelecionada(8)));
					}
				}
			}
		});
		botao9.setFont(new Font("Tahoma", Font.PLAIN, 40));
		botao9.setBounds(529, 241, 55, 93);
		add(botao9);

		JLabel lblTotalSelecionado = new JLabel("Total selecionado:");
		lblTotalSelecionado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTotalSelecionado.setBounds(44, 400, 179, 21);
		add(lblTotalSelecionado);

		somaSelecionados = new JTextField();
		somaSelecionados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		somaSelecionados.setHorizontalAlignment(SwingConstants.CENTER);
		somaSelecionados.setBounds(243, 396, 66, 31);
		add(somaSelecionados);
		somaSelecionados.setColumns(10);

		JButton btnConfirmarJogada = new JButton("Confirmar Jogada");
		btnConfirmarJogada.setEnabled(false);
		btnConfirmarJogada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConfirmarJogada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int response = -1;
				boolean[] desabilita = new boolean[9];
				if (btnConfirmarJogada.isEnabled()) {
					try {
						response = client.enviaJogada();
						if (response == 0) {
							desabilita = client.getCasas();
							if (desabilita[0] == true) {
								client.casaDeselecionada(0);
								botao1.setForeground(Color.GRAY);
								botao1.setEnabled(false);
							}
							if (desabilita[1] == true) {
								client.casaDeselecionada(1);
								botao2.setForeground(Color.GRAY);
								botao2.setEnabled(false);
							}
							if (desabilita[2] == true) {
								client.casaDeselecionada(2);
								botao3.setForeground(Color.GRAY);
								botao3.setEnabled(false);
							}
							if (desabilita[3] == true) {
								client.casaDeselecionada(3);
								botao4.setForeground(Color.GRAY);
								botao4.setEnabled(false);
							}
							if (desabilita[4] == true) {
								client.casaDeselecionada(4);
								botao5.setForeground(Color.GRAY);
								botao5.setEnabled(false);
							}
							if (desabilita[5] == true) {
								client.casaDeselecionada(5);
								botao6.setForeground(Color.GRAY);
								botao6.setEnabled(false);
							}
							if (desabilita[6] == true) {
								client.casaDeselecionada(6);
								botao7.setForeground(Color.GRAY);
								botao7.setEnabled(false);
							}
							if (desabilita[7] == true) {
								client.casaDeselecionada(7);
								botao8.setForeground(Color.GRAY);
								botao8.setEnabled(false);
							}
							if (desabilita[8] == true) {
								client.casaDeselecionada(8);
								botao9.setForeground(Color.GRAY);
								botao9.setEnabled(false);
							}
							dado1.setText("");
							dado2.setText("");
							btn_desistir.setEnabled(false);
							btnJogarDados.setEnabled(true);
							btnConfirmarJogada.setEnabled(false);
							somaSelecionados.setText(Integer.toString(client.somaSelecionados));
							// System.out.println("Soma Selec: " +
							// Integer.toString(client.somaSelecionados));
							JOptionPane.showConfirmDialog(null, "Jogada correta.", "Confirmação",
									JOptionPane.DEFAULT_OPTION);
						} else if (response == -1) {
							if (botao1.isEnabled())
								botao1.setForeground(Color.BLACK);
							if (botao2.isEnabled())
								botao2.setForeground(Color.BLACK);
							if (botao3.isEnabled())
								botao3.setForeground(Color.BLACK);
							if (botao4.isEnabled())
								botao4.setForeground(Color.BLACK);
							if (botao5.isEnabled())
								botao5.setForeground(Color.BLACK);
							if (botao6.isEnabled())
								botao6.setForeground(Color.BLACK);
							if (botao7.isEnabled())
								botao7.setForeground(Color.BLACK);
							if (botao8.isEnabled())
								botao8.setForeground(Color.BLACK);
							if (botao9.isEnabled())
								botao9.setForeground(Color.BLACK);
							for (int i = 0; i < 9; i++) {
								client.casaDeselecionada(i);
							}
							btnJogarDados.setEnabled(false);
							somaSelecionados.setText(Integer.toString(client.somaSelecionados));
							JOptionPane.showConfirmDialog(null, "Jogada incorreta.", "Confirmação",
									JOptionPane.DEFAULT_OPTION);
						} else if (response == 1) {
							JOptionPane.showConfirmDialog(null,
									"Você concluiu o jogo com " + subtotal.getText() + " pontos. Parabéns!",
									"Jogo concluído", JOptionPane.DEFAULT_OPTION);
							client.encerraPartida();
							frame.dispose();
						}
					} catch (RemoteException e2) {
						// TODO Auto-generated catch block
						JOptionPane.showConfirmDialog(null, "Ocorreu um erro na comunicação. Tente novamente.", "ERRO",
								JOptionPane.DEFAULT_OPTION);
						e2.printStackTrace();
					}
				}
			}
		});
		btnConfirmarJogada.setBounds(382, 379, 189, 67);
		add(btnConfirmarJogada);

		dado1 = new JTextField();
		dado1.setHorizontalAlignment(SwingConstants.CENTER);
		dado1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		dado1.setBounds(100, 114, 86, 67);
		add(dado1);
		dado1.setColumns(10);

		JLabel lblDado = new JLabel("Dado 1");
		lblDado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDado.setBounds(28, 135, 72, 23);
		add(lblDado);

		JLabel lblDado_1 = new JLabel("Dado 2");
		lblDado_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDado_1.setBounds(205, 135, 70, 22);
		add(lblDado_1);

		dado2 = new JTextField();
		dado2.setHorizontalAlignment(SwingConstants.CENTER);
		dado2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		dado2.setColumns(10);
		dado2.setBounds(275, 114, 86, 67);
		add(dado2);

		btnJogarDados = new JButton("Jogar dados");
		btnJogarDados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (btnJogarDados.isEnabled()) {
					dados = new int[2];
					try {
						dados = client.jogaDados();
						dado1.setText(Integer.toString(dados[0]));
						if (dados[1] != 0) {
							dado2.setText(Integer.toString(dados[1]));
						} else {
							dado2.setText("-");
						}
						btnJogarDados.setEnabled(false);
						btnConfirmarJogada.setEnabled(true);
						btn_desistir.setEnabled(true);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnJogarDados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnJogarDados.setBounds(382, 115, 189, 67);
		add(btnJogarDados);

		btn_desistir = new JButton("Acumular Dados");
		btn_desistir.setEnabled(false);
		btn_desistir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (btn_desistir.isEnabled()) {
					int answer = JOptionPane.showConfirmDialog(null, "Deseja acumular o valor dos dados?",
							"Confirmação", JOptionPane.YES_NO_OPTION);
					if (answer == 0) {
						try {

							subtotal.setText(Integer.toString(client.getScore()));
							dado1.setText("");
							dado2.setText("");
							btnConfirmarJogada.setEnabled(false);
							btnJogarDados.setEnabled(true);
							btn_desistir.setEnabled(false);
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		btn_desistir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_desistir.setBounds(382, 485, 189, 67);
		add(btn_desistir);

		JLabel lblSubtotalAcumulado = new JLabel("Subtotal Acumulado:");
		lblSubtotalAcumulado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubtotalAcumulado.setBounds(44, 509, 201, 21);
		add(lblSubtotalAcumulado);

		subtotal = new JTextField();
		subtotal.setHorizontalAlignment(SwingConstants.CENTER);
		subtotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		subtotal.setColumns(10);
		subtotal.setBounds(243, 504, 66, 31);
		add(subtotal);

		JLabel lblJogueOsDados = new JLabel("1. Jogue os Dados");
		lblJogueOsDados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblJogueOsDados.setBounds(23, 74, 107, 14);
		add(lblJogueOsDados);

		JLabel lblEscolhaOsNmeros = new JLabel("2. Escolha os n\u00FAmeros, que somados, deem a soma dos dados");
		lblEscolhaOsNmeros.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEscolhaOsNmeros.setBounds(23, 212, 351, 14);
		add(lblEscolhaOsNmeros);

		JLabel lblSeOsNmeros = new JLabel("3. Se os n\u00FAmeros combinarem com os dados, confirme a jogada");
		lblSeOsNmeros.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeOsNmeros.setBounds(23, 357, 366, 14);
		add(lblSeOsNmeros);

		JLabel lblSeNoCombinarem = new JLabel(
				"4. Se n\u00E3o combinarem, acumule os pontos e jogue os dados novamente");
		lblSeNoCombinarem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeNoCombinarem.setBounds(23, 463, 431, 14);
		add(lblSeNoCombinarem);

		JPanel panel = new JPanel();
		panel.setForeground(Color.GRAY);
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setBounds(7, 90, 583, 111);
		add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.GRAY);
		panel_1.setBorder(new LineBorder(Color.GRAY));
		panel_1.setBounds(7, 228, 583, 118);
		add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.GRAY);
		panel_2.setBorder(new LineBorder(Color.GRAY));
		panel_2.setBounds(7, 70, 583, 21);
		add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.GRAY);
		panel_3.setBorder(new LineBorder(Color.GRAY));
		panel_3.setBounds(7, 208, 583, 21);
		add(panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setForeground(Color.GRAY);
		panel_4.setBorder(new LineBorder(Color.GRAY));
		panel_4.setBounds(8, 353, 583, 21);
		add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setForeground(Color.GRAY);
		panel_5.setBorder(new LineBorder(Color.GRAY));
		panel_5.setBounds(8, 373, 583, 78);
		add(panel_5);

		JPanel panel_6 = new JPanel();
		panel_6.setForeground(Color.GRAY);
		panel_6.setBorder(new LineBorder(Color.GRAY));
		panel_6.setBounds(8, 459, 583, 21);
		add(panel_6);

		JPanel panel_7 = new JPanel();
		panel_7.setForeground(Color.GRAY);
		panel_7.setBorder(new LineBorder(Color.GRAY));
		panel_7.setBounds(8, 479, 583, 78);
		add(panel_7);

	}
}
