package potterpg.console.fluxos;

import java.util.Scanner;

import potterpg.core.entidades.Pergunta;

public class FluxoUtils {
	

	public void datilografa(String string) {
		
		for (int i = 0; i < string.length(); i++) {
			
			char caractere = string.charAt(i);
			
			try {
				
				Thread.sleep(40);
				
			} catch (Exception ex) {
				
				System.err.println(ex.getMessage());
				
			}
			
			System.out.print(caractere);
		}
	}
}
