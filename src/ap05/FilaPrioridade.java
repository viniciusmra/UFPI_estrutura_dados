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
*/ 
import java.util.Scanner;
public class UsoFila{
    public static void main(String[] args) {
        FilaPrioridade fila = new FilaPrioridade();
        Scanner teclado = new Scanner(System.in);
        int opcao;
        String nome;
        boolean flag = false;

        while(true){
            System.out.println("=-=-=-=-=-=-==-=-=-=-=-=-==-=-=-=-=-=-=");
            System.out.println("[0] Inserir Pessoa na da fila [sem prioridades]");
            System.out.println("[1] Inserir Pessoa na fila [com prioridades]");
            System.out.println("[2] Atendimento");
            System.out.println("[3] Listar Todos os Nomes da Fila");
            System.out.println("[4] Estatisticas");
            System.out.println("[5] Sair");
            System.out.println("=-=-=-=-=-=-==-=-=-=-=-=-==-=-=-=-=-=-=");
            System.out.println("Informe uma opcao:");
            
            opcao = teclado.nextInt();
            teclado.nextLine();
            switch (opcao) {
                case 0:
                    System.out.println("Informe seu nome: (Sem prioridade)");
                    nome = teclado.nextLine();
                    fila.inserir(nome, false);
                    break;
                case 1:
                    System.out.println("Informe seu nome: (Com prioridade)");
                    nome = teclado.nextLine();
                    fila.inserir(nome, true);
                    break;
                case 2:
                    fila.chamarPrioritario();
                    break;
                case 3:
                    if(fila.Tam()>0){
                        fila.mostrarTodos();
                    }else{
                        System.out.println("Nao ha pessoas a serem atendidios.");
                    }
                    
                    break;
                case 4:
                    System.out.println("Total de atendimentos: " + fila.totalAtendidos());
                    if(fila.totalAtendidos() > 0){
                        System.out.println(fila.normalAtendidos()+"% dos atendimentos foram sem prioridades");
                        System.out.println(fila.prioAtendidos()+"% dos atendimentos foram com prioridades");
                    }
                    
                    break;
                case 5:
                    if(fila.totalAtendidos() == fila.Tam()){
                        flag = true;
                        System.out.println("Atendimentos conluidos");
                    }else{
                       System.out.println("O atendimento nao foi conluido");
                    }
                    break;
                default:
                    System.out.println("Informe uma opcao:");
                    opcao = teclado.nextInt();
                    break;
            }
            if(flag){
                break;
            }
        }
        teclado.close();
    }
}
