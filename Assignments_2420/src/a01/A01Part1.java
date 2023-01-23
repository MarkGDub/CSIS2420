package a01;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Coding challenges for assignment A01 part1.
 * 
 * @author CSIS Starter Code + Mark GW
 *
 */
public class A01Part1 {
	
	/**
	 * Returns a new array that includes every other number starting with the 
	first.
	 * E.g., [10, 20, 30, 40, 50, 60] returns [10, 30, 50]
	 * E.g., [10] returns [10]
	 * <p>
	 * Boundary cases:
	 * If the array is empty, an empty array should be returned. 
	 * If the user passes null as an argument, the method should return null.
	 * 
	 * @param numbers original array of whole numbers
	 * @return array that includes every other number starting with the first
	 */
	public static int[] everyOther(int[] numbers) {
		if(numbers == null) {
			return null;
		}
		
		if(numbers.length == 1) {
			return numbers;
		}
		int[] everyOtherNumber = new int[(int)Math.ceil((numbers.length + .00) / 2)];
		
		
		int index = 0;
		for(int i = 0; i < numbers.length ; i++) {
		  if(i % 2 == 0) {
			  everyOtherNumber[index] = numbers[i];
			  index++;
		  }
		}
	  
		return everyOtherNumber;
	}
	
	/**
	 * Returns a new array that includes commas as thousands separators.
	 * E.g., ['7', '6', '5', '4', '3', '2', '1'] returns ['7', ',', 6, 5, 4, ',',
	3, 2, 1] 
	 * E.g., ['5', '3', '6'] returns ['5', '3', '6']
	 * <p>
	 * Boundary cases:
	 * If the array is empty, an empty array should be returned. 
	 * If the user passes null as an argument, the method should return null.
	 * 
	 * @param digits original array of digits
	 * @return new array that includes commas as thousands separators.
	 * @throws IllegalArgumentException if the array <code>digits</code> includes
	 * any characters that are not digits.
	 */
	public static char[] addSeparators (char[] digits) {
		if(digits == null) {
			return null;
		}
		
		
		if (digits.length < 4) {
			for(int i = 0; i < digits.length; i++) {
				if(Character.isDigit(digits[i]) == false) {
					throw new IllegalArgumentException("Input contain non-digits at index:" + i);
				}
			}
			
			return digits;
		}
		
		
		
		DecimalFormat df = new DecimalFormat("#.00");
		double beginningThousandsthPlace = (digits.length +.00) / 3;
		String angleFormated = df.format(beginningThousandsthPlace);
		
		int start = 1;

		int amountOfCommaSeparated = ((digits.length) / 3) -1;
		int size = digits.length + amountOfCommaSeparated;
		if(digits.length == 4) {
			size++;
		}
		
		if(angleFormated.contains(".00")) {
			start = 2;
		} else if(angleFormated.contains(".33")) {
			start = 0;
		} else {
			start = 1;
		}
		
		
		char[] commaSeparated = new char[size];
		
		int index = 0;
		int thousandsthPlace = 1;
		
		for(int i = 0; i < digits.length ; i++) {
			if(Character.isDigit(digits[i]) == false) {
				throw new IllegalArgumentException("Input contain non-digit at index:" + i);
			}
			
			if(i == start || thousandsthPlace == 3) {
				
				
				commaSeparated[index] = digits[i];
				
				
				index++;
				if(index < commaSeparated.length) {
					commaSeparated[index] = ',';
					index++;	
				}
				thousandsthPlace = 1;
			} else {
				
				
				commaSeparated[index] = digits[i];
				index++;
				if(i > start) {					
					thousandsthPlace++;
				}
			}
			
		}
		
		return commaSeparated;
	}
	
	/**
	 * Determines whether the order of the elements in the array from front to 
	back
	 * is the same as the order of the elements from back to front.
	 * E.g., ['r', 'a', 'c', 'e', 'c', 'a', 'r'] returns true
	 * E.g., ['D', 'a', 'd'] returns false (case matters)
	 * E.g., [10, 20] returns false
	 * E.g., ["hello"] returns true (a single element is a palindrome)
	 * 
	 * @param array
	 * @return true if the array is a palindrome and false otherwise
	 * @throws IllegalArgumentException if the array includes no elements or
	 * if the argument passed to the method is null.
	 */
	public static <T> boolean isPalindrome(T[] array) {
		if(array == null) {
			throw new IllegalArgumentException("Null Input");
		}
		
		if(array.length == 0) {
			throw new IllegalArgumentException("Empty Array");
		}
		
		if(array.length == 1) {
			return true;
		}
		
		int reverseIndex = array.length - 1; 
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] != array[reverseIndex]) {
				return false;
			}
			
			reverseIndex--;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,5,6,7,8,9};
		char[] chars = {'1', '2', '3', '4'}; // 1,234,567,890
		Character[] test = {'r', 'a', 'c', 'e', 'c', 'a', 'r'};
		Number[] test2 = {10, 10, 10, 1};
		
		int [] everyOtherNumber = everyOther(numbers);
		char[] charWithSeparators = addSeparators(chars);
		
		System.out.println(Arrays.toString(everyOtherNumber));
		System.out.println(Arrays.toString(charWithSeparators));
		System.out.println(Arrays.toString(test) + " is palindrome? " + isPalindrome(test));
		System.out.print(Arrays.toString(test2) + " is palindrome? " + isPalindrome(test2));
	}
} 