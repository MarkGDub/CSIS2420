package a02;

import java.util.NoSuchElementException;

/**
 * Linked List that stores the elements in sorted order based on the 
 * implementation  of Comparable<Item>.
 * The elements are internally stored in a doubly-linked list, and 
 * null elements are not allowed.
 * 
 * @author CSIS Starter Code + Mark GW and John R
 *  
 * @param <Item> type of elements stored in the sorted list
 */
public class SortedList<Item extends Comparable<Item>> {
	private Node head;
	private Node tail;
	private int size;
	
	/**
	 * Represents a node in a double linked list.
	 */ 
	private class Node {
		private Item item;
		private Node next;
		private Node prev;
	}
	
	/**
	 * Determines whether the list is empty.
	 * 
	 * @return true if there are no elements in the list and false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Determines how many elements are in the list.
	 * 
	 * @return number of elements in the list
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Adds <code>item</code> to the list while maintaining the list's sorted order.
	 * 
	 * @param item element to add to the sorted list
	 * @throws NullPointerException if the specified element is null
	 */
	public void insert(Item item) {
		if(item == null){
    	throw new NullPointerException();
    	}
		
		Node newNode = new Node();
		newNode.item = item;
		
		if(isEmpty()) {
			head = newNode;
			tail = newNode;
			
			size++;
			return;
		}
		
		Node currentNode = head;
		while(currentNode != null) {
			boolean isGreaterThan = newNode.item.compareTo(currentNode.item) > 0;
			
			if(!isGreaterThan) break;	
			
			currentNode = currentNode.next;
		}
			
		
		if(currentNode == null) {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;	
		}
		else if(head == currentNode) {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		} else {
			Node previousNode = currentNode.prev;
			previousNode.next = newNode;
			newNode.prev = previousNode;
			newNode.next = currentNode;
			currentNode.prev = newNode;
		}
		size++;
	}
	
	/**
	 * Deletes the element on the specified <code>index</code> 
	 * and returns the value of the deleted element.
	 * 
	 * @param index position of the element that needs to be deleted
	 * @return the deleted item
	 * @throws NoSuchElementException if the method is called on an empty list
	 * @throws IndexOutOfBoundsException if the specified index is not in the 
	range [0, n)
	 */
	public Item delete(int index) {
		if(isEmpty()) {
			throw new NoSuchElementException();
		} else if(index > size - 1 || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		Node currentNode = head;
		int currentIndex = 0;
		while(currentIndex != index) {
			currentNode = currentNode.next;
			currentIndex++;
		}
		
		if(size == 1) {
			head = null;
			tail = null;
		}
		else if(head == currentNode) {
			head = currentNode.next;
			currentNode.next.prev = null;
		}
		else if(tail == currentNode) {
			tail = currentNode.prev;
			currentNode.prev.next = null;
		} 
		else {
			currentNode.prev.next = currentNode.next;
			currentNode.next.prev = currentNode.prev;
		}
		
		size--;
		return currentNode.item;
	}
	
	/**
	 * Updates the element on the specified <code>index</code> by replacing it with <code>item</code>
	 * and moves the updated node as needed to restore the sorted order of the list.
	 *
	 * @param index position of the element that needs to be updated
	 * @param item new value of the updated element
	 * @throws IndexOutOfBoundsException if the specified index is not in the 
	range [0, n)
	 * @throws NoSuchElementException if this list is empty
	 * @throws NullPointerException if this list is not empty and the item passed
	to the method is null
	 */
	public void update(int index, Item item) {
		if(isEmpty()) {
			throw new NoSuchElementException();
		} 
		else if(index > size - 1 || index < 0) {
			throw new IndexOutOfBoundsException();
		} 
		else if(item == null) {
			throw new NullPointerException();
		}
		
		Node currentNode = head;
		
		for(int i = 0; i <= size; i++) {
			if (index == i) {
				currentNode.item = item;
				delete(i);
				insert(item);
				break;
			}
			
			currentNode = currentNode.next;
		}

	}
	
	/**
	 * Builds a string that includes all the list elements in order. 
	 * Each element is followed by a single space.
	 * If this list is empty, and empty string is returned.
	 * 
	 * @return a string representation of the sorted list
	 */
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
	
	// = = = Optional Test Client = = =
	public static void main(String[] args) {
	}
}