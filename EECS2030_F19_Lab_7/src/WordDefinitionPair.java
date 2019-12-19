
public class WordDefinitionPair {
	private String word;
	private String definition;

	public WordDefinitionPair(String word, String definition) {
		// TODO Auto-generated constructor stub
		this.setWord(word);
		this.setDefinition(definition);

	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		} else if (this.word == ((WordDefinitionPair) obj).getWord()
				&& this.definition == ((WordDefinitionPair) obj).getDefinition()) {
			return true;
		}
		return false;
	}

}
