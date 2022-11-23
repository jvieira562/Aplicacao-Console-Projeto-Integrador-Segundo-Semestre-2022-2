package potterpg.console.fluxos;

import java.util.Scanner;

import potterpg.containers.ContainerDI;
import potterpg.core.regras.interfaces.IJogadorRegra;

public class FluxoJogador {

	
	Scanner input = new Scanner(System.in);
	ContainerDI cdi = new ContainerDI();
	IJogadorRegra _jRegra;
	
	public FluxoJogador() {
		_jRegra = cdi.getDependencia(_jRegra);
	}
	
	private void pegarNome() {
		
		String nome = input.next();
	}
	
}
