package potterpg.teste.algoritmosDeOrdenacao;

import java.util.ArrayList;

import potterpg.core.entidades.Jogador;
import potterpg.core.entidades.Pergunta;
import potterpg.core.regras.JogadorRegra;
import potterpg.core.regras.PerguntaRegra;

public class SelectionSort {
	
	static PerguntaRegra _pRegra = new PerguntaRegra();
	static JogadorRegra _jRegra = new JogadorRegra();
	
	public static void main(String[] args) {
        
		ArrayList<Pergunta> perguntas = _pRegra.buscarTodasPerguntas();
		
//		selectionSortForQuestions(perguntas);
		
	}
	
	private static void SelectionSortTutorial() {
        int[] vetor = new int[10];
        
        for(int i=0; i < vetor.length; i++){
            vetor[i] = (int) (Math.random() * vetor.length);
        }
        
        System.out.println("Desordenado");
        for(int i=0; i < vetor.length; i++){
            System.out.print(vetor[i] + ", ");
        }
        
        //Selection sort O(N^2)
        int posicao_menor, aux;
        for(int i=0; i < vetor.length; i++){ //O(N)
            posicao_menor = i;
            for(int j = i+1; j < vetor.length; j++){ //O(N)
                if (vetor[j] < vetor[posicao_menor]){
                    posicao_menor = j;
                }
            }
            aux = vetor[posicao_menor];
            vetor[posicao_menor] = vetor[i];
            vetor[i] = aux;
        }
        
        System.out.println("\n\nOrdenado");
        for(int i=0; i < vetor.length; i++){
            System.out.print(vetor[i] + ", ");
        }
	}
	

	
}
