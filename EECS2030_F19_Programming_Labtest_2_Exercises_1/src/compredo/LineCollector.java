package compredo;

public class LineCollector {
	
	Line[] linecol; 
	int nol;
	
	public LineCollector() {
		linecol = new Line[100];
	}
	
	public LineCollector(LineCollector lc) {
		this.linecol = lc.linecol;
		this.nol = lc.nol;
	}
	
	public void addLine(Line line) {
		linecol[nol++] = line;
	}
	
	public Line getLineAt(int index) {
		return new Line(linecol[index]);
	}
	
	public Line[] getLines() {
		Line[] temp = new Line[this.nol];
		
		for(int i =0; i < nol; i++) {
			temp[i] = new Line(linecol[i]);
		}
		return temp;
	}
	
	public boolean equals(Object obj) {
		if(obj == null || obj.getClass() == null || obj.getClass() != this.getClass()) {
			return false;
		} else if (this.nol != ((LineCollector)obj).nol) {
			return false;
		} else {
			for(int i = 0; i < this.nol; i ++) {
				if(!this.linecol[i].equals(((LineCollector)obj).linecol[i])) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
}
