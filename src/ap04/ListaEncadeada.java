package ap04;

public class ListaEncadeada {
    private Node inicio = null;
    
    // Método para adicionar nome ao início
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

    // Método para adicionar nome ao final
    public void addNomeFinal(String nome){
		Node novo = new Node(nome); 
        if (verificar(nome) == false) { // Verifica se o nome ja existe
            if(inicio != null){ // Verifica se a lista ja tem algum elemento
                Node aux = inicio;
                // While que percorre todos os elementos na lista até que aux seja o último
                while(aux.getProx() != null){ 
                    aux = aux.getProx();
                }
                aux.setProx(novo); // o ultimo elemento vai apontar para o novo elemento
            } else{ // Se a lista não tem nenhum elemento, o elemento novo é adiciona ao início
                inicio = novo;
            }
		} else { 
            System.out.println("Nome ja existente.");
		}
    }
    
    // Método que marca elemento excluído como "não-excluído"
    public void recuperarNome(String nome){
        Node aux = pesquisar(nome);
        if(aux != null){
            aux.setExcluido(false);
        }
    }
    
    // Método para marcar elemento como excluído
    public void removerNome(String nome){
        Node aux = pesquisar(nome); 
        if(aux !=null){
            aux.setExcluido(true);
            System.out.println("Nome marcado como excluido!");
        }
    }
    
    // Método que verifica que o nome ja está na lista
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
    
    // Método que pesquisa e retorna um nome
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

    // Método que mostra todos os nomes
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


