import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//  Classe herda todos os metodos da classe BST e implementa alguns metodos extras.
 
public class BSTPlus<Key extends Comparable<Key>, Value> extends BST<Key, Value>{
    public BSTPlus(){ //construtor
        super();
    }
      public static String[] readWords(String filename) { // abrir o arquivo tales.tx
        ArrayList<String> wordList = new ArrayList<String>(); // Cria um arraylist para guardar os dados
        try {
            File file = new File(filename);
            Scanner rows = new Scanner(file);
    
            while (rows.hasNext()) { // Continua lendo enquanto ainda estiver linhas para serem lidas
                String word = rows.next();
                wordList.add(word); // Adiciona a linha lida ao ArrayList
            }
            rows.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao efetuar a leitura");
            e.printStackTrace();
        }
    
        return wordList.toArray(new String[0]);
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


    public int getValue(Key key) throws Exception {
        boolean flag = false;
        for (Key s : keys()) {
			if(s.compareTo(key) == 0){
                flag = true;
            }
		}

        if(flag){
            for (Key s : keys()) {
                if(s.compareTo(key) == 0){
                    return (int)getNode(key).val;
                }
            }
        } else{
            throw new Exception("Node nao existe");
        }
        return 0;
    }
    // Métodod que retorna a profundidade de um elemento com determianda chave key
    public int getDepth(Key key){
       if(!verification(key)){
           return -1;
       }else{
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