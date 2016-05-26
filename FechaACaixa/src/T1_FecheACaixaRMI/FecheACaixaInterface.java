package T1_FecheACaixaRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * INTERFACE COM O MÉTODOS UTILIZADOS PELO CLIENT E O SERVER
 * 
 * @author Leandro Rowedder de Oliveira
 * @author Nathan Dal Ben Flores
 **/

public interface FecheACaixaInterface extends Remote{
	public int registraJogador(String nome) throws RemoteException;
	public void encerraPartida (int id) throws RemoteException;
	public int obtemPontuacao (int id) throws RemoteException;
	public int[] jogaDados (int id) throws RemoteException;
	public int enviaJogada (int id) throws RemoteException;
	public String getNomeJogador(int id) throws RemoteException;
	public void setSelecionaCasa(int id, int pos, boolean e) throws RemoteException;
	public boolean[] getSelecionadas(int id) throws RemoteException;
	public int getSomaSelecionadas(int id) throws RemoteException;
	public void zerarSomaSelecionadas (int id) throws RemoteException;
}
