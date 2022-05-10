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

    // Delete
    
    long tmInicialHSPD = System.currentTimeMillis();
    for(int i = 0; i < words.length; i++){
      stHashSetST.remove(words[i]);
      //System.out.println(stHashSetST.contains(words[i]));
    }

    long tmFinalHSPD = System.currentTimeMillis();
    time.add("Delete time HashSet : " + (tmFinalHSPD-tmInicialHSPD) + " ms"); 
    
    return time;
  }

  public Vector<String> timeLinkedHashSetST(String filename){
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
    time.add("Search time LinkedHashSet : " + (tmFinalLHSP-tmInicialLHSP) + " ms");

    // Delete
    long tmInicialLHSD = System.currentTimeMillis();

    for(int i = 0; i < words.length; i++){
      stLinkedHashSetST.remove(words[i]);
      //System.out.println(stLinkedHashSetST.contains(words[i]));
    }

    long tmFinalLHSD = System.currentTimeMillis();
    time.add("Delete time LinkedHashSet : " + (tmFinalLHSD-tmInicialLHSD) + " ms"); 

    return time;
  }

  public Vector<String> timeTreeSetST(String filename){
    Vector<String> arq = new Vector<String>();
    Vector<String> time = new Vector<String>();
    arq = Remove.readWords(filename);
    String[] words = {"Lisbon", "NASA", "Kyunghee","Konkuk", "Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};
      
    //inserir
    long tmInicialTM = System.currentTimeMillis();
    TreeSet<String> stTreeSetST = new TreeSet<String>();
    for(int x=0 ; x < arq.size(); x++){// elemento a ser comparado
      stTreeSetST.add(arq.get(x));
    }		
    long tmFinalTM = System.currentTimeMillis();
    time.add("TreeSet : " + (tmFinalTM-tmInicialTM));

    // Procura
    long tmInicialTMP = System.currentTimeMillis();
    for(int i = 0; i < words.length; i++){
          stTreeSetST.contains(words[i]);
    }

    long tmFinalTMP = System.currentTimeMillis();
    time.add("Search time TreeSet : " + (tmFinalTMP-tmInicialTMP) + " ms");
    
    // Delete
    long tmInicialTSD = System.currentTimeMillis();

    for(int i = 0; i < words.length; i++){
        stTreeSetST.remove(words[i]);
      // System.out.println(stTreeSetST.contains(words[i]));
    }

    long tmFinalTSD = System.currentTimeMillis();
    time.add("Delete time TreeSet : " + (tmFinalTSD-tmInicialTSD) + " ms"); 

    return time;
  }
}