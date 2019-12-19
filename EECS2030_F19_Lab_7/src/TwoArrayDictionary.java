/* Make sure the instructions document is read carefully.
 * 
 * You are required to use the given `words` and `definitions` arrays to implement the methods.
 * See test_two_array_implementation_insert and test_two_array_implementation_remove 
 * in class TestArrayImplementations.
 * 
 * Requirements:
 * 		- You are not allowed to add new attributes to this class.
 * 		- You are not allowed to use any Java collection library (no import statements).
 * 
 * The idea is that both `words` and `definitions` are initialized as arrays of size `MAX_CAPACITY` with each slot storing null.
 * Entries (words and definitions) are added from left to right, whereas all free slots remain null.
 * When an entry is removed, all slots to its right are shifted to the left to close the gap.
 * 
 * For example, given a dictionary with four entries:
 * words:       {w1, w2, w3, w4, null, null, ...}
 * definitions: {d1, d2, d3, d4, null, null, ...}
 * Removing the entry for word `w2` has the resulting dictionary:
 * words:       {w1, w3, w4, null, null, null, ...}
 * definitions: {d1, d3, d4, null, null, null, ...}
 * 
 * You may consider studying this note on manipulating basic array:
 * https://www.eecs.yorku.ca/~jackie/teaching/lectures/2019/F/EECS2030/notes/EECS2030_F19_Notes_Tracing_PointCollectorTester.pdf
 */

public class TwoArrayDictionary implements Dictionary {

	/*
	 * Use these attributes only to implement the methods.
	 */
	int MAX_CAPACITY = 100;
	int count = 0; // number of entries in dictionary

	String[] words;
	String[] definitions;

	// added constructor
	public TwoArrayDictionary() {
		// TODO Auto-generated constructor stub
		words = new String[MAX_CAPACITY];
		definitions = new String[MAX_CAPACITY];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.count;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (this.count == 0)
			return true;
		return false;
	}

	@Override
	public String getDefinition(String word) throws WordNotInDictionaryException {
		// TODO Auto-generated method stub

		for (int i = 0; i < count; i++) {
			if (words[i] == word) {
				return definitions[i];
			}
		}

		throw new WordNotInDictionaryException();
	}

	@Override
	public void insertEntry(String word, String definition)
			throws WordAlreadyExistsInDictionaryException, DictionaryFullException {
		// TODO Auto-generated method stub
		if (count == 99) {
			throw new DictionaryFullException(word);
		}
		for (int i = 0; i < count; i++) {
			if (words[i] == word) {
				throw new WordAlreadyExistsInDictionaryException();
			}
		}
		words[count] = word;
		definitions[count++] = definition;

	}

	@Override
	public String removeWord(String word) throws WordNotInDictionaryException {
		// TODO Auto-generated method stub

		String def = "poop";
		boolean exists = false;
		for (int i = 0; i < this.count; i++) {
			if (words[i] == word) {
				def = definitions[i];
				exists = true;
				this.count--;
			}
			if (exists) {
				words[i] = words[i + 1];
				definitions[i] = definitions[i + 1];
			}
		}
		if (!exists) {
			throw new WordNotInDictionaryException();
		} else {
			words[count] = null;
			definitions[count] = null;
		}

		return def;
	}

	@Override
	public String[] getWords() {
		// TODO Auto-generated method stub
		String[] temp = new String[count];

		for (int i = 0; i < count; i++) {
			temp[i] = words[i];
		}
		return temp;
	}

	@Override
	public String[] getDefinitions() {
		// TODO Auto-generated method stub
		String[] temp = new String[count];

		for (int i = 0; i < count; i++) {
			temp[i] = definitions[i];
		}
		return temp;
	}

	@Override
	public WordDefinitionPair[] getEntries() {
		// TODO Auto-generated method stub
		WordDefinitionPair[] tempPairs = new WordDefinitionPair[count];

		for (int i = 0; i < count; i++) {
			tempPairs[i] = new WordDefinitionPair(words[i], definitions[i]);
		}

		return tempPairs;
	}

	/*
	 * Your tasks: declare and implement methods from the Dictionary interface.
	 */
}
