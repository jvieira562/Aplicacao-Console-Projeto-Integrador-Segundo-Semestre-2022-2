package potterpg.core.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Jogador {
	
	private String nome;
	private double pontuacao;
	private String dataDeCriacao;

	public Jogador(String nome, double pontuacao, String dataDeCriacao) {
		
		this.nome = nome;
		this.pontuacao = pontuacao;
		this.dataDeCriacao = dataDeCriacao;		
	}
	
	public Jogador(String nome) {
		
		this.nome = nome;
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		this.dataDeCriacao = dataFormatada.format(new Date());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(double pontuacao) {
		this.pontuacao = pontuacao;
	}

	public String getDataDeCriacao() {
		return dataDeCriacao;
	}


	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", pontuacao=" + pontuacao + ", dataDeCriacao=" + dataDeCriacao + "]";
	}
	
}
