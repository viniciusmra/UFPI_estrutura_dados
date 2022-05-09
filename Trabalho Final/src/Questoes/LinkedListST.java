package Questoes;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListST<Key, Value> {
	LinkedList<Key> keys ;
	LinkedList<Value> values ;  // symbol table values
    private int n = 0;      // number of elements in symbol table


	public LinkedListST(){
		 this.keys = new LinkedList<Key>(); // symbol table keys
		 this.values = new LinkedList<Value>();  // symbol table values
	}
    public void put(Key key, Value value) {
        // to deal with duplicates
        delete(key, value);
		// add new key and value at the end of array
		keys.add(key);
		values.add(value); // PERIGO : CRIADO POR ELLEM
        n++;
    }
	private void delete(Key key, Value val){
		int index = keys.indexOf(key);
		if( index > -1){
			keys.remove(index);
			values.remove(index);
		}
	}

	public void get(){
		Iterator<Key> i = keys.iterator();
		Iterator<Value> j = values.iterator();
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
			System.out.println(j.next() + " ");
		}
	}
    
	public Value getValue(Key key) {
		if(keys.indexOf(key) > -1){
			return values.get(keys.indexOf(key));
		}
        return null;
    }
	
	public void getAllKeys(){
		for(int i = 0; i < values.size(); i++){
			System.out.println(values.get(i));
		}
	}

}
