package ceLinked;

import java.util.Iterator;

/**
 * WordList is a singly-linked list of Strings.
 * It is designed as a practice opportunity to
 * learn how to manipulate linked structures.
 * 
 * @author CSIS2420 + Mark GW
 */
public class WordList implements Iterable<String> {
	private Node head; // first node of the list or null
	private Node tail; // last node of the list or null
	private int n;     // number of words in the list

	/**
	 * Node of LinkedList that stores the item and a
	 * single reference to the next node.
	 */
	private class Node {
		private String item;
		private Node next;
	}
	
	/** 
	 * Adds a node containing the new item at the
	 * end of the list.
	 * 
	 * @param newItem
	 */
	public void append(String newItem) {
		Node newNode = new Node();
		newNode.item = newItem;
		
		if (isEmpty()) {
			head = newNode;
		}
		else {
			tail.next = newNode;
		}
		
		tail = newNode;
		
		n++;
	}
	
	/** 
	 * Adds a node containing the new item at the
	 * front of the list.
	 * 
	 * @param newItem
	 */
	public void prepend(String newItem) {		
		
		Node newNode = new Node();
		newNode.item = newItem;
		
		if(isEmpty()) {
			tail = newNode;
		} 
		else {
			newNode.next = head;
		}
		
		head = newNode;
		
		n++;
	}
	
	/** 
	 * Returns the index of the first occurrence of the specified item.
	 * If the specified item in not part of the list
	 * the method indexOf returns -1
	 * 
	 * @param item
	 * @return index of the first occurrence of the item; -1 if the word was not found.
	 */
	public int indexOf(String item) {
		Node current = head;
		for(int i = 0; current != null; i++) {
			if(item == current.item) {
				return i;
			}
			
			current = current.next;
		}
		
		return -1;
	}
	
	/** 
	 * Checks whether the list contains the given item.
	 * 
	 * @param item
	 * @return true if the item is contained in the list; false otherwise.
	 */
	public boolean contains(String item) {	
		Node current = head;
		for(int i = 0; current != null; i++) {
			if(item == current.item) {
				return true;
			}
			
			current = current.next;
		}
		
		return false;
	}
	
	/**
	 * Returns the number of elements in the list
	 * @return the number of elements
	 */
	public int size() {
		return n;
	}
	
	/** 
	 * Determines whether the list is empty or not.
	 * @return true if there are no elements in the list.
	 */
	public boolean isEmpty() {
		return n == 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node current = head;
		
		while(current != null) {
			sb.append(current.item).append(" ");
			current = current.next;
		}
		
		return sb.toString();
	}
	
	@Override
	public Iterator<String> iterator() {
		return new WordListIterator();
	}
	
	private class WordListIterator implements Iterator<String> {
		private Node current = head;

		@Override
		public boolean hasNext() {
			if(current != null) {
				return true;
			}
			return false;
		}

		@Override
		public String next() {
			String item = current.item;
			current = current.next;
			
			return item;
		}
		
	}
	
	/* * * * * * * * Test Client * * * * * * */
	public static void main(String[] args) {
		WordList list = new WordList();
		System.out.println("size: " + list.size());
			
		System.out.println("The list " + (list.isEmpty() ? "is" : "is not") + " empty");	
		
		list.append("ant");
		list.append("bat");
		list.append("cow");
		list.append("dog");
		
		list.prepend("gorilla");
		list.prepend("dolphin");
		
		System.out.println("The list " + (list.isEmpty() ? "is" : "is not") + " empty");
		
		System.out.println(list.contains("dog"));
		
		System.out.println("list: " + list.toString());
		
		System.out.println();

		for(String item: list) {
			System.out.print(item + " ");
		}
		
		System.out.println();
		
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}
}
