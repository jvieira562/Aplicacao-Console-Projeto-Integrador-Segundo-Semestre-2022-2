package potterpg.console.fluxos;

import java.util.Scanner;

import potterpg.core.entidades.Pergunta;

public class FluxoPergunta {
	
	Scanner input = new Scanner(System.in);
	FluxoUtils utils;

	public boolean apresentarPergunta(Pergunta p) {
		
		apresentaConteudoPergunta(p.getConteudoPergunta());
		apresentaAlternativas(p.getAlternativas());
		
		return validarResposta(p.getAlternativaCorreta());
	}
	private void apresentaConteudoPergunta(String string) {
		utils.datilografa(string);
	}
	private void apresentaAlternativas(String[] alternativas) {
		for (String s : alternativas) {
			utils.datilografa(s);
		}
	}
	private boolean validarResposta(String respota) {
		
		boolean status = false;
		System.out.print("\nR: ");
		String respostaInput = input.next();
		
		if(respostaInput.equalsIgnoreCase(respota)) {
			
			status = true;
		}
		
		return status;
	}
	
}
