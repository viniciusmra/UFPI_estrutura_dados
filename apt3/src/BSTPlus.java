import java.util.ArrayList;

/*  Classe herda todos os metodos da classe BST e implementa alguns metodos extras.
    
    TO-DO:
        -Implentar uma verificacao para caso a chave passada no parametro key do metodo getDepth
            nao seja encontrada e o metodo retorne -1;
        -Implementar a interface;
        -Colocar os arrays da travessias em um arquivo.


*/

public class BSTPlus<Key extends Comparable<Key>, Value> extends BST<Key, Value>{
    public BSTPlus(){ //construtor
        super();
    }
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
        if (x == null) return new Node(key, val, 1, anterior); 
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val, x);
        else if (cmp > 0) x.right = put(x.right, key, val, x);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right); //aqui
        
        return x;
    }

    public boolean verification(Key key)  {
        for (Key s : keys()) {
			if(s.compareTo(key)==0){
                return true;
            }
		}
        return false;
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

    // public void printAnterior(Key key){
    //     try {
    //         System.out.println(getNode(key).anterior.key);
    //     } catch (Exception e) {
    //         System.out.println("Errouu!");
    //     }
        
    // }
     public ArrayList<Key> preOrder(){ //Metodo para travessia em pre-ordem 
        ArrayList<Key> preOrderList = new ArrayList<Key>();
        preOrder(root, preOrderList);
        return preOrderList; 
    }
    public void preOrder(Node root,  ArrayList<Key> preOrder ){
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
        while(!queue.isEmpty()){
            Node x = queue.dequeue();
            if(x != null){
                preOrder.add(x.key);
                preOrder(x.left, preOrder);
                preOrder(x.right, preOrder);  
            }
        }
    }
    public ArrayList<Key> inOrder(){ //Metodo para travessia em em-ordem olá 
        ArrayList<Key> inOrderList = new ArrayList<Key>();
        inOrder(root, inOrderList);
        return inOrderList; 
     }
    public void inOrder(Node root, ArrayList<Key> inOrder){
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
       
        while(!queue.isEmpty()){
            Node x = queue.dequeue();
            if(x != null){
                inOrder(x.left, inOrder);
                inOrder.add(x.key);  
                inOrder(x.right, inOrder); 
            }
        }
    }
     public ArrayList<Key> posOrder(){ //Metodo para travessia em pos-ordem olá 
        ArrayList<Key> posOrderList = new ArrayList<Key>();
        posOrder(root, posOrderList);
        return posOrderList;
     }
    public void posOrder(Node root, ArrayList<Key> posOrder){
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
        while(!queue.isEmpty()){
            Node x = queue.dequeue();
            if(x != null){
                posOrder(x.left, posOrder);
                posOrder(x.right, posOrder);
                posOrder.add(x.key);    
            }
        }
    }
}