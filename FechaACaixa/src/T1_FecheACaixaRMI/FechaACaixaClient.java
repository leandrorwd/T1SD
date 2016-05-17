package T1_FecheACaixaRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class FechaACaixaClient {
	int codigoJogador;
	String nomeJogador;
	int somaSelecionados;

	// 0 livre
	// 1 clicado aguardando jogada
	// -1 desativado
	boolean[] casas = { false, false, false, false, false, false, false, false, false};

	public boolean[] getCasas() {
		return casas;
	}

	public void setCasas(boolean[] casas) {
		this.casas = casas;
	}

	FecheACaixaInterface fac;

	public FechaACaixaClient() throws MalformedURLException, RemoteException, NotBoundException {
		somaSelecionados = 0;
		casas = new boolean[9];
		try {
			fac = (FecheACaixaInterface) Naming.lookup("//localhost/Fecha");
		} catch (Exception e) {
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

	public int casaSelecionada(int pos) {
		somaSelecionados += pos;
		casas[pos - 1] = true;
		return somaSelecionados;
	}

	public int casaDeselecionada(int pos) {
		somaSelecionados -= pos;
		casas[pos - 1] = false;
		return somaSelecionados;
	}
	
	public boolean enviaJogada() throws RemoteException {
		somaSelecionados = 0;
		return fac.selecionaCasas(codigoJogador, casas);
	}
	
	public int cancelaPartida() throws RemoteException {
		return fac.encerraPartida(codigoJogador);
	}

	public int[] jogaDados() throws RemoteException{
		return fac.jogaDados(codigoJogador);
	}
	
}