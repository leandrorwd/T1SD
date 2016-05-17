package T1_FecheACaixaRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FecheACaixaImpl extends UnicastRemoteObject implements FecheACaixaInterface {

	Jogo[] jogo;

	protected FecheACaixaImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		jogo = new Jogo[50];

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nomeJogador;

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
		System.out.println("Jogar criado!");
		System.out.println(i);
		return i;
	}

	@Override
	public int encerraPartida(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int obtemTabuleiro(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int obtemPontuacao(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] jogaDados(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return jogo[id].giraDados();
	}

	@Override
	public boolean selecionaCasas(int id, boolean[] casas) throws RemoteException {
		// TODO Auto-generated method stub
		return jogo[id].realizaJogada(casas);
	}

	// 1) registraJogador
	// Recebe: string com o nome do usuário/jogador.
	// Retorna: id (valor inteiro) do usuário (que corresponde a um número de identificação único para este
	// usuário durante uma partida), ­1 se este usuário já está cadastrado ou ­2 se o número máximo de
	// jogadores (ou seja, de partidas) tiver sido atingido.

	// 2) encerraPartida
	// Recebe: id do usuário (obtido através da chamada registraJogador).
	// Retorna:  ­1 em caso  de erro ou 0 em
	//  caso de sucesso, ou seja, a partida foi  encerrada e as
	// informações desta partida podem ser descartadas.

	// 3) obtemTabuleiro
	// Recebe: id do usuário (obtido através da chamada registraJogador).
	// Retorna: string vazio em caso de erro ou string com o conteúdo das casas do tabuleiro, mostrando
	// um dígito para casas abertas e um “_” para casas já fechadas. No início de uma partida, este método
	// retornará sempre “123456789”. E, por exemplo, se na primeira jogada o jogador tiver obtido os
	// valores “4” e “5” e tiver optado por aplicar a sua soma (9) respectivamente nas casas “1”, “3” e “5”
	// (soma 9), este método retornará “_2_4_6789”. O jogo estará encerrado quando este método retornar
	// “_________” (após o que o cliente poderá chamar os métodos obtemPontuacao e encerraPartida).

	// 4) obtemPontuacao
	// Recebe: id do usuário (obtido através da chamada registraJogador).
	// Retorna: valor inteiro correspondente aos pontos acumulados até o momento ou ­1 em caso de erro.

	// 5) jogaDados
	// Recebe: id do usuário (obtido através da chamada registraJogador).
	// Retorna: string vazio para erro ou string com os valores obtidos nos dados. Caso o jogador esteja na
	// fase inicial, ainda jogando com dois dados, este string será composto por 2 dígitos. Por exemplo,
	// “35” significa que foram lançados 2 dados e os resultados foram “3” e “5” (soma igual a 8). Ou, por
	// exemplo, “6” que significa que as casas “7”, “8” e “9” já estão fechadas e o valor do dado lançado
	// foi “6” (soma igual a 6). 

	// 6) selecionaCasas
	// Recebe: id do usuário (obtido através da chamada registraJogador), string com os dígitos das casas a
	// serem fechadas (este string pode conter de um a quatro dígitos).
	// Retorna: 0 (seleção corretamente aplicada, ou seja, tudo certo), ­1 (identificador inválido) ou ­2 (erro
	// na seleção).

}
