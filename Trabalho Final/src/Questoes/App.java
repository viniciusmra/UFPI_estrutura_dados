package Questoes;

import java.io.FileNotFoundException;
import java.util.Vector;
import java.util.Scanner;
/*
	Ellem Almeida	
	Pedro Felipe
    Vinicius Alves

	DESCRICAO: Esta atividade versa sobre a Java Collections API.
	Collections em Java sao usadas para armazenar grupos de objetos. A Collections API
	fornece um numero de interfaces (incluindo Collection, List, Map e Set) para definir
	uma maneira padrao de usar uma faixa concreta de estrutura de dados. 

*/

public class App{

    public static void main(String[] args) throws FileNotFoundException {
		String filename = "src/Questoes/leipzig100kUnic.txt";
		Scanner keyboard = new Scanner(System.in);
		Integer key;
		//Vector<String> arq = new Vector<String>();
		//criando arquivo sem palavras repetidas
		//arq = readWords("leipzig100kUnic.txt");
        // arq = readWords("src/Questoes/leipzig100k.txt");
		// newFile(arq, "src/Questoes/leipzig100kUnic.txt");

		Questao1 classeQ1 = new Questao1();
		Questao2 classeQ2 = new Questao2();
		Questao3 classeQ3 = new Questao3();

		Vector<String> metodosQ1 = new Vector<String>();
		Vector<String> metodosQ2 = new Vector<String>();
		Vector<String> metodosQ3 = new Vector<String>();

		boolean flag = true;
		while(flag){

			System.out.println("=-=-=-=-=-=-=-=-=-=");
			System.out.println("        MENU       ");
			System.out.println("=-=-=-=-=-=-=-=-=-=");
			System.out.println("[0] Classes List");
			System.out.println("[1] Classes Set");
			System.out.println("[2] Classes MAP");
			System.out.println("[3] Tudo");
			System.out.println("[4] Sair");
			System.out.println("=-=-=-=-=-=-=-=-=-=");
			System.out.print("Informe uma opção: ");
			key = keyboard.nextInt();
			System.out.println("=-=-=-=-=-=-=-=-=-=");

			switch(key){
				case 0:
					System.out.println("Carregando...");
					System.out.println("=-=-=-=-=-=-=-=-=-=");

					metodosQ1.addAll(classeQ1.timeVectorST(filename));
					metodosQ1.addAll(classeQ1.timeArrayListST(filename));
					metodosQ1.addAll(classeQ1.timeLinkedListST(filename));
			
					for(int i = 0; i <  metodosQ1.size(); i++){
						System.out.println(metodosQ1.get(i));
						if((i+1)%3 == 0 && (i+1 != metodosQ1.size())){
							System.out.println("=-=-=-=-=-=-=-=-=-=");
						}
					}

					break;

				case 1:
					System.out.println("Carregando...");
					System.out.println("=-=-=-=-=-=-=-=-=-=");

					metodosQ2.addAll(classeQ2.timeHashSetST(filename));
					metodosQ2.addAll(classeQ2.timeLinkedHashSetST(filename));
					metodosQ2.addAll(classeQ2.timeTreeSetST(filename));

					for(int i = 0; i <  metodosQ2.size(); i++){
						System.out.println(metodosQ2.get(i));
						if((i+1)%3 == 0 && (i+1 != metodosQ2.size())){
							System.out.println("=-=-=-=-=-=-=-=-=-=");
						}
					}

					break;

				case 2:
					System.out.println("Carregando...");
					System.out.println("=-=-=-=-=-=-=-=-=-=");

					metodosQ3.addAll(classeQ3.timeTreeMapST(filename));
					metodosQ3.addAll(classeQ3.timeLinkedHashST(filename));
					metodosQ3.addAll(classeQ3.timeHashMapST(filename));

					for(int i=0; i<  metodosQ3.size(); i++){
						System.out.println(metodosQ3.get(i));
						if((i+1)%3 == 0 && (i+1 != metodosQ3.size())){
							System.out.println("=-=-=-=-=-=-=-=-=-=");
						}	
					}
					break;

				case 3:
					System.out.println("Carregando...");
					System.out.println("=-=-=-=-=-=-=-=-=-=");

					
					metodosQ1.addAll(classeQ1.timeVectorST(filename));
					metodosQ1.addAll(classeQ1.timeArrayListST(filename));
					metodosQ1.addAll(classeQ1.timeLinkedListST(filename));

					metodosQ2.addAll(classeQ2.timeHashSetST(filename));
					metodosQ2.addAll(classeQ2.timeLinkedHashSetST(filename));
					metodosQ2.addAll(classeQ2.timeTreeSetST(filename));	

					metodosQ3.addAll(classeQ3.timeTreeMapST(filename));
					metodosQ3.addAll(classeQ3.timeLinkedHashST(filename));
					metodosQ3.addAll(classeQ3.timeHashMapST(filename));

					for(int i=0; i<  metodosQ1.size(); i++){
						System.out.println(metodosQ1.get(i));
						if((i+1)%3 == 0 && (i+1 != metodosQ1.size())){
							System.out.println("=-=-=-=-=-=-=-=-=-=");
						}
					}
					
					for(int i=0; i<  metodosQ2.size(); i++){
						System.out.println(metodosQ2.get(i));
						if((i+1)%3 == 0 && (i+1 != metodosQ2.size())){
							System.out.println("=-=-=-=-=-=-=-=-=-=");
						}
					}
					
					for(int i=0; i<  metodosQ3.size(); i++){
						System.out.println(metodosQ3.get(i));
						if((i+1)%3 == 0 && (i+1 != metodosQ3.size())){
							System.out.println("=-=-=-=-=-=-=-=-=-=");
						}
					}

					break;

				case 4:
					System.out.println("Encerrando...");
					flag=false;
					break;

				default:
					System.out.println("Informe uma opcao valida");
                   	//key = keyboard.nextInt();
                    break;
			}
		}
		System.out.println("=-=-=-=-=-=-=-=-=-=");
		keyboard.close();
     }

}