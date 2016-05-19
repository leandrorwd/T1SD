package T1_FecheACaixaRMI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JanelaAux {
	JFrame frame;

	public JanelaAux() {
		frame = new JFrame();
	}

	public Object show() {
		frame.setTitle("Nome do jogador");
		Object result;
		result = JOptionPane.showInputDialog(frame, "Insira o seu nome:");
		return result;
	}

}