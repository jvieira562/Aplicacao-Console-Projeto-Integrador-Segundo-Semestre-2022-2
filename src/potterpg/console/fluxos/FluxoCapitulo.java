package potterpg.console.fluxos;

import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.collections.bag.SynchronizedSortedBag;

import potterpg.console.fluxos.interfaces.IFluxoCapitulo;
import potterpg.console.fluxos.interfaces.IFluxoJogador;
import potterpg.console.fluxos.interfaces.IFluxoPergunta;
import potterpg.containers.ContainerDI;
import potterpg.core.entidades.Capitulo;
import potterpg.core.entidades.Pergunta;
import potterpg.core.regras.interfaces.ICapituloRegra;

public class FluxoCapitulo implements IFluxoCapitulo {

	private ICapituloRegra _CRegra;
	private IFluxoJogador _Fjogador;
	private IFluxoPergunta _FPergunta;
	private ContainerDI cdi = new ContainerDI();
	static double pontuacao;
	

	public FluxoCapitulo() {
		_CRegra = cdi.getDependencia(_CRegra);
		_Fjogador = cdi.getDependencia(_Fjogador);
		_FPergunta = cdi.getDependencia(_FPergunta);
	}

	@Override
	public void apresentarCapitulo(int codigo) {

		Capitulo capitulo = getCapitulo(codigo);
		fim : for (int i = 0; i <= capitulo.getListaPergunta().size(); i++) {
//			System.out.println("TAMANHO DA LISTA DE PERGUNTAS DO CAPITULO -> " + codigo + "\nTAMANHO: " + capitulo.getListaPergunta().size());
			var condicaoParaFinalizarCapitulo = fimDoCapitulo(codigo, i, capitulo.getListaPergunta().size());
			if (_Fjogador.verificaVida(_Fjogador.getJogador())) {
				System.out.println("Jogador: " +_Fjogador.getJogador());
				morte();
			}
			if(condicaoParaFinalizarCapitulo) {
				
				capitulo =  null;
				break fim;
			}

			Pergunta p = capitulo.getListaPergunta().get(i);

			boolean statusDaResposta = _FPergunta.apresentarPergunta(p);

			if (statusDaResposta) escolhaCerta(p.getPontos());

			else {
				do {					
					escolhaErrada();					
				} while (!_FPergunta.casoErre(p));
				escolhaCerta(p.getPontos());
			}
		}
	}
	private void morte() {

			System.err.println("\nVOCÊ MORREU!");
			_Fjogador.salvarJogador(_Fjogador.getJogador());
		
	}
	/**
	 * @param numeroDoCapitulo Codígo de identificação do capítulo que está sendo processado no momento.
	 * @param atual Valor da pergunta que está sendo processada no momento da execução do programa.
	 * @param total Valor total de perguntas presentes no capítulo.
	 * @return Verdadeiro Caso o capitule chega ao fim, Falso Caso o capítulo ainda tenha perguntas para processar.
	 */
	private boolean fimDoCapitulo(int numeroDoCapitulo, int atual, int total) {
		boolean status = false;
		if(atual >= total) {
			System.err.println("FIM DO " + numeroDoCapitulo + "ª CAPÍTULO...");
			status = true;
			
		}
		return status;
	}
	private void escolhaErrada() {

		_Fjogador.getJogador().setVida(_Fjogador.getJogador().getVida() - 1);
		String[] escolha = { "Essa escolha te levou a morte!", "Reflita sobre suas escolhas.",
				"Assistir os filme vai facilitar.", "Leia as instruções, lá tem alguns blogs sobre Harry Potter." };

		System.err.println("\nNÃO FOI DESSA VEZ! " + escolha[new Random().nextInt(4)]);
		System.err.println("VIDAS RESTANTES: " + _Fjogador.getJogador().getVida());
	}
	private void escolhaCerta(int pontos) {

		pontuacao = pontuacao + pontos;
		String[] escolha = { "Ufa, essa foi por pouco!", "Continue assim! ",
				"Você parece ser um grande fã de Harry Potter.", "Você é realmente imbatível." };

		System.err.println("\nPARABÉNS! " + escolha[new Random().nextInt(4)]);
		System.err.println("PONTOS: " + pontuacao + "\n");
	}
	/**
	 * @param Código de identificação do capítulo
	 * @return Objeto do tipo Capitulo que contém o mesmo código passado no
	 *         parâmetro do método.
	 */
	private Capitulo getCapitulo(int codigo) {

		Capitulo capitulo = null;
		ArrayList<Capitulo> capitulos = _CRegra.buscarCapitulos();
		parar : for (Capitulo c : capitulos) {
			if ((c.getCod_Capitulo() == codigo)) {
				capitulo = c;
				break parar;
			}
		}
		return capitulo;
	}

}
