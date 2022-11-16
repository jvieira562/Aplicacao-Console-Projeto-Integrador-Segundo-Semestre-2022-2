package potterpg.console.helpers;

import java.util.ArrayList;
import java.util.Scanner;

import potterpg.core.entidades.Jogador;
import potterpg.core.regras.JogadorRegra;

public class FluxoConsoleRegra {

	Scanner entrada = new Scanner(System.in);
	JogadorRegra jogadorRegra = new JogadorRegra();

	public boolean validaopcoesMenu(int opcao) {

		boolean status = false;
		
		if (opcao >= 1 & opcao <= 4) {
			switch (opcao) {

			case 1: {
				System.out.print("\n\nINFORME SEU NOME: ");
				String nome = entrada.next();
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
	public void start() {

		int opcao = apresentarMenu();
		boolean status = validaopcoesMenu(opcao);
	}
	public int apresentarMenu() {
		System.out.println("########################## MENU ##########################");
		System.out.print("\n1 - Jogar\n2 - Ranking\n3 - Instruções\n4 - Sair\nR: ");
		return entrada.nextInt();
	}
	public void exibirRank() {

		ArrayList<Jogador> jogadores = jogadorRegra.buscarTodosJogadores();
		System.out.println("\n########################## RANK ##########################");
		System.out.println("## NOME\t\t\t | PONTUAÇÃO\t | ÚLTIMO JOGO\t##");
		System.out.println("##\t\t\t\t\t\t\t##");
		for (Jogador jogador : jogadores) {
			System.out.println("## ----------------------|---------------|------------- ##");
			System.out.print("## " + jogador.getNome() + "\t\t | " + jogador.getPontuacao() + "\t | "
					+ jogador.getDataDeCriacao() + "\t##\n");
		}
		System.out.println("##########################################################\n\n");
		continuarJogando();
	}
	public void continuarJogando() {

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
		} else if(opcaoConvertida == 1) {
			start();
		} else {
			sair();
		}
	}
	public void leiaInstrucoes() {
		System.err.print("\n\nNÃO SEJA DELINQUENTE. LEIA AS INSTRUÇÕES!");
	}
	public void sair() {
		System.out.println("\nATÉ MAIS! ... by POTTERPG");
		System.exit(0);
	}
}
