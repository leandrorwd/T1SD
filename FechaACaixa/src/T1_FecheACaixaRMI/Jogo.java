package T1_FecheACaixaRMI;

/**
 * CRIA UM JOGO COM TABULEIROS, DADOS, NOME DO JOGADOR
 * 
 * @author Leandro Rowedder de Oliveira
 * @author Nathan Dal Ben Flores
 **/

public class Jogo {
	private int id;
	private String nomeJogador;
	private boolean[] tabuleiro;
	private boolean[] selecionadas;
	private int somaSelecionados;
	private int tamanhoTab;
	private int numeroDadosAtuais;
	private int dado1;
	private int dado2;
	private int score;

	public Jogo(String nomeJogador, int id) {
		this.id = id;
		tamanhoTab = 9;
		tabuleiro = new boolean[tamanhoTab];
		selecionadas = new boolean[tamanhoTab];
		score = 0;
		somaSelecionados = 0;
		for (int i = 0; i < tamanhoTab; i++) {
			tabuleiro[i] = true;
			selecionadas[i] = false;
		}
		this.nomeJogador = nomeJogador;
		numeroDadosAtuais = 2;
	}

	/**
	 * Realiza uma jogada ao jogador confirmar a seleção de dados.
	 * 
	 * @return -1 Jogada incorreta
	 * @return 0 Jogada correta
	 * @return 1 Partida encerrada
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public int realizaJogada() {
		if (!validaCasas(selecionadas)) {
			return -1;
		}
		if (!validaJogada(selecionadas)) {
			return -1;
		}
		marcaCasasJogadas(selecionadas);
		setNumeroDados();
		if (verificaFinal()) {
			return 1;
		}
		return 0;
	}

	/**
	 * Gira os dados conforme a quantidade de dados a serem jogados.
	 * 
	 * @return Retorna o resultado de 2 dados lançados
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public int[] giraDados() {
		int dados[] = new int[2];
		if (numeroDadosAtuais == 2) {
			dado1 = (int) (Math.random() * 6 + 1);
			dado2 = (int) (Math.random() * 6 + 1);
		}
		if (numeroDadosAtuais == 1) {
			dado1 = (int) (Math.random() * 6 + 1);
			dado2 = 0;
		}
		dados[0] = dado1;
		dados[1] = dado2;
		return dados;
	}

	/**
	 * Atualiza a variável score com os valores dos dados.
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public void setScore() {
		score = score + dado1 + dado2;
	}

	/**
	 * Retorna o score atual da partida.
	 * 
	 * @return Retorna o score atual
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public int getScore() {
		return score;
	}

	/**
	 * Define o número de dados a ser utilizado usando variável.
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	private void setNumeroDados() {
		if (tabuleiro[8] == false && tabuleiro[7] == false && tabuleiro[6] == false) {
			numeroDadosAtuais = 1;
		} else
			numeroDadosAtuais = 2;
	}

	/**
	 * Valida se as casas da jogada estão disponíveis.
	 * 
	 * @param jogada Recebe a jogada enviada pelo client
	 * @return Retorna se as casas estão disponíveis
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	private boolean validaCasas(boolean[] jogada) {
		for (int i = 0; i < tamanhoTab; i++) {
			if (jogada[i] == true && tabuleiro[i] == false)
				return false;
		}
		return true;
	}

	/**
	 * Verifique se a soma das casas confere com o valor dos dados.
	 * 
	 * @param jogada Recebe a jogada enviada pelo client
	 * @return Retorna true se a jogada for válida
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	private boolean validaJogada(boolean[] jogada) {
		int total = dado1 + dado2;
		int valorJogado = 0;
		for (int i = 0; i < tamanhoTab; i++) {
			if (jogada[i] == true) {
				valorJogado = valorJogado + (i + 1);
			}
		}
		if (total == valorJogado) {

			return true;
		}
		return false;
	}

	/**
	 * Marca as casas no tabuleiro após jogada bem-sucedida.
	 * 
	 * @param jogada Jogada enviada pelo client
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	private void marcaCasasJogadas(boolean[] jogada) {
		for (int i = 0; i < tamanhoTab; i++) {
			if (jogada[i] == true)
				tabuleiro[i] = false;
		}
	}

	/**
	 * Verifica se a partida acabou.
	 * 
	 * @return True se a partida acabou, false se não ainda
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	private boolean verificaFinal() {
		int verifica = 0;
		for (int i = 0; i < tamanhoTab; i++) {
			if (tabuleiro[i] == false) {
				verifica++;
			}
			if (verifica == 9) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Marca ou desmarca uma casa no jogo.
	 * 
	 * @param pos Posição da casa a ser selecionada ou não
	 * @param e True caso a casa seja selecionada, false para que seja deselecionada
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public void setSelecionaCasa(int pos, boolean e) {
		if (e) {
			somaSelecionados += pos;
		} else {
			somaSelecionados -= pos;
		}
		selecionadas[pos - 1] = e;
	}

	/**
	 * Retorna um array com as casas selecionadas ou não.
	 * 
	 * @return Variável com as casas selecionadas ou não
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public boolean[] getSelecionadas() {
		return selecionadas;
	}

	/**
	 * Retorna a soma das casas selecionadas.
	 * 
	 * @param somaSelecionados Variável que armazena as casas selecionadas ou não
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public int getSomaSelecionadas() {
		return somaSelecionados;
	}

	/**
	 * Zera a contagem das casas selecionadas.
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public void zerarSomaSelecionadas() {
		somaSelecionados = 0;
	}

	/**
	 * Retorna a identicação do jogador/partida.
	 * 
	 * @return Identificação do jogador/partida
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public int getId() {
		return id;
	}

	/**
	 * Determina a identificação do jogador/partida.
	 * 
	 * @return Linha destino da peça a ser movida
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retorna o nome do jogador.
	 * 
	 * @return Nome do jogador da partida
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public String getNomeJogador() {
		return nomeJogador;
	}

	/**
	 * Determina o nome do jogador.
	 * 
	 * @param nomeJogador Nome do jogador da partida
	 * 
	 * @author Leandro Rowedder de Oliveira
	 * @author Nathan Dal Ben Flores
	 **/

	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}
}