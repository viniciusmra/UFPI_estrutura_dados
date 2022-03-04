package ap03;
import java.util.Scanner;

public class Questao3 {

    public Node inicio = null;
    public int contador = 0;

    private class Node {
        private double valor;
        private Node prox;

        public Node(double valor) {
            this.valor = valor;
            this.prox = null;
        }
    }

    public void addValor(double valor){
        Node novo = new Node(valor);
        if(inicio == null){ // quando a lista n contem elementos
            inicio = novo;
            contador++;
        }else { // quando a lista contem elementos
            novo.prox = inicio;
            inicio = novo;
            contador++;
        }
    }

    public void mostrarTodos(){
        Node aux = inicio;
        while(aux != null){
            System.out.println(aux.valor);
            aux = aux.prox;
        }
    }

    public int size(){
        return contador;
    }

    public void lista_vetor(double a[]){
        Node aux = inicio;
        int i=0;
        while(aux != null){
            a[i] = aux.valor;
            aux = aux.prox;
            i++;
        }
    }

    public int max_Repeticoes(double b[]){
        int repeticoes_i, lim = 0;
        int max_repeticoes=0;
        double sup[] = b;

        for(int i=0; i<size(); i++){
            repeticoes_i=1;
            for(int j=i+1; j < size(); j++){
                if(sup[i] == sup[j]){
                    repeticoes_i++; // conta a quantidade de repeticoes para cada membro;
                }
            }
            if (repeticoes_i > lim){
                max_repeticoes = repeticoes_i;
                lim = max_repeticoes;
            }   
        }
        return max_repeticoes;

    }

    public void modaVetor(){
        int repeticoes_i;
        double sup[] = new double[size()];
        int qtd_moda=0, maximo_repeticoes=0;
        double moda=0;
        double modas[] = new double[size()];

        lista_vetor(sup);

        maximo_repeticoes = max_Repeticoes(sup);

        for(int i=0; i < size(); i++){
            repeticoes_i=1;
            for(int j=i+1; j < size(); j++){
                if(sup[i] == sup[j]){
                    repeticoes_i++;
                }
            }
            if(repeticoes_i == maximo_repeticoes){
                moda = sup[i];
                modas[qtd_moda++] = moda;
            }
        }

        if(qtd_moda>0){
            for(int k=0; k < qtd_moda; k++){
                System.out.println(modas[k]);
            }
        }
        else{
            System.out.println(moda);
        }

    }
    
    public static void main(String[] args) {
        Questao3 app = new Questao3();
        Scanner teclado = new Scanner(System.in);
        double valor;

        while(true){
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.printf("Informe um valor:");
            valor = teclado.nextDouble();
            app.addValor(valor);
            System.out.println("=-=-=-=-=-=-=-=-=");
            System.out.printf("Deseja Continuar?[0/1]:");
            int flag = teclado.nextInt();
            if(flag == 0){break;}
        }
        System.out.println("=-=-=-=-=-=-=-=-=");
        System.out.println("Lista dos valores adicionados (pilha)");
        app.mostrarTodos();
        System.out.println("=-=-=-=-=-=-=-=-=");
        System.out.println("Quantidade de elementos adicionados:"+app.size());
        System.out.println("=-=-=-=-=-=-=-=-=");
        System.out.println("Moda (ou Modas) do conjunto:");
        app.modaVetor();
        teclado.close();
    }
}