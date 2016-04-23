package T1_FecheACaixaRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FecheACaixaInterface extends Remote{
	public  int registraJogador(String nome) throws RemoteException;
	public int encerraPartida (int id) throws RemoteException;
	public int obtemTabuleiro (int id) throws RemoteException;
	public int obtemPontuacao (int id) throws RemoteException;
	public int jogaDados (int id) throws RemoteException;
	public int selecionaCasas (int id) throws RemoteException;
}
