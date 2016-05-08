package T1_FecheACaixaRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FecheACaixaImpl extends UnicastRemoteObject implements FecheACaixaInterface{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nomeJogador;
	
	protected FecheACaixaImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

//	1) registraJogador
//	Recebe:�string�com�o�nome�do�usu�rio/jogador.
//	Retorna:�id�(valor�inteiro)�do�usu�rio�(que�corresponde�a�um�n�mero�de�identifica��o��nico�para�este
//	usu�rio�durante�uma�partida),��1�se�este�usu�rio�j�est�cadastrado�ou��2�se�o�n�mero�m�ximo�de
//	jogadores�(ou�seja,�de�partidas)�tiver�sido�atingido.
	
	@Override
	public int registraJogador(String nome) throws RemoteException {
		// TODO Auto-generated method stub
		nomeJogador = nome;
		
		return 0;
	}

//	2) encerraPartida
//	Recebe:�id�do�usu�rio�(obtido�atrav�s�da�chamada�registraJogador).
//	Retorna: ��1�em�caso �de�erro�ou�0�em �caso�de�sucesso,�ou�seja,�a�partida�foi �encerrada�e�as
//	informa��es�desta�partida�podem�ser�descartadas.
	
	@Override
	public int encerraPartida(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

//	3) obtemTabuleiro
//	Recebe:�id�do�usu�rio�(obtido�atrav�s�da�chamada�registraJogador).
//	Retorna:�string�vazio�em�caso�de�erro�ou�string�com�o�conte�do�das�casas�do�tabuleiro,�mostrando
//	um�d�gito�para�casas�abertas�e�um��_��para�casas�j�fechadas.�No�in�cio�de�uma�partida,�este�m�todo
//	retornar�sempre��123456789�.�E,�por�exemplo,�se�na�primeira�jogada�o�jogador�tiver�obtido�os
//	valores��4��e��5��e�tiver�optado�por�aplicar�a�sua�soma�(9)�respectivamente�nas�casas��1�,��3��e��5�
//	(soma�9),�este�m�todo�retornar᠓_2_4_6789�.�O�jogo�estar�encerrado�quando�este�m�todo�retornar
//	�_________��(ap�s�o�que�o�cliente�poder�chamar�os�m�todos�obtemPontuacao�e�encerraPartida).
	
	@Override
	public int obtemTabuleiro(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

//	4) obtemPontuacao
//	Recebe:�id�do�usu�rio�(obtido�atrav�s�da�chamada�registraJogador).
//	Retorna:�valor�inteiro�correspondente�aos�pontos�acumulados�at�o�momento�ou��1�em�caso�de�erro.
	
	@Override
	public int obtemPontuacao(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

//	5) jogaDados
//	Recebe:�id�do�usu�rio�(obtido�atrav�s�da�chamada�registraJogador).
//	Retorna:�string�vazio�para�erro�ou�string�com�os�valores�obtidos�nos�dados.�Caso�o�jogador�esteja�na
//	fase�inicial,�ainda�jogando�com�dois�dados,�este�string�ser�composto�por�2�d�gitos.�Por�exemplo,
//	�35��significa�que�foram�lan�ados�2�dados�e�os�resultados�foram��3��e��5��(soma�igual�a�8).�Ou,�por
//	exemplo,��6��que�significa�que�as�casas��7�,��8��e��9��j�est�o�fechadas�e�o�valor�do�dado�lan�ado
//	foi��6��(soma�igual�a�6).�
	
	@Override
	public int jogaDados(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

//	6) selecionaCasas
//	Recebe:�id�do�usu�rio�(obtido�atrav�s�da�chamada�registraJogador),�string�com�os�d�gitos�das�casas�a
//	serem�fechadas�(este�string�pode�conter�de�um�a�quatro�d�gitos).
//	Retorna:�0�(sele��o�corretamente�aplicada,�ou�seja,�tudo�certo),��1�(identificador�inv�lido)�ou��2�(erro
//	na�sele��o).
	
	@Override
	public int selecionaCasas(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}
}
