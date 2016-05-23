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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Janela extends JPanel {

	private static final long serialVersionUID = 1L;
	static JFrame frame;
	static int somaselecionados = 0;
	int[] dados;
	public JTextField somaSelecionados;
	private JTextField dado1;
	private JTextField dado2;
	private JButton btnJogarDados;
	static Random gerador = new Random();
	static FechaACaixaClient client;
	private JTextField subtotal;
	private JButton btn_acumularPontos;

	public static void main(String args[])
			throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException, MalformedURLException, RemoteException, NotBoundException {

		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			if ("Windows".equals(info.getName())) {
				javax.swing.UIManager.setLookAndFeel(info.getClassName());
				break;
			}
		}

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				FileReader arq;
				BufferedReader lerArq;
				try {
					arq = new FileReader("src\\T1_FecheACaixaRMI\\ip.ini");
					lerArq = new BufferedReader(arq);	
					client = new FechaACaixaClient(lerArq.readLine());
					arq.close();
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println();
				Object result;
				Janela gui = new Janela();
				gui.somaSelecionados.setText("0");
				show(gui);
				result = JOptionPane.showInputDialog(null, "Insira o seu nome: ", "Nome do Jogador", 3);
				frame.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent windowEvent) {
						if (JOptionPane.showConfirmDialog(frame, "Você deseja encerrar o jogo?", "Fechar realmente?",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
							try {
								client.encerraPartida();
								frame.dispose();
							} catch (RemoteException e) {
								e.printStackTrace();
							}
						} else {
							frame.setDefaultCloseOperation(0);
						}
					}
				});

				if (result == null) {
					JOptionPane.showConfirmDialog(null, "Um nome deve ser informado. O jogo será encerrado.", "Erro",
							JOptionPane.DEFAULT_OPTION);
					frame.dispose();
				} else {
					try {
						client.setNomeJogador(result.toString());
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	 /**
	  * Valida um movimento de xadrez.
	  * 
	  * @param aColunaDe   Coluna atual da peça a ser movida
	  * @param aLinhaDe    Linha atual da peça a ser movida
	  * @param aColunaPara Coluna destino da peça a ser movida
	  * @param aLinhaPara  Linha destino da peça a ser movida
	  * @author            Leandro Oliveira
	  * @author            Nathan Dal Ben Flores
	  **/
	
	private static void show(Janela ui) {
		frame = new JFrame();
		frame.setTitle("T1 | Sistemas distribuidos | Leandro Oliveira e Nathan Dal Ben");
		frame.getContentPane().setBackground(Color.white);
		frame.setSize(614, 603);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(ui, BorderLayout.CENTER);
		frame.setLocationRelativeTo(null); // position in the center of the
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	 /**
	  * Valida um movimento de xadrez.
	  * 
	  * @param aColunaDe   Coluna atual da peça a ser movida
	  * @param aLinhaDe    Linha atual da peça a ser movida
	  * @param aColunaPara Coluna destino da peça a ser movida
	  * @param aLinhaPara  Linha destino da peça a ser movida
	  * @author            Leandro Oliveira
	  * @author            Nathan Dal Ben Flores
	  **/
	
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
					try {
						if (botao1.getForeground() == Color.red) {
							botao1.setForeground(Color.black);
							client.setSelecionaCasa(1, false);
							somaSelecionados.setText(Integer.toString(client.getSomaSelecionados()));
						} else {
							botao1.setForeground(Color.red);
							client.setSelecionaCasa(1, true);
							somaSelecionados.setText(Integer.toString(client.getSomaSelecionados()));
						}
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
					try {
						if (botao2.getForeground() == Color.red) {
							botao2.setForeground(Color.black);
							client.setSelecionaCasa(2, false);
							somaSelecionados.setText(Integer.toString(client.getSomaSelecionados()));
						} else {
							botao2.setForeground(Color.red);
							client.setSelecionaCasa(2, true);
							somaSelecionados.setText(Integer.toString(client.getSomaSelecionados()));
						}
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
						try {
							if (botao3.getForeground() == Color.red) {
								botao3.setForeground(Color.black);
								client.setSelecionaCasa(3, false);
								somaSelecionados.setText(Integer.toString(client.getSomaSelecionados()));
							} else {
								botao3.setForeground(Color.red);
								client.setSelecionaCasa(3, true);
								somaSelecionados.setText(Integer.toString(client.getSomaSelecionados()));
							}
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
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
					try {
						if (botao4.getForeground() == Color.red) {
							botao4.setForeground(Color.black);
							client.setSelecionaCasa(4, false);
							somaSelecionados.setText(Integer.toString(client.getSomaSelecionados()));
						} else {
							botao4.setForeground(Color.red);
							client.setSelecionaCasa(4, true);
							somaSelecionados.setText(Integer.toString(client.getSomaSelecionados()));
						}
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
					try {
						if (botao5.getForeground() == Color.red) {
							botao5.setForeground(Color.black);
							client.setSelecionaCasa(5, false);
							somaSelecionados.setText(Integer.toString(client.getSomaSelecionados()));
						} else {
							botao5.setForeground(Color.red);
							client.setSelecionaCasa(5, true);
							somaSelecionados.setText(Integer.toString(client.getSomaSelecionados()));
						}
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
					try {
						if (botao6.getForeground() == Color.red) {
							botao6.setForeground(Color.black);
							client.setSelecionaCasa(6, false);
							somaSelecionados.setText(Integer.toString(client.getSomaSelecionados()));
						} else {
							botao6.setForeground(Color.red);
							client.setSelecionaCasa(6, true);
							somaSelecionados.setText(Integer.toString(client.getSomaSelecionados()));
						}
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
					try {
						if (botao7.getForeground() == Color.red) {
							botao7.setForeground(Color.black);
							client.setSelecionaCasa(7, false);
							somaSelecionados.setText(Integer.toString(client.getSomaSelecionados()));
						} else {
							botao7.setForeground(Color.red);
							client.setSelecionaCasa(7, true);
							somaSelecionados.setText(Integer.toString(client.getSomaSelecionados()));
						}
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
					try {
						if (botao8.getForeground() == Color.red) {
							botao8.setForeground(Color.black);
							client.setSelecionaCasa(8, false);
							somaSelecionados.setText(Integer.toString(client.getSomaSelecionados()));
						} else {
							botao8.setForeground(Color.red);
							client.setSelecionaCasa(8, true);
							somaSelecionados.setText(Integer.toString(client.getSomaSelecionados()));
						}
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});

		JButton botao9 = new JButton("9");
		botao9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (botao9.isEnabled()) {
					try {
						if (botao9.getForeground() == Color.red) {
							botao9.setForeground(Color.black);
							client.setSelecionaCasa(9, false);
							somaSelecionados.setText(Integer.toString(client.getSomaSelecionados()));
						} else {
							botao9.setForeground(Color.red);
							client.setSelecionaCasa(9, true);
							somaSelecionados.setText(Integer.toString(client.getSomaSelecionados()));
						}
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});
		botao9.setFont(new Font("Tahoma", Font.PLAIN, 40));
		botao9.setBounds(529, 241, 55, 93);

		add(botao9);

		JLabel lblTotalSelecionado = new JLabel("Total Selecionado:");
		lblTotalSelecionado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTotalSelecionado.setBounds(44, 400, 179, 21);
		add(lblTotalSelecionado);

		somaSelecionados = new JTextField();
		somaSelecionados.setEditable(false);
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
							desabilita = client.getSelecionadas();

							if (desabilita[0] == true) {
								client.setSelecionaCasa(1, false);
								botao1.setForeground(Color.GRAY);
								botao1.setEnabled(false);
							}
							if (desabilita[1] == true) {
								client.setSelecionaCasa(2, false);
								botao2.setForeground(Color.GRAY);
								botao2.setEnabled(false);
							}
							if (desabilita[2] == true) {
								client.setSelecionaCasa(3, false);
								botao3.setForeground(Color.GRAY);
								botao3.setEnabled(false);
							}
							if (desabilita[3] == true) {
								client.setSelecionaCasa(4, false);
								botao4.setForeground(Color.GRAY);
								botao4.setEnabled(false);
							}
							if (desabilita[4] == true) {
								client.setSelecionaCasa(5, false);
								botao5.setForeground(Color.GRAY);
								botao5.setEnabled(false);
							}
							if (desabilita[5] == true) {
								client.setSelecionaCasa(6, false);
								botao6.setForeground(Color.GRAY);
								botao6.setEnabled(false);
							}
							if (desabilita[6] == true) {
								client.setSelecionaCasa(7, false);
								botao7.setForeground(Color.GRAY);
								botao7.setEnabled(false);
							}
							if (desabilita[7] == true) {
								client.setSelecionaCasa(8, false);
								botao8.setForeground(Color.GRAY);
								botao8.setEnabled(false);
							}
							if (desabilita[8] == true) {
								client.setSelecionaCasa(9, false);
								botao9.setForeground(Color.GRAY);
								botao9.setEnabled(false);
							}
							dado1.setText("");
							dado2.setText("");
							btn_acumularPontos.setEnabled(false);
							btnJogarDados.setEnabled(true);
							btnConfirmarJogada.setEnabled(false);
							somaSelecionados.setText(Integer.toString(client.getSomaSelecionados()));
							JOptionPane.showConfirmDialog(null, "Jogada correta.", "Confirmação",
									JOptionPane.DEFAULT_OPTION, 1);
						} else if (response == -1) {
							if (botao1.isEnabled()) {
								client.setSelecionaCasa(1, false);
								botao1.setForeground(Color.BLACK);
							}
							if (botao2.isEnabled()) {
								client.setSelecionaCasa(2, false);
								botao2.setForeground(Color.BLACK);
							}
							if (botao3.isEnabled()) {
								client.setSelecionaCasa(3, false);
								botao3.setForeground(Color.BLACK);
							}
							if (botao4.isEnabled()) {
								client.setSelecionaCasa(4, false);
								botao4.setForeground(Color.BLACK);
							}
							if (botao5.isEnabled()) {
								client.setSelecionaCasa(5, false);
								botao5.setForeground(Color.BLACK);
							}
							if (botao6.isEnabled()) {
								client.setSelecionaCasa(6, false);
								botao6.setForeground(Color.BLACK);
							}
							if (botao7.isEnabled()) {
								client.setSelecionaCasa(7, false);
								botao7.setForeground(Color.BLACK);
							}
							if (botao8.isEnabled()) {
								client.setSelecionaCasa(8, false);
								botao8.setForeground(Color.BLACK);
							}
							if (botao9.isEnabled()) {
								client.setSelecionaCasa(9, false);
								botao9.setForeground(Color.BLACK);
							}
							client.zerarSomaSelecionadas();
							btnJogarDados.setEnabled(false);
							somaSelecionados.setText(Integer.toString(client.getSomaSelecionados()));
							JOptionPane.showConfirmDialog(null, "Jogada incorreta.", "Confirmação",
									JOptionPane.DEFAULT_OPTION, 0);
						} else if (response == 1) {
							JOptionPane.showConfirmDialog(null,
									"Você concluiu o jogo com " + subtotal.getText() + " pontos. Parabéns "
											+ client.getNomeJogador() + "!",
									"Jogo concluído", JOptionPane.DEFAULT_OPTION, 1);
							client.encerraPartida();
							frame.dispose();
						}
					} catch (RemoteException e2) {
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
		dado1.setEditable(false);
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
		dado2.setEditable(false);
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
							dado2.setText("");
						}
						btnJogarDados.setEnabled(false);
						btnConfirmarJogada.setEnabled(true);
						btn_acumularPontos.setEnabled(true);
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnJogarDados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnJogarDados.setBounds(382, 115, 189, 67);
		add(btnJogarDados);

		btn_acumularPontos = new JButton("Acumular Pontos");
		btn_acumularPontos.setEnabled(false);
		btn_acumularPontos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (btn_acumularPontos.isEnabled()) {
					int answer = JOptionPane.showConfirmDialog(null, "Deseja acumular o valor dos dados?",
							"Confirmação", JOptionPane.YES_NO_OPTION);
					if (answer == 0) {
						try {
							subtotal.setText(Integer.toString(client.getScore()));
							dado1.setText("");
							dado2.setText("");

							btnConfirmarJogada.setEnabled(false);
							btnJogarDados.setEnabled(true);
							btn_acumularPontos.setEnabled(false);
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		btn_acumularPontos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_acumularPontos.setBounds(382, 485, 189, 67);
		add(btn_acumularPontos);

		JLabel lblSubtotalAcumulado = new JLabel("Pontos Acumulados:");
		lblSubtotalAcumulado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubtotalAcumulado.setBounds(44, 509, 201, 21);
		add(lblSubtotalAcumulado);

		subtotal = new JTextField();
		subtotal.setEditable(false);
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
