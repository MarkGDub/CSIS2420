package a01;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Coding challenges for assignment A01 part2.
 * 
 * @author CSIS Starter Code + ....... (add your name here)
 *
 */
public class A01Part2 {
		
	/**
	 * @param array
	 * @param sum 
	 * @return the minimum number of consecutive addends to calculate the 
	specified sum. 
	 * @throws IllegalArgumentException if the array includes one or more 
	negative numbers.
	 */
	public static int minNumberOfAddends(int[] array, int sum) {
		if(array == null || array.length == 0) return 0;
		
		int iterator = 1;
		int index = 0;
		while(iterator <= array.length) {
			
			if(iterator == 1 && array[index] < 0) 
				throw new IllegalArgumentException("Negative int at index:" + index);
			
			if(iterator == 1) {
				if(array[index] == sum) return iterator;
				
			} else {
				
				int[] sequence = Arrays.copyOfRange(array, index, index + iterator);
				
				
				int sequenceSum = IntStream.of(sequence).sum();
				
				
				if(sequenceSum == sum) return iterator;
			}
			
			if(index + iterator == array.length) {
				index = 0;
				iterator++;
				
			} else {
				index++;
			
			}
		}
		
		return 0;
	}
	
	/**
	 * @param array2d
	 * @return 
	 * @throws IllegalArgumentException if the array is empty.
	 * @throws NullPointerException if the argument is null.
	 */
	public static void doubleValues(int[][] array2d) {
		if(array2d == null) {
			throw new NullPointerException("Null argument passed");
		}
		
		if(array2d.length == 0) {
			throw new IllegalArgumentException("Empty 2d array");
		}
		
		for(int i = 0; i < array2d.length; i ++) {
			
			for(int j = 0; j < array2d[i].length; j++) {
				
				array2d[i][j] = 2 * array2d[i][j];
			}
		}
		
	}
	
	/**
	 * @param matrix
	 * @throws IllegalArgumentException if the rows vary in length.
	 */
	public static boolean goldenTicket(char[][] matrix) {
		if(matrix == null || matrix.length == 0) {
			return false;
		}
		
		int expectedRectangleRowLength = matrix[0].length;
		for(int i = 1; i < matrix.length; i++) {
			if(matrix[i].length != expectedRectangleRowLength) 
				throw new IllegalArgumentException("The matrix is not rectangular");
		}
		
		String goldenTicket = "GGGGGG";
		for(int i = 0; i < matrix.length; i++) {
			if(matrix.length - i < 3) {
				return false;
			}
			
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i].length - j >= 2) {
					String currentRow = "" + matrix[i][j] + matrix[i][j + 1];
					
					if(currentRow.equals("GG")) {
						String oneRowBelow = "" + matrix[i + 1][j] + matrix[i + 1][j + 1];
						String twoRowsBelow = "" + matrix[i + 2][j] + matrix[i + 2][j + 1];
						String ticket = currentRow + oneRowBelow + twoRowsBelow;
						
						if(goldenTicket.equals(ticket)) {
							return true;
						}
					}
					
				} else {
					continue;
				}
					
			}
		}
		
		return false; 
	}
	
	public static void main(String[] args) {
//		int[][] array2d = {{1,2,3,4},{4,5,6},{7,8,9,0},{1,2,3,4,5,6,7,8,9}};
//		int[][] empty2dArray = {};
//		char[][] ticket = {
//				{'C','A','G','C','B','V','T'},
//				{'C','G','A','C','B','V','T'},
//				{'C','G','G','C','B','V','T'},
//				{'C','A','G','C','B','V','T'},
//				{'C','G','G','G','G','V','T'},
//				{'C','G','G','G','G','V','T'},
//				{'C','G','A','G','G','V','T'},
//				{'C','A','D','C','B','V','T'}
//				};
		
		int[] addends = {};
		
//		doubleValues(array2d);
		
		
		System.out.println("Smallest sequence of addends needed = " + minNumberOfAddends(addends, 5));
//		System.out.print("Contains golden ticket = " + goldenTicket(ticket));
	}
} 

