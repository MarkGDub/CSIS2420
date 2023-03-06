package ceQuick;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Compares quicksort to selection sort in time logs
 * @author Mark GW
 *
 */
public class SortComparison {
	
	/**
	 * returns array of random numbers with specificied amount of digits
	 * @param arraySize
	 * @param numberOfDigits
	 * @return randomNumber array
	 */
	private static Integer[] getRandomNumberArray(int arraySize, int numberOfDigits) {
		if(numberOfDigits < 1 || numberOfDigits > 10) {
			throw new IllegalArgumentException("The number of digits needs to be a value between 1 and 10.");
		}
		
		Integer[] randomNumbers = new Integer[arraySize];
		
		int start = (int)Math.pow(10, numberOfDigits - 1);
		int end = (int)Math.pow(10, numberOfDigits);
		
		for(int i = 0; i < randomNumbers.length; i++) {
			randomNumbers[i] = StdRandom.uniformInt(start, end);
		}
		return randomNumbers;
	}
	
	// ------- Test Client -------
	public static void main(String[] args) {
		int BILLION = 1_000_000_000;
		System.out.printf("--------------------------------------%n");
		System.out.printf("| %8s | %10s | %10s |%n", "n", "Selection", "Quick");
		System.out.printf("--------------------------------------%n");
		
		int n = 1_000;
		for(int i = 0; i < 10; i++) {
			Integer[] randomNumbers = getRandomNumberArray(n, 7);
			Integer[] randomNumbersCopy = randomNumbers.clone();
			
			long selectionStart = System.nanoTime();
			Selection.sort(randomNumbers);
			double selectionElapsedTime = System.nanoTime() - selectionStart;
			
			long quickStart = System.nanoTime();
			Quick.sort(randomNumbersCopy);
			double quickElapsedTime = System.nanoTime() - quickStart;
			
			System.out.printf("| %8d | %8.4f s | %8.4f s |%n", n, selectionElapsedTime / BILLION,  quickElapsedTime / BILLION);
			
			n*=2;
		}
		System.out.printf("--------------------------------------%n");
	}
}
