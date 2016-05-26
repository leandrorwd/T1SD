package T1_FecheACaixaRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * GERENCIA A JANELA E CHAMA OS M�TODOS DO SERVIDOR VIA RMI
 * 
 * @author Leandro Rowedder de Oliveira
 * @author Nathan Dal Ben Flores
 **/

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

	/**
	 * Retorna o nome do jogador.
	 * 
	 * @return Nome do jogador
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public String getNomeJogador() throws RemoteException {
		return fac.getNomeJogador(id);
	}

	/**
	 * Determina o nome do jogador e determina a identifica��o da
	 * partida/jogador.
	 * 
	 * @param nomeJogador Nome do jogador na partida
	 *            
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public void setNomeJogador(String nomeJogador) throws RemoteException {
		id = fac.registraJogador(nomeJogador);
	}

	/**
	 * Seleciona ou deseleciona uma casa baseado na decis�o do jogador.
	 * 
	 * @param pos Posi��o da casa a ser selecionada ou n�o
	 * @param b True para selecionada e false para n�o-selecionada
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public void setSelecionaCasa(int pos, boolean b) throws RemoteException {
		fac.setSelecionaCasa(id, pos, b);
	}

	/**
	 * Retorna a soma das casas selecionadas.
	 * 
	 * @return Soma das casas selecionadas
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public int getSomaSelecionados() throws RemoteException {
		return fac.getSomaSelecionadas(id);
	}

	/**
	 * Chama o m�todo do servidor para zerar a soma de casas selecionadas
	 *
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public void zerarSomaSelecionadas() throws RemoteException {
		fac.zerarSomaSelecionadas(id);
	}

	/**
	 * Solicita do server que retorne as casas que est�o selecionadas e as que
	 * n�o.
	 * 
	 * @return Casas selecionadas e as n�o-selecionadas
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public boolean[] getSelecionadas() throws RemoteException {
		return fac.getSelecionadas(id);
	}

	/**
	 * Envia ao servidor uma solicita��o de realiza��o de uma jogada.
	 * 
	 * @return O status da jogada enviada
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public int enviaJogada() throws RemoteException {
		return fac.enviaJogada(id);
	}

	/**
	 * Solicita ao servidor o encerramento de uma partida.
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public void encerraPartida() throws RemoteException {
		fac.encerraPartida(id);
	}

	/**
	 * Solicita ao servidor que sejam jogados o(s) dado(s).
	 * 
	 * @return Retorna o valor do(s) dado(s) jogado(s)
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public int[] jogaDados() throws RemoteException {
		return fac.jogaDados(id);
	}

	/**
	 * Solicita ao servidor o score (pontua��o) da partida.
	 * 
	 * @return Retorna o valor do score da partida atual
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public int getScore() throws RemoteException {
		return fac.obtemPontuacao(id);
	}
}