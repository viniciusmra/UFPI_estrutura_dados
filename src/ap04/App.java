package ap04;
import java.util.Scanner;
/*DESCRIÇÃO: Listas Encadeadas. Escrever uma aplicação para criar uma lista encadeada 
para armazenar nomes de pessoas, com as seguintes opções:
*Inserir um nome no início da lista, sem permitir nomes repetidos;
*Inserir um nome no final da lista, sem permitir nomes repetidos;
*Buscar um determinado nome na lista, retornando true ou false, conforme o caso;
*Excluir ou Marcar como excluído um determinado nome, se ele estiver na lista;
*Mostrar todos os nomes da lista;*/
public class App {
    
    public static void main(String[] args) throws Exception {
    
        ListaEncadeada lista = new ListaEncadeada();

        int flag=0;
        Scanner teclado = new Scanner(System.in);
        int opcao;
        String nome;
        
        while(true){
            System.out.println("=-=-=-=-=-=-=");
            System.out.println("[0] Inserir Elemento no Inicio da Lista");
            System.out.println("[1] Inserir Elemento no Final da Lista");
            System.out.println("[2] Buscar Determinado Nome da Lista");
            System.out.println("[3] Marcar como Excluido");
            System.out.println("[4] Mostrar Todos os Nomes da Lista");
            System.out.println("[5] Sair");
            System.out.println("=-=-=-=-=-=-=");
            System.out.println("Informe uma opcao:");
            opcao = teclado.nextInt();
            teclado.nextLine();
            switch (opcao) {
                case 0:  
                    System.out.println("[0] Inserir Elemento no Inicio da Lista");
                    System.out.println("Informe um nome [inicio]:");
                    nome = teclado.nextLine();
                    
                    if(lista.verificar(nome)){
                        if(lista.pesquisar(nome).getExcluido()){
                            System.out.println("O nome está marcado como excluido, deseja recuperar?[0 - não|1 - sim]");
                            int resposta = teclado.nextInt();
                            if(resposta==1){
                                lista.recuperarNome(nome);
                                System.out.println("Nome recuperado.");
                            }
                        }
                    } else{
                        lista.addNomeInicio(nome);
                    }
                    break;
                case 1:
                    System.out.println("[1] Inserir Elemento no Final da Lista");
                    System.out.println("Informe um nome [final]:");
                    nome = teclado.nextLine();
                    
                    if(lista.verificar(nome)){
                        if(lista.pesquisar(nome).getExcluido()){    
                            System.out.println("O nome está marcado como excluido, deseja recuperar?[0 - não|1 - sim]");
                            int resposta = teclado.nextInt();
                            if(resposta==1){
                                lista.recuperarNome(nome);
                                System.out.println("Nome recuperado.");
                            }
                        } 
                    }else{
                        lista.addNomeFinal(nome);
                    }
                    break;
                case 2:
                    System.out.println("[2] Buscar Determinado Nome da Lista");
                    System.out.println("Buscar um nome na lista:");
                    nome = teclado.nextLine();
                    if(lista.verificar(nome)){
                        if(lista.pesquisar(nome).getExcluido()){
                            System.out.println("Nome excluido");
                        }else{
                            System.out.println("Nome encontrado");
                        }
                    }else{
                        System.out.println("Nome NÃO encontrado");
                    }
                    break;
                case 3:
                    System.out.println("[3] Marcar como Excluido");
                    System.out.println("Informe um nome [remover]:");
                    nome = teclado.nextLine();
                    lista.removerNome(nome);
                    break;
                case 4:
                    System.out.println("[4] Mostrar Todos os Nomes da Lista");
                    lista.mostrarTodos();
                    break;
                case 5:
                    System.out.println("[5] Sair");
                    flag=1;
                    break;           
                default:
                    System.out.println("Informe uma opcao valida");
                    opcao = teclado.nextInt();
                    break;
            }
            if(flag==1){break;}
        }
        teclado.close();
    }
}
