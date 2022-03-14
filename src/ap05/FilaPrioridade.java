public class FilaPrioridade {
    private Node inicio = null;
    private Node fim = null;
    private double total_atindidos=0, prio_atendidos=0, normal_atendidos=0;
    private int senhaP = 0, senhaN = 0;
    private int tam=0;

    // Adiciona uma pessoa no final da lista
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

    // Retorna o próximo atendimento prioritário da lista
    public void chamarPrioritario(){
        Node aux = inicio;
        boolean flag = false;
        if(aux != null){
            do{
                if((aux.getPrioridade()) && (!aux.getExcluido())){
                    aux.setExcluido(true);
                    prio_atendidos++;
                    System.out.println("Paciente: " + aux.getNome() + " | Senha: P" + aux.getSenha()*(-1));
                    flag = true;
                    break;
                }
                aux = aux.getProx();
            }while(aux != null);
            // Se chegar aqui, não tem prioridades, então é chamada um atendimento normal
            if(!flag){
                chamarNormal();
            }
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
            // Se chegar aqui, não tem atendimento normal, então é chamada um atendimento prioritário
            if(!flag){
                System.out.println("Todos os pacientes foram atendidos");
            }
        }
          
    }
    
    public void mostrarTodos(){
        Node aux = inicio;
        while(aux != null){
            if(!aux.getExcluido()){
                if(aux.getSenha() < 0){
                    System.out.println("Paciente: " + aux.getNome() + " | Senha: P" + aux.getSenha()*(-1));
                }else{
                    System.out.println("Paciente: " + aux.getNome() + " | Senha: N" + aux.getSenha());
                }
            }
            aux = aux.getProx();
        }
    }

    public double totalAtendidos(){
        total_atindidos = prio_atendidos + normal_atendidos;
        return total_atindidos;
    }
    
    public double prioAtendidos(){
        double porcentagem = (prio_atendidos/total_atindidos)*100;
        return porcentagem ;
    }

    public double normalAtendidos(){
        double porcentagem = (normal_atendidos/total_atindidos) * 100;
        return porcentagem;
    }

    public int Tam(){
            return tam;
    }
}
