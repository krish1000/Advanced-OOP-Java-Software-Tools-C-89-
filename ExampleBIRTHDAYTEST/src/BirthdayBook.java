
public class BirthdayBook {

	private Entry[] entries;
	private int noe = 0;

	public BirthdayBook() {
		// TODO Auto-generated constructor stub
		entries = new Entry[10];
	}

	public int getNumberOfEntries() {
		return this.noe;
	}

	public Entry[] getEntries() {
		Entry[] temp = new Entry[noe];

		for (int i = 0; i < noe; i++) {
			temp[i] = this.entries[i];
		}
		return temp;
	}

//	public Entry[] getEntries() {
//		Entry[] temp = new Entry[noe]; // temp array
//
//		for (int i = 0; i < noe; i++) {
//			temp[i] = entries[i];
//		}
//
//		return temp;
//	}

	public String toString() {
		String poo = "There are " + this.getNumberOfEntries() + " entries in the book\n";
		for (int i = 0; i < this.getEntries().length; i++) {
			poo += this.getEntries()[i].toString() + "\n";
		}
		return poo;
	}
//
	public boolean nameExists(String person) {
		// temp false

		for (int i = 0; i < noe; i++) {
			if (this.getEntries()[i].getName() == person) {
				return true;
			}
		}
		return false;
	}

	public Birthday getBirthday(String person) {

		for (int i = 0; i < noe; i++) {
			if (this.getEntries()[i].getName() == person) {
				return this.getEntries()[i].getBirthday();
			}
		}

		return null; // temp null
	}

	
	public String[] getReminders(Birthday bd) {
		String[] temp;
		int counter = 0;
		for(int i = 0; i < this.noe; i++) {
			if (this.getEntries()[i].getBirthday().equals(bd)) {
				counter++;
			}
		}
		
		temp = new String[counter];
		int counter2 = 0;
		for(int i = 0; i < this.noe; i++) {
			if (this.getEntries()[i].getBirthday().equals(bd)) {
				temp[counter2] = this.getEntries()[i].getName();
			}
		}
		
		return temp;
	}
	
	
	
	
	
	
//	public String[] getReminders(Birthday bd) { // not sure if its correct
//		int counter = 0;
//		String[] temp;
//		for (int i = 0; i < noe; i++) {
//			if (this.getEntries()[i].getBirthday().equals(bd)) {
//				counter++;
//				// System.out.println("counterafter: " + counter);
//			}
//		}
//
//		temp = new String[counter];
//		counter = 0;
//		for (int i = 0; i < noe; i++) {
//			if (this.getEntries()[i].getBirthday().equals(bd)) {
//				temp[counter] = this.getEntries()[i].getName();
//				counter++;
//			}
//		}

		return temp;
	}

	public String[] getReminders(int month, int day) {
		String[] temp = null;
		int counter = 0;
		for (int i = 0; i < this.noe; i++) {
			if (this.getEntries()[i].getBirthday().equals(new Birthday(month, day))) {
				counter++;
			}
		}
		temp = new String[counter];
		for (int i = 0; i < this.noe; i++) {
			if (this.getEntries()[i].getBirthday().equals(new Birthday(month, day))) {
				temp[counter] = this.getEntries()[i].getName();
				counter++;
			}
		}

		return temp;
	}

