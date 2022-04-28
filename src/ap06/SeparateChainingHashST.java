/******************************************************************************
 *  Compilation:  javac SeparateChainingHashST.java
 *  Execution:    java SeparateChainingHashST < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/34hash/tinyST.txt
 *
 *  A symbol table implemented with a separate-chaining hash table.
 * 
 ******************************************************************************/

package ap06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SeparateChainingHashST<Key, Value> {
	//private static final int INIT_CAPACITY = 128;

	private static int n; // number of key-value pairs
	private static int m; // hash table size
	private static int r;
	private int h = 0;
	private SequentialSearchST<Key, Value>[] st; // array of linked-list symbol tables

	/**
	 * Initializes an empty symbol table.
	 */
	public SeparateChainingHashST() {
		this(m, r);
	}

	/**
	 * Initializes an empty symbol table with {@code m} chains.
	 * 
	 * @param m the initial number of chains
	 */
	@SuppressWarnings("unchecked")
	public SeparateChainingHashST(int m, int r) {
		this.m = m;
		this.r = r;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
		for (int i = 0; i < m; i++)
			st[i] = new SequentialSearchST<Key, Value>();
	}

	// resize the hash table to have the given number of chains,
	// rehashing all of the keys

	// hash function for keys - returns value between 0 and m-1
//	private int hashTextbook(Key key) {
//		return (key.hashCode() & 0x7fffffff) % m;
//	}

	// hash function for keys - returns value between 0 and m-1 (assumes m is a
	// power of 2)
	// (from Java 7 implementation, protects against poor quality hashCode()
	// implementations)

	public int hash(Key key) {
		int h = 0;
		for (int i = 0; i < ((String) key).length(); i++) {
			h = (r * h + (((String) key).charAt(i))) % m;
		}
		return h;
	}

//	private int hash(Key key) {
//		int h = 0;
//		for (int i = 0; i < ((String) key).length(); i++) {
//			h = (r * (((String) key).charAt(i)) - '@') % m;
//		}
//		return h;
//	}

	/**
	 * Returns the number of key-value pairs in this symbol table.
	 *
	 * @return the number of key-value pairs in this symbol table
	 */
	public int size() {
		return n;
	}

	/**
	 * Returns true if this symbol table is empty.
	 *
	 * @return {@code true} if this symbol table is empty; {@code false} otherwise
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Returns true if this symbol table contains the specified key.
	 *
	 * @param key the key
	 * @return {@code true} if this symbol table contains {@code key}; {@code false}
	 *         otherwise
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public boolean contains(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to contains() is null");
		return get(key) != null;
	}

	/**
	 * Returns the value associated with the specified key in this symbol table.
	 *
	 * @param key the key
	 * @return the value associated with {@code key} in the symbol table;
	 *         {@code null} if no such value
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public Value get(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to get() is null");
		int i = hash(key);
		return st[i].get(key);
	}

	/**
	 * Inserts the specified key-value pair into the symbol table, overwriting the
	 * old value with the new value if the symbol table already contains the
	 * specified key. Deletes the specified key (and its associated value) from this
	 * symbol table if the specified value is {@code null}.
	 *
	 * @param key the key
	 * @param val the value
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public void put(Key key, Value val) {
		if (key == null)
			throw new IllegalArgumentException("first argument to put() is null");
		if (val == null) {
			delete(key);
			return;
		}

		// double table size if average length of list >= 10
		// if (n >= 10*m) resize(2*m);

		int i = hash(key);
		if (!st[i].contains(key))
			n++;
		st[i].put(key, val);
	}

	/**
	 * Removes the specified key and its associated value from this symbol table (if
	 * the key is in this symbol table).
	 *
	 * @param key the key
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public void delete(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to delete() is null");

		int i = hash(key);
		if (st[i].contains(key))
			n--;
		st[i].delete(key);

		// halve table size if average length of list <= 2
		// if (m > INIT_CAPACITY && n <= 2*m) resize(m/2);
	}

	// return keys in symbol table as an Iterable
	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<Key>();
		for (int i = 0; i < m; i++) {
			for (Key key : st[i].keys())
				queue.enqueue(key);
		}
		return queue;
	}

	public static String[] readWords(String filename) { // abrir o arquivo tales.tx
		ArrayList<String> wordList = new ArrayList<String>(); // Cria um arraylist para guardar os dados
		int nWords = 0;
		try {
			File file = new File(filename);
			Scanner rows = new Scanner(file);

			while (rows.hasNext()) { // Continua lendo enquanto ainda estiver linhas para serem lidas
				String word = rows.next();
				wordList.add(word); // Adiciona a linha lida ao ArrayList
				nWords++;
			}
			System.out.println("Número de palavras " + nWords);
			rows.close();
		} catch (FileNotFoundException e) {
			System.out.println("Erro ao efetuar a leitura");
			e.printStackTrace();
		}

		return wordList.toArray(new String[0]);
	}

	/**
	 * Unit tests the {@code SeparateChainingHashST} data type.
	 *
	 * @param args the command-line arguments
	 */
	public static void main(String[] args) {
//		SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();
//		String[] vet = readWords("taleUnico.txt");
//		
//		ArrayList<Integer> hashVet = new ArrayList<Integer>();
//
//		for (int i = 0; i < vet.length; i++) {
//			String key = vet[i];
//			st.put(key, i);
//		}
//		// print keys
//		for (String s : st.keys()) {
//			//StdOut.println(s + " " + st.get(s) + " " + st.hash(s));
//			hashVet.add(st.hash(s));
//		}
//		
//        int[] histogramVet = histogram(hashVet,INIT_CAPACITY);
//		
//		//System.out.println(hashVet.size());
//		
////		for (int i = 0; i < hashVet.size(); i++) {
////			System.out.println(hashVet.get(i));
////		}
//        
//		for (int i = 0; i < histogramVet.length; i++) {
//			System.out.println(i+ " ; " + histogramVet[i] + " ; " + hashVet.size()/m);
//		}
		
	}
}
