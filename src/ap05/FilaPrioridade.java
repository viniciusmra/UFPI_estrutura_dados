public class FilaPrioridade {
    private Node inicio = null;
    private Node fim = null;
    private int total_atendidos = 0, prio_atendidos = 0, normal_atendidos = 0;
    private int senhaP = 0, senhaN = 0;
    private int tam = 0;

    // Adiciona uma pessoa no final da lista e atribui um senha
    // as senhas contendo números negativos são para atendimentos prioritários
    // as senhas contendo números positivos são para atendimentos normais
    public void inserir(String nome, boolean prioridade){
        Node novo = new Node(nome, prioridade);
        if(prioridade){
            senhaP--;
            novo.setSenha(senhaP);
        }else{
            senhaN++;
            novo.setSenha(senhaN);
        }

        if(inicio == null && fim == null){
            inicio = novo;
            fim = novo;
        }else{
            fim.setProx(novo);
            fim = novo;
        }
        tam++;
    }

    // Retorna o próximo atendimento prioritário da lista,
    // caso não existam atendimentos prioritários, é chamado
    // o método chamarNormal
    public void chamarPrioritario(){
        Node aux = inicio;
        boolean flag = false;
        if(aux != null){ // checa se o primeiro objeto é diferente de null, ou seja se a lista não está vazia
            do{
                if((aux.getPrioridade()) && (!aux.getExcluido())){ // Checa se o nome foi cadastrado como atendimento prioritário e se ele não está marcado como excluido
                    aux.setExcluido(true); // Marca o nome como excluído, informando que ele ja foi atendido
                    prio_atendidos++; // Incrementa a variável que registra os atendimentos prioritários
                    System.out.println("Paciente: " + aux.getNome() + " | Senha: P" + aux.getSenha()*(-1));
                    flag = true;
                    break; // Caso existe alguma paciente de atendimento prioritário, encerra o laço
                }
                aux = aux.getProx();
            }while(aux != null); // Se o próximo objeto não está vazio, continua o laço
            
        }
        // Se chegar aqui, não tem prioridades, então é chamada um atendimento normal
        if(!flag){
            chamarNormal();
        }
   
    }

    // Retorna o próximo atendimento normal da lista
    public void chamarNormal(){
        Node aux = inicio;
        boolean flag = false;
        if(aux != null){
            do{
                if((!aux.getPrioridade()) && (!aux.getExcluido())){
                    aux.setExcluido(true);
                    normal_atendidos++;
                    System.out.println("Paciente: " + aux.getNome() + " | Senha: N" + aux.getSenha());
                    flag = true;
                    break;
                }
                aux = aux.getProx();
            }while(aux != null);

        }
        // Se chegar aqui, não tem mais atendimentos, então é exibida uma mensagem 
        if(!flag){
            System.out.println("A fila esta vazia");
        }
    }
    
    // Mostra todos os pacientes na fila que não tenha sido atendido ainda
    public void mostrarTodos(){
        Node aux = inicio;
        boolean flag = false;
        while(aux != null){
            if(!aux.getExcluido()){
                flag = true;
                if(aux.getSenha() < 0){
                    System.out.println("Paciente: " + aux.getNome() + " | Senha: P" + aux.getSenha()*(-1));
                }else{
                    System.out.println("Paciente: " + aux.getNome() + " | Senha: N" + aux.getSenha());
                }
            }
            aux = aux.getProx();
        }
        if(!flag){
            System.out.println("Nao ha pacientes na fila");
        }
    }

    // Retorna o total de pacientes atendidos
    public int totalAtendidos(){
        total_atendidos = prio_atendidos + normal_atendidos;
        return total_atendidos;
    }
    
    // Retorna o porcentagem de atendimentos prioritários
    public double prioAtendidos(){
        double porcentagem = (prio_atendidos/total_atendidos)*100;
        return porcentagem ;
    }

    // Retorna a porcentagem de atendimentos normais
    public double normalAtendidos(){
        double porcentagem = (normal_atendidos/total_atendidos) * 100;
        return porcentagem;
    }

    // Retorna o tamanho da fila
    public int getTam(){
        return tam;
    }
}
