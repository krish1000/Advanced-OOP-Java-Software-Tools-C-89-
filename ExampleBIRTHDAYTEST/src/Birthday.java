
public class Birthday {

	private int month, day;

	public Birthday(int month, int day) {
		// TODO Auto-generated constructor stub
		if (month > 12 || day > 31) {
			throw new IllegalArgumentException();
		}
		this.month = month;
		this.day = day;
	}

	public int getMonth() {
		return this.month;
	}

	public int getDay() {
		return this.day;
	}

	public String toString() {
		String monthname = null;

		if (month > 11) {
			monthname = "December";
		} else if (month > 10) {
			monthname = "November";
		} else if (month > 9) {
			monthname = "October";
		} else if (month > 8) {
			monthname = "September";
		} else if (month > 7) {
			monthname = "August";
		} else if (month > 6) {
			monthname = "July";
		} else if (month > 5) {
			monthname = "June";
		} else if (month > 4) {
			monthname = "May";
		} else if (month > 3) {
			monthname = "April";
		} else if (month > 2) {
			monthname = "March";
		} else if (month > 1) {
			monthname = "February";
		} else if (month > 0) {
			monthname = "January";
		}
		return monthname + " " + day;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || obj.getClass() == null || obj.getClass() != this.getClass()) {
			return false;
		} else if (this.toString().equals(((Birthday) obj).toString())) {
			return true;
		}
		return false;
	}

	
}
