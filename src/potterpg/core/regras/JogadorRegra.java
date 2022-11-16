package potterpg.core.regras;

import java.util.ArrayList;

import potterpg.core.entidades.Jogador;
import potterpg.data.JogadorData;

public class JogadorRegra implements IJogadorRegra{
	
	JogadorData data = new JogadorData();

	@Override
	public boolean salvarJogador(Jogador jogador) {
		boolean status = false;
		
		if (!(jogador != null)) {
			
			
		}
		return status;
	}

	@Override
	public ArrayList<Jogador> buscarTodosJogadores() {
		return data.buscarTodosJogadores();
	}

}
