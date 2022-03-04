package ap04;

public class Node {
    private String nome;
	private Node prox;
    private boolean excluido;
		
		public Node(String nome) {
			this.nome = nome;
			this.prox = null;
		}

        public String getNome(){
            return nome;
        }
        public void setNome(String nome){
            this.nome=nome;
        }
         public Node getProx(){
            return prox;
        }
        public void setProx(Node prox){
            this.prox=prox;
        }
        public boolean getExcluido(){
            return excluido;
        }
        public void setExcluido(boolean b){
            excluido = b;
        }
        
}
