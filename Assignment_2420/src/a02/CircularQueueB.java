package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * generic circular queue using a linked structure
 * 
 * @author CSIS2420 + John R and Mark GW
 *
 * @param <Item>
 */
public class CircularQueueB<Item> implements Iterable<Item> {
	private Node head;
	private Node tail;
	private int size;
	private int capacity;
	
	/**
	 * creates queue with capacity
	 * 
	 * @param capacity
	 */
	CircularQueueB(int capacity) {
		if(capacity < 1) {
			throw new IllegalArgumentException("Cannot set the size of the queue to " + capacity);
		}
		this.capacity = capacity;
	}
	
	/**
	 * Node of LinkedList that stores the item and a
	 * single reference to the next node.
	 */
	private class Node {
		private Item item;
		private Node next;
	}
	
	/** 
	 * Determines whether the queue is full or not.
	 * 
	 * @return true if the queue is full.
	 */
	public boolean isFull() {
		return size == capacity;
	}
	
	/** 
	 * Determines whether the queue is empty or not.
	 * 
	 * @return true if there are no items in the queue.
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Returns the number of items in the queue
	 * 
	 * @return the number of items
	 */
	public int size() {
		return size;
	}
	
	/** 
	 * Adds a node containing the new item at the end of the queue.
	 * 
	 * @param item
	 */
	public void enqueue(Item item){
		if(isFull()) {
			throw new UnsupportedOperationException("Queue is full");
		}
		
		Node newNode = new Node();
		newNode.item = item;
		
		if (isEmpty()) {
			head = newNode;
		}
		else {
			tail.next = newNode;
		}
		
		newNode.next = head;
		tail = newNode;
		
		size++;
	}
	
	/**
	 * Removes the node item from the front of the queue
	 * 
	 * @return item
	 */
	public Item dequeue(){
		if(isEmpty()){
			throw new NoSuchElementException("Queue is empty");
		} 
		
		Item item = head.item;
		
		if(size == 1) {
			head = null;
			tail = null;
		} else {
			tail.next = head.next;
			head = head.next;
		}
		
		
		--size;
		return item;
	}
	
	/**
	 * Shows the next item that will come out of the queue
	 * 
	 * @return the next item out of queue
	 */
	public Item peek(){
		if(isEmpty()) {
			throw new NoSuchElementException("Queue is empty");
		}
		
		return head.item;
	}
	
	/**
	 * initiates an iterator for the CircularQueueB class
	 * 
	 * @return iterator
	 */
	@Override
	public Iterator<Item> iterator() {
		return new CircularQueueBIterator();
	}
	
	/**
	 * Represents an iterator
	 */
	private class CircularQueueBIterator implements Iterator<Item> {
		private Node current = head;
		private int count;

		/**
		 * Check if there is a next node
		 *
		 * @return true if there is a next node or false if there is not
		 */
		@Override
		public boolean hasNext() {
			if(count != size) {
				return true;
			}
			
			return false;
		}

		/**
		 * gets item of current node, and moves the iterator to the next node
		 * 
		 * @return item of node
		 */
		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			
			++count;
			
			return item;
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
		
		for(int i = 0; i < size; i++) {
			sb.append(current.item).append(" ");
			current = current.next;
		}
		
		return sb.toString();
	}


	/* * * * * * * * Test Client * * * * * * */
	public static void main(String[] args){
	}
}
