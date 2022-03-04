// Questão 2 da atividade pártica 3 de ciência da computação
// Autor Vinícius Alves de Moura - GP01
// e-mail: viniciusmra@gmail.com

package ap03;

import java.util.Scanner;

public class Questao2_lista {
	
	private Node inicio = null;
	private int tam = 0;
	
	private class Node{
		double valor;
		private Node next;
		private Node prev;

		public Node(double valor) {
			this.valor = valor;
			this.next = null;
			this.prev = null;
			tam++;
		}
	}
	
	// Método para adiconar um elemento à lista
	public void addValor(double valor) {
		Node novo = new Node(valor);
		
		if(inicio == null) {
			inicio = novo;
		}else {
			novo.next = inicio;
			inicio.prev = novo;
			inicio = novo;
		}
	}
	
	// Método para mostrar todos os elementos da lista
	public void mostrarTodos() {
		Node aux = inicio;
		System.out.print("[");
		while(aux != null) {
			System.out.print(aux.valor);
			aux = aux.next;
			if(aux == null) {
				System.out.println("]");
			}
			else {
				System.out.print(", ");
			}
		}
	}
	
	// Método para ordenar a lista
	public void ordenar() {
		Node x = null, y = null, z = null, w = null; // declaração das variáveis
		// São elas
		// y é o valor atual
		// z é o próximo valor (y.next), que será permutado ou não com y
		// x é o valor anterior ao atual (y.prev)
		// w é o valor seguinte a z (z.next ou y.next.next)
		
		for(int i = 0; i < tam-1; i++) { // for que se repete o mesmo número de vezes do tamanho da lista
			y = inicio;
			while(y.next != null) { // while que percorre o todos os elementos da lista encadeada
				
				x = y.prev;
				z = y.next;
				w = y.next.next;
				
				if(y.valor > z.valor) { // checa se o valor atual é maior que o próximo valor, se sim eles são permutados entre si
					if(x != null) {
						x.next = z;
						
					} else {
						inicio = z;
					}
					z.prev = x;
					
					z.next = y;
					y.prev = z;
					y.next = w;
					if(w != null) {
						w.prev = y;
					}
					if(x != null && x.prev != null) {
						x.prev.next = x;
					}
					if(w != null && w.next != null) {
						w.next.prev = w;
					}
				} else { // Se o valor não for maior o valor atual se torna o próximo elemento da lista
					y = y.next;
				}
			}
		}
		
	}
	
	// Método que retorna o valor do elemento na posição n da lista
	public double getVal(int n) {
		if(n < tam) {
			Node aux = inicio;
			for(int i = 0; i < tam; i++){
				if(i == n) {
					return aux.valor;
				}
				aux = aux.next;
			}
		}
		return -1;
	}
	
	// MAIN
	public static void main(String[] args) {
		Questao2_lista lista = new Questao2_lista();
		
		// Leitura dos dados
		Scanner input = new Scanner(System.in);
		System.out.print("Informe quantos valores serão digitados: ");
		int rep = input.nextInt();
		System.out.println("Digite os valores: ");
		for(int i = 0; i < rep; i++) {
			System.out.print((i+1) + " - ");
			lista.addValor(input.nextDouble());
		}
		input.close();
		
		// Mostrando os dados da forma que o usuário colocou
		System.out.print("Lista desordenada: ");
		lista.mostrarTodos();
		
		// Mostrando os dados depois do algoritmo de ordenação
		System.out.print("Lista ordenada:    ");
		lista.ordenar();
		lista.mostrarTodos();
		
// Cálculo da mediana
double mediana;
if(lista.tam%2 != 0) { // Caso 1: dados com tamanho impar
	mediana = lista.getVal((int)(lista.tam/2));
	
} else { // Caso 2: Dados com tamanho par
	mediana = (double)(lista.getVal((int)(lista.tam/2) - 1) + lista.getVal((int)(lista.tam/2)))/2;
}
System.out.println("Mediana: " + mediana);
		
	}
}
