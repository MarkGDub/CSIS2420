package ceLinked;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WordListTest {

	@Test
	void testAppend() {
		WordList list = new WordList();
		
		list.append("dog");
		list.append("cat");
		
		assertEquals("dog cat ", list.toString());
	}

	@Test
	void testPrepend() {
		WordList list = new WordList();
		
		list.prepend("dog");
		list.prepend("cat");
		
		assertEquals("cat dog ", list.toString());
	}

	@Test
	void testIndexOf_fist() {
		WordList list = new WordList();
		
		list.append("dog");
		list.append("cat");
		list.append("monkey");
		list.append("lion");
		list.append("dolphin");
		list.append("giraffe");
		list.append("alligator");
		
		
		assertEquals(0, list.indexOf("dog"));
	}
	

	@Test
	void testIndexOf_last() {
		WordList list = new WordList();
		
		list.append("dog");
		list.append("cat");
		list.append("monkey");
		list.append("lion");
		list.append("dolphin");
		list.append("giraffe");
		list.append("alligator");
		
		
		assertEquals(6, list.indexOf("alligator"));
	}
	

	@Test
	void testIndexOf_notThere() {
		WordList list = new WordList();
		
		list.append("dog");
		list.append("cat");
		list.append("monkey");
		list.append("lion");
		list.append("dolphin");
		list.append("giraffe");
		list.append("alligator");
		
		
		assertEquals(-1, list.indexOf("eel"));
	}

	@Test
	void testContains() {
		WordList list = new WordList();
		
		list.append("dog");
		list.append("cat");
		list.append("monkey");
		list.append("lion");
		list.append("dolphin");
		list.append("giraffe");
		list.append("alligator");
		
		
		assertEquals(true, list.contains("dog"));
	}

	@Test
	void testSize() {
		WordList list = new WordList();
		
		list.append("dog");
		list.append("cat");
		
		
		assertEquals(2, list.size());
	}

	@Test
	void testIsEmpty() {
		WordList list = new WordList();
		
		assertEquals(true, list.isEmpty());
	}

	@Test
	void testToString() {
		WordList list = new WordList();
		
		list.append("dog");
		list.append("cat");
		
		
		assertEquals("dog cat ", list.toString());
	}

}
