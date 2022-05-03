import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class App {

    public static String[] readWords(String filename) { // abrir o arquivo tales.tx
        ArrayList<String> wordList = new ArrayList<String>(); // Cria um arraylist para guardar os dados
        try {
            File file = new File(filename);
            Scanner rows = new Scanner(file);
    
            while (rows.hasNext()) { // Continua lendo enquanto ainda estiver linhas para serem lidas
                String word = rows.next();
                wordList.add(word); // Adiciona a linha lida ao ArrayList
            }
            rows.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao efetuar a leitura");
            e.printStackTrace();
        }
    
        return wordList.toArray(new String[0]);
    }

    public static void main(String[] args) throws Exception {
        String[] nomes;
        BSTPlus<String, Integer> st = new BSTPlus<String, Integer>();
        try {
            nomes = readWords(args[0]);
            for(int i = 0; i < nomes.length; i++){
                st.put(nomes[i], i);
            }
        } catch (Exception e) {
            System.out.println("NÃO CONSEGUE NÉ?!");
            return;
        }

        for(int i = 0; i < nomes.length; i++){ //profundidade de cada chave
            System.out.println(nomes[i]  + " - " + st.getDepth(nomes[i]));
        }

        System.out.println(st.internalPathLength());

        //st.printAnterior("Ellem");
        
        st.preOrder();
        System.out.print("\n");
        st.posOrder();
        System.out.print("\n");
        st.inOrder();

    }
}