//
//	public String[] getReminders(int month, int day) {
//		int counter = 0;
//		String[] temp;
//		for (int i = 0; i < noe; i++) {
//			if (this.getEntries()[i].getBirthday().getMonth() == month
//					&& this.getEntries()[i].getBirthday().getDay() == day) {
//				counter++;
//			}
//		}
//
//		temp = new String[counter];
//		counter = 0;
//		for (int i = 0; i < noe; i++) {
//			if (this.getEntries()[i].getBirthday().getMonth() == month
//					&& this.getEntries()[i].getBirthday().getDay() == day) {
//				temp[counter] = this.getEntries()[i].getName();
//				counter++;
//			}
//		}
//		return temp;
//
//	}

	public void removeEntry(String person) {
		// if nameExist's method doesn't exist
		boolean poo = false;
		for (int i = 0; i < this.noe; i++) {
			if (this.getEntries()[i].getName() == person) {
				poo = true;
			}
		}
		if (poo) {
			int counter = 0;
			for (int i = 0; i < this.noe; i++) {
				if (this.getEntries()[i].getName() != person) {
					this.entries[counter] = this.getEntries()[i];
					counter++;
				}
			}
			this.noe--;
		}
	}

	/*
	 * if (nameExists(person)) { int count = 0; for (int i = 0; i < this.noe; i++) {
	 * if (this.getEntries()[i].getName() != (person)) { this.entries[count++] =
	 * this.getEntries()[i]; } } this.noe--; }
	 */

//	public void removeEntry(String person) {
//		
//		boolean poo = false;
//		if (this.getEntries().length > 0) {
//			if (this.nameExists(person) == true) {
//				Entry[] temparr = new Entry[99];
//				int counter = 0;
//				for (int i = 0; i < this.noe; i++) {
//					if (this.getEntries()[i].getName() != person) {
//						temparr[counter] = this.getEntries()[i];
//						counter++;
//					} else {
//						poo = true;
//					}
//				}
//				if (poo == true) {
//					noe--;
//				}
//				this.entries = temparr;
//
//			}
//		}
//	}
//	
	/*
	 * if (this.noe > 0) { if (this.nameExists(person) == true) { Entry[] temparr =
	 * new Entry[this.getEntries().length - 1];
	 * 
	 * for (int i = 0; i < noe; i++) { if (this.getEntries()[i].getName() == person)
	 * { // counter = i; this.getEntries()[i] = null;
	 * 
	 * for (int j = i; j < noe; j++) { if (j < noe-1) { this.getEntries()[j] =
	 * this.getEntries()[j + 1]; } else { this.getEntries()[j] = null; } } } }
	 * 
	 * for (int i = 0; i < noe; i++) { temparr[i] = this.getEntries()[i]; }
	 * this.entries = temparr; } }
	 */

//	counter = 0;
//	for (int j = 0; j < noe; j++) {
//		if (this.getEntries()[j] == null) {
//			//do nothing
//		} else {
//			temparr[counter] = this.getEntries()[j];
//		}
//	}
//	
//	entries = temparr;

	public void addEntry(String person, int month, int day) {
//		if(noe <0) {
//			noe++;
//		}
		Birthday bd = new Birthday(month, day);
		if (this.nameExists(person) == true) {

			for (int i = 0; i < this.getNumberOfEntries(); i++) {
				if (this.getEntries()[i].getName() == person) {
					this.entries[i] = new Entry(person, bd);
				}
			}

		} else {
			// Birthday bd = new Birthday(month, day);
			entries[noe] = new Entry(person, bd);
			noe++;
		}
	}

	public void addEntry(String person, Birthday bd) {

		// Birthday bd = new Birthday(month, day);
		if (this.nameExists(person) == true) {

			for (int i = 0; i < this.getNumberOfEntries(); i++) {
				if (this.getEntries()[i].getName() == person) {
					this.entries[i] = new Entry(person, bd);
				}
			}

		} else {
			// Birthday bd = new Birthday(month, day);
			entries[noe] = new Entry(person, bd);
			noe++;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || obj.getClass() == null || obj.getClass() != this.getClass()) {
			return false;
		} else if (((BirthdayBook) obj).getNumberOfEntries() != this.getNumberOfEntries()) {
			return false;
		} else {
			for (int i = 0; i < this.getNumberOfEntries(); i++) {
				if (((BirthdayBook) obj).getEntries()[i].equals(this.getEntries()[i])) {

				} else {
					return false;
				}
			}
		}
		return true;
	}

	
}
