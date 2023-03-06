package ceMail;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.StdOut;

public class DemoHeap {
	public static void main(String[] args) {
		Mail[] allMail = new Mail[25];
	
		for(int i = 0; i < allMail.length; i++) {
			Mail mail = new Mail();		
			System.out.println(mail);		
			allMail[i] = mail;
		}
		StdOut.println();
		
		StdOut.println("Ordered Mail:");
		StdOut.println("--------------");
		
		MaxPQ<Mail> pq = new MaxPQ<>(allMail);
		while(!pq.isEmpty()) {
			StdOut.println(pq.delMax());
		}
	}
}
