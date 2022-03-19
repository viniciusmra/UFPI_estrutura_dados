package ap05;
public class Node {
    private String nome; // nome do paciente
	private Node prox;
    private int senha; // senha de atendimento
    private boolean prioridade; // verifica se é um atendimento prioritario ou nao
    private boolean excluido; // verificar se um paciente foi atendido ou nao
    private int ordem; // utilizado para ordenar o historico de pacientes
		
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
