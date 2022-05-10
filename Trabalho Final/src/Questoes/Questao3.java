package Questoes;

import java.util.Vector;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.HashMap;

public class Questao3{
    //TREEMAP
    public Vector<String> timeTreeMapST(String filename){
        Vector<String> arq = new Vector<String>();
        Vector<String> time = new Vector<String>();
        arq = Remove.readWords(filename);
        String[] words = {"Lisbon", "NASA", "Kyunghee","Konkuk", "Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};
      
        // Insercao
		long tmInicialTM = System.currentTimeMillis();
        
        TreeMap<String, Integer>  stTreeMapST = new TreeMap<>();
        for(int x=0 ; x < arq.size(); x++){// elemento a ser comparado
         	stTreeMapST.put(arq.get(x), null);
		}		
		long tmFinalTM = System.currentTimeMillis();
        time.add("Treemap : " + (tmFinalTM-tmInicialTM));	

         // Procura
         long tmInicialTMP = System.currentTimeMillis();
         for(int i = 0; i < words.length; i++){
            stTreeMapST.containsKey(words[i]);
        }

        long tmFinalTMP = System.currentTimeMillis();
        time.add("Search time Treemap : " + (tmFinalTMP-tmInicialTMP) + " ms"); 

        // Delete
        long tmInicialSTD = System.currentTimeMillis();
        for(int i = 0; i < words.length; i++){
            stTreeMapST.remove(words[i]);
            //System.out.println(stTreeMapST.containsKey(words[i]));
        }
        long tmFinalSTD = System.currentTimeMillis();
        time.add("Delete time Treemap : " + (tmFinalSTD-tmInicialSTD) + " ms"); 

        return time;
    }
    
    //LINKEDHASHMAP
    public Vector<String> timeLinkedHashST(String filename){
        Vector<String> arq = new Vector<String>();
        Vector<String> time = new Vector<String>();
        arq = Remove.readWords(filename);
        String[] words = {"Lisbon", "NASA", "Kyunghee","Konkuk", "Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};
        
        // Insercao
		long tmInicialTM = System.currentTimeMillis();
        LinkedHashMap<String, Integer> stLinkedHasMapST = new LinkedHashMap<String, Integer>();
        for(int x=0 ; x < arq.size(); x++){// elemento a ser comparado
            stLinkedHasMapST.put(arq.get(x), null);
		}		
		long tmFinalTM = System.currentTimeMillis();
        time.add("LinkedHash : " + (tmFinalTM-tmInicialTM));	

        // Procura
        long tmInicialLHMP = System.currentTimeMillis();
        for(int i = 0; i < words.length; i++){
            stLinkedHasMapST.containsKey(words[i]);
        }

        long tmFinalLHMP = System.currentTimeMillis();
        time.add("Search time LinkedHash : " + (tmFinalLHMP-tmInicialLHMP) + " ms"); 

        // Delete
        long tmInicialLHMD = System.currentTimeMillis();
        for(int i = 0; i < words.length; i++){
            stLinkedHasMapST.remove(words[i]);
            //System.out.println(stLinkedHasMapST.containsKey(words[i]));
        }
        long tmFinalLHMD = System.currentTimeMillis();
        time.add("Delete time LinkedHash : " + (tmFinalLHMD-tmInicialLHMD) + " ms"); 

        return time;
    }

    public Vector<String> timeHashMapST(String filename){
        Vector<String> arq = new Vector<String>();
        Vector<String> time = new Vector<String>();
        String[] words = {"Lisbon", "NASA", "Kyunghee","Konkuk", "Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};
        arq = Remove.readWords(filename);

        //HASHMAP

        //inserir
		long tmInicialHM = System.currentTimeMillis();
        HashMap<String, Integer> stHashMapST = new HashMap<String, Integer>();
        //TreeSet<String> stTreeMapST = new TreeSet<String>();
        for(int x=0 ; x < arq.size(); x++){// elemento a ser comparado
			stHashMapST.put(arq.get(x), null);
		}		
		long tmFinalHM = System.currentTimeMillis();
        time.add("HashMap : " + (tmFinalHM-tmInicialHM));

        // Procura
        long tmInicialHMP = System.currentTimeMillis();
        for(int i = 0; i < words.length; i++){
            stHashMapST.containsKey(words[i]);
        }

        long tmFinalHMP = System.currentTimeMillis();
        time.add("Search time HashMap : " + (tmFinalHMP-tmInicialHMP) + " ms"); 

        // Delete
        long tmInicialHMD = System.currentTimeMillis();
        for(int i = 0; i < words.length; i++){
            stHashMapST.remove(words[i]);
            //System.out.println( stHashMapST.containsKey(words[i]));
        }
        long tmFinalHMD = System.currentTimeMillis();
        time.add("Delete time HashMap : " + (tmFinalHMD-tmInicialHMD) + " ms"); 

        return time;
    }
}