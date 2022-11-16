package potterpg.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import potterpg.core.entidades.Jogador;

public class JogadorData implements IJogadorData {

	String path = "C:\\Users\\conta\\Documents\\projetos\\java\\potterpg-refatorado\\src\\potterpg\\bases\\JogadorBase.csv";

	@Override
	public boolean SalvarJogador(Jogador jogador) {

		boolean status = false;

		if (jogador != null) {
			ArrayList<Jogador> listaDeJogadores = buscarTodosJogadores();
			listaDeJogadores.add(jogador);
			salvarListaDeJogadores(listaDeJogadores);
			status = true;
		}

		return status;
	}

	@Override
	public ArrayList<Jogador> buscarTodosJogadores() {

		ArrayList<Jogador> lista = new ArrayList<Jogador>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String linha = br.readLine();
			linha = br.readLine();

			while (linha != null) {

				String dados[] = linha.split(";");

				String nome = dados[0];
				double pontuacao = Double.parseDouble(dados[1]);
				String dataDeCriacao = dados[2];

				Jogador jogador = new Jogador(nome, pontuacao, dataDeCriacao);
				lista.add(jogador);

				linha = br.readLine();

			}
//			System.out.println("ITEMS: ");
//			for (Jogador j : lista) {
//				System.out.println(j);
//			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return lista;
	}

	private void salvarListaDeJogadores(ArrayList<Jogador> lista) {

		try (FileWriter fw = new FileWriter(path);) {
			
			StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(fw).build();
			beanToCsv.write(lista);
			fw.close();

		} catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
			System.out.println(e.getMessage());
		}
	}
}
