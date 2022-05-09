package Questoes;

import java.io.FileNotFoundException;
import java.util.Vector;


public class App <Key, Value>{

    public static void main(String[] args) throws FileNotFoundException {

		//Vector<String> arq = new Vector<String>();

		//criando arquivo sem palavras repetidas
        // arq = readWords("src/Questoes/leipzig100k.txt");
		// newFile(arq, "src/Questoes/leipzig100kUnic.txt");
		//arq = readWords("leipzig100kUnic.txt");
		
		// //QUESTAO 1:
		Questao1 q1 = new Questao1();
		Vector<String> aq1Vect = new Vector<String>();

		// aq1Vect.addAll(q1.timeST("leipzig100kUnic.txt"));

		// for(int i=0; i< aq1Vect.size(); i++){
		// 	System.out.println(aq1Vect.get(i));
		// }

		aq1Vect.addAll(q1.timeVectorST("leipzig100kUnic.txt"));

		//aq1Vect.addAll(q1.timeArrayListST("leipzig100kUnic.txt"));

		//aq1Vect.addAll(q1.timeLinkedListST("leipzig100kUnic.txt"));
		for(int i=0; i< aq1Vect.size(); i++){
			System.out.println(aq1Vect.get(i));
		}

		// //QUESTAO 2:

		// Questao2 q2 = new Questao2();
		// Vector<String> aq2Vect = new Vector<String>();
		// aq2Vect.addAll(q2.ST("leipzig100kUnic.txt"));

		// for(int j=0; j< aq2Vect.size(); j++){
		// 	System.out.println(aq2Vect.get(j));
		// }

		//QUESTAO 3:

		// Questao3 q3 = new Questao3();
		// Vector<String> aq3Vect = new Vector<String>();
		// aq3Vect.addAll(q3.ST("leipzig100kUnic.txt"));

		// for(int j=0; j< aq3Vect.size(); j++){
		// 	System.out.println(aq3Vect.get(j));
		// }

		
		
     }

}