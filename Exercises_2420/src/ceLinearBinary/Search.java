package ceLinearBinary;

/**
 * The {@code Search} class provides static methods for searching a
 * number {@code n} in an array of whole numbers.
 * 
 * @author CSIS Starter Code + Mark
 *
 */
public class Search {
	/**
	* Searches the array {@code numbers} for the specified
	* {@code n} based on the linear search algorithm.
	*
	* @param numbers array of whole numbers
	* @param n the number that we are looking for
	* @return the index of the first occurrence of {@code n}
	* in the array or -1 if {@code n} was not found.
	*/
	public static int linear(int[] numbers, int n) {
		int index = -1;
				
	   for(int i = 0 ; i < numbers.length; i++) {
		   if(numbers[i] == n) {
			   index = i;
		   };
	   };
	   
	   return index;
	}
	
	/**
	* Searches the array {@code array} for the specified
	* {@code el} based on the linear search algorithm.
	*
	* @param array array of elements
	* @param el is the element that we are looking for
	* @return the index of the first occurrence of {@code el}
	* in the array or -1 if {@code el} was not found.
	*/
	public static <T> int linear(T[] array, T el) {
		int index = -1;
				
	   for(int i = 0 ; i < array.length; i++) {
		   if(array[i].equals(el)) {
			   index = i;
		   };
	   };
	   
	   return index;
	}
	
	/**
	* Searches the array {@code numbers} for the specified
	* {@code n} based on the binary search algorithm.
	* The array needs to be sorted.
	* 
	* @param numbers sorted array of whole numbers
	* @param n the number that we are looking for
	* @return the index of the first occurrence of {@code n}
	* in the array or -1 if {@code n} was not found.
	*/
	public static int binary(int[] numbers, int n) {
	   int start = 0;
	   int end = numbers.length - 1;
		
		while(start <= end) {
			int mid = start + (end - start) / 2;
			
			if(numbers[mid] == n) {
				return mid;
			} else if (n > numbers[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return -1; 
	}
}
