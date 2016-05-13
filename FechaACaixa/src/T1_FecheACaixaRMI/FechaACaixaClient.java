package T1_FecheACaixaRMI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FechaACaixaClient {
	int codigoJogador;
	String nomeJogador;
	int somaSelecionados;
	
	// 0 livre
	// 1 clicado aguardando jogada
	// -1 desativado
	int[] numeros;

	FecheACaixaInterface fac;
	
	public FechaACaixaClient() throws MalformedURLException, RemoteException, NotBoundException {
		somaSelecionados = 0;
		numeros = new int[9];
		try {
			fac = (FecheACaixaInterface) Naming.lookup("//localhost/Fecha");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro TF.");
		}
	}

	public int getCodigoJogador() {
		return codigoJogador;
	}

	public void setCodigoJogador(int codigoJogador) {
		this.codigoJogador = codigoJogador;
	}

	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJogador) throws RemoteException {
		this.nomeJogador = nomeJogador;
		codigoJogador = fac.registraJogador(nomeJogador);
	}

	public String getSomaSelecionados() {
		return Integer.toString(somaSelecionados);
	}

	public void setSomaSelecionados(int somaSelecionados) {
		this.somaSelecionados = somaSelecionados;
	}

	public JButton numeroClicado(JButton botao, int pos) {
		if (botao.isEnabled()) {
			numeros[pos - 1] = true;
			if (botao.getForeground() == Color.red) {
				botao.setForeground(Color.black);
				somaSelecionados -= 1;
			} else {
				botao.setForeground(Color.red);
				somaSelecionados += 1;
			}
		}
		return botao;
	}

}