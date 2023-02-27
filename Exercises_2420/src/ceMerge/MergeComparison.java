package ceMerge;

import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MergeComparison {
	public static void main(String[] args) {
		int BILLION = 1_000_000_000;
		
		
		System.out.println("Merge Sort: ");
		System.out.println("-----------");
		int n = 10_000;
		for(int i = 0; i < 10; i++) {
			Integer[] a = getIntegerArray(n);
			
			long start = System.nanoTime();
			Merge.sort(a);
			double elapsedTime = System.nanoTime() - start;
			
			StdOut.printf("Time to sort " + n + " elements = %.4f s %n", elapsedTime / BILLION);
			
			n*=2;
		}
		System.out.println();
		
		System.out.println("MergeSlow Sort: ");
		System.out.println("-----------");
		n = 10_000;
		for(int i = 0; i < 10; i++) {
			Integer[] a = getIntegerArray(n);
			
			long start = System.nanoTime();
			MergeSlow.sort(a);
			double elapsedTime = System.nanoTime() - start;
			
			StdOut.printf("Time to sort " + n + " elements = %.4f s %n", elapsedTime / BILLION);
			
			n*=2;
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
}
