package ceQuick;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdRandom;

public class SortComparison {
	
	private static Integer[] getRandomNumberArray(int arraySize, int numberOfDigits) {
		if(numberOfDigits < 1 || numberOfDigits > 10) {
			throw new IllegalArgumentException("The number of digits needs to be a value between 1 and 10.");
		}
		
		Integer[] randomNumbers = new Integer[arraySize];
		
		for(int i = 0; i < randomNumbers.length; i++) {
			randomNumbers[i] = StdRandom.uniformInt(10^(numberOfDigits - 1), (10^numberOfDigits) - 1);
		}
		
		return randomNumbers;
	}
	
	public static void main(String[] args) {
		Selection.sort(args);
		Quick.sort(args);
	}
}
