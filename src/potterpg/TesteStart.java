package potterpg;

import potterpg.console.helpers.FluxoConsoleRegra;
import potterpg.core.regras.PerguntaRegra;

public class TesteStart {
	
	public static void main(String[] args) {
//		JogadorRegra regra = new JogadorRegra();
//		regra.buscarTodosJogadores();
//		PerguntaRegra pregra = new PerguntaRegra();
//		pregra.buscarTodasPerguntas();
		
		FluxoConsoleRegra regra = new FluxoConsoleRegra();
		
		regra.start();
	}

}
