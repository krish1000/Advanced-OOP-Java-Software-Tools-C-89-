package aggregation;

public class LineCollector {
	private Line[] lines;
	private int nol; /* number of points */
	private final int MAX_CAPACITY = 20;
	
	LineCollector(LineCollector other) {
		this.lines = other.lines;
		this.nol = other.nol;
	}
	
	LineCollector() {
		lines = new Line[MAX_CAPACITY];
		nol = 0;
	}
	
	int getNumberOfLines() {
		return nol;
	}
	
	Line[] getLines() {
		Line[] ls = new Line[nol];
		for(int i = 0; i < nol; i ++) {
			ls[i] = lines[i];
		}
		return ls;
	}
	
	Line getLineAt(int i) {
		if(!(0 <= i && i < this.nol)) {
			throw new IllegalArgumentException();
		} 
		return lines[i];
	}
	
	void addLine(Line l) {
		lines[nol] = l;
		nol ++;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		LineCollector other = (LineCollector) obj;
		boolean isEqual = this.nol == other.nol;
		for(int i = 0; i < nol && isEqual; i ++) {
			isEqual = lines[i].equals(other.lines[i]);
		}
		return isEqual;
	}
}
