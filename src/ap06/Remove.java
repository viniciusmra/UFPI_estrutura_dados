package ap06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Remove {

	public static String[] readWords(String filename) { // abrir o arquivo tales.tx
		ArrayList<String> wordList = new ArrayList<String>(); // Cria um arraylist para guardar os dados
		//int nWords = 0;
		try {
			File file = new File(filename);
			Scanner rows = new Scanner(file);

			while (rows.hasNext()) { // Continua lendo enquanto ainda estiver linhas para serem lidas
				String word = rows.next();
				wordList.add(word); // Adiciona a linha lida ao ArrayList
				//nWords++;
			}
			//System.out.println("Número de palavras " + nWords); // PERIGO : ADICIONADO POR VINICIUS ALVES 
			rows.close();
		} catch (FileNotFoundException e) {
			File file = new File(filename);
			System.out.println("Erro ao efetuar a leitura no arquivo " + filename + " em " + file.getAbsolutePath());
			//e.printStackTrace();
			return null;
		}

		return wordList.toArray(new String[0]);
	}

	public static void newFile(String[] arrayVet, String filename) {
		ArrayList<String> vet = new ArrayList<String>();
		for (int i = 0; i < arrayVet.length; i++) {
			vet.add(arrayVet[i]);
		}

		String[] symbols = { ".", "#", ":", ";", ",", "!", "_", "(", ")", "?", "\"", "-", "*", "`", "[", "]", "\\", "/",
				"$", "@", "\n"};

		// Remove a pontuação
		for (int i = 0; i < vet.size(); i++) {
			for (int j = 0; j < symbols.length; j++) {
				vet.set(i, vet.get(i).replace(symbols[j], "")); // substitui as pontuações por ""
			}
		}

		// Remove as repetidas
		for (int i = 0; i < vet.size(); i++) { // elemento a ser comparado
			for (int j = i + 1; j < vet.size(); j++) { // toda a lista
				// verifica se o elemento a ser comparado (em maiusculas) equivale a algum
				// elemento
				// presente na lista (em maiusculas)
				if (((String) vet.get(i)).toUpperCase().equals(((String) vet.get(j)).toUpperCase())) {
					vet.remove(j);
				}
			}
		}

		try { // cria um arquivo de texto sem strings repetidas
			FileWriter myWriter = new FileWriter(filename);
			for (int i = 0; i < vet.size(); i++) {
				myWriter.write(vet.get(i) + " ");
			}
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	void main() {
		
		String[] vet = readWords("tale.txt"); // pedro que fez
		if(vet == null) {
			return;
		}
		newFile(vet, "taleUnico.txt");
	}
}
