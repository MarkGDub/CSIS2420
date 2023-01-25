package a01;

import java.util.Arrays;

/**
 * Coding challenges for assignment A01 part1.
 * 
 * @author CSIS Starter Code + Mark GW
 *
 */
public class A01Part1 {
	
	/**
	 * Returns a new array that includes every other number starting with the first.
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
			
			boolean arrayContainsNonDigit = Character.isDigit(digits[0]) != true || Character.isDigit(digits[1]) != true || Character.isDigit(digits[2]) != true;
			
			if(arrayContainsNonDigit) {
				throw new IllegalArgumentException("Array input contains non-digit");
		}
			
			return digits;
		}

		
		int amountOfSeparators;
		if(digits.length % 3 == 0) {
			amountOfSeparators = digits.length / 3 - 1;
		} else {
			amountOfSeparators = digits.length / 3; 
		}
		
		char[] commaSeparatedDigits = new char[digits.length + amountOfSeparators];
		
		int count = 0;
		int index = commaSeparatedDigits.length - 1;
		for(int i = digits.length - 1; i >= 0; i--) {
			if(Character.isDigit(digits[i])  != true) {
				throw new IllegalArgumentException("Array input contains non-digit at index: " + i + ", value: " + digits[i]);
			}
			
			if(count != 3) {
				commaSeparatedDigits[index] = digits[i];
				
				count++;
				index--;
			} else {
				commaSeparatedDigits[index] = ',';
				index--;
				
				commaSeparatedDigits[index] = digits[i];
				index--;
				
				count = 1;
			}
		}
		
		return commaSeparatedDigits;
	}
	
	
	/**
	 * Determines whether the order of the elements in the array from front to back
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
		char[] chars = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
		Character[] palindrome = {'r', 'a', 'c', 'e', 'c', 'a', 'r'};
		Number[] nonPalindrome = {10, 10, 10, 1};
		
		int [] everyOtherNumber = everyOther(numbers);
		char[] charWithSeparators = addSeparators(chars);
		
//		System.out.println(Arrays.toString(everyOtherNumber));
//		System.out.println(Arrays.toString(charWithSeparators));
//		System.out.println(Arrays.toString(palindrome) + " is palindrome? " + isPalindrome(palindrome));
//		System.out.print(Arrays.toString(nonPalindrome) + " is palindrome? " + isPalindrome(nonPalindrome));
	}
} 