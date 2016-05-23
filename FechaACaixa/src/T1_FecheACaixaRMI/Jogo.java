package T1_FecheACaixaRMI;

public class Jogo {
	private int id;
	private String nomeJogador;
	private boolean[] tabuleiro;
	private boolean[] selecionadas;
	private int somaSelecionados;
	private int numeroDadosAtuais;
	private int dado1;
	private int dado2;
	private String status;
	private int score;

	public Jogo(String nomeJogador, int id) {
		this.id = id;
		tabuleiro = new boolean[9];
		selecionadas = new boolean[9];
		score = 0;
		somaSelecionados = 0;
		for (int i = 0; i < 9; i++) {
			tabuleiro[i] = true;
			selecionadas[i] = false;
		}
		this.nomeJogador = nomeJogador;
		numeroDadosAtuais = 2;
	}

	// Realiza a jogada e retorna o novo tabuleiro se a jogada for valida.
	// Quando for usar isso usar um try catch e buscar o status caso der
	// nullpointer
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

	public boolean[] getTabuleiro() {
		return tabuleiro;
	}

	// Retorna o numero de dados a serem jogados
	public int getNumeroDados() {
		return numeroDadosAtuais;
	}

	// Retorna a mensagem de erro ao jogar
	public String getStatus() {
		return status;
	}

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

	// Ao clicar no botão desistir da vez este metodo é chamado.
	public void setScore() {
		score = score + dado1 + dado2;
	}

	// Retornar o score total do jogador
	public int getScore() {
		return score;
	}

	private void setNumeroDados() {
		if (tabuleiro[8] == false && tabuleiro[7] == false && tabuleiro[6] == false) {
			numeroDadosAtuais = 1;
		} else
			numeroDadosAtuais = 2;
	}

	private boolean validaCasas(boolean[] jogada) {
		for (int i = 0; i <= 8; i++) {
			if (jogada[i] == true && tabuleiro[i] == false)
				return false;
		}
		return true;
	}

	private boolean validaJogada(boolean[] jogada) {
		int total = dado1 + dado2;
		int valorJogado = 0;
		for (int i = 0; i <= 8; i++) {
			if (jogada[i] == true) {
				valorJogado = valorJogado + (i + 1);
			}
		}
		if (total == valorJogado) {

			return true;
		}
		return false;
	}

	private void marcaCasasJogadas(boolean[] jogada) {
		for (int i = 0; i <= 8; i++) {
			if (jogada[i] == true)
				tabuleiro[i] = false;
		}
	}

	private boolean verificaFinal() {
		int verifica = 0;
		for (int i = 0; i <= 8; i++) {
			if (tabuleiro[i] == false) {
				verifica++;
			}
			if (verifica == 9) {
				return true;
			}
		}
		return false;
	}

	public void setSelecionaCasa(int pos, boolean e) {
		if (e) {
			somaSelecionados += pos;
		} else {
			somaSelecionados -= pos;
		}
		selecionadas[pos - 1] = e;
	}

	public boolean[] getSelecionadas() {
		return selecionadas;
	}

	public int getSomaSelecionadas() {
		return somaSelecionados;
	}

	public void zerarSomaSelecionadas() {
		somaSelecionados = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}
}