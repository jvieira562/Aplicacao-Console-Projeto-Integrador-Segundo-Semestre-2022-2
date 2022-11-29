package potterpg.console.fluxos;

import java.util.ArrayList;
import java.util.Scanner;

import potterpg.console.fluxos.interfaces.IFluxoCapitulo;
import potterpg.console.fluxos.interfaces.IFluxoJogador;
import potterpg.console.fluxos.interfaces.IFluxoMenu;
import potterpg.containers.ContainerDI;
import potterpg.core.entidades.Jogador;
import potterpg.core.regras.interfaces.IJogadorRegra;

public class FluxoMenu implements IFluxoMenu {

	IJogadorRegra _JRegra;
	IFluxoJogador _FJogador;
	IFluxoCapitulo _FCapitulo;
	ContainerDI cdi = new ContainerDI();
	Jogador jogador = new Jogador();
	Scanner entrada = new Scanner(System.in);

	public FluxoMenu() {
		_JRegra = cdi.getDependencia(_JRegra);
		_FCapitulo = cdi.getDependencia(_FCapitulo);
		_FJogador = cdi.getDependencia(_FJogador);
	}
	@Override
	public void start() {

		int opcao = apresentarMenu();
		validaopcoesMenu(opcao);
	}

	private int apresentarMenu() {
		System.out.println("########################## MENU ##########################");
		System.out.print("\n1 - Jogar\n2 - Ranking\n3 - Instruções\n4 - Sair\nR: ");

			int dado = entrada.nextInt();
		return dado;
		
	}
	
	private void modosDeJogo() {
		
		System.out.println("\nMODO: ");
		System.out.print("\n1 - Hardcore\n2 - Hard\n3 - Easy\n4 - Ordinary\nR: ");
		
	}

	private String validaModoDeJogo() {
		
		int opcao = 1, vida = 0;
		String modo = " ";
		modosDeJogo(); 
		do {
			
			opcao = entrada.nextInt();
			
			if (opcao == 1) {
				modo = "Hardcore";
				vida = 1;
			}
			else if (opcao == 2) {
				modo = "Hard";
				vida = 2;
			}
			else if (opcao == 3) {
				modo = "Easy";
				vida = 3;
			}
			else if (opcao == 4) {
				modo = "Ordinary";
				vida = 5;
				
			}
			else {
				System.out.println("OPCÃO INVALIDA!");
			}
			
		} while(!(opcao >= 1 & opcao <= 4));
		
		System.err.println("\nMODO SELECIONADO\t: " + modo);
		jogador.setVida(vida);
		System.err.println("QUANTIDADE DE VIDAS\t: " + vida + "\n");
		
		
		return modo;
	}
	private boolean validaopcoesMenu(int opcao) {

		boolean status = false;

		if (opcao >= 1 & opcao <= 4) {
			switch (opcao) {

			case 1: {
				System.out.print("\n\nINFORME SEU NOME: ");
				jogador.setNome(entrada.next());
				jogador.setModoDeJogo(validaModoDeJogo());
				
				_FJogador.sorteioDragao();
				_FCapitulo.apresentarCapitulo(1);
				jogador.setPontuacao(FluxoCapitulo.pontuacao);
				System.out.println(jogador);
				_FJogador.salvarJogador(jogador);
				
				
				break;
			}
			case 2: {

				exibirRank();
				break;
			}
			case 3: {

				System.out.println("INSTRUÇÕES EM DESENVOLVIMENTO!");
				continuarJogando();
				break;
			}
			case 4: {
				sair();
				break;

			}

			}

			status = true;

		} else {
			System.out.println("OPÇÃO INVALIDA!" + opcao);
			leiaInstrucoes();
		}
		return status;
	}

	private void continuarJogando() {

		int opcaoConvertida = 0;

		System.out.print("CONTINUAR JOGANDO? 1 para SIM, 2 para NÃO\nR: ");

		String opcao = entrada.next();
		System.out.print("\n");

		try {

			opcaoConvertida = Integer.parseInt(opcao);

		} catch (Exception ex) {

			leiaInstrucoes();
			System.out.println("\n EXCEPTION: " + ex.getMessage());

		}
		if (!(opcaoConvertida >= 1 & opcaoConvertida <= 2)) {
			leiaInstrucoes();
		} else if (opcaoConvertida == 1) {
			start();
		} else {
			sair();
		}
	}

	private void leiaInstrucoes() {
		System.err.print("\n\nNÃO SEJA DELINQUENTE. LEIA AS INSTRUÇÕES!");
	}

	private void sair() {
		System.out.println("\nATÉ MAIS! ... by POTTERPG");
		System.exit(0);
	}

	private void exibirRank() {

		ArrayList<Jogador> jogadores = _JRegra.buscarTodosJogadores();
		System.out.println("\n###################################### RANK ######################################");
		System.out.println("## Nº \t| NOME\t\t | PONTUAÇÃO\t | MODO DE JOGO\t   | ÚLTIMO JOGO\t##");
		System.out.println("## \t|\t\t |\t\t |\t\t   |\t\t\t##");
		int numero = 0;
		for (Jogador jogador : jogadores) {
			numero ++;
			System.out.println("## -----|----------------|---------------|-----------------|------------------- ##");
			System.out.print("## " + numero + " \t| " + jogador.getNome() + "\t | " + jogador.getPontuacao() + "\t | " + jogador.getModoDeJogo() + "\t   | "  + jogador.getDataDeCriacao() + "  \t##\n");
		}
		System.out.println("##################################################################################\n\n");
		continuarJogando();
	}
}
