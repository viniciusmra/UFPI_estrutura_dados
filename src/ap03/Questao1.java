package ap03;
/*1. Ler e armazenar informações de N alunos(as), incluindo nome e idade.
 *  Em seguida, fazer um método para encontrar a idade do aluno(a) mais novo e do aluno(a) mais velho. 
 *  Fazer também um método para imprimir o nome e a idade desses alunos(as). 
 *  OBS: Pode existir mais de um aluno(a) com a mesma idade. 
 *  Por fim, fazer um método para encontrar e imprimir a média de idade da turma.*/

import java.util.Scanner;

public class Questao1 {
	
	private Node inicio;
	private class Node {
		private String nome;
		private int idade;
		private Node prox;
		
		public Node(String nome, int idade) {
			this.nome=nome;
			this.idade=idade;
			this.prox=null;
		}
	}
	
	public void idadeMaiorEMenor() {

		Node aux= inicio;
		int idadeMenor, idadeMaior=0;
		idadeMenor=aux.idade;
		while(aux!=null) {
			
			if(aux.idade>idadeMaior) {
				idadeMaior=aux.idade;
			}
			if(aux.idade<idadeMenor) {
				idadeMenor=aux.idade;
			}
			aux = aux.prox;
		}
		System.out.println("\nMaior idade da turma: "+idadeMaior+"\nMenor idade da turma: "+idadeMenor+"\n");
	}
	public void imprimir() {
		Node alunos = inicio;
		System.out.println("Lista de nome e idade dos alunos:");
		while (alunos != null) {
			System.out.println("Nome: "+alunos.nome+"\tIdade: "+alunos.idade);
			alunos = alunos.prox;
		}
	}
	public void mediaIdade(int quant) {
		Node alunos = inicio;
		double medIdade=0;
		int soma=0;
		while (alunos != null) {
			soma+=alunos.idade;
			alunos = alunos.prox;
		}
		medIdade=soma/(double)quant;
		System.out.println("A media de idade da turma eh: "+ String.format("%.2f",medIdade));
	}
	
	public void novoAluno(int quant) {
		Scanner sc =new Scanner(System.in);
	
		System.out.println("Digite o nome do aluno "+ (quant+1)+":");
		String nome = sc.nextLine();
		System.out.println("Digite a idade do aluno "+ (quant+1)+":");
		int idade = sc.nextInt();
		
		Node novo = new Node(nome, idade);
		if (inicio==null) {
			inicio = novo;
		} else { 
			novo.prox = inicio;
			inicio = novo;
		}
	
	}
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Digite a quantidade de alunos:");
		int tam = sc.nextInt();
		while(tam==0){
			System.out.println("A turma vazia. Digite uma quantidade de alunos:");
			tam = sc.nextInt();
		}
		
		Questao1 aluno = new Questao1();
		for(int i=0;i<tam;i++) {
			aluno.novoAluno(i);
		}
		aluno.idadeMaiorEMenor();
		aluno.imprimir();
		aluno.mediaIdade(tam);
		
		sc.close();
	}
	
}

