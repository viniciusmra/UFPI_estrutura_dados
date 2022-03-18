package ap05;
public class Node {
    private String nome;
	private Node prox;
    private int senha;
    private boolean prioridade;
    private boolean excluido;
    private int ordem;
		
    public Node(String nome, boolean prioridade) {
        this.nome = nome;
        this.prox = null;
        this.prioridade = prioridade;
        this.excluido = false;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Node getProx(){
        return prox;
    }

    public void setProx(Node prox){
        this.prox = prox;
    }

    public boolean getPrioridade(){
        return prioridade;
    }
    
    public boolean getExcluido(){
        return excluido;
    }

    public void setExcluido(boolean excluido){
        this.excluido = excluido;
    }

    public int getSenha(){
        return senha;
    }

    public void setSenha(int senha){
        this.senha= senha;
    }

    public void setOrdem(int ordem){
        this.ordem = ordem;
    }
    
    public int getOrdem(){
        return ordem;
    }
}
