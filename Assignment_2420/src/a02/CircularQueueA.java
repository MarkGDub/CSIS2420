package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * CircularQueueA is a circular queue using an array of type Item.
 * 
 * @author CSIS2420 ... John R and Mark GW
 *
 * @param <Item>
 */
public class CircularQueueA<Item> implements Iterable<Item> {
	private int size = 0;
	private int front = -1;
	private int rear = -1;
	private int capacity;
	private Item[] q;
	
	/**
	 * creates queue with capacity
	 * @param capacity
	 */
	CircularQueueA(int capacity) {
		if(capacity < 1) {
			throw new IllegalArgumentException("Cannot set the size of the queue to " + capacity);
		}
		this.capacity = capacity;
		this.q = (Item[]) new Object[capacity];
	}
	
	/** 
	 * Determines whether the queue is full or not.
	 * @return true if the queue is full.
	 */
	public boolean isFull() {
		if (size == capacity) {
			return true;
		}
		return false;
	}
	
	/** 
	 * Determines whether the queue is empty or not.
	 * @return true if there are no items in the queue.
	 */
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the number of items in the queue
	 * @return the number of items
	 */
	public int size() {
		return size;
	}
	
	/** 
	 * Adds an Item at the end of the queue.
	 * @param item
	 */
	public void enqueue(Item item){
		if(isFull()) {
			throw new UnsupportedOperationException("Queue is full");
		}
		else {
			if (front == - 1) {
				front = 0;
			}
			rear = (rear + 1) % capacity;
			q[rear] = item;
			size++;
		}
	}
	
	/**
	 * Removes item from the front of the queue
	 * @return item
	 */
	public Item dequeue(){
		if(isEmpty()){
			throw new NoSuchElementException("Queue is empty");
		} 
		else {
			Item item = q[front];
			
			q[front] = null;

			if(front == rear){
				front = -1;
				rear = -1;
			}
			else {
				front = (front + 1) % capacity;
			} 
			
			size--;
			return item;
		}
	}
	
	/**
	 * Shows the next item that will come out of the queue
	 * @return the next item out of queue
	 */
	public Item peek(){
		if(isEmpty()) {
			throw new NoSuchElementException("Queue is empty");
		}
		return q[front];
	}
	
	@Override
	public Iterator<Item> iterator(){
		return new ArrayQueueIterator();
	}
	
	/**
	 * CircularQueueAIterator is an iterator used by the Iterable interface of type Item
	 * @return iterator
	 */
	private class ArrayQueueIterator implements Iterator<Item>{
		private int current = front;
		private int count = 0;
		
		@Override
		public boolean hasNext(){
			return current != -1 && count != capacity  && q[current] != null;
		}

		@Override
		public Item next(){
			Item item = q[current];
      
			current = (current + 1) % capacity;
			count++;
      
			return item;
		}
	}
	
	@Override
	public String toString() {
		if(isEmpty()) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		
		int current = front;
		int count = 0;
		
		while(q[current] != null && count != capacity) {
			sb.append(q[current]).append(" ");
			current = (current + 1) % capacity;
			count++;
		}
		
		return sb.toString();
	}

	/* * * * * * * * Test Client * * * * * * */
	public static void main(String[] args){
		CircularQueueA<String> queue1 = new CircularQueueA<String>(3);
		
		System.out.print("Queue: ");
		
		queue1.enqueue("meow");
		queue1.enqueue("meow");
		queue1.enqueue("meow");
		queue1.dequeue();
		
		for(String item: queue1) {
			
			System.out.print(item + " ");
		}
		
		System.out.println();
		System.out.print("Second Loop: ");
		
		for(String item: queue1) {
			
			System.out.print(item + " ");
		}
	}
}
