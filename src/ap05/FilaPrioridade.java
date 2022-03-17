public class FilaPrioridade {
    private Node inicio = null;
    private Node fim = null;
    private int total_atendidos = 0, prio_atendidos = 0, normal_atendidos = 0;
    private int senhaP = 0, senhaN = 0;
    private int tam = 0;
    private int ordem = 0;

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
    public String chamarPrioritario(){
        Node aux = inicio;
        if(aux != null){ // checa se o primeiro objeto é diferente de null, ou seja se a lista não está vazia
            do{
                if((aux.getPrioridade()) && (!aux.getExcluido())){ // Checa se o nome foi cadastrado como atendimento prioritário e se ele não está marcado como excluido
                    aux.setExcluido(true); // Marca o nome como excluído, informando que ele ja foi atendido
                    prio_atendidos++; // Incrementa a variável que registra os atendimentos prioritários
                    aux.setOrdem(ordem++);
                    return "Paciente: " + aux.getNome() + " | Senha: P" + aux.getSenha()*(-1);
                }
                aux = aux.getProx();
            }while(aux != null); // Se o próximo objeto não está vazio, continua o laço
            
        }
        // Se chegar aqui, não tem prioridades, então é chamada um atendimento normal
        return chamarNormal();

   
    }

    // Retorna o próximo atendimento normal da lista, analogamente ao método anterior
    public String chamarNormal(){
        Node aux = inicio;
        if(aux != null){
            do{
                if((!aux.getPrioridade()) && (!aux.getExcluido())){
                    aux.setExcluido(true);
                    normal_atendidos++;
                    aux.setOrdem(ordem++);
                    return "Paciente: " + aux.getNome() + " | Senha: N" + aux.getSenha();
                }
                aux = aux.getProx();
            }while(aux != null);

        }
        // Se chegar aqui, não tem mais atendimentos, então é retornado null
        return null;

    }
    
    // Método que retorna um vetor de strings contendo todos os pacientes
    public String[] mostrarTodos(){
        Node aux = inicio;
        int contador = 0;
        String[] pacientes = new String[tam - total_atendidos]; // Cria um array de string com tamanho igual aos pacientes que ainda não foram atendidos
        while(aux != null){
            if(!aux.getExcluido()){ // Verifica se o paciente ainda não foi atendido
                if(aux.getSenha() < 0){ // Verifica se o paciente é prioritário ou não (senhas negativas são prioritárias)
                    pacientes[contador++] = "Paciente: " + aux.getNome() + " | Senha: P" + aux.getSenha()*(-1); // atendimento prioritário
                }else{
                    pacientes[contador++] = "Paciente: " + aux.getNome() + " | Senha: N" + aux.getSenha(); // atendimento prioritário
                }
            }
            aux = aux.getProx();
        }
        return pacientes; // retorna o array
    }
    
    // Metodo que retorna um vetor de strings com o historico de todos os pacientes atendidos
    public String[] mostrarHistorico(){
        int contador = 0; 
        String[] pacientes = new String[total_atendidos]; // Cria uma string com o tamanho igual aos pacientes que foram atendidos 
        for(int i = 0; i < total_atendidos; i++){ 
            Node aux = inicio;
            while(aux != null){
                if(aux.getExcluido() && aux.getOrdem() == i){ // Verifica se o paciente ja foi atendido (excluido) e se a ordem do paciente equivale ao procurado
                    if(aux.getSenha() < 0){ // Verifica se o paciente é prioritário ou não (senhas negativas são prioritárias)
                        pacientes[contador++] = (i+1) + " - Paciente: " + aux.getNome() + " | Senha: P" + aux.getSenha()*(-1);
                        break;
                    }else{
                        pacientes[contador++] = (i+1) + " - Paciente: " + aux.getNome() + " | Senha: N" + aux.getSenha();
                        break;
                    }
                }
                aux = aux.getProx();
            }
        }
        return pacientes; // retorna o array
    }

    // Retorna o total de pacientes atendidos
    public int getTotalAtendidos(){
        total_atendidos = prio_atendidos + normal_atendidos;
        return total_atendidos;
    }
    
    // Retorna o porcentagem de atendimentos prioritários
    public double getPorcentPrioridade(){
        double porcentagem = (prio_atendidos/(double)total_atendidos)*100;
        return porcentagem ;
    }

    // Retorna a porcentagem de atendimentos normais
    public double getPorcentNormal(){
        double porcentagem = (normal_atendidos/(double)total_atendidos) * 100;
        return porcentagem;
    }

    // Retorna o tamanho da fila
    public int getTam(){
        return tam;
    }
}
