package Questoes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Remove {

	public static Vector<String> readWords(String filename) { // abrir o arquivo tales.tx
		Vector<String> wordList = new Vector<String>(); // Cria um vetor para guardar os dados
		//int nWords = 0;
		try {
			File file = new File(filename);
			Scanner rows = new Scanner(file).useDelimiter("[^A-z]");
			while (rows.hasNext()) { // Continua lendo enquanto ainda estiver linhas para serem lidas
				String word = rows.next();
				if(word.length()>0){
					if(!wordList.contains(word)){
						wordList.add(word);
						// System.out.println(nWords);
						// nWords++;
				   }
				//wordList.add(word); // Adiciona a linha lida ao ArrayList
				}
			}
			//System.out.println("Número de palavras " + nWords); // PERIGO : ADICIONADO POR VINICIUS ALVES 
			rows.close();
		} catch (FileNotFoundException e) {
			File file = new File(filename);
			System.out.println("Erro ao efetuar a leitura no arquivo " + filename + " em " + file.getAbsolutePath());
			//e.printStackTrace();
			return null;
		}
	
		return wordList;
	}

	public static void newFile(Vector<String> vet, String filename) {

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
}