/*
 * You are required to use the given `dict` array to implement the methods.
 * See test_one_array_implementation_insert and test_one_array_implementation_remove 
 * in class TestArrayImplementations.
 *
 * Requirements:
 * 		- You are not allowed to add new attributes to this class.
 * 		- You are not allowed to use any Java collection library (no import statements).
 * 
 * The idea is that `dict` is initialized as an array of size `MAX_CAPACITY` with each slot storing null.
 * Entries are added from left to right, whereas all free slots remain null.
 * When an entry is removed, all slots to its right are shifted to the left to close the gap.
 * 
 * For example, given a dictionary with four entries:
 * {(w1, d1), (w2, d2), (w3, d3), (w4, d4), null, null, ...} 
 * Removing the entry for word `w2` has the resulting dictionary:
 * {(w1, d1), (w3, d3), (w4, d4), null, null, null, ...}
 * 
 * You may consider studying this note on manipulating basic array:
 * https://www.eecs.yorku.ca/~jackie/teaching/lectures/2019/F/EECS2030/notes/EECS2030_F19_Notes_Tracing_PointCollectorTester.pdf
 */

public class OneArrayDictionary implements Dictionary {

	int MAX_CAPACITY = 100;
	int count = 0;
	WordDefinitionPair[] dict;

	// added constructor
	public OneArrayDictionary() {
		// TODO Auto-generated constructor stub
		dict = new WordDefinitionPair[MAX_CAPACITY];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.count;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size() == 0)
			return true;
		return false;
	}

	@Override
	public String getDefinition(String word) throws WordNotInDictionaryException {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.count; i++) {
			if (dict[i].getWord() == word) {
				return dict[i].getDefinition();
			}
		}
		throw new WordNotInDictionaryException();
		// return null;
	}

	@Override
	public void insertEntry(String word, String definition)
			throws WordAlreadyExistsInDictionaryException, DictionaryFullException {
		// TODO Auto-generated method stub
		if (this.count == 99) {
			throw new DictionaryFullException(word);
		}
		String[] tempWordList = getWords();
		for (int i = 0; i < tempWordList.length; i++) {
			if (tempWordList[i] == word) {
				//throw new WordAlreadyExistsInDictionaryException();
			}
		}

		this.dict[count++] = new WordDefinitionPair(word, definition);
	}

	@Override
	public String removeWord(String word) throws WordNotInDictionaryException {
		// TODO Auto-generated method stub

		// Could have exploited using getDefinition
		String def = "poop";
		boolean exists = false;
		for (int i = 0; i < this.count; i++) {
			if (dict[i].getWord() == word) {
				def = dict[i].getDefinition();
				exists = true;
				this.count--;
			}
			if (exists) {
				dict[i] = dict[i + 1];
			}
		}
		if (!exists) {
			throw new WordNotInDictionaryException();
		} else {
			dict[count] = null;
		}

		return def;
	}

	@Override
	public String[] getWords() {
		// TODO Auto-generated method stub
		String[] wordList = new String[this.count];

		for (int i = 0; i < this.count; i++) {
			wordList[i] = dict[i].getWord();
		}
		return wordList;
	}

	@Override
	public String[] getDefinitions() {
		// TODO Auto-generated method stub
		String[] defList = new String[this.count];

		for (int i = 0; i < this.count; i++) {
			defList[i] = dict[i].getDefinition();
		}
		return defList;
	}

	@Override
	public WordDefinitionPair[] getEntries() {
		// TODO Auto-generated method stub
		WordDefinitionPair[] entList = new WordDefinitionPair[this.count];

		for (int i = 0; i < this.count; i++) {
			entList[i] = dict[i];
		}
		return entList;
	}

	/*
	 * Your tasks: declare and implement methods from the Dictionary interface.
	 */
}
