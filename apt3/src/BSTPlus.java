/*  Classe herda todos os métodos da classe BST e implementa alguns métodos extras.
    
    TODO
        Implentar uma verificação para caso a chave passada no parametro key do método getDepth
            não seja encontrada e o método retorne -1.
        Tentar trazer a modificação do Node da BST para BSTPlus
        Implementar as funções da questão 4
        Implementar a interface

*/

public class BSTPlus<Key extends Comparable<Key>, Value> extends BST<Key, Value>{
    public BSTPlus(){ //construtor
        super();
    }

    // Versão modificada da put incluindo o parametro "anterior"

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("calls put() with a null key");
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val, null);
        assert check();
    }

    private Node put(Node x, Key key, Value val, Node anterior) {
        if (x == null) return new Node(key, val, 1, anterior); //+1
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val, x);
        else if (cmp > 0) x.right = put(x.right, key, val, x);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right); //aqui
        
        return x;
    }


    // Métodod que retorna a profundidade de um elemento com determianda chave key
    public int getDepth(Key key){
        Node actualNode = root;
        int depth = 0;
        while(true){
            // caso actualNode esteja vazio, retorna -1
            if(actualNode == null){ 
                return -1;
            }
        
            // caso a key do actualNode seja igual a que está sendo buscada, retorna a depth
            if(key.compareTo(actualNode.key) == 0){ 
                return depth;
                
            // caso a key que esta sendo buscada seja maior que a do actualNode, a variável depth é incrementada e 
            // o actualNode agora é actualNode.right, ou seja, o nó que esta a direita
            } else if(key.compareTo(actualNode.key) > 0){
                depth++;
                actualNode = actualNode.right;
            
            // caso a key que esta sendo buscada seja menor que a do actualNode, a variável depth é incrementada e 
            // o actualNode agora é actualNode.left, ou seja, o nó que esta a left 
            } else if(key.compareTo(actualNode.key) < 0){
                depth++;
                actualNode = actualNode.left;
            }
        }
    }

    public int internalPathLength(){
        int length = 0;
        for (Key s : keys()){
            length += getDepth(s);
        }
        return length;
    }
    
    public Node getNode(Key key) {
        Queue<Key> keys = new Queue<Key>();
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            Node x = queue.dequeue();
            if (x == null) continue;
            if(x.key.compareTo(key) == 0){
                return x;
            }
            keys.enqueue(x.key);
            queue.enqueue(x.left);
            queue.enqueue(x.right);
            
        }
        return null;
    }

    public void printAnterior(Key key){
        try {
            System.out.println(getNode(key).anterior.key);
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }



}