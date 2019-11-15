import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestArrayImplementations {

	@Test
	public void test_one_array_implementation_insert() {
		OneArrayDictionary d = new OneArrayDictionary();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");  

			assertEquals(new WordDefinitionPair("w1", "d1"), d.dict[0]);
			assertEquals(new WordDefinitionPair("w2", "d2"), d.dict[1]);
			assertEquals(new WordDefinitionPair("w3", "d3"), d.dict[2]);
			assertEquals(new WordDefinitionPair("w4", "d4"), d.dict[3]);
			assertEquals(new WordDefinitionPair("w5", "d5"), d.dict[4]);

			// maximum capacity of the dictionary is 100
			// all remaining slots in the array should be null.
			for (int i = 5; i < d.MAX_CAPACITY; i ++) {
				assertNull(d.dict[i]);
			}
		} catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
	}

	@Test
	public void test_one_array_implementation_remove() {
		OneArrayDictionary d = new OneArrayDictionary();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5"); 

			d.removeWord("w2");

			assertEquals(new WordDefinitionPair("w1", "d1"), d.dict[0]);
			assertEquals(new WordDefinitionPair("w3", "d3"), d.dict[1]);
			assertEquals(new WordDefinitionPair("w4", "d4"), d.dict[2]);
			assertEquals(new WordDefinitionPair("w5", "d5"), d.dict[3]);

			// maximum capacity of the dictionary is 100
			// all remaining slots in the array should be null.
			for (int i = 4; i < d.MAX_CAPACITY; i ++) {
				assertNull(d.dict[i]);
			}

			d.removeWord("w4");
			assertEquals(new WordDefinitionPair("w1", "d1"), d.dict[0]);
			assertEquals(new WordDefinitionPair("w3", "d3"), d.dict[1]);
			assertEquals(new WordDefinitionPair("w5", "d5"), d.dict[2]);
			// maximum capacity of the dictionary is 100
			// all remaining slots in the array should be null.
			for (int i = 3; i < d.MAX_CAPACITY; i ++) {
				assertNull(d.dict[i]);
			} 
		} catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		} catch (WordNotInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		}
	}

	@Test
	public void test_two_array_implementation_insert() {
		TwoArrayDictionary d = new TwoArrayDictionary();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");  

			assertEquals("w1", d.words[0]);
			assertEquals("w2", d.words[1]);
			assertEquals("w3", d.words[2]);
			assertEquals("w4", d.words[3]);
			assertEquals("w5", d.words[4]);

			assertEquals("d1", d.definitions[0]);
			assertEquals("d2", d.definitions[1]);
			assertEquals("d3", d.definitions[2]);
			assertEquals("d4", d.definitions[3]);
			assertEquals("d5", d.definitions[4]);

			// maximum capacity of the dictionary is 100
			// all remaining slots in the array should be null.
			for (int i = 5; i < d.MAX_CAPACITY; i ++) {
				assertNull(d.words[i]);
				assertNull(d.definitions[i]);
			}
		} catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void test_two_array_implementation_remove() {
		TwoArrayDictionary d = new TwoArrayDictionary();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5"); 

			d.removeWord("w2");

			assertEquals("w1", d.words[0]);
			assertEquals("w3", d.words[1]);
			assertEquals("w4", d.words[2]);
			assertEquals("w5", d.words[3]);
			
			assertEquals("d1", d.definitions[0]);
			assertEquals("d3", d.definitions[1]);
			assertEquals("d4", d.definitions[2]);
			assertEquals("d5", d.definitions[3]);

			// maximum capacity of the dictionary is 100
			// all remaining slots in the array should be null.
			for (int i = 4; i < d.MAX_CAPACITY; i ++) {
				assertNull(d.words[i]);
				assertNull(d.definitions[i]);
			}

			d.removeWord("w4");
			
			assertEquals("w1", d.words[0]);
			assertEquals("w3", d.words[1]); 
			assertEquals("w5", d.words[2]);
			
			assertEquals("d1", d.definitions[0]);
			assertEquals("d3", d.definitions[1]); 
			assertEquals("d5", d.definitions[2]);
			
			// maximum capacity of the dictionary is 100
			// all remaining slots in the array should be null.
			for (int i = 3; i < d.MAX_CAPACITY; i ++) {
				assertNull(d.words[i]);
				assertNull(d.definitions[i]);
			} 
		} catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		} catch (WordNotInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		}
	}

	private void unexpectedExceptionOccurred(Exception e) {
		String msg = e.getClass().getName() + " not expected";
		fail(msg);
	}
}
