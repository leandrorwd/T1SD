package T1_FecheACaixaRMI;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window extends JPanel {

	/**
	 * Create the panel.
	 */
	public Window() {
		setLayout(null);
		
		JLabel lblFechaACaixa = new JLabel("FECHA A CAIXA");
		lblFechaACaixa.setBounds(149, 5, 311, 49);
		lblFechaACaixa.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaACaixa.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFechaACaixa.setFont(new Font("Tahoma", Font.BOLD, 40));
		add(lblFechaACaixa);
		
		JPanel panel = new JPanel();
		panel.setBounds(45, 59, 554, 123);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton button_0 = new JButton("1");
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_0.setFont(new Font("Tahoma", Font.PLAIN, 40));
		button_0.setSize(100, 100);
		panel.add(button_0);
		
		JButton button_1 = new JButton("2");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel.add(button_1);
		
		JButton button_2 = new JButton("3");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel.add(button_2);
		
		JButton button_3 = new JButton("4");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel.add(button_3);
		
		JButton button_4 = new JButton("5");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel.add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel.add(button_5);
		
		JButton button_6 = new JButton("7");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel.add(button_6);
		
		JButton button_7 = new JButton("8");
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel.add(button_7);
		
		JButton btnJogarDados = new JButton("CONFIRMA JOGADA");
		btnJogarDados.setBounds(239, 131, 131, 23);
		btnJogarDados.setHorizontalAlignment(SwingConstants.LEFT);
		add(btnJogarDados);

	}

}
