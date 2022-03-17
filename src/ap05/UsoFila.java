/*
Na aplicação cliente, você deve criar um menu com opções para: 
i) chegada de pessoa para atendimento normal; 
ii) chegada de pessoa para atendimento prioritário; 
iii) atendimento de uma pessoa (todas as pessoas com prioridade devem ser atendidas 
antes de pessoas normais ou pode ser implementada outra política por exemplo: cinco 
normais e um prioridade); 
iv) listar todas as pessoas da fila; e 
v) gerar estatísticas parciais sobre o atendimento em um determinado período da empresa: 
%atendimentoPrioritário, %atendimentoNormal e tamanho das filas 

** TO DO:
    (vini)    
    revisar os comentários que eu fiz (alterei algumas coisas e n alterei os comentários) 
    revisar o nome de alguns métodos de get e set
    //pedro passou por aqui
*/ 
import java.util.Scanner;
public class UsoFila{
    public static void main(String[] args) {
        FilaPrioridade fila = new FilaPrioridade();
        Scanner teclado = new Scanner(System.in);
        int opcao;
        String nome;
        boolean flag = true;

        while(flag){
            System.out.println("=-=-=-=-=-=-==-=-=-=-=-=-==-=-=-=-=-=-=");
            System.out.println("[0] Inserir Pessoa na da fila [sem prioridades]");
            System.out.println("[1] Inserir Pessoa na fila [com prioridades]");
            System.out.println("[2] Atendimento");
            System.out.println("[3] Listar Todos os Nomes da Fila");
            System.out.println("[4] Estatisticas");
            System.out.println("[5] Sair");
            System.out.println("=-=-=-=-=-=-==-=-=-=-=-=-==-=-=-=-=-=-=");
            System.out.println("Informe uma opcao:");
            System.out.print("> ");
            
            opcao = teclado.nextInt();
            teclado.nextLine();
            switch (opcao) {
                case 0:
                    System.out.println("Informe seu nome: (Sem prioridade)");
                    System.out.print("> ");
                    nome = teclado.nextLine();
                    fila.inserir(nome, false);
                    break;
                    
                case 1:
                    System.out.println("Informe seu nome: (Com prioridade)");
                    System.out.print("> ");
                    nome = teclado.nextLine();
                    fila.inserir(nome, true);
                    break;

                case 2:
                    String msg = fila.chamarPrioritario();
                    if(msg != null){
                        System.out.println(msg); 
                    } else{
                        System.out.println("A fila esta vazia");
                    }
                    break;

                case 3:
                    String[] pacientes = new String[fila.getTam() - fila.totalAtendidos()];
                    pacientes = fila.mostrarTodos();
                    if(pacientes.length > 0){
                        for(int i = 0; i < fila.getTam() - fila.totalAtendidos(); i++){
                            System.out.println(pacientes[i]);
                        }
                    }else{
                        System.out.println("A fila esta vazia");
                    }
                    break;

                case 4:
                    System.out.println("Total de pacientes na fila: " + (fila.getTam() - fila.totalAtendidos()));
                    System.out.println("Total de atendimentos: " + fila.totalAtendidos());
                    if(fila.totalAtendidos() > 0){
                        System.out.println(" |- " + fila.normalAtendidos() + "% dos atendimentos foram sem prioridades");
                        System.out.println(" |- " + fila.prioAtendidos() + "% dos atendimentos foram com prioridades");
                    }
                    break;

                case 5:
                    if(fila.totalAtendidos() == fila.getTam()){
                        flag = false;
                        System.out.println("Atendimentos conluidos");
                        System.out.println("Total de atendimentos: " + fila.totalAtendidos());
                        if(fila.totalAtendidos() > 0){
                            System.out.println(" |- " + fila.normalAtendidos() + "% dos atendimentos foram sem prioridades");
                            System.out.println(" |- " + fila.prioAtendidos() + "% dos atendimentos foram com prioridades");
                        }
                    }else{
                       System.out.println("O atendimento nao foi conluido, restam " + ((fila.getTam() - fila.totalAtendidos())) + " paciente(s) na fila");
                    }
                    break;

                default:
                    System.out.println("Informe uma opcao:");
                    System.out.print("> ");
                    opcao = teclado.nextInt();
                    break;
            }
        }
        teclado.close();
    }
}
