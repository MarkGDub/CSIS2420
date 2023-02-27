package ceStable;

import java.util.Arrays;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Selection;

public class DemoStable {
	public static void main(String[] args) {
		Friend[] friends = {
				new Friend("Ann", 8),
				new Friend("Don", 6),
				new Friend("Ben", 7), 
				new Friend("Dee", 8), 
				new Friend("Abe", 9),
				new Friend("Ron", 6),
				new Friend("Dan", 8),
				new Friend("Bob", 6),
				new Friend("Tim", 7),
				new Friend("Rob", 6),
				new Friend("Joe", 7),
				new Friend("Jim", 9),
				};
		
		System.out.println("Original Friends: " + Arrays.toString(friends));
		
		// Stable Sorting
		System.out.println("- - - Stable Sorting - - -");
		
		Selection.sort(friends); // stability is not important
		
		System.out.println("Friends sorted by name: " + Arrays.toString(friends));
		
		Insertion.sort(friends, Friend.BY_AGE); // stability is important
		
		System.out.println("Friends sorted by age: " + Arrays.toString(friends));
		
		// Unstable Sorting
		System.out.println("- - - Unstable Sorting - - -");
		
		
		Insertion.sort(friends); // here stability is irrelevant for the demo
		
		System.out.println("Friends sorted by name: " + Arrays.toString(friends));
		
		Selection.sort(friends, Friend.BY_AGE); // having an algorithm that is not stable is important
		
		System.out.println("Friends sorted by age: " + Arrays.toString(friends));
	}
}
