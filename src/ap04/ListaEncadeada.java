package ap04;

public class ListaEncadeada {
    private Node inicio = null;
    
    public void addNomeInicio(String nome){
		Node novo = new Node(nome);

        if (verificar(nome)==false) {
            if(inicio==null){
                inicio = novo;
            }else{
                novo.setProx(inicio);
                inicio=novo;
            }
		} else { 
            System.out.println("Nome ja existente.");
		}
    }
    public void addNomeFinal(String nome){
		Node novo = new Node(nome); 
        if (verificar(nome) == false) {
            Node aux=inicio;
            while(true){ // para quando o prox elemento do nó for null
                if(aux.getProx() == null){
                    break;
                }
                 aux = aux.getProx(); // aux é o ultimo elemento
            }
            aux.setProx(novo); // o ultimo elemento vai apontar para o novo elemento
		} else { 
            System.out.println("Nome ja existente.");
		}
    }
    
    public void recuperarNome(String nome){
        Node aux = pesquisar(nome);
        if(aux != null){
            aux.setExcluido(false);
        }
    }
    
    public void removerNome(String nome){
        Node aux = pesquisar(nome); 
        if(aux !=null){
            aux.setExcluido(true);
            System.out.println("Nome marcado como excluido!");
        }
    }
    
    public boolean verificar(String nome){
        Node aux = inicio;
        while(aux != null){
            if(nome.equals(aux.getNome())){
                return true;
            }
            aux = aux.getProx();
        }
        return false;
    }
    
    public Node pesquisar(String nome){
        Node aux = inicio;
        while(aux != null){
            if(nome.equals(aux.getNome())){
                    return aux;
            }
            aux = aux.getProx();
        }
        return null;
    }

    public void mostrarTodos(){
        Node aux = inicio;
        while(aux != null){
            if(aux.getExcluido() == false){
                System.out.println(aux.getNome());
            }
            aux = aux.getProx();
        }
    }

}


