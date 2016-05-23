package T1_FecheACaixaRMI;

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
	private String status;
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

	// Realiza a jogada e retorna o novo tabuleiro se a jogada for valida.
	// Quando for usar isso usar um try catch e buscar o status caso der
	// nullpointer
	
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
	
	public int realizaJogada() {
		if (!validaCasas(selecionadas)) {
			status = "Uma ou mais casas não poderam ser selecionadas";
			return -1;
		}
		if (!validaJogada(selecionadas)) {
			status = "Sua conta está incorreta";
			return -1;
		}
		marcaCasasJogadas(selecionadas);
		setNumeroDados();
		if (verificaFinal()) {
			status = "O jogo terminou";
			return 1;
		}
		return 0;
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
	
	public boolean[] getTabuleiro() {
		return tabuleiro;
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
	
	// Retorna o numero de dados a serem jogados
	public int getNumeroDados() {
		return numeroDadosAtuais;
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
	
	// Retorna a mensagem de erro ao jogar
	public String getStatus() {
		return status;
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
	
	// Gira a quantidade de dados correta e retorna a soma deles.
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
	  * Valida um movimento de xadrez.
	  * 
	  * @param aColunaDe   Coluna atual da peça a ser movida
	  * @param aLinhaDe    Linha atual da peça a ser movida
	  * @param aColunaPara Coluna destino da peça a ser movida
	  * @param aLinhaPara  Linha destino da peça a ser movida
	  * @author            Leandro Oliveira
	  * @author            Nathan Dal Ben Flores
	  **/
	
	// Ao clicar no botão desistir da vez este metodo é chamado.
	public void setScore() {
		score = score + dado1 + dado2;
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
	
	// Retornar o score total do jogador
	public int getScore() {
		return score;
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

	private void setNumeroDados() {
		if (tabuleiro[8] == false && tabuleiro[7] == false && tabuleiro[6] == false) {
			numeroDadosAtuais = 1;
		} else
			numeroDadosAtuais = 2;
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
	
	private boolean validaCasas(boolean[] jogada) {
		for (int i = 0; i < tamanhoTab; i++) {
			if (jogada[i] == true && tabuleiro[i] == false)
				return false;
		}
		return true;
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
	  * Valida um movimento de xadrez.
	  * 
	  * @param aColunaDe   Coluna atual da peça a ser movida
	  * @param aLinhaDe    Linha atual da peça a ser movida
	  * @param aColunaPara Coluna destino da peça a ser movida
	  * @param aLinhaPara  Linha destino da peça a ser movida
	  * @author            Leandro Oliveira
	  * @author            Nathan Dal Ben Flores
	  **/
	
	private void marcaCasasJogadas(boolean[] jogada) {
		for (int i = 0; i < tamanhoTab; i++) {
			if (jogada[i] == true)
				tabuleiro[i] = false;
		}
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
	  * Valida um movimento de xadrez.
	  * 
	  * @param aColunaDe   Coluna atual da peça a ser movida
	  * @param aLinhaDe    Linha atual da peça a ser movida
	  * @param aColunaPara Coluna destino da peça a ser movida
	  * @param aLinhaPara  Linha destino da peça a ser movida
	  * @author            Leandro Oliveira
	  * @author            Nathan Dal Ben Flores
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
	  * Valida um movimento de xadrez.
	  * 
	  * @param aColunaDe   Coluna atual da peça a ser movida
	  * @param aLinhaDe    Linha atual da peça a ser movida
	  * @param aColunaPara Coluna destino da peça a ser movida
	  * @param aLinhaPara  Linha destino da peça a ser movida
	  * @author            Leandro Oliveira
	  * @author            Nathan Dal Ben Flores
	  **/
	
	public boolean[] getSelecionadas() {
		return selecionadas;
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
	
	public int getSomaSelecionadas() {
		return somaSelecionados;
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
	
	public void zerarSomaSelecionadas() {
		somaSelecionados = 0;
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
	
	public int getId() {
		return id;
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
	
	public void setId(int id) {
		this.id = id;
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
	
	public String getNomeJogador() {
		return nomeJogador;
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
	
	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}
}