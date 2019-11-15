import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public abstract class TestDictionary {
	
	protected abstract Dictionary dict();
	
	@Test
	public void testEmptyDictionarySize() {
		Dictionary d = dict();
		assertEquals(0, d.size());
	}
	
	@Test
	public void testOneItemDictionarySize() {
		Dictionary d = dict();
		try {
			d.insertEntry("oxford", "the best university");
			assertEquals(1, d.size());
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testFiveItemDictionarySize() {
		Dictionary d = dict();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");
			assertEquals(5, d.size());
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testNineItemDictionarySize() {
		Dictionary d = dict();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");
			d.insertEntry("w6", "d6");
			d.insertEntry("w7", "d7");
			d.insertEntry("w8", "d8");
			d.insertEntry("w9", "d9");
			assertEquals(9, d.size());
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testDictionarySize() {
		Dictionary d = dict();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");
			d.insertEntry("w6", "d6");
			d.insertEntry("w7", "d7");
			d.insertEntry("w8", "d8");
			d.insertEntry("w9", "d9");
			d.insertEntry("w10", "d10");
			assertEquals(10, d.size());
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testEmptyDictionaryIsEmpty() {
		Dictionary d = dict();
		assertEquals(true, d.isEmpty());
	}
	
	@Test
	public void testOneItemDictionaryIsEmpty() {
		Dictionary d = dict();
		try {
			d.insertEntry("oxford", "the best university");
			assertEquals(false, d.isEmpty());
		} catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testFiveItemDictionaryIsEmpty() {
		Dictionary d = dict();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");
			assertEquals(false, d.isEmpty());
		} catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testNineItemDictionaryIsEmpty() {
		Dictionary d = dict();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");
			d.insertEntry("w6", "d6");
			d.insertEntry("w7", "d7");
			d.insertEntry("w8", "d8");
			d.insertEntry("w9", "d9");
			assertEquals(false, d.isEmpty());
		} catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testDictionaryIsEmpty() {
		Dictionary d = dict();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");
			d.insertEntry("w6", "d6");
			d.insertEntry("w7", "d7");
			d.insertEntry("w8", "d8");
			d.insertEntry("w9", "d9");
			d.insertEntry("w10", "d10");
			assertEquals(false, d.isEmpty());
		} catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testEmptyDictionaryGetDefinition() {
		Dictionary d = dict();
		try {
			String def = d.getDefinition("oxford");
			expectedExceptionDidNotOccur(WordNotInDictionaryException.class.getName());
		} 
		catch (WordNotInDictionaryException e) {
			// expected
		}
	}
	
	@Test
	public void testOneItemDictionaryGetDefinitionExistingWord() {
		Dictionary d = dict();
		try {
			d.insertEntry("oxford", "the best university");
			String def = d.getDefinition("oxford");
			assertEquals("the best university", def);
		} catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		} catch (WordNotInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testOneItemDictionaryGetDefinitionNonExistingWord() {
		Dictionary d = dict();
		try {
			d.insertEntry("oxford", "the best university");
			String def = d.getDefinition("cambridge");
			expectedExceptionDidNotOccur(WordNotInDictionaryException.class.getName());
		} catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		} catch (WordNotInDictionaryException e) {
			// expected
		}
	}
	
	@Test
	public void testFiveItemDictionaryGetDefinitionExistingWord() {
		Dictionary d = dict();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");
			assertEquals("d1", d.getDefinition("w1"));
			assertEquals("d2", d.getDefinition("w2"));
			assertEquals("d3", d.getDefinition("w3"));
			assertEquals("d4", d.getDefinition("w4"));
			assertEquals("d5", d.getDefinition("w5"));
		} catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		} catch (WordNotInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testFiveItemDictionaryGetDefinitionNonExistingWord() {
		Dictionary d = dict();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");
			String def = d.getDefinition("cambridge");
			expectedExceptionDidNotOccur(WordNotInDictionaryException.class.getName());
		} catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		} catch (WordNotInDictionaryException e) {
			// expected
		}
	}
	
	@Test
	public void testNineItemDictionaryGetDefinitionExistingWord() {
		Dictionary d = dict();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");
			d.insertEntry("w6", "d6");
			d.insertEntry("w7", "d7");
			d.insertEntry("w8", "d8");
			d.insertEntry("w9", "d9");
			assertEquals("d1", d.getDefinition("w1"));
			assertEquals("d2", d.getDefinition("w2"));
			assertEquals("d3", d.getDefinition("w3"));
			assertEquals("d4", d.getDefinition("w4"));
			assertEquals("d5", d.getDefinition("w5"));
			assertEquals("d6", d.getDefinition("w6"));
			assertEquals("d7", d.getDefinition("w7"));
			assertEquals("d8", d.getDefinition("w8"));
			assertEquals("d9", d.getDefinition("w9"));
		} catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		} catch (WordNotInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testNineItemDictionaryGetDefinitionNonExistingWord() {
		Dictionary d = dict();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");
			d.insertEntry("w6", "d6");
			d.insertEntry("w7", "d7");
			d.insertEntry("w8", "d8");
			d.insertEntry("w9", "d9");
			String def = d.getDefinition("cambridge");
			expectedExceptionDidNotOccur(WordNotInDictionaryException.class.getName());
		} catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		} catch (WordNotInDictionaryException e) {
			// expected
		}
	}
	
	@Test
	public void testDictionaryGetDefinitionExistingWord() {
		Dictionary d = dict();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");
			d.insertEntry("w6", "d6");
			d.insertEntry("w7", "d7");
			d.insertEntry("w8", "d8");
			d.insertEntry("w9", "d9");
			d.insertEntry("w10", "d10");
			assertEquals("d1", d.getDefinition("w1"));
			assertEquals("d2", d.getDefinition("w2"));
			assertEquals("d3", d.getDefinition("w3"));
			assertEquals("d4", d.getDefinition("w4"));
			assertEquals("d5", d.getDefinition("w5"));
			assertEquals("d6", d.getDefinition("w6"));
			assertEquals("d7", d.getDefinition("w7"));
			assertEquals("d8", d.getDefinition("w8"));
			assertEquals("d9", d.getDefinition("w9"));
			assertEquals("d10", d.getDefinition("w10"));
		} catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		} catch (WordNotInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testDictionaryGetDefinitionNonExistingWord() {
		Dictionary d = dict();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");
			d.insertEntry("w6", "d6");
			d.insertEntry("w7", "d7");
			d.insertEntry("w8", "d8");
			d.insertEntry("w9", "d9");
			d.insertEntry("w10", "d10");
			String def = d.getDefinition("cambridge");
			expectedExceptionDidNotOccur(WordNotInDictionaryException.class.getName());
		} catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		} catch (WordNotInDictionaryException e) {
			// expected
		}
	}
	
	@Test
	public void testEmptyDictionaryInsertEntry() {
		Dictionary d = dict();
		try {
			d.insertEntry("oxford", "the best university");
			assertEquals(1, d.size());
			assertEquals(1, d.getWords().length);
			assertEquals("oxford", d.getWords()[0]);
			assertEquals(1, d.getDefinitions().length);
			assertEquals("the best university", d.getDefinitions()[0]);
			assertEquals(1, d.getEntries().length);
			assertEquals("oxford", d.getEntries()[0].getWord());
			assertEquals("the best university", d.getEntries()[0].getDefinition());
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testOneItemDictionaryInsertEntryExistingWord() {
		Dictionary d = dict();
		try {
			d.insertEntry("oxford", "the best university");
			d.insertEntry("oxford", "certainly better than cambridge");
			expectedExceptionDidNotOccur(WordAlreadyExistsInDictionaryException.class.getName());
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			// expected
		} 
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testOneItemDictionaryInsertEntryNonExistingWord() {
		Dictionary d = dict();
		try {
			d.insertEntry("oxford", "the best university");
			d.insertEntry("cambridge", "an ok university");
			
			assertEquals(2, d.size());
			assertEquals(2, d.getWords().length);
			assertEquals("oxford", d.getWords()[0]);
			assertEquals("cambridge", d.getWords()[1]);
			assertEquals(2, d.getDefinitions().length);
			assertEquals("the best university", d.getDefinitions()[0]);
			assertEquals("an ok university", d.getDefinitions()[1]);
			assertEquals(2, d.getEntries().length);
			assertEquals("oxford", d.getEntries()[0].getWord());
			assertEquals("the best university", d.getEntries()[0].getDefinition());
			assertEquals("cambridge", d.getEntries()[1].getWord());
			assertEquals("an ok university", d.getEntries()[1].getDefinition());
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testFiveItemDictionaryInsertEntryExistingWord() {
		Dictionary d = dict();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");
			
			d.insertEntry("w3", "d3");
			expectedExceptionDidNotOccur(WordAlreadyExistsInDictionaryException.class.getName());
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			// expected
		} 
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testFiveItemDictionaryInsertEntryNonExistingWord() {
		Dictionary d = dict();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");
			
			d.insertEntry("w6", "d6");
			
			assertEquals(6, d.size());
			assertEquals(6, d.getWords().length);
			assertEquals("w1", d.getWords()[0]);
			assertEquals("w2", d.getWords()[1]);
			assertEquals("w3", d.getWords()[2]);
			assertEquals("w4", d.getWords()[3]);
			assertEquals("w5", d.getWords()[4]);
			assertEquals("w6", d.getWords()[5]);
			assertEquals(6, d.getDefinitions().length);
			assertEquals("d1", d.getDefinitions()[0]);
			assertEquals("d2", d.getDefinitions()[1]);
			assertEquals("d3", d.getDefinitions()[2]);
			assertEquals("d4", d.getDefinitions()[3]);
			assertEquals("d5", d.getDefinitions()[4]);
			assertEquals("d6", d.getDefinitions()[5]);
			assertEquals(6, d.getEntries().length);
			assertEquals("w1", d.getEntries()[0].getWord());
			assertEquals("d1", d.getEntries()[0].getDefinition());
			assertEquals("w2", d.getEntries()[1].getWord());
			assertEquals("d2", d.getEntries()[1].getDefinition());
			assertEquals("w3", d.getEntries()[2].getWord());
			assertEquals("d3", d.getEntries()[2].getDefinition());
			assertEquals("w4", d.getEntries()[3].getWord());
			assertEquals("d4", d.getEntries()[3].getDefinition());
			assertEquals("w5", d.getEntries()[4].getWord());
			assertEquals("d5", d.getEntries()[4].getDefinition());
			assertEquals("w6", d.getEntries()[5].getWord());
			assertEquals("d6", d.getEntries()[5].getDefinition());
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testNineItemDictionaryInsertEntryExistingWord() {
		Dictionary d = dict();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");
			d.insertEntry("w6", "d6");
			d.insertEntry("w7", "d7");
			d.insertEntry("w8", "d8");
			d.insertEntry("w9", "d9");
			
			d.insertEntry("w7", "d7");
			expectedExceptionDidNotOccur(WordAlreadyExistsInDictionaryException.class.getName());
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			// expected
		} 
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testNineItemDictionaryInsertEntryNonExistingWord() {
		Dictionary d = dict();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");
			d.insertEntry("w6", "d6");
			d.insertEntry("w7", "d7");
			d.insertEntry("w8", "d8");
			d.insertEntry("w9", "d9");
			
			d.insertEntry("w10", "d10");
			
			assertEquals(10, d.size());
			assertEquals(10, d.getWords().length);
			assertEquals("w1", d.getWords()[0]);
			assertEquals("w2", d.getWords()[1]);
			assertEquals("w3", d.getWords()[2]);
			assertEquals("w4", d.getWords()[3]);
			assertEquals("w5", d.getWords()[4]);
			assertEquals("w6", d.getWords()[5]);
			assertEquals("w7", d.getWords()[6]);
			assertEquals("w8", d.getWords()[7]);
			assertEquals("w9", d.getWords()[8]);
			assertEquals("w10", d.getWords()[9]);
			assertEquals(10, d.getDefinitions().length);
			assertEquals("d1", d.getDefinitions()[0]);
			assertEquals("d2", d.getDefinitions()[1]);
			assertEquals("d3", d.getDefinitions()[2]);
			assertEquals("d4", d.getDefinitions()[3]);
			assertEquals("d5", d.getDefinitions()[4]);
			assertEquals("d6", d.getDefinitions()[5]);
			assertEquals("d7", d.getDefinitions()[6]);
			assertEquals("d8", d.getDefinitions()[7]);
			assertEquals("d9", d.getDefinitions()[8]);
			assertEquals("d10", d.getDefinitions()[9]);
			assertEquals(10, d.getEntries().length);
			assertEquals("w1", d.getEntries()[0].getWord());
			assertEquals("d1", d.getEntries()[0].getDefinition());
			assertEquals("w2", d.getEntries()[1].getWord());
			assertEquals("d2", d.getEntries()[1].getDefinition());
			assertEquals("w3", d.getEntries()[2].getWord());
			assertEquals("d3", d.getEntries()[2].getDefinition());
			assertEquals("w4", d.getEntries()[3].getWord());
			assertEquals("d4", d.getEntries()[3].getDefinition());
			assertEquals("w5", d.getEntries()[4].getWord());
			assertEquals("d5", d.getEntries()[4].getDefinition());
			assertEquals("w6", d.getEntries()[5].getWord());
			assertEquals("d6", d.getEntries()[5].getDefinition());
			assertEquals("w7", d.getEntries()[6].getWord());
			assertEquals("d7", d.getEntries()[6].getDefinition());
			assertEquals("w8", d.getEntries()[7].getWord());
			assertEquals("d8", d.getEntries()[7].getDefinition());
			assertEquals("w9", d.getEntries()[8].getWord());
			assertEquals("d9", d.getEntries()[8].getDefinition());
			assertEquals("w10", d.getEntries()[9].getWord());
			assertEquals("d10", d.getEntries()[9].getDefinition());
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testDictionaryInsertEntryExistingWord() {
		Dictionary d = dict();
		try {
			for(int i = 1; i <= 100; i ++) {
				d.insertEntry("w" + i, "d" + i);
			}
			
			d.insertEntry("w100", "d100");
			expectedExceptionDidNotOccur(WordAlreadyExistsInDictionaryException.class.getName());
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (DictionaryFullException e) {
			// expected
		}
	}
	
	@Test
	public void testDictionaryInsertEntryNonExistingWord() {
		Dictionary d = dict();
		try {
			for(int i = 1; i <= 100; i ++) {
				d.insertEntry("w" + i, "d" + i);
			}
			
			d.insertEntry("w101", "d101");
			expectedExceptionDidNotOccur(WordAlreadyExistsInDictionaryException.class.getName());
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (DictionaryFullException e) {
			// expected
		}
	}
	
	@Test
	public void testEmptyDictionaryRemoveWord() {
		Dictionary d = dict();
		try {
			d.removeWord("oxford");
			expectedExceptionDidNotOccur(WordNotInDictionaryException.class.getName());
		} 
		catch (WordNotInDictionaryException e) {
			
		}
	}
	
	@Test
	public void testOneItemDictionaryRemoveWordExistingWord() {
		Dictionary d = dict();
		try {
			d.insertEntry("oxford", "the best university");
			d.removeWord("oxford");
			
			assertEquals(0, d.size());
			assertEquals(true, d.isEmpty());
			assertEquals(0, d.getWords().length);
			assertEquals(0, d.getDefinitions().length);
			assertEquals(0, d.getEntries().length);
		} 
		catch (WordNotInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testOneItemDictionaryRemoveWordNonExistingWord() {
		Dictionary d = dict();
		try {
			d.insertEntry("oxford", "the best university");
			d.removeWord("cambridge");
			expectedExceptionDidNotOccur(WordNotInDictionaryException.class.getName());
		} 
		catch (WordNotInDictionaryException e) {
			// expected
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testFiveItemDictionaryRemoveWordExistingWord() {
		Dictionary d = dict();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");
			
			d.removeWord("w3");
			
			assertEquals(4, d.size());
			assertEquals(4, d.getWords().length);
			assertEquals("w1", d.getWords()[0]);
			assertEquals("w2", d.getWords()[1]);
			assertEquals("w4", d.getWords()[2]);
			assertEquals("w5", d.getWords()[3]);
			assertEquals(4, d.getDefinitions().length);
			assertEquals("d1", d.getDefinitions()[0]);
			assertEquals("d2", d.getDefinitions()[1]);
			assertEquals("d4", d.getDefinitions()[2]);
			assertEquals("d5", d.getDefinitions()[3]);
			assertEquals(4, d.getEntries().length);
			assertEquals("w1", d.getEntries()[0].getWord());
			assertEquals("d1", d.getEntries()[0].getDefinition());
			assertEquals("w2", d.getEntries()[1].getWord());
			assertEquals("d2", d.getEntries()[1].getDefinition());
			assertEquals("w4", d.getEntries()[2].getWord());
			assertEquals("d4", d.getEntries()[2].getDefinition());
			assertEquals("w5", d.getEntries()[3].getWord());
			assertEquals("d5", d.getEntries()[3].getDefinition());
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (WordNotInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		}
		catch (Exception e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testFiveItemDictionaryRemoveWordNonExistingWord() {
		Dictionary d = dict();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");
			
			d.removeWord("w6");
			
			expectedExceptionDidNotOccur(WordNotInDictionaryException.class.getName());
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (WordNotInDictionaryException e) {
			// expected
		}
		catch (Exception e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testNineItemDictionaryRemoveWordExistingWord() {
		Dictionary d = dict();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");
			d.insertEntry("w6", "d6");
			d.insertEntry("w7", "d7");
			d.insertEntry("w8", "d8");
			d.insertEntry("w9", "d9");
			
			d.removeWord("w1");
			
			assertEquals(8, d.size());
			assertEquals(8, d.getWords().length);
			assertEquals("w2", d.getWords()[0]);
			assertEquals("w3", d.getWords()[1]);
			assertEquals("w4", d.getWords()[2]);
			assertEquals("w5", d.getWords()[3]);
			assertEquals("w6", d.getWords()[4]);
			assertEquals("w7", d.getWords()[5]);
			assertEquals("w8", d.getWords()[6]);
			assertEquals("w9", d.getWords()[7]);
			assertEquals(8, d.getDefinitions().length);
			assertEquals("d2", d.getDefinitions()[0]);
			assertEquals("d3", d.getDefinitions()[1]);
			assertEquals("d4", d.getDefinitions()[2]);
			assertEquals("d5", d.getDefinitions()[3]);
			assertEquals("d6", d.getDefinitions()[4]);
			assertEquals("d7", d.getDefinitions()[5]);
			assertEquals("d8", d.getDefinitions()[6]);
			assertEquals("d9", d.getDefinitions()[7]);
			assertEquals(8, d.getEntries().length);
			assertEquals("w2", d.getEntries()[0].getWord());
			assertEquals("d2", d.getEntries()[0].getDefinition());
			assertEquals("w3", d.getEntries()[1].getWord());
			assertEquals("d3", d.getEntries()[1].getDefinition());
			assertEquals("w4", d.getEntries()[2].getWord());
			assertEquals("d4", d.getEntries()[2].getDefinition());
			assertEquals("w5", d.getEntries()[3].getWord());
			assertEquals("d5", d.getEntries()[3].getDefinition());
			assertEquals("w6", d.getEntries()[4].getWord());
			assertEquals("d6", d.getEntries()[4].getDefinition());
			assertEquals("w7", d.getEntries()[5].getWord());
			assertEquals("d7", d.getEntries()[5].getDefinition());
			assertEquals("w8", d.getEntries()[6].getWord());
			assertEquals("d8", d.getEntries()[6].getDefinition());
			assertEquals("w9", d.getEntries()[7].getWord());
			assertEquals("d9", d.getEntries()[7].getDefinition());
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (WordNotInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		}
		catch (Exception e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testNineItemDictionaryRemoveWordNonExistingWord() {
		Dictionary d = dict();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");
			d.insertEntry("w6", "d6");
			d.insertEntry("w7", "d7");
			d.insertEntry("w8", "d8");
			d.insertEntry("w9", "d9");
			
			d.removeWord("w10");
			
			expectedExceptionDidNotOccur(WordNotInDictionaryException.class.getName());
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (WordNotInDictionaryException e) {
			// expected
		}
		catch (Exception e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testDictionaryRemoveWordExistingWord() {
		Dictionary d = dict();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");
			d.insertEntry("w6", "d6");
			d.insertEntry("w7", "d7");
			d.insertEntry("w8", "d8");
			d.insertEntry("w9", "d9");
			d.insertEntry("w10", "d10");
			
			d.removeWord("w5");
			
			assertEquals(9, d.size());
			assertEquals(9, d.getWords().length);
			assertEquals("w1", d.getWords()[0]);
			assertEquals("w2", d.getWords()[1]);
			assertEquals("w3", d.getWords()[2]);
			assertEquals("w4", d.getWords()[3]);
			assertEquals("w6", d.getWords()[4]);
			assertEquals("w7", d.getWords()[5]);
			assertEquals("w8", d.getWords()[6]);
			assertEquals("w9", d.getWords()[7]);
			assertEquals("w10", d.getWords()[8]);
			assertEquals(9, d.getDefinitions().length);
			assertEquals("d1", d.getDefinitions()[0]);
			assertEquals("d2", d.getDefinitions()[1]);
			assertEquals("d3", d.getDefinitions()[2]);
			assertEquals("d4", d.getDefinitions()[3]);
			assertEquals("d6", d.getDefinitions()[4]);
			assertEquals("d7", d.getDefinitions()[5]);
			assertEquals("d8", d.getDefinitions()[6]);
			assertEquals("d9", d.getDefinitions()[7]);
			assertEquals("d10", d.getDefinitions()[8]);
			assertEquals(9, d.getEntries().length);
			assertEquals("w1", d.getEntries()[0].getWord());
			assertEquals("d1", d.getEntries()[0].getDefinition());
			assertEquals("w2", d.getEntries()[1].getWord());
			assertEquals("d2", d.getEntries()[1].getDefinition());
			assertEquals("w3", d.getEntries()[2].getWord());
			assertEquals("d3", d.getEntries()[2].getDefinition());
			assertEquals("w4", d.getEntries()[3].getWord());
			assertEquals("d4", d.getEntries()[3].getDefinition());
			assertEquals("w6", d.getEntries()[4].getWord());
			assertEquals("d6", d.getEntries()[4].getDefinition());
			assertEquals("w7", d.getEntries()[5].getWord());
			assertEquals("d7", d.getEntries()[5].getDefinition());
			assertEquals("w8", d.getEntries()[6].getWord());
			assertEquals("d8", d.getEntries()[6].getDefinition());
			assertEquals("w9", d.getEntries()[7].getWord());
			assertEquals("d9", d.getEntries()[7].getDefinition());
			assertEquals("w10", d.getEntries()[8].getWord());
			assertEquals("d10", d.getEntries()[8].getDefinition());
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (WordNotInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		}
		catch (Exception e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testDictionaryRemoveWordNonExistingWord() {
		Dictionary d = dict();
		try {
			d.insertEntry("w1", "d1");
			d.insertEntry("w2", "d2");
			d.insertEntry("w3", "d3");
			d.insertEntry("w4", "d4");
			d.insertEntry("w5", "d5");
			d.insertEntry("w6", "d6");
			d.insertEntry("w7", "d7");
			d.insertEntry("w8", "d8");
			d.insertEntry("w9", "d9");
			d.insertEntry("w10", "d10");
			
			d.removeWord("w11");
			
			expectedExceptionDidNotOccur(WordNotInDictionaryException.class.getName());
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (WordNotInDictionaryException e) {
			// expected
		}
		catch (Exception e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testEmptyDictionaryGetWords() {
		Dictionary d = dict();
		assertEquals(0, d.getWords().length);
	}
	
	@Test
	public void testOneItemDictionaryGetWords() {
		Dictionary d = dict();
		try {
			d.insertEntry("oxford", "the best university");
			assertEquals(1, d.getWords().length);
			assertEquals("oxford", d.getWords()[0]);
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testEmptyDictionaryGetDefinitions() {
		Dictionary d = dict();
		assertEquals(0, d.getDefinitions().length);
	}
	
	@Test
	public void testOneItemDictionaryGetDefinitions() {
		Dictionary d = dict();
		try {
			d.insertEntry("oxford", "the best university");
			assertEquals(1, d.getDefinitions().length);
			assertEquals("the best university", d.getDefinitions()[0]);
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testEmptyDictionaryGetEntries() {
		Dictionary d = dict();
		assertEquals(0, d.getEntries().length);
	}
	
	@Test
	public void testOneItemDictionaryGetEntries() {
		Dictionary d = dict();
		try {
			d.insertEntry("oxford", "the best university");
			assertEquals(1, d.getEntries().length);
			assertEquals("oxford", d.getEntries()[0].getWord());
			assertEquals("the best university", d.getEntries()[0].getDefinition());
		} 
		catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		} 
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
	}

	@Test
	public void testRemoveExistingMiddles() {
		Dictionary d = dict();
		try {
			String w1 = "w1";
			String w2 = "w2";
			String w3 = "w3";
			String w4 = "w4";
			String w5 = "w5";
			String w6 = "w6";
			String w7 = "w7";
			String w8 = "w8";
			String w9 = "w9";
			String w10 = "w10";
			
			String d1 = "d1";
			String d2 = "d2";
			String d3 = "d3";
			String d4 = "d4";
			String d5 = "d5";
			String d6 = "d6";
			String d7 = "d7";
			String d8 = "d8";
			String d9 = "d9";
			String d10 = "d10";
			
			d.insertEntry(w1, d1);
			d.insertEntry(w2, d2);
			d.insertEntry(w3, d3);
			d.insertEntry(w4, d4);
			d.insertEntry(w5, d5);
			d.insertEntry(w6, d6);
			d.insertEntry(w7, d7);
			d.insertEntry(w8, d8);
			d.insertEntry(w9, d9);
			d.insertEntry(w10, d10);
			
			String rd1, rd3, rd5, rd7, rd9;
			rd1 = d.removeWord("w1");
			rd3 = d.removeWord("w3");
			rd5 = d.removeWord("w5");
			rd7 = d.removeWord("w7");
			rd9 = d.removeWord("w9");
		
			assertEquals(rd1, d1);
			assertEquals(rd3, d3);
			assertEquals(rd5, d5);
			assertEquals(rd7, d7);
			assertEquals(rd9, d9);
			
			String[] words = {w2, w4, w6, w8, w10};
			String[] definitions = {d2, d4, d6, d8, d10};
			WordDefinitionPair[] entries = {
					new WordDefinitionPair(w2, d2),
					new WordDefinitionPair(w4, d4),
					new WordDefinitionPair(w6, d6),
					new WordDefinitionPair(w8, d8),
					new WordDefinitionPair(w10, d10)
			};
			
			assertTrue(equalStringArrays(words, d.getWords()));
			assertTrue(equalStringArrays(definitions, d.getDefinitions()));
			assertTrue(equalWDPArrays(entries, d.getEntries()));
		}
		catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		}
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
		catch (WordNotInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		}
		catch (Exception e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	@Test
	public void testRemoveExistingMiddlesThenInsert() {
		Dictionary d = dict();
		try {
			String w1 = "w1";
			String w2 = "w2";
			String w3 = "w3";
			String w4 = "w4";
			String w5 = "w5";
			String w6 = "w6";
			String w7 = "w7";
			String w8 = "w8";
			String w9 = "w9";
			String w10 = "w10";
			
			String d1 = "d1";
			String d2 = "d2";
			String d3 = "d3";
			String d4 = "d4";
			String d5 = "d5";
			String d6 = "d6";
			String d7 = "d7";
			String d8 = "d8";
			String d9 = "d9";
			String d10 = "d10";
			
			d.insertEntry(w1, d1);
			d.insertEntry(w2, d2);
			d.insertEntry(w3, d3);
			d.insertEntry(w4, d4);
			d.insertEntry(w5, d5);
			d.insertEntry(w6, d6);
			d.insertEntry(w7, d7);
			d.insertEntry(w8, d8);
			d.insertEntry(w9, d9);
			d.insertEntry(w10, d10);
			
			String rd1, rd3, rd5, rd7, rd9;
			rd1 = d.removeWord("w1");
			rd3 = d.removeWord("w3");
			rd5 = d.removeWord("w5");
			rd7 = d.removeWord("w7");
			rd9 = d.removeWord("w9");
		
			assertEquals(rd1, d1);
			assertEquals(rd3, d3);
			assertEquals(rd5, d5);
			assertEquals(rd7, d7);
			assertEquals(rd9, d9);
			
			d.insertEntry(w1, d1);
			d.insertEntry(w3, d3);
			d.insertEntry(w5, d5);
			d.insertEntry(w7, d7);
			d.insertEntry(w9, d9);
			
			String[] words = {w2, w4, w6, w8, w10, w1, w3, w5, w7, w9};
			String[] definitions = {d2, d4, d6, d8, d10, d1, d3, d5, d7, d9};
			WordDefinitionPair[] entries = {
					new WordDefinitionPair(w2, d2),
					new WordDefinitionPair(w4, d4),
					new WordDefinitionPair(w6, d6),
					new WordDefinitionPair(w8, d8),
					new WordDefinitionPair(w10, d10),
					new WordDefinitionPair(w1, d1),
					new WordDefinitionPair(w3, d3),
					new WordDefinitionPair(w5, d5),
					new WordDefinitionPair(w7, d7),
					new WordDefinitionPair(w9, d9)
			};
			
			assertTrue(equalStringArrays(words, d.getWords()));
			assertTrue(equalStringArrays(definitions, d.getDefinitions()));
			assertTrue(equalWDPArrays(entries, d.getEntries()));
		}
		catch (WordAlreadyExistsInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		}
		catch (DictionaryFullException e) {
			unexpectedExceptionOccurred(e);
		}
		catch (WordNotInDictionaryException e) {
			unexpectedExceptionOccurred(e);
		}
		catch (Exception e) {
			unexpectedExceptionOccurred(e);
		}
	}
	
	private Boolean equalStringArrays(String[] a1, String[] a2) {
		boolean soFarEqual = a1.length == a2.length;
		for(int i = 0; i < a1.length && soFarEqual; i ++) {
			soFarEqual = soFarEqual && a1[i].equals(a2[i]);
		}
		return soFarEqual;
	}
	
	private Boolean equalWDPArrays(WordDefinitionPair[] a1, WordDefinitionPair[] a2) {
		boolean soFarEqual = a1.length == a2.length;
		for(int i = 0; i < a1.length && soFarEqual; i ++) {
			soFarEqual = 
				soFarEqual 
			&& a1[i].getWord().equals(a2[i].getWord())
			&& a1[i].getDefinition().equals(a2[i].getDefinition());
		}
		return soFarEqual;
	}
	
	private void unexpectedExceptionOccurred(Exception e) {
		String msg = e.getClass().getName() + " not expected";
		fail(msg);
	}
	
	private void expectedExceptionDidNotOccur(String e) {
		String msg = e + " is expected";
		fail(msg);
	}
}
