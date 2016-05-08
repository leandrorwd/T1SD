package T1_FecheACaixaRMI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;

@SuppressWarnings("serial")
public class FechaACaixaClient extends JPanel {
	private JTextField campoNomeJogador;
	static FecheACaixaInterface fac;
	static int somaselecionados = 0, dados = 2;
	boolean[] botoesSelec = new boolean[9];
	private JTextField somaselec;
	private JTextField dado1;
	private JTextField dado2;
	static Random gerador = new Random();

	public static void main(String args[]) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {

		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			if ("Windows".equals(info.getName())) {
				javax.swing.UIManager.setLookAndFeel(info.getClassName());
				break;
			}
		}

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FechaACaixaClient gui = new FechaACaixaClient();
				show(gui);
			}
		});

		try {
			fac = (FecheACaixaInterface) Naming.lookup("//localhost/Fecha");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro TF.");
		}
	}

	private static void show(FechaACaixaClient ui) {
		JFrame frame = new JFrame();
		frame.setTitle("T1 Sistemas distribuidos - Leandro Oliveira e Nathan Dal Ben");
		frame.getContentPane().setBackground(Color.white);
		frame.setSize(620, 450);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(ui, BorderLayout.CENTER);
		frame.setLocationRelativeTo(null); // position in the center of the
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * Create the panel.
	 */
	public FechaACaixaClient() {
		setLayout(null);
		JLabel lblFechaACaixa = new JLabel("FECHA A CAIXA");
		lblFechaACaixa.setBounds(149, 5, 311, 49);
		lblFechaACaixa.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaACaixa.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFechaACaixa.setFont(new Font("Tahoma", Font.BOLD, 40));
		add(lblFechaACaixa);

		campoNomeJogador = new JTextField();
		campoNomeJogador.setBounds(137, 80, 184, 20);
		add(campoNomeJogador);
		campoNomeJogador.setColumns(10);

		JLabel lblNomeJogador = new JLabel("Nome do Jogador");
		lblNomeJogador.setBounds(45, 83, 90, 14);
		add(lblNomeJogador);

		JButton btnOk = new JButton("Ok");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					System.out.println(fac.registraJogador(campoNomeJogador.getText()));
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk.setBounds(331, 79, 66, 23);
		add(btnOk);

		JButton botao1 = new JButton("1");
		botao1.setLocation(10, 124);
		botao1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		botao1.setSize(55, 93);
		add(botao1);
		botao1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (botao1.isEnabled()) {
					if (botao1.getForeground() == Color.red) {
						botao1.setForeground(Color.black);
						somaselecionados -= 1;
						somaselec.setText(Integer.toString(somaselecionados));
						botoesSelec[0] = false;
					} else {
						botao1.setForeground(Color.red);
						somaselecionados += 1;
						somaselec.setText(Integer.toString(somaselecionados));
						botoesSelec[0] = true;
					}
					System.out.println(botao1.getForeground());
				}
			}
		});

		JButton botao2 = new JButton("2");
		botao2.setBounds(75, 124, 55, 93);
		add(botao2);
		botao2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		botao2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (botao2.isEnabled()) {
					if (botao2.getForeground() == Color.red) {
						botao2.setForeground(Color.black);
						somaselecionados -= 2;
						somaselec.setText(Integer.toString(somaselecionados));
						botoesSelec[1] = false;
					} else {
						botao2.setForeground(Color.red);
						somaselecionados += 2;
						somaselec.setText(Integer.toString(somaselecionados));
						botoesSelec[1] = true;
					}
				}
			}
		});

		JButton botao3 = new JButton("3");
		botao3.setBounds(139, 124, 55, 93);
		add(botao3);
		botao3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		botao3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (botao3.isEnabled()) {
					if (botao3.getForeground() == Color.red) {
						botao3.setForeground(Color.black);
						somaselecionados -= 3;
						somaselec.setText(Integer.toString(somaselecionados));
						botoesSelec[2] = false;
					} else {
						botao3.setForeground(Color.red);
						somaselecionados += 3;
						somaselec.setText(Integer.toString(somaselecionados));
						botoesSelec[2] = true;
					}
				}
			}
		});

		JButton botao4 = new JButton("4");
		botao4.setBounds(204, 124, 55, 93);
		add(botao4);
		botao4.setFont(new Font("Tahoma", Font.PLAIN, 40));
		botao4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (botao4.getForeground() == Color.red) {
					botao4.setForeground(Color.black);
				} else {
					botao4.setForeground(Color.red);
				}
			}
		});

		JButton botao5 = new JButton("5");
		botao5.setBounds(269, 124, 55, 93);
		add(botao5);
		botao5.setFont(new Font("Tahoma", Font.PLAIN, 40));
		botao5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (botao5.getForeground() == Color.red) {
					botao5.setForeground(Color.black);
				} else {
					botao5.setForeground(Color.red);
				}
			}
		});

		JButton botao6 = new JButton("6");
		botao6.setBounds(334, 124, 55, 93);
		add(botao6);
		botao6.setFont(new Font("Tahoma", Font.PLAIN, 40));
		botao6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (botao6.getForeground() == Color.red) {
					botao6.setForeground(Color.black);
				} else {
					botao6.setForeground(Color.red);
				}
			}
		});

		JButton botao7 = new JButton("7");
		botao7.setBounds(399, 124, 55, 93);
		add(botao7);
		botao7.setFont(new Font("Tahoma", Font.PLAIN, 40));
		botao7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (botao7.getForeground() == Color.red) {
					botao7.setForeground(Color.black);
				} else {
					botao7.setForeground(Color.red);
				}
			}
		});

		JButton botao8 = new JButton("8");
		botao8.setBounds(464, 124, 55, 93);
		add(botao8);
		botao8.setFont(new Font("Tahoma", Font.PLAIN, 40));
		botao8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (botao8.getForeground() == Color.red) {
					botao8.setForeground(Color.black);
				} else {
					botao8.setForeground(Color.red);
				}
			}
		});

		JButton botao9 = new JButton("9");
		botao9.setFont(new Font("Tahoma", Font.PLAIN, 40));
		botao9.setBounds(529, 124, 55, 93);
		add(botao9);
		
		JLabel lblTotalSelecionado = new JLabel("Total selecionado:");
		lblTotalSelecionado.setBounds(48, 241, 90, 14);
		add(lblTotalSelecionado);

		somaselec = new JTextField();
		somaselec.setHorizontalAlignment(SwingConstants.CENTER);
		somaselec.setBounds(137, 238, 55, 20);
		add(somaselec);
		somaselec.setColumns(10);

		JButton btnConfirmarJogada = new JButton("Confirmar Jogada");
		btnConfirmarJogada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < 9; i++) {
					if (botoesSelec[i]) {
						switch (i) {
						case 0:
							botao1.setEnabled(false);
							botao1.setForeground(Color.black);
							
							break;
						case 1:
							botao2.setEnabled(false);
							botao2.setForeground(Color.black);
							break;
						case 2:
							botao3.setEnabled(false);
							botao3.setForeground(Color.black);
							break;
						}
					}
				}
				somaselecionados = 0;
				somaselec.setText(Integer.toString(somaselecionados));
			}
		});
		btnConfirmarJogada.setBounds(437, 232, 120, 23);
		add(btnConfirmarJogada);
		
		dado1 = new JTextField();
		dado1.setHorizontalAlignment(SwingConstants.CENTER);
		dado1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		dado1.setBounds(44, 329, 86, 67);
		add(dado1);
		dado1.setColumns(10);
		
		JLabel lblDado = new JLabel("Dado 1");
		lblDado.setBounds(66, 304, 46, 14);
		add(lblDado);
		
		JLabel lblDado_1 = new JLabel("Dado 2");
		lblDado_1.setBounds(166, 304, 46, 14);
		add(lblDado_1);
		
		dado2 = new JTextField();
		dado2.setHorizontalAlignment(SwingConstants.CENTER);
		dado2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		dado2.setColumns(10);
		dado2.setBounds(146, 329, 86, 67);
		add(dado2);
		
		JButton btnJogarDados = new JButton("Jogar dados");
		btnJogarDados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (dados == 2) {
					dado1.setText(Integer.toString(gerador.nextInt(6)+1));
					dado2.setText(Integer.toString(gerador.nextInt(6)+1));
				} if (dados == 1) {
					dado1.setText(Integer.toString(gerador.nextInt(6)));
					dado2.setText(" ");
				}
			}
		});
		btnJogarDados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnJogarDados.setBounds(269, 329, 139, 67);
		add(btnJogarDados);
	}
}
