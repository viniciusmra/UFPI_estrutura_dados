package ap03;

import java.util.Vector;

public class Questao2_vet {
	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<>(); // Declara o vetor
		
		// Adiciona os dados (poderia ser um input do usu�rio)
		vector.add(9);
		vector.add(8);
		vector.add(7);
		vector.add(6);
		vector.add(5);
		vector.add(4);
		vector.add(3);
		vector.add(2);
		vector.add(1);

		System.out.println("Vetor desordenado: " + vector);
		int aux = 0;
		for(int i = 0; i < vector.size()-1; i++) {
			
			for(int j = 0; j < vector.size()-1-i; j++) {
				
				if(vector.get(j) > vector.get(j + 1)) { // Checa se o valor atual � maior que  o pr�ximo
					aux = vector.get(j); // atribui o valor atual � vari�vel auxiliar
					vector.set(j, vector.get(j + 1)); // permuta o valor das posi��es
					vector.set(j + 1, aux);
				}
			}
			//System.out.println((i +1 ) + " - " + vector);
		}
		System.out.println("Vetor ordenado: " + vector);
		
float mediana = 0;
if(vector.size()%2 != 0) { // Caso 1: N�mero de dados impar
	mediana = vector.get((int)(vector.size()/2));
}else { // Caso 2: N�mero par de dados 
	mediana = (float)(vector.get((vector.size()/2)-1) + vector.get((vector.size()/2)))/2;
}

System.out.println("Mediana: " + mediana);
	}
}
