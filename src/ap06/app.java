package ap06;

import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter; 
import java.io.IOException;

public class app {

    public static String[] readWords(String filename){ //abrir o arquivo tales.tx
        ArrayList<String> wordList = new ArrayList<String>(); // Cria um arraylist para guardar os dados
        int nWords = 0;
        try {
           File file = new File(filename);
           Scanner rows = new Scanner(file);

            while (rows.hasNext()) { // Continua lendo enquanto ainda estiver linhas para serem lidas
              String word = rows.next();
              wordList.add(word);  // Adiciona a linha lida ao ArrayList
              nWords++;
            }
            System.out.println("Número de palavras " + nWords);
            rows.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao efetuar a leitura");
            e.printStackTrace();
        }
        
        return wordList.toArray(new String[0]);
    }
    
    public static void newFile(String[] arrayVet, String filename){
        ArrayList<String> vet = new ArrayList<String>();
        for(int i = 0; i< arrayVet.length; i++){
            vet.add(arrayVet[i]);
        }

        String[] symbols = {".","#",":",";",",", "!", "_", "(", ")", "?", "\"", "-", "*", "`","[","]", "\\", "/", "$", "@"};

        //Remove a pontuação
        for(int i = 0; i < vet.size(); i++){
            for(int j = 0; j < symbols.length; j++){
                vet.set(i, vet.get(i).replace(symbols[j],"")); //substitui as pontuações por ""
            }
        }

        // Remove as repetidas
        for(int i = 0; i < vet.size(); i++){ // elemento a ser comparado
            for(int j = i + 1; j < vet.size(); j++){ // toda a lista
            // verifica se o elemento a ser comparado (em maiusculas) equivale a algum elemento 
            // presente na lista (em maiusculas)  
                if(((String) vet.get(i)).toUpperCase().equals(((String) vet.get(j)).toUpperCase())){
                    vet.remove(j);
                }
            }
        }

        try { // cria um arquivo de texto sem strings repetidas
            FileWriter myWriter = new FileWriter(filename); 
            for(int i = 0; i < vet.size(); i++) {
                myWriter.write(vet.get(i) + " ");
             }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

    }

    public static int[] hashCodeApp(String[] vet, int M, int R){
        int[] intVet = new int[vet.length];
       
        //s = palavra
        for(int j = 0; j<vet.length; j++){
            int h = 0;
            for (int i = 0; vet[i].length() < s.length(); i++){
                h = (R * h + (vet[i].charAt(i))) % M;
            }
            intVet[i] = h;
        }
        

        // parte errada
        //for (int i=0; i<vet.length; i++){
        //    h = (R * h + (vet[i].charAt(0)-'a')) % M;
        //    intVet[i] = h;
        //}      
        
        return intVet;
    }

    public static int[] histogram(int[] vet, int M){  //organiza o histograma
        int[] histogramVet = new int[M];

        for(int i = 0; i < M; i++){ // percorrer o vetor
            int count = 0;
            for(int j = 0; j < vet.length; j++){
                if(vet[j] == i){
                    count++;
                }
            }
            histogramVet[i] = count;
        }
        return histogramVet;
    }


    public static void main(String[] args) {

        //String[] vet = readWords("tale.txt");
        //newFile(vet, "taleUnico.txt");

        int M = 4;
        int R = 11;
        /*
        String[] vet = readWords("q5.txt");
        int[] hashVet = hashCodeApp(vet,M, R);

        int[] histogramVet = histogram(hashVet, M);
        
        for(int i = 0; i < histogramVet.length; i++){
            //System.out.println(i + "; " + histogramVet[i] + "; " + ((int) 11708/M));
            System.out.println(i + "; " + histogramVet[i] + "; " + ((int) 13/M));
        }*/

        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>(M,R);
        String[] vet = readWords("taleUnico.txt");
        for (int i = 0; i < vet.length; i++) {
            String key = vet[i];
            st.put(key, i);
        }

        // print keys
        for (String s : st.keys()) 
            StdOut.println(s + " " + st.get(s)); 
    }
}