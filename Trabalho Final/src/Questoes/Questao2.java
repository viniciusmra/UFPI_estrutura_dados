package Questoes;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Vector;

/*
    Classe Questao 02:
    
    RESPONSAVEL POR CONTER AS INTERFACES PARA HASHSET, LINKEDHASHSET e TREESET

*/


public class Questao2 {

/* 
    INPUT: RECEBE O NOME DO ARQUIVO

    METODO RESPONSAVEL POR CALCULAR :
    O TEMPO DE EXECUCAO DA INSERCAO DOS ELEMENTOS DO ARQUIVO NO VETOR;
    O TEMPO DE EXECUCAO PARA PROCURAR 10 ELEMENTOS NO VETOR;
    O TEMPO DE EXECUCAO PARA DELETAR 10 ELEMENTOS NO VETOR;

    OUTPUT: RETORNA UM VETOR COM O TEMPO DAS EXECUCOES
*/

  public Vector<String> timeHashSetST(String filename){
    Vector<String> arq = new Vector<String>();
    Vector<String> time = new Vector<String>();
    arq = Remove.readWords(filename);
    String[] words = {"Lisbon", "NASA", "Kyunghee","Konkuk", "Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};
    
    //inserir
    long tmInicialHS = System.nanoTime();
    HashSet<String> stHashSetST = new HashSet<String>(); 
    for(int x=0 ; x < arq.size(); x++){// elemento a ser comparado
      stHashSetST.add(arq.get(x));
    }		
    long tmFinalHS = System.nanoTime();
    time.add("Insertion HashSet : " + (tmFinalHS-tmInicialHS));

    // Procurar
    long tmInicialHSP = System.nanoTime();
    for(int i = 0; i < words.length; i++){
      stHashSetST.contains(words[i]);
    }

    long tmFinalHSP = System.nanoTime();
    time.add("Search time HashSet : " + (tmFinalHSP-tmInicialHSP) + " ns");

    // Deletar
    
    long tmInicialHSPD = System.nanoTime();
    for(int i = 0; i < words.length; i++){
      stHashSetST.remove(words[i]);
    }

    long tmFinalHSPD =System.nanoTime();
    time.add("Delete time HashSet : " + (tmFinalHSPD-tmInicialHSPD) + " ns"); 
    
    return time;
  }

  public Vector<String> timeLinkedHashSetST(String filename){
    Vector<String> arq = new Vector<String>();
    Vector<String> time = new Vector<String>();
    arq = Remove.readWords(filename);
    String[] words = {"Lisbon", "NASA", "Kyunghee","Konkuk", "Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};
    
    //inserir
    long tmInicialLHS = System.nanoTime();
    LinkedHashSet<String> stLinkedHashSetST = new LinkedHashSet<String>();
    for(int x=0 ; x < arq.size(); x++){// elemento a ser comparado
      stLinkedHashSetST.add(arq.get(x));
    }		
    long tmFinalLHS = System.nanoTime();
    time.add("Insertion LinkedHashSet : " + (tmFinalLHS-tmInicialLHS));

    // Procurar
    long tmInicialLHSP = System.nanoTime();
    for(int i = 0; i < words.length; i++){
      stLinkedHashSetST.contains(words[i]);
    }

    long tmFinalLHSP = System.nanoTime();
    time.add("Search time LinkedHashSet : " + (tmFinalLHSP-tmInicialLHSP) + " ns");

    // Deletar
    long tmInicialLHSD = System.nanoTime();

    for(int i = 0; i < words.length; i++){
      stLinkedHashSetST.remove(words[i]);
      //System.out.println(stLinkedHashSetST.contains(words[i]));
    }

    long tmFinalLHSD = System.nanoTime();
    time.add("Delete time LinkedHashSet : " + (tmFinalLHSD-tmInicialLHSD) + " ns"); 

    return time;
  }

  public Vector<String> timeTreeSetST(String filename){
    Vector<String> arq = new Vector<String>();
    Vector<String> time = new Vector<String>();
    arq = Remove.readWords(filename);
    String[] words = {"Lisbon", "NASA", "Kyunghee","Konkuk", "Sogang", "momentarily", "rubella", "vaccinations", "government", "Authorities"};
      
    //inserir
    long tmInicialTM = System.nanoTime();
    TreeSet<String> stTreeSetST = new TreeSet<String>();
    for(int x=0 ; x < arq.size(); x++){// elemento a ser comparado
      stTreeSetST.add(arq.get(x));
    }		
    long tmFinalTM = System.nanoTime();
    time.add("Insertion TreeSet : " + (tmFinalTM-tmInicialTM));

    // Procurar
    long tmInicialTMP = System.nanoTime();
    for(int i = 0; i < words.length; i++){
          stTreeSetST.contains(words[i]);
    }

    long tmFinalTMP = System.nanoTime();
    time.add("Search time TreeSet : " + (tmFinalTMP-tmInicialTMP) + " ns");
    
    // Deletar
    long tmInicialTSD = System.nanoTime();

    for(int i = 0; i < words.length; i++){
      stTreeSetST.remove(words[i]);
    }

    long tmFinalTSD = System.nanoTime();
    time.add("Delete time TreeSet : " + (tmFinalTSD-tmInicialTSD) + " ns"); 

    return time;
  }
}