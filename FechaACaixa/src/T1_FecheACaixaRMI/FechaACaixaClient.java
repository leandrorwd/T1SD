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

	 /**
	  * Insere o nome do jogador.
	  * 
	  * @retur id	Número de identificação do jogador
	  * @author     Leandro Oliveira
	  * @author     Nathan Dal Ben Flores
	 **/
	
	public String getNomeJogador() throws RemoteException {
		return fac.getNomeJogador(id);
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
	
	public void setNomeJogador(String nomeJogador) throws RemoteException {
		id = fac.registraJogador(nomeJogador);
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
	
	public void setSelecionaCasa(int pos, boolean b) throws RemoteException {
		fac.setSelecionaCasa(id, pos, b);
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
	
	public int getSomaSelecionados() throws RemoteException {
		return fac.getSomaSelecionadas(id);
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
	
	public void zerarSomaSelecionadas () throws RemoteException {
		fac.zerarSomaSelecionadas(id);
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
	
	public boolean[] getSelecionadas() throws RemoteException {
		return fac.getSelecionadas(id);
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
	
	public int enviaJogada() throws RemoteException {
		return fac.enviaJogada(id);
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
	
	public void encerraPartida() throws RemoteException {
		fac.encerraPartida(id);
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
	
	public int[] jogaDados() throws RemoteException {
		return fac.jogaDados(id);
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
	
	public int getScore() throws RemoteException {
		return fac.obtemPontuacao(id);
	}
}