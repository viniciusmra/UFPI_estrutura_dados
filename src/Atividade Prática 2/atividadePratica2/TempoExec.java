package atividadePratica2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TempoExec {
  public static void main(String[] args) {
    // Efetua a leitura das três listas atribuindo cada uma a seu respectivo array
    String[] nomes5k = getNomes("nomes5k.txt");
    String[] nomes10k = getNomes("nomes10k.txt");
    String[] nomes50k = getNomes("nomes50k.txt");
    double comeco; // Declarava a variável necessária para marcar o tempo
    

    System.out.println("\tBinaryInsertion\tSelection"); //Marcador
    ///////////////////////////Listas desordenadas
    // 5k
    System.out.print("5k\t");
    String[] nomes5kTemp = new String[nomes5k.length]; // Declara uma variável que recebe os dados da lista e é enviada para ordenação

    // BinaryInsertion
    comeco = System.nanoTime();
    for(int i = 0; i < 10; i++){ //Faz 10 repetições
      System.arraycopy(nomes5k, 0, nomes5kTemp, 0, nomes5k.length); // A cada repetição o array recebe os dados desordenados
      BinaryInsertion.sort(nomes5kTemp); // Executa a ordenação
    }
    System.out.print(((System.nanoTime() - comeco)/1000000.0) + " ms\t"); // Imprime o tempo de execução
    
    // Selection
    comeco = System.nanoTime();
    for(int i = 0; i < 10; i++){
      System.arraycopy(nomes5k, 0, nomes5kTemp, 0, nomes5k.length);
      Selection.sort(nomes5kTemp);
    }
    System.out.println(((System.nanoTime() - comeco)/1000000.0) + " ms");

    // 10k
    System.out.print("10k\t");
    String[] nomes10kTemp = new String[nomes10k.length];

    // BinaryInsertion
    comeco = System.nanoTime();
    for(int i = 0; i < 10; i++){
      System.arraycopy(nomes10k, 0, nomes10kTemp, 0, nomes10k.length);
      BinaryInsertion.sort(nomes10kTemp);
    }
    System.out.print(((System.nanoTime() - comeco)/1000000.0) + " ms\t");

    // Selection
    comeco = System.nanoTime();
    for(int i = 0; i < 10; i++){
      System.arraycopy(nomes10k, 0, nomes10kTemp, 0, nomes10k.length);
      Selection.sort(nomes10kTemp);
    }
    System.out.println(((System.nanoTime() - comeco)/1000000.0) + " ms");

    // 50k
    System.out.print("50k\t");
    String[] nomes50kTemp = new String[nomes50k.length];

    // BinaryInsertion
    comeco = System.nanoTime();
    for(int i = 0; i < 10; i++){
      System.arraycopy(nomes50k, 0, nomes50kTemp, 0, nomes50k.length);
      BinaryInsertion.sort(nomes50kTemp);
    }
    System.out.print(((System.nanoTime() - comeco)/1000000.0) + " ms\t");

    // Selection
    comeco = System.nanoTime();
    for(int i = 0; i < 10; i++){
      System.arraycopy(nomes50k, 0, nomes50kTemp, 0, nomes50k.length);
      Selection.sort(nomes50kTemp);
    }
    System.out.println(((System.nanoTime() - comeco)/1000000.0) + " ms");

    ///////////////////// Listas ordenadas
    System.out.println("\tBinaryInsertion\tSelection");
    // 5k
    System.out.print("5k\t");

    // BinaryInsertion
    System.arraycopy(nomes5k, 0, nomes5kTemp, 0, nomes5k.length);
    BinaryInsertion.sort(nomes5kTemp);
    comeco = System.nanoTime();
    for(int i = 0; i < 10; i++){
      BinaryInsertion.sort(nomes5kTemp);
    }
    System.out.print(((System.nanoTime() - comeco)/1000000.0) + " ms\t");
    
    // Selection
    System.arraycopy(nomes5k, 0, nomes5kTemp, 0, nomes5k.length);
    Selection.sort(nomes5kTemp);
    comeco = System.nanoTime();
    for(int i = 0; i < 10; i++){
      Selection.sort(nomes5kTemp);
    }
    System.out.println(((System.nanoTime() - comeco)/1000000.0) + " ms");

    // 10k
    System.out.print("10k\t");

    // BinaryInsertion
    System.arraycopy(nomes10k, 0, nomes10kTemp, 0, nomes10k.length);
    BinaryInsertion.sort(nomes10kTemp);
    comeco = System.nanoTime();
    for(int i = 0; i < 10; i++){
      BinaryInsertion.sort(nomes10kTemp);
    }
    System.out.print(((System.nanoTime() - comeco)/1000000.0) + " ms\t");

    // Selection
    System.arraycopy(nomes10k, 0, nomes10kTemp, 0, nomes10k.length);
    Selection.sort(nomes10kTemp);
    comeco = System.nanoTime();
    for(int i = 0; i < 10; i++){
      Selection.sort(nomes10kTemp);
    }
    System.out.println(((System.nanoTime() - comeco)/1000000.0) + " ms");

    // 50k
    System.out.print("50k\t");

    // BinaryInsertion
    System.arraycopy(nomes50k, 0, nomes50kTemp, 0, nomes50k.length);
    BinaryInsertion.sort(nomes50kTemp);
    comeco = System.nanoTime();
    for(int i = 0; i < 10; i++){
      BinaryInsertion.sort(nomes50kTemp);
    }
    System.out.print(((System.nanoTime() - comeco)/1000000.0) + " ms\t");

    // Selection
    System.arraycopy(nomes50k, 0, nomes50kTemp, 0, nomes50k.length);
    Selection.sort(nomes50kTemp);
    comeco = System.nanoTime();
    for(int i = 0; i < 10; i++){
      Selection.sort(nomes50kTemp);
    }
    System.out.println(((System.nanoTime() - comeco)/1000000.0) + " ms");

  }

  // Método que recebe o nome do arquivo a ser lido e retorna um array de String
  // onde cada elemento corresponde a uma linha do arquivo
  public static String[] getNomes(String nomeArquivo){
    ArrayList<String> listaNomes = new ArrayList<String>(); // Cria um arraylist para guardar os dados
    try {
      File arquivo = new File(nomeArquivo);
      Scanner nomes = new Scanner(arquivo);
      while (nomes.hasNextLine()) { // Continua lendo enquanto ainda estiver linhas para serem lidas
        String nome = nomes.nextLine();
        listaNomes.add(nome);  // Adiciona a linha lida ao ArrayList
      }
      nomes.close();
    } catch (FileNotFoundException e) {
      System.out.println("Erro ao efetuar a leitura");
      e.printStackTrace();
    }
    return listaNomes.toArray(new String[0]); // Retorna o arraylist convertido para array
  }

  public static void imprimeArray(String[] a){
    for(int i = 0; i < a.length; i++){
      System.out.println(a[i]);
    }
  }
}
