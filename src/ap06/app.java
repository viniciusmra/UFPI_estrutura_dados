package ap06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class app {
	
	static int m;
	static int r;
	
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
			//System.out.println("N�mero de palavras " + nWords); // PERIGO : ADICIONADO POR VINICIUS ALVES 
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

		// Remove a pontua��o
		for (int i = 0; i < vet.size(); i++) {
			for (int j = 0; j < symbols.length; j++) {
				vet.set(i, vet.get(i).replace(symbols[j], "")); // substitui as pontua��es por ""
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
	
	public static int[] histogram(ArrayList<Integer> vet, int M) { // organiza o histograma
		int[] histogramVet = new int[M];

		for (int i = 0; i < M; i++) { // percorrer o vetor
			int count = 0;
			for (int j = 0; j < vet.size(); j++) {
				if (vet.get(j) == i) {
					count++;
				}
			}
			histogramVet[i] = count;
		}

		return histogramVet;
	}

	public static void main(String[] args) {
	
		File f = new File("taleUnico.txt");
		if(!(f.exists())) { 
			Remove x = new Remove();
			x.main();
		}
		
		try {
           m = Integer.parseInt(args[0]);
           r = Integer.parseInt(args[1]);
        } catch (Exception e) {
            System.err.println("ERRO! N�o foi passado todos os argumentos.");
            return;
        }
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>(m,r);
        String[] vet = readWords("taleUnico.txt");
        if(vet == null) {
        	return;
        }
		
		ArrayList<Integer> hashVet = new ArrayList<Integer>();

		for (int i = 0; i < vet.length; i++) {
			String key = vet[i];
			st.put(key, i);
		}
		
		// print keys
		for (String s : st.keys()) {
			//StdOut.println(s + " " + st.get(s) + " " + st.hash(s));
			hashVet.add(st.hash(s));
		}
		int[] histogramVet = histogram(hashVet, m);
		
		//System.out.println(hashVet.size());
		
//		for (int i = 0; i < hashVet.size(); i++) {
//			System.out.println(hashVet.get(i));
//		}
        
		for (int i = 0; i < histogramVet.length; i++) {
			System.out.println(i+ " ; " + histogramVet[i] + " ; " + hashVet.size()/m);
		}

	}
}