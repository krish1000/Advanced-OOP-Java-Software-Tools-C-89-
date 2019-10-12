
public class Entry {

	private Birthday bd;
	private String person;

	// not sure if needed test 5

	public Entry(String person, Birthday bd) {
		// TODO Auto-generated constructor stub
		this.person = person;

		this.bd = bd;

	}

	// test 5 added
	public Entry(String person, int month, int day) {
		this.person = person;

		this.bd = new Birthday(month, day);
	}

	public String getName() {
		return this.person;
	}

	public Birthday getBirthday() {
		return this.bd;
	}

	public String toString() {
		return this.person + " was born on " + this.bd.toString();
	}
	
	public void setName(String person) {
		this.person = person;
	}
	
	public void setBirthday(int month, int day) {
		this.bd = new Birthday(month, day);
	}
	
	public void setBirthday(Birthday bd) {
		this.bd = bd;
	}
	
	//test 6
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || obj.getClass() == null || obj.getClass() != this.getClass()) {
			return false;
		} else if ((((Entry)obj).toString()).equals(this.toString())) {
			return true;
		}
		return false;
	}

}
