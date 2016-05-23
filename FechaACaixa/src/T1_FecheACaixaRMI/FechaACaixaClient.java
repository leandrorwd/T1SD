package T1_FecheACaixaRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class FechaACaixaClient {
	int id;
	FecheACaixaInterface fac;

	public FechaACaixaClient(String server) throws MalformedURLException, RemoteException, NotBoundException {
		try {
			fac = (FecheACaixaInterface) Naming.lookup("//" + server + "/Fecha");
		} catch (Exception e) {
			System.out.println("Erro TF.");
		}
	}

	public String getNomeJogador() throws RemoteException {
		return fac.getNomeJogador(id);
	}

	public void setNomeJogador(String nomeJogador) throws RemoteException {
		id = fac.registraJogador(nomeJogador);
	}

	public void setSelecionaCasa(int pos, boolean b) throws RemoteException {
		fac.setSelecionaCasa(id, pos, b);
	}
	
	public int getSomaSelecionados() throws RemoteException {
		return fac.getSomaSelecionadas(id);
	}
	
	public void zerarSomaSelecionadas () throws RemoteException {
		fac.zerarSomaSelecionadas(id);
	}
	
	public boolean[] getSelecionadas() throws RemoteException {
		return fac.getSelecionadas(id);
	}
	
	public int enviaJogada() throws RemoteException {
		return fac.enviaJogada(id);
	}

	public void encerraPartida() throws RemoteException {
		fac.encerraPartida(id);
	}

	public int[] jogaDados() throws RemoteException {
		return fac.jogaDados(id);
	}
	public int getScore() throws RemoteException {
		return fac.obtemPontuacao(id);
	}
}