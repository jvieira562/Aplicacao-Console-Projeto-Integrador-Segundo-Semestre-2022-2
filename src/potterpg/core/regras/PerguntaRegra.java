package potterpg.core.regras;

import java.util.LinkedHashSet;

import potterpg.core.entidades.Pergunta;

import potterpg.data.PerguntaData;

public class PerguntaRegra implements IPerguntaRegra	{

	private PerguntaData data = new PerguntaData();
	
	@Override
	public LinkedHashSet<Pergunta> buscarTodasPerguntas() {
		
		return data.buscarTodasPerguntas();
	}	
}
