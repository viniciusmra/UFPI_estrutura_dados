package Questoes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

/*
    Classe Questao 01:

    RESPONSAVEL POR CONTER AS INTERFACES PARA VECTOR, LINKEDLIST e ARRAYLIST

*/

public class Questao1{


    /* 
        INPUT: RECEBE O NOME DO ARQUIVO

        METODO RESPONSAVEL POR CALCULAR :
        O TEMPO DE EXECUCAO DA INSERCAO DOS ELEMENTOS DO ARQUIVO NO VETOR;
        O TEMPO DE EXECUACAO PARA PROCURAR 10 ELEMENTOS NO VETOR;
        O TEMPO DE EXECUCAO PARA DELETAR 10 ELEMENTOS NO VETOR;

        OUTPUT: RETORNA UM VETOR COM O TEMPO DAS EXECUCOES
    */

    public Vector<String> timeVectorST(String filename){

        Vector<String> arq = new Vector<String>();
        Vector<String> time = new Vector<String>();
        arq = Remove.readWords(filename);
        String[] words = {"Lisbon", "NASA", "Kyunghee","Konkuk", "Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};
        
        //VECTOR 

        // Insercao
		long tmInicialVet = System.nanoTime();
		Vector<String> stVector = new Vector<String>();
        for(int x=0 ; x < arq.size(); x++){// elemento a ser comparado
        	stVector.add(arq.get(x));
		}		
		long tmFinalVet = System.nanoTime();	
        time.add("Insertion Vector : " + (tmFinalVet-tmInicialVet)+ " ns");	

        // Procura
        long tmInicialVectS = System.nanoTime();
        for(int i = 0; i < words.length; i++){
            stVector.contains(words[i]);
        }

        long tmFinalVectS = System.nanoTime();
        time.add("Search time Vector : " + (tmFinalVectS-tmInicialVectS) + " ns"); 

        // Delete
        long tmInicialVectD = System.nanoTime();

        for(int i = 0; i < words.length; i++){
            stVector.remove(words[i]);
        }

        long tmFinalVectD = System.nanoTime();
        time.add("Delete time Vector : " + (tmFinalVectD-tmInicialVectD) + " ns"); 

        return time;
    }

    public Vector<String> timeArrayListST(String filename){
        Vector<String> arq = new Vector<String>(); 
        Vector<String> time = new Vector<String>();
        arq = Remove.readWords(filename);
        String[] words = {"Lisbon", "NASA", "Kyunghee","Konkuk", "Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};

	    //ARRAYLIST

        //Inserção
		long tmInicialAL = System.nanoTime();
		ArrayList<String> stArrayList = new ArrayList<String>();
        for(int x=0 ; x < arq.size(); x++){
            stArrayList.add(arq.get(x));
        }		

		long tmFinalAL = System.nanoTime();
        time.add("Insercion time ArrayList : " + (tmFinalAL-tmInicialAL)+ " ns"); 

        //Procura
        long tmInicialALS = System.nanoTime();
        for(int j = 0; j < words.length; j++){
            stArrayList.contains(words[j]);
        }

        long tmFinalALS = System.nanoTime();
        time.add("Search time ArrayList : " + (tmFinalALS-tmInicialALS)+ " ns"); 

        // Delete
        long tmInicialALD = System.nanoTime();

        for(int i = 0; i < words.length; i++){
            stArrayList.remove(words[i]);
        }

        long tmFinalALD = System.nanoTime();
        time.add("Delete time  ArrayList : " + (tmFinalALD-tmInicialALD) + " ns"); 

        return time;	
    }

    public Vector<String> timeLinkedListST(String filename){
        Vector<String> arq = new Vector<String>();
        Vector<String> time = new Vector<String>();
        arq = Remove.readWords(filename);
        String[] words = {"Lisbon", "NASA", "Kyunghee","Konkuk", "Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};

        //LINKEDLIST
        //Inserção
		long tmInicialLL = System.nanoTime();
		LinkedList<String> stLinkedList = new LinkedList<String>(); 
        for(int x=0 ; x < arq.size(); x++){// elemento a ser comparado
         	stLinkedList.add(arq.get(x));
		}		

		long tmFinalLL = System.nanoTime();
        time.add("Insertion time LinkedList : " + (tmFinalLL-tmInicialLL)+ " ns"); 

        //Procura
        long tmInicialLLS = System.nanoTime();
        for(int j = 0; j < words.length; j++){
            stLinkedList.contains(words[j]);
        }

        long tmFinalLLS = System.nanoTime();
        time.add("Search time LinkedList : " + (tmFinalLLS-tmInicialLLS)+ " ns"); 
        
        // Delete
        long tmInicialLLD = System.nanoTime();

        for(int i = 0; i < words.length; i++){
            stLinkedList.remove(words[i]);
        }

        long tmFinalLLD = System.nanoTime();
        time.add("Delete time LinkedList : " + (tmFinalLLD-tmInicialLLD) + " ns"); 
        return time;	
    }
}