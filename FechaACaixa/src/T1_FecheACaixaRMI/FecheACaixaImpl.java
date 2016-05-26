package T1_FecheACaixaRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * CLASSE QUE INICIALIZADA POR RMI, GERENCIA AS PARTIDAS
 * 
 * @author Leandro Rowedder de Oliveira
 * @author Nathan Dal Ben Flores
 **/

public class FecheACaixaImpl extends UnicastRemoteObject implements FecheACaixaInterface {

	Jogo[] jogo;

	protected FecheACaixaImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		jogo = new Jogo[50];

	}

	private static final long serialVersionUID = 1L;
	String nomeJogador;

	/**
	 * Registra uma partida nova
	 * 
	 * @param nome Nome do jogador da partida a ser criada
	 * @return Retorna o ID (identifica��o) da partida criada
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	@Override
	public int registraJogador(String nome) throws RemoteException {
		// TODO Auto-generated method stub
		int i = 0;
		for (i = 0; i < 50; i++) {
			if (jogo[i] == null) {
				jogo[i] = new Jogo(nome, i);
				break;
			}
		}
		return i;
	}

	/**
	 * Encerra uma partida existente.
	 * 
	 * @param id Envia a id (identifica��o) da partida
	 *            
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	@Override
	public void encerraPartida(int id) throws RemoteException {
		// TODO Auto-generated method stub
		jogo[id] = null;
	}

	/**
	 * Obtem a pontua��o/score da partida
	 * 
	 * @param id Envia a identifica��o da partida que necessita de score
	 * @return Retorna a pontua��o/score da partida
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	@Override
	public int obtemPontuacao(int id) throws RemoteException {
		// TODO Auto-generated method stub
		jogo[id].setScore();
		return jogo[id].getScore();
	}

	/**
	 * Joga os dados na partida
	 * 
	 * @param id Envia a identifica��o da partida que necessita de score
	 * @return O valor do(s) dado(s) jogado(s)
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	@Override
	public int[] jogaDados(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return jogo[id].giraDados();
	}

	/**
	 * Envia uma jogada para ser validada.
	 * 
	 * @param id Envia a identifica��o da partida que necessita de score
	 * @return Retorna a situa��o da jogada realizada
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	@Override
	public int enviaJogada(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return jogo[id].realizaJogada();
	}

	/**
	 * Retorna o nome do jogador da partida.
	 * 
	 * @param id Envia a identifica��o da partida que necessita de score
	 * @return Nome do jogador da partida
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public String getNomeJogador(int id) throws RemoteException {
		return jogo[id].getNomeJogador();
	}

	/**
	 * Determina as casas selecionadas ou n�o.
	 * 
	 * @param id Envia a identifica��o da partida que necessita de score
	 * @param pos Posi��o da casa a ser selecionada ou n�o
	 * @param e True para a casa selecionada, false para a casa n�o-selecionada
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public void setSelecionaCasa(int id, int pos, boolean e) {
		jogo[id].setSelecionaCasa(pos, e);
	}

	/**
	 * Recebe as casas que est�o selecionadas e as que n�o est�o.
	 * 
	 * @param id Envia a identifica��o da partida que necessita de score
	 * @return As casas que est�o selecionadas e as que n�o est�o
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public boolean[] getSelecionadas(int id) throws RemoteException {
		return jogo[id].getSelecionadas();
	}

	/**
	 * Recebe a soma das casas seleciondas
	 * 
	 * @param id Envia a identifica��o da partida que necessita de score
	 * @return A soma das casas selecionadas
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public int getSomaSelecionadas(int id) throws RemoteException {
		return jogo[id].getSomaSelecionadas();
	}

	/**
	 * Zera na partida a soma das casas selecionadas
	 * 
	 * @param id Envia a identifica��o da partida que necessita de score
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public void zerarSomaSelecionadas(int id) throws RemoteException {
		jogo[id].zerarSomaSelecionadas();
	}
}
