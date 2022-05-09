package Questoes;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Vector;

public class Questao2{
  public Vector<String> timeHashSetST(String filename){
    Vector<String> arq = new Vector<String>();
    Vector<String> time = new Vector<String>();
    arq = Remove.readWords(filename);
    String[] words = {"Lisbon", "NASA", "Kyunghee","Konkuk", "Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};
    
    //inserir
    long tmInicialHS = System.currentTimeMillis();
    HashSet<String> stHashSetST = new HashSet<String>(); 
    for(int x=0 ; x < arq.size(); x++){// elemento a ser comparado
      stHashSetST.add(arq.get(x));
    }		
    long tmFinalHS = System.currentTimeMillis();
    time.add("HashSet : " + (tmFinalHS-tmInicialHS));

    // Procura
      long tmInicialHSP = System.currentTimeMillis();
      for(int i = 0; i < words.length; i++){
      stHashSetST.contains(words[i]);
    }

    long tmFinalHSP = System.currentTimeMillis();
    time.add("Search time HashSet : " + (tmFinalHSP-tmInicialHSP) + " ms");

    // Procura
      long tmInicialHSP = System.currentTimeMillis();
      for(int i = 0; i < words.length; i++){
        stHashSetST.contains(words[i]);
    }

    long tmFinalHSP = System.currentTimeMillis();
    time.add("Search time HashSet : " + (tmFinalHSP-tmInicialHSP) + " ms");
    return time;
  }
  public Vector<String> timeLinkedHashSet(String filename){
    Vector<String> arq = new Vector<String>();
    Vector<String> time = new Vector<String>();
    arq = Remove.readWords(filename);
    String[] words = {"Lisbon", "NASA", "Kyunghee","Konkuk", "Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};
    
    //inserir
    long tmInicialLHS = System.currentTimeMillis();
    LinkedHashSet<String> stLinkedHashSetST = new LinkedHashSet<String>();
    for(int x=0 ; x < arq.size(); x++){// elemento a ser comparado
      stLinkedHashSetST.add(arq.get(x));
    }		
    long tmFinalLHS = System.currentTimeMillis();
    time.add("LinkedHashSet : " + (tmFinalLHS-tmInicialLHS));

    // Procura
    long tmInicialLHSP = System.currentTimeMillis();
    for(int i = 0; i < words.length; i++){
      stLinkedHashSetST.contains(words[i]);
    }

    long tmFinalLHSP = System.currentTimeMillis();
    time.add("Search time HashSet : " + (tmFinalLHSP-tmInicialLHSP) + " ms");
    return time;
    }
public Vector<String> timeTreeMap(String filename){
        Vector<String> arq = new Vector<String>();
        Vector<String> time = new Vector<String>();
        arq = Remove.readWords(filename);
        String[] words = {"Lisbon", "NASA", "Kyunghee","Konkuk", "Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};
        
        //inserir
        long tmInicialTM = System.currentTimeMillis();
        TreeSet<String> stTreeMapST = new TreeSet<String>();
        for(int x=0 ; x < arq.size(); x++){// elemento a ser comparado
				stTreeMapST.add(arq.get(x));
		  }		
		    long tmFinalTM = System.currentTimeMillis();
        time.add("TreeSet : " + (tmFinalTM-tmInicialTM));

        // Procura
         long tmInicialTMP = System.currentTimeMillis();
         for(int i = 0; i < words.length; i++){
            stTreeMapST.contains(words[i]);
        }

        long tmFinalTMP = System.currentTimeMillis();
        time.add("Search time TreeMap : " + (tmFinalTMP-tmInicialTMP) + " ms");

		return time;
    }
    
    
}