package composition;

public class LineCollector {

	Line[] linecoll;
	int nol;
	
	public LineCollector() {
		// TODO Auto-generated constructor stub
		linecoll = new Line[100];
	}

	public LineCollector(LineCollector lc1) {
		// TODO Auto-generated constructor stub
		this.linecoll = lc1.linecoll;
		//DONT FORGET TO ALSO CHANGE int nol
		this.nol = lc1.nol;
	}

	public void addLine(Line l1) {
		// TODO Auto-generated method stub
		this.linecoll[nol++] = l1;
		
	}

	public Line getLineAt(int i) {
		// TODO Auto-generated method stub
		return new Line(this.getLines()[i]); //CHANGED
	}

	public Line[] getLines() {
		// TODO Auto-generated method stub
		Line[] newlinecoll = new Line[nol];
		
		for(int i = 0; i < this.nol; i++) {
			newlinecoll[i] = new Line(this.linecoll[i]); //CHANGED
		}
		
		return newlinecoll;
	}
	
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		} else if(this.getLines().length != ((LineCollector)obj).getLines().length){
//			System.out.println("this: "+ this.getLines().length);
//			System.out.println("object: " + ((LineCollector)obj).getLines().length);
			return false;
		} else {
//			System.out.println("this: "+ this.getLines().length);
//			System.out.println("object: " + ((LineCollector)obj).getLines().length);
			for(int i = 0; i < this.getLines().length; i++) {
				if(!((this.linecoll[i]).equals(((LineCollector)obj).linecoll[i]))){
					return false;
				}
			}
		}
		
		return true;
	}
}
