package Questoes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Questao1{
    public Vector<String> timeVectorST(String filename){

        Vector<String> arq = new Vector<String>();
        Vector<String> time = new Vector<String>();
        arq = Remove.readWords(filename);
        String[] words = {"Lisbon", "NASA", "Kyunghee","Konkuk", "Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};
        
        //VECTOR 

        // Insercao
		long tmInicialVet = System.currentTimeMillis();
		Vector<String> stVector = new Vector<String>();
        for(int x=0 ; x < arq.size(); x++){// elemento a ser comparado
        	stVector.add(arq.get(x));
		}		
		long tmFinalVet = System.currentTimeMillis();	
        time.add("Insertion Vector : " + (tmFinalVet-tmInicialVet)+ " ms");	

        // Procura
        long tmInicialVectS = System.currentTimeMillis();
        for(int i = 0; i < words.length; i++){
            stVector.contains(words[i]);
        }

        long tmFinalVectS = System.currentTimeMillis();
        time.add("Search time Vector : " + (tmFinalVectS-tmInicialVectS) + " ms"); 

        // Delete
        long tmInicialVectD = System.currentTimeMillis();

        for(int i = 0; i < words.length; i++){
            //System.out.println(stVector.get(stVector.indexOf(words[i])));
            stVector.remove(words[i]);
            //System.out.println(stVector.contains(words[i]));
        }

        long tmFinalVectD = System.currentTimeMillis();
        time.add("Delete time Vector : " + (tmFinalVectD-tmInicialVectD) + " ms"); 

        return time;
    }

    public Vector<String> timeArrayListST(String filename){
        Vector<String> arq = new Vector<String>(); 
        Vector<String> time = new Vector<String>();
        arq = Remove.readWords(filename);
        String[] words = {"Lisbon", "NASA", "Kyunghee","Konkuk", "Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};

	    //ARRAYLIST

        //Inserção
		long tmInicialAL = System.currentTimeMillis();
		ArrayList<String> stArrayList = new ArrayList<String>();
        for(int x=0 ; x < arq.size(); x++){
            stArrayList.add(arq.get(x));
        }		

		long tmFinalAL = System.currentTimeMillis();
        time.add("Insercion time ArrayList : " + (tmFinalAL-tmInicialAL)+ " ms"); 

        //Procura
        long tmInicialALS = System.currentTimeMillis();
        for(int j = 0; j < words.length; j++){
            stArrayList.contains(words[j]);
        }

        long tmFinalALS = System.currentTimeMillis();
        time.add("Search time ArrayList : " + (tmFinalALS-tmInicialALS)+ " ms"); 

        // Delete
        long tmInicialALD = System.currentTimeMillis();

        for(int i = 0; i < words.length; i++){
            stArrayList.remove(words[i]);
            //System.out.println(stArrayList.contains(words[i]));
        }

        long tmFinalALD = System.currentTimeMillis();
        time.add("Delete time  ArrayList : " + (tmFinalALD-tmInicialALD) + " ms"); 

        return time;	
    }

    public Vector<String> timeLinkedListST(String filename){
        Vector<String> arq = new Vector<String>();
        Vector<String> time = new Vector<String>();
        arq = Remove.readWords(filename);
        String[] words = {"Lisbon", "NASA", "Kyunghee","Konkuk", "Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};

        //LINKEDLIST
        //Inserção
		long tmInicialLL = System.currentTimeMillis();
		LinkedList<String> stLinkedList = new LinkedList<String>(); 
        for(int x=0 ; x < arq.size(); x++){// elemento a ser comparado
         	stLinkedList.add(arq.get(x));
		}		

		long tmFinalLL = System.currentTimeMillis();
        time.add("Insertion time LinkedList : " + (tmFinalLL-tmInicialLL)+ " ms"); 

        //Procura
        long tmInicialLLS = System.currentTimeMillis();
        for(int j = 0; j < words.length; j++){
            stLinkedList.contains(words[j]);
        }

        long tmFinalLLS = System.currentTimeMillis();
        time.add("Search time LinkedList : " + (tmFinalLLS-tmInicialLLS)+ " ms"); 
        
        // Delete
        long tmInicialLLD = System.currentTimeMillis();

        for(int i = 0; i < words.length; i++){
            stLinkedList.remove(words[i]);
            //System.out.println(stLinkedList.contains(words[i]));
        }

        long tmFinalLLD = System.currentTimeMillis();
        time.add("Delete time LinkedList : " + (tmFinalLLD-tmInicialLLD) + " ms"); 
        return time;	
    }
}