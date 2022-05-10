package Questoes;

import java.util.Vector;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.HashMap;

/*
    Classe Questao 03:
    
    RESPONSAVEL POR CONTER AS INTERFACES PARA TREEMAP, LINKEDHASHMAP e HASHMAP

*/

public class Questao3{

    /* 
        INPUT: RECEBE O NOME DO ARQUIVO

        METODO RESPONSAVEL POR CALCULAR :
        O TEMPO DE EXECU플O DA INSER플O DOS ELEMENTOS DO ARQUIVO NO VETOR;
        O TEMPO DE EXECU플O PARA PROCURAR 10 ELEMENTOS NO VETOR;
        O TEMPO DE EXECU플O PARA DELETAR 10 ELEMENTOS NO VETOR;

        OUTPUT: RETORNA UM VETOR COM O TEMPO DAS EXECUCOES
    */


    //TREEMAP
    public Vector<String> timeTreeMapST(String filename){
        Vector<String> arq = new Vector<String>();
        Vector<String> time = new Vector<String>();
        arq = Remove.readWords(filename);
        String[] words = {"Lisbon", "NASA", "Kyunghee","Konkuk", "Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};
      
        // Insercao
		long tmInicialTM = System.nanoTime();
        
        TreeMap<String, Integer>  stTreeMapST = new TreeMap<>();
        for(int x=0 ; x < arq.size(); x++){// elemento a ser comparado
         	stTreeMapST.put(arq.get(x), null);
		}		
		long tmFinalTM = System.nanoTime();
        time.add("TreeMap : " + (tmFinalTM-tmInicialTM));	

        // Procura
        long tmInicialTMP = System.nanoTime();
        for(int i = 0; i < words.length; i++){
            stTreeMapST.containsKey(words[i]);
        }

        long tmFinalTMP = System.nanoTime();
        time.add("Search time TreeMap : " + (tmFinalTMP-tmInicialTMP) + " ns"); 

        // Delete
        long tmInicialSTD = System.nanoTime();
        for(int i = 0; i < words.length; i++){
            stTreeMapST.remove(words[i]);
            //System.out.println(stTreeMapST.containsKey(words[i]));
        }
        long tmFinalSTD = System.nanoTime();
        time.add("Delete time TreeMap : " + (tmFinalSTD-tmInicialSTD) + " ns"); 

        return time;
    }
    
    //LINKEDHASHMAP
    public Vector<String> timeLinkedHashST(String filename){
        Vector<String> arq = new Vector<String>();
        Vector<String> time = new Vector<String>();
        arq = Remove.readWords(filename);
        String[] words = {"Lisbon", "NASA", "Kyunghee","Konkuk", "Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};
        
        // Insercao
		long tmInicialTM = System.nanoTime();
        LinkedHashMap<String, Integer> stLinkedHasMapST = new LinkedHashMap<String, Integer>();
        for(int x=0 ; x < arq.size(); x++){// elemento a ser comparado
            stLinkedHasMapST.put(arq.get(x), null);
		}		
		long tmFinalTM = System.nanoTime();
        time.add("LinkedHashMap : " + (tmFinalTM-tmInicialTM));	

        // Procura
        long tmInicialLHMP = System.nanoTime();
        for(int i = 0; i < words.length; i++){
            stLinkedHasMapST.containsKey(words[i]);
        }

        long tmFinalLHMP = System.nanoTime();
        time.add("Search time LinkedHashMap : " + (tmFinalLHMP-tmInicialLHMP) + " ns"); 

        // Delete
        long tmInicialLHMD = System.nanoTime();
        for(int i = 0; i < words.length; i++){
            stLinkedHasMapST.remove(words[i]);
            //System.out.println(stLinkedHasMapST.containsKey(words[i]));
        }
        long tmFinalLHMD = System.nanoTime();
        time.add("Delete time LinkedHashMap : " + (tmFinalLHMD-tmInicialLHMD) + " ns"); 

        return time;
    }

    public Vector<String> timeHashMapST(String filename){
        Vector<String> arq = new Vector<String>();
        Vector<String> time = new Vector<String>();
        String[] words = {"Lisbon", "NASA", "Kyunghee","Konkuk", "Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};
        arq = Remove.readWords(filename);

        //HASHMAP

        //inserir
		long tmInicialHM = System.nanoTime();
        HashMap<String, Integer> stHashMapST = new HashMap<String, Integer>();
        //TreeSet<String> stTreeMapST = new TreeSet<String>();
        for(int x=0 ; x < arq.size(); x++){// elemento a ser comparado
			stHashMapST.put(arq.get(x), null);
		}		
		long tmFinalHM = System.nanoTime();
        time.add("HashMap : " + (tmFinalHM-tmInicialHM));

        // Procura
        long tmInicialHMP = System.nanoTime();
        for(int i = 0; i < words.length; i++){
            stHashMapST.containsKey(words[i]);
        }

        long tmFinalHMP = System.nanoTime();
        time.add("Search time HashMap : " + (tmFinalHMP-tmInicialHMP) + " ns"); 

        // Delete
        long tmInicialHMD = System.nanoTime();
        for(int i = 0; i < words.length; i++){
            stHashMapST.remove(words[i]);
            //System.out.println( stHashMapST.containsKey(words[i]));
        }
        long tmFinalHMD = System.nanoTime();
        time.add("Delete time HashMap : " + (tmFinalHMD-tmInicialHMD) + " ns"); 

        return time;
    }
}