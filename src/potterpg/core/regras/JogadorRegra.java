package potterpg.core.regras;

import java.util.ArrayList;

import potterpg.core.entidades.Jogador;
import potterpg.core.regras.interfaces.IGerenico;
import potterpg.core.regras.interfaces.IJogadorRegra;
import potterpg.data.JogadorData;

public class JogadorRegra implements IJogadorRegra {

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
		return bubbleSortParaJogadores(data.buscarTodosJogadores());
	}
	private ArrayList<Jogador> bubbleSortParaJogadores(ArrayList<Jogador> jogadores) {

		Jogador jogadorAuxiliar = null;
		
		for (int i = 0; i < jogadores.size(); i++) {

			for (int j = 1; j < (jogadores.size() - i); j++) {

				if (jogadores.get(j - 1).getPontuacao() < jogadores.get(j).getPontuacao()) {

					jogadorAuxiliar = jogadores.get(j - 1);
					jogadores.set(j - 1,jogadores.get(j));
					jogadores.set(j, jogadorAuxiliar);
				}
			}
		}
		return jogadores;		
	}
	
}
