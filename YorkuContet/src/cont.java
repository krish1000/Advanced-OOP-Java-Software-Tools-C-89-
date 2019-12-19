import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class cont {

	public cont() {
		// ArrayList<> adsf = new ArrayList<>();
	}

//	public static void main(String args[]) throws Exception {
//		/*
//		 * Sample code to perform I/O: Use either of these methods for input
//		 * 
//		 * //BufferedReader BufferedReader br = new BufferedReader(new
//		 * InputStreamReader(System.in)); String name = br.readLine(); // Reading input
//		 * from STDIN System.out.println("Hi, " + name + "."); // Writing output to
//		 * STDOUT
//		 * 
//		 * //Scanner Scanner s = new Scanner(System.in); String name = s.nextLine(); //
//		 * Reading input from STDIN System.out.println("Hi, " + name + "."); // Writing
//		 * output to STDOUT
//		 * 
//		 */
//
//		// Write your code here
//
//		Scanner s = new Scanner(System.in);
//
//		// 4, 9, 10, 6, 1, 4, 2, 3
//		String value = s.nextLine();
//
		List<String> asdf = Arrays.asList((value.split(", ")));

		ArrayList<Integer> converted = new ArrayList<Integer>();
//	        
		for (int i = 0; i < asdf.size(); i++) {
			converted.add(Integer.parseInt(asdf.get(i)));
		}
		if (converted.size() == 0) {
			System.out.println("0");
		} else if (converted.size() == 1) {
			System.out.println("1");
		} else {

	        
	        int mheight = 0;
	        int absheight = 0;
	        
	        int prev = 0;
	        
	        int higherval = 0;
	        
//	        for(int i = 0; i < converted.size(); i++) {
//	        System.out.println(converted.get(i));
//	        }
	        for(int i = 0; i < converted.size(); i++) {
	        	prev = converted.get(i);	
	        	
	        	for(int j = 0; j < converted.size(); j++) {
	        		if(prev > converted.get(j)) {
	        			
	        			for(int k = j; k < converted.size(); k++) {
	        				if(prev > converted.get(k) && converted.get(j) < converted.get(k)) {
	        					
	        				}
	        				
	        			}
	        			
	        			
	        			//System.out.println(prev + "   " + converted.get(j));
	        			prev = converted.get(j);
	        			mheight++;
	        		}
	        		if(j+1 >= converted.size()) {
	        			if(mheight > absheight) {
	        				absheight = mheight;
	        			}
	        		}
	        		
	        	}
	        	mheight = 0;
	        	
	        }
	        
	        System.out.println(absheight);

//			int tempma = 0;
//			int current = 0;
//			int abolutema = 0;
//			int abolutecur = 0;
//			for (int i = 0; i < converted.size(); i++) {
//				current = converted.get(i);
//				for (int j = i+1; j < converted.size(); j++) {
//					if (current > converted.get(j)) {
//						tempma++;
//					}
//				}
//				if (tempma > abolutema) {
//					abolutema = tempma;
//					abolutecur = i;
//				}
//				tempma = 0;
//			}
//
//			int ma;
//			int curr1 = 0;
//			for (int i = abolutecur + 1; i < converted.size(); i++) {
//				curr1 = converted.get(i);
//				for(int j = 0; j < converted.size(); j++) {
//					
//				}
//				
//				
//			}
//
//			System.out.println(abolutecur);
//		}
//	}
//	
	public static void main(String args[]) throws Exception {
		/*
		 * Sample code to perform I/O: Use either of these methods for input
		 * 
		 * //BufferedReader BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String name = br.readLine(); // Reading input
		 * from STDIN System.out.println("Hi, " + name + "."); // Writing output to
		 * STDOUT
		 * 
		 * //Scanner
		 */

		// Write your code here

		Scanner s = new Scanner(System.in);
		int length3 = Integer.parseInt(s.nextLine()); // Reading input from STDIN

		// System.out.println(length3);
		int zzz = 0;
		ArrayList<String> zhape = new ArrayList<String>();
		ArrayList<Integer> length1 = new ArrayList<Integer>();
		while (zzz < length3) {
			String temp = s.nextLine();
			// String[] part = temp.split("(?<=\\D)(?=\\d)");
			String[] part = temp.split(" ");
			zhape.add(part[0]);
			length1.add(Integer.parseInt(part[1]));

			// System.out.println("ssssss");
			zzz++;
		}

		for (int oooo = 0; oooo < zhape.size(); oooo++) {
			// System.out.println(zhape.get(oooo) + ";;" + length1.get(0) + ";;");
			if (zhape.get(oooo).equals("diamond")) { //
				// System.out.println(zhape.get(oooo) + ";;" + length1.get(0) + ";;");
				int size1 = length1.get(oooo);
				int size1lower = size1 - 1;
				for (int i = 0; i < size1 - 1; i++) {
					for (int j = 0; j < size1lower; j++)
						System.out.print(" ");

					for (int j = 0; j <= i; j++)
						System.out.print("* ");

					System.out.print("\n");
					size1lower--;
				}

				size1lower = 0;

				for (int i = size1; i > 0; i--) {

					for (int j = 0; j < size1lower; j++) {
						System.out.print(" ");
					}

					for (int j = 0; j < i; j++) {
						System.out.print("* ");

					}
					System.out.print("\n");
					size1lower++;
				}
			} else if (zhape.get(oooo).equals("triangle")) {
				int size1 = length1.get(oooo);
				int size1lower = size1 - 1;
				for (int i = 0; i < size1; i++) {
					for (int j = 0; j < size1lower; j++) {
						System.out.print(" ");
					}
					for (int k = 0; k <= i; k++) {
						System.out.print("* ");
					}
					System.out.print("\n");
					size1lower--;
				}

			} else if (zhape.get(oooo).equals("hexagon")) {
				int size1 = length1.get(oooo);
				boolean even = false;
				if (size1 == 1) {
					System.out.print("* ");
					System.out.println("");
				} else if (size1 == 2) {
					System.out.print(" * * ");
					System.out.println("");
				} else {
					int uppersize = size1 / 2;
					if (size1 % 2 == 0) {
						even = true;
					}

					////////////////////////////////////////////////
					int size1lower = size1 - 1;

					if (!even) {
						for (int i = uppersize; i < size1 - 1; i++) {
							for (int j = uppersize; j < size1lower; j++)
								System.out.print(" ");

							for (int j = 0; j <= i; j++)
								System.out.print("* ");

							System.out.print("\n");
							size1lower--;
						}

						size1lower = 0;

						for (int i = size1; i > uppersize; i--) {

							for (int j = 0; j < size1lower; j++) {
								System.out.print(" ");
							}

							for (int j = 0; j < i; j++) {
								System.out.print("* ");

							}
							System.out.print("\n");
							size1lower++;
						}
					} else {
						for (int i = uppersize; i < size1 - 1; i++) {
							for (int j = uppersize; j < size1lower+1; j++)
								System.out.print(" ");

							for (int j = 0; j <= i; j++)
								System.out.print("* ");

							System.out.print("\n");
							size1lower--;
						}

						size1lower = 0;

						for (int i = size1; i > uppersize; i--) {

							for (int j = 0; j < size1lower+1; j++) {
								System.out.print(" ");
							}

							for (int j = 0; j < i; j++) {
								System.out.print("* ");

							}
							System.out.print("\n");
							size1lower++;
						}
					}

					// System.out.println(uppersize);
				}
			}
			System.out.println(""); // to make empty line or watever between

		}
	}

}
