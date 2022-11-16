package potterpg.core.entidades;

import java.util.Arrays;

public class Pergunta {

	int cod_OrdemDeChamada;
	int cod_Capitulo;
	int nivelDeDificuldade;
	int pontos;
	String conteudoPergunta;
	String[] alternativas = new String[3];
	String alternativaCorreta;

	public Pergunta(int cod_OrdemDeChamada, int cod_Capitulo, int nivelDeDificuldade, int pontos, String conteudoPergunta, String[] alternativas,
			String alternativaCorreta) {

		this.cod_OrdemDeChamada = cod_OrdemDeChamada;
		this.cod_Capitulo = cod_Capitulo;
		this.nivelDeDificuldade = nivelDeDificuldade;
		this.pontos = pontos;
		this.conteudoPergunta = conteudoPergunta;
		this.alternativas = alternativas;
		this.alternativaCorreta = alternativaCorreta;
	}

	@Override
	public String toString() {
		return "cod_OrdemDeChamada = " + cod_OrdemDeChamada 
				+ "\ncod_Capitulo = " + cod_Capitulo
				+ "\nnivelDeDificuldade = " + nivelDeDificuldade 
				+ "\npontos = " + pontos
				+ "\nConteudo = " + conteudoPergunta
				+ "\nalternativas = "
				+ Arrays.toString(alternativas) 
				+ "\nalternativaCorreta = " + alternativaCorreta;
	}	
}
