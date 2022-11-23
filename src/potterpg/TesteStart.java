package potterpg;

import potterpg.console.fluxos.FluxoPrincipal;
import potterpg.core.regras.PerguntaRegra;

public class TesteStart {
	
	public static void main(String[] args) {
//		JogadorRegra regra = new JogadorRegra();
//		regra.buscarTodosJogadores();
//		PerguntaRegra pregra = new PerguntaRegra();
//		pregra.buscarTodasPerguntas();
		
		FluxoPrincipal regra = new FluxoPrincipal();
		
		regra.start();
	}

}
