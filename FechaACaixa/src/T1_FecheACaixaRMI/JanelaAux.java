package T1_FecheACaixaRMI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JanelaAux {
	JFrame frame;
	
	public JanelaAux() {
		frame = new JFrame();
		
	}
	
	public Object show() {
		Object result;
		result = JOptionPane.showInputDialog("Insira o seu nome:");
		return result;
	}

}