package a04mystery;

import java.util.Arrays;

import csis.Mystery;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Represents a sorting detective that uses a nested Friend class to be able to visualize the compares made
 * and can time the sorting method to help prove the assumed sort
 * 
 * @author Mark GW + Chris K + John R
 *
 */
public class A04 {
	private static int amountOfComparisons = 0;
	
	/*
	 * Represents a friend defined by the name
	 */
	private static class Friend implements Comparable<Friend>{
		private String name;
		
		private Friend(String name) {
			this.name = name;
		}


		@Override
		public String toString() {
			return name;
		}

		/**
		 * Natural order compare by name.<p>
		 * {@inheritDoc}
		 */
		@Override
		public int compareTo(Friend other) {
			System.out.println("Comparing " + this.name + " to " + other.name);
			amountOfComparisons++;
			return this.name.compareTo(other.name);
		}
	}
	
	/**
	 * Creates an Integer array of the specified size filled with random seven digit number
	 * @param size
	 * @return
	 */
	private static Integer[] getIntegerArray(int size) {
		Integer[] integers = new Integer[size];
		
		for(int i = 0; i < integers.length; i++) {
			integers[i] = StdRandom.uniformInt(1000000, 9000000);
		}
		
		return integers;
	}
	
	/**
	 * Creates a partially ordered Integer Array of the specified size
	 * @param size of the array
	 * @param divider number to modulo by to create out of order element
	 * @return
	 */
	private static Integer[] getPartiallyOrderedArray(int size, int divider) {
		Integer[] partiallyOrderedNumbers = new Integer[size];
	
		for(int i = 0; i < size; i++) {
			if(i % divider == 0) {
				partiallyOrderedNumbers[i] = 5;
			} else {				
				partiallyOrderedNumbers[i] = i;
			}
		}
	
		return partiallyOrderedNumbers;
	}
	
	
	
	// ----------- Test Client -----------
	public static void main(String[] args) {
		// ------ visualizing the compares -------
		Friend[] friends = {
				new Friend("Ann"),
				new Friend("Don"),
				new Friend("Ben"), 
				new Friend("Dee"), 
				new Friend("Abe"),
				new Friend("Ron"),
				new Friend("Dan"),
				new Friend("Bob"),
				new Friend("Tim"),
				new Friend("Rob"),
				new Friend("Joe"),
				new Friend("Jim"),
				};
		
		System.out.println("Original: " + Arrays.toString(friends));
		
//		need to uncomment the sort you would like to run and move the grouped print lines to the respective sort
//		make sure all other Mystery sorts are commented out otherwise the result will not be accurate
//		Sort 1 = Merge 
//		Mystery.sort1(friends);
		
//		Sort 2 = Selection
//		Mystery.sort2(friends);
		
//		Sort 3 = Quick
//		Mystery.sort3(friends);

//		Sort 4 = Insertion
		Mystery.sort4(friends);
		System.out.println("Sorted: " + Arrays.toString(friends));
		System.out.println("Comparisons made = " + amountOfComparisons);	
		System.out.println();
		
		// --------- timing the sorts ---------
		System.out.println("----------- Sort Time -----------");
		int BILLION = 1_000_000_000;
		int n = 10_000;
		
		for(int i = 0; i < 10; i++) {
			Integer[] randomNumbers = getIntegerArray(n);
			Integer[] partiallySortedNumbers = getPartiallyOrderedArray(n, n / 15);
			
//			only run one sort at a time otherwise the time logs will be inaccurate
			long start = System.nanoTime();
//			Mystery.sort1(randomNumbers);
//			Mystery.sort2(randomNumbers);
//			Mystery.sort3(randomNumbers);
//			Mystery.sort4(randomNumbers);
			Mystery.sort4(partiallySortedNumbers);
			double elapsedTime = System.nanoTime() - start;
			
			StdOut.printf("Time to sort " + n + " elements = %.4f s %n", elapsedTime / BILLION);
			
			n*=2;
		}
	}
}
