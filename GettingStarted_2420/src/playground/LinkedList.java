package playground;

public class LinkedList<T> {
	private Node head;
	private Node tail;
	private int size;
	
	private class Node {
		private T item;
		private Node next;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void append(T newItem) {
		Node newNode = new Node();
		newNode.item = newItem;
		
		if(isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		
		tail = newNode;
		
		++size;
	}
	
	public void prepend(T newItem) {
		Node newNode = new Node();
		newNode.item = newItem;
		
		if(isEmpty()) {
			tail = newNode;
		} else {
			newNode.next = head;
		}
		
		head = newNode;
		
		++size;
	}
	
	public T getItem(T item){
		if(isEmpty()) {
			return null;
		}
		
		Node previousNode = null;
		Node currentNode = head;
		
		while(currentNode != null) {
			if(currentNode.item == item) {
				break;
			}
			
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
		
		if(currentNode == null) {
			return null;
		} else if (size == 1) {
			head = null;
			tail = null;
		} else if(head == currentNode) {
			head = currentNode.next;
		} else if(tail == currentNode) {
			previousNode.next = null;
			tail = previousNode;
		} else {
			previousNode.next = currentNode.next;
		}
		
		--size;
		
		return currentNode.item;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		Node current = head;
		
		while(current != null) {
			sb.append(current.item);
			sb.append(" ");
			
			current = current.next;
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		
		list.append("meow");
		list.prepend("bark");
		list.append("ribbit");
		list.prepend("squawk");
		
		String value = list.getItem("ribbit");
		
		System.out.println("List: " + list);
		System.out.print("Value: " + value);
	}

}
