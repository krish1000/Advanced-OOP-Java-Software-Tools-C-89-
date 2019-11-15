public interface Dictionary {
	/**
	 * Size of dictionary.
	 * @return Number of word-definition pairs stored in this dictionary
	 */
	int size();

	/**
	 * Is the dictionary empty?
	 * @return true if this dictionary stores no word-definition pairs
	 */
	boolean isEmpty(); 
	
	/**
	 * 
	 * @param word an input word
	 * @return the associated definition of the input word if it exists in this dictionary
	 * @throws WordNotInDictionaryException if the input word does not exist
	 */
	String getDefinition(String word)
			throws WordNotInDictionaryException;

	/**
	 * Given inputs `word` and its associated `definition`, add them to the dictionary.
	 * @param word an input word
	 * @param definition associated definition of the input word
	 * @throws WordAlreadyExistsInDictionaryException if the new word already exists in the dictionary 
	 * @throws DictionaryFullException if the dictionary already stores the maximum number of entries
	 */
	void insertEntry(String word, String definition)
			throws WordAlreadyExistsInDictionaryException, DictionaryFullException;

	/**
	 * Given an input `word`, remove it and its association, and return the removed definition.
	 * @param word an input word
	 * @return the removed definition
	 * @throws WordNotInDictionaryException if the input `word` exists in the dictionary
	 */
	String removeWord(String word)
			throws WordNotInDictionaryException;

	/**
	 * All words stored in the dictionary
	 * @return the collection of words stored in this dictionary
	 */
	String[] getWords();

	/**
	 * All definitions stored in the dictionary
	 * @return the collection of definitions stored in this dictionary
	 */
	String[] getDefinitions();

	/**
	 * All word-definition entries stored in the dictionary
	 * @return the collection of word-definition entries stored in this dictionary
	 */
	WordDefinitionPair[] getEntries();
}