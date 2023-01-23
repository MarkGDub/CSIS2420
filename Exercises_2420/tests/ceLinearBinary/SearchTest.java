package ceLinearBinary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SearchTest {
	private final int[] array = {5, 2, 7, 9, 1, 3, 4, 6 ,0 ,8 };
	
	private final int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ,11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
	
	private final int[] emptyArray = {};
	
	private final String[] words = {"cat", "dog", "mat", "bat", "bee"};
	
	private final Rectangle[] rectangles = {new Rectangle(5,3),new Rectangle(2,3), new Rectangle(7,3), new Rectangle(2,6), new Rectangle(1,1), new Rectangle(4,8), new Rectangle(3,9)};

	// ORIGINAL LINEAR TESTS --------------------------------	
	
	@Test
	void linear_searchNumberAtMiddleIndex() {
		
		int expected = 6;		
		int actual = Search.linear(array, 4); // call method that is tested
		
		// always include assert method
		assertEquals(expected, actual); // expected first, actual second
		
		// no printing inside a jUnit test
	}
	
	@Test
	void linear_searchNumberAtFirstIndex() {
		assertEquals(0, Search.linear(array, 5)); 
	}
	
	@Test
	void linear_searchNumberAtEndIndex() {
		assertEquals(9, Search.linear(array, 8)); 
	}
	
	@Test
	void linear_searchNumberNotInArray() {
		assertEquals(-1, Search.linear(array, 10)); 
	}
	
	@Test
	void linear_searchEmptyArray() {
		assertEquals(-1, Search.linear(emptyArray, 10)); 
	}
	
	@Test
	void linear_searchNullArray() {
		assertThrows(NullPointerException.class, () -> {
			Search.linear(null, 2);
		});
	}
	
	// GENERIC LINEAR TESTS --------------------------------	
	
	@Test
	void linearT_elementInMiddle() {
		assertEquals(2, Search.linear(words, "mat"));
	}
	
	@Test
	void linearT_elementInBeginning() {
		assertEquals(0, Search.linear(rectangles, new Rectangle(5,3)));
	}
	
	@Test
	void linearT_elementInEnd() {
		assertEquals(6, Search.linear(rectangles, new Rectangle(3,9)));
	}
	
	@Test
	void linearT_elementNotInArray() {
		assertEquals(-1, Search.linear(rectangles, new Rectangle(13,9)));
	}
	
	@Test
	void linearT_emptyArray() {
		Rectangle[] a = {};
		assertEquals(-1, Search.linear(a, new Rectangle(5,3)));
	}
	
	@Test
	void linearT_nullArray() {
		assertThrows(NullPointerException.class, () -> {
			Search.linear(null, "hello");
		});
	}
	
	// BINARY TESTS--------------------------------	

	@Test
	void binary_getMiddleNumber() {
		assertEquals(9, Search.binary(sortedArray, 10));
	}
	
	@Test
	void binary_getEndNumber() {
		assertEquals(19, Search.binary(sortedArray, 20));
	}

	@Test
	void binary_getStartNumber() {
		assertEquals(0, Search.binary(sortedArray, 1));
	}
	
	@Test
	void binary_numberNotInArray() {
		assertEquals(-1, Search.binary(sortedArray, 0));
	}
	
	@Test
	void binary_emptyArray() {
		assertEquals(-1, Search.binary(emptyArray, 10));
	}
	
	@Test
	void binary_arrayIsNull() {
		assertThrows(NullPointerException.class, () -> {
			Search.binary(null, 2);
		});
	}

}