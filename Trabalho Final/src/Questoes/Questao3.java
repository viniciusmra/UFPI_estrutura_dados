package Questoes;

import java.util.Vector;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.HashMap;

public class Questao3{
    public Vector<String> timeTreeMapST(String filename){
        Vector<String> arq = new Vector<String>();
        Vector<String> time = new Vector<String>();
        arq = Remove.readWords(filename);
        String[] words = {"Lisbon", "NASA", "Kyunghee","Konkuk", "Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};
      
        // Inserção
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
        time.add("Search time Vector : " + (tmFinalTMP-tmInicialTMP) + " ms"); 

        // Delete
        long tmInicialSTD = System.currentTimeMillis();
        for(int i = 0; i < words.length; i++){
            stTreeMapST.remove(words[i]);
            System.out.println(stTreeMapST.containsKey(words[i]));
        }
        long tmFinalSTD = System.currentTimeMillis();
        time.add("Delete time Vector : " + (tmFinalSTD-tmInicialSTD) + " ms"); 

        return time;
    }
public Vector<String> ST(String filename){
        Vector<String> arq = new Vector<String>();
        Vector<String> time = new Vector<String>();
        arq = Remove.readWords(filename);

        //TREEMAP
		long tmInicialTM = System.currentTimeMillis();
        
        TreeMap<String, Integer>  stTreeMapST = new TreeMap<>();
        for(int x=0 ; x < arq.size(); x++){// elemento a ser comparado
         		stTreeMapST.put(arq.get(x), null);
		  }		
		long tmFinalTM = System.currentTimeMillis();
        time.add("Treemap : " + (tmFinalTM-tmInicialTM));	

		//LINKEDHASHMAP
		long tmInicialLHM = System.currentTimeMillis();
        LinkedHashMap<String, Integer> stLinkedHashMapST = new LinkedHashMap<String, Integer>();
        for(int x=0 ; x < arq.size(); x++){// elemento a ser comparado
				stLinkedHashMapST.put(arq.get(x), null);
		  }		
		long tmFinalLHM = System.currentTimeMillis();
        time.add("LinkedHashMap : " + (tmFinalLHM-tmInicialLHM));

        //HASHMAP
		long tmInicialHM = System.currentTimeMillis();
        HashMap<String, Integer> stHashMapST = new HashMap<String, Integer>();
        //TreeSet<String> stTreeMapST = new TreeSet<String>();
        for(int x=0 ; x < arq.size(); x++){// elemento a ser comparado
				stHashMapST.put(arq.get(x), null);
		  }		
		long tmFinalHM = System.currentTimeMillis();
        time.add("HashMap : " + (tmFinalHM-tmInicialHM));

        return time;
    }
    

}