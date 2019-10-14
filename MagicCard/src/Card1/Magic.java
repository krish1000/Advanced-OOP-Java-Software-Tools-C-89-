package Card1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Magic {

	// need 21 cards, 7x3
	static ArrayList<String> col1 = new ArrayList<>(Arrays.asList("♠K", "♥6", "♣5", "♥Q", "♠9", "♦8", "♣2"));
	static ArrayList<String> col2 = new ArrayList<>(Arrays.asList("♠2", "♥7", "♣6", "♥J", "♠4", "♦9", "♣3"));
	static ArrayList<String> col3 = new ArrayList<>(Arrays.asList("♠5", "♥10", "♣9", "♥A", "♠Q", "♦J", "♣K"));

//	static String[][] all1 = { { "♠1", "♥6", "♣5", "♥10", "♠9", "♦8", "♣2" },
//			{ "♠2", "♥7", "♣6", "♥J", "♠10", "♦9", "♣3" }, { "♠5", "♥10", "♣9", "♥A", "♠Q", "♦J", "♣K" } };

	static ArrayList<String> newcol1 = new ArrayList<>();
	static ArrayList<String> newcol2 = new ArrayList<>();
	static ArrayList<String> newcol3 = new ArrayList<>();

	static ArrayList<String> ans1 = new ArrayList<>();

	public Magic() {
		// TODO Auto-generated constructor stub

	}

	public static void main(String[] args) {
		// testing unicode
		System.out.println("Testing Unicode for Card Suits: ");
		System.out.print("\u2660, ");// ♠	
		System.out.print("\u2666, ");// ♦
		System.out.print("\u2663, ");// ♣
		System.out.print("\u2665 \n");// ♥
		System.out.println("*****************");

		// int counter = 0;

//		all1 = {"♠1", "♥6", "♣5", "♥10", "♠9", "♦8", "♣2"};

//		// need 21 cards, 7x3
//
//		ArrayList<String> col1 = new ArrayList<>(Arrays.asList("♠1", "♥6", "♣5", "♥10", "♠9", "♦8", "♣2"));
//		ArrayList<String> col2 = new ArrayList<>(Arrays.asList("♠2", "♥7", "♣6", "♥J", "♠10", "♦9", "♣3"));
//		ArrayList<String> col3 = new ArrayList<>(Arrays.asList("♠5", "♥10", "♣9", "♥A", "♠Q", "♦J", "♣K"));

		// Create scanner obj
		Scanner input = new Scanner(System.in);

//		String[] col1 = new String[7];
//		String[] col2 = new String[7];
//		String[] col3 = new String[7];

		System.out.println("What is your name?");
		String name = input.nextLine();

		boolean stay = true;
		while (stay) {
			System.out.print("\n" + name + ", choose a card in your mind and remember it");

			// Using 3 arrayList
			for (int i = 0; i < col1.size(); i++) {
				System.out.format("\n%s\t\t%s\t\t%s", col1.get(i), col2.get(i), col3.get(i));
			}
			System.out.println("\n*********************************************");

			// Using 2D array 3x7
//		for (int i = 0; i < 7; i++) {
//			System.out.format("\n%s\t\t%s\t\t%s", all1[0][i], all1[1][i], all1[2][i]);
//		}

			System.out.println("\n\nIt will take me only 3 simple questions to know which card you chose!");
			System.out.println("Hit Enter to start!");
			input.nextLine();

			System.out.println("Question 1: Which column (1, 2, or 3) does your card locate?");
			int num1 = input.nextInt();
			// SWITCHES COLOUMNS, chosen column is moved to mid section
			colswitch1list(num1);
			System.out.println("\n*********************************************");

			System.out.println("Question 2: Which column (1, 2, or 3) does your card locate?");
			int num2 = input.nextInt();
			// SWITCHES NEW COLOUMNS, chosen column is moved to mid section
			colswitch2list(num2);
			System.out.println("\n*********************************************");

			System.out.println("Question 3: Which column (1, 2, or 3) does your card locate?");
			int num3 = input.nextInt();

			System.out.println(name + ", now I know which card you chose!");
//			System.out.println("Hit enter to prove I am right.");
//			input.nextLine();
			//for some reason i cant do hit enter here ^
			
			String magic1 = tadamagic(num3);
			System.out.println(name + ", you chose: " + magic1);
			System.out.println("Ez Magic");

			System.out.println("Would you like to play again? (Y/N)");
			String exit = input.nextLine();

			if (!exit.equals("Y")) {
				stay = false;
				System.out.println("Bye!");
			}
		}
	}

	public static String tadamagic(int num) {
		if (num == 1) {
			return ans1.get(0);
		} else if (num == 2) {
			return ans1.get(1);
		}

		return ans1.get(2);
	}

	public static void colswitch2list(int num) {
		ArrayList<String> top = newcol1, mid = newcol3, bottom = newcol2;
		if (num == 1) {
			top = newcol2;
			mid = newcol1;
			bottom = newcol3;
		} else if (num == 2) {
			top = newcol3;
			mid = newcol2;
			bottom = newcol1;
		}

		// TOP -------------------------------------
		for (int i = 0; i < 4; i++) {
			System.out.format("\n%s\t\t%s\t\t%s", top.get(i), top.get(++i), top.get(++i));
		}
		System.out.format("\n%s", top.get(6));

		// MIDDLE -----------------------------------
		System.out.format("\t\t%s\t\t%s", mid.get(0), mid.get(1));
		for (int i = 2; i < 4; i++) {
			ans1.add(mid.get(2));
			ans1.add(mid.get(3));
			ans1.add(mid.get(4));
			System.out.format("\n%s\t\t%s\t\t%s", mid.get(i), mid.get(++i), mid.get(++i));
		}
		System.out.format("\n%s\t\t%s", mid.get(5), mid.get(6));

		// BOTTOM ------------------------------------
		System.out.format("\t\t%s", bottom.get(0));
		for (int i = 1; i < 7; i++) {
			System.out.format("\n%s\t\t%s\t\t%s", bottom.get(i), bottom.get(++i), bottom.get(++i));
		}

	}

	/*
	 * static String[][] all1 = { { "♠1", "♥6", "♣5", "♥10", "♠9", "♦8", "♣2" }, {
	 * "♠2", "♥7", "♣6", "♥J", "♠10", "♦9", "♣3" }, { "♠5", "♥10", "♣9", "♥A", "♠Q",
	 * "♦J", "♣K" } };
	 */

//	public static void col2DArray(int num) {
//		num--;
//		if (num == 0) {
//			// print 2 then print 1 then print 3
//			
//			for (int i = 0; i < 4; i++) {
//				System.out.format("\n%s\t\t%s\t\t%s", all1[num][i], all1[num][++i], all1[num][++i]);
//			}
//
//		}
//	}

	public static void colswitch1list(int num) {
		// TOP
		ArrayList<String> top = col1, mid = col3, bottom = col2;
		if (num == 1) {
			top = col2;
			mid = col1;
			bottom = col3;
		} else if (num == 2) {
			top = col3;
			mid = col2;
			bottom = col1;
		}

		// TOP -------------------------------------
		int x = 0;
		for (int i = 0; i < 4; i++) {
			x = i;
			newcol1.add(top.get(x));
			newcol2.add(top.get(++x));
			newcol3.add(top.get(++x));

			System.out.format("\n%s\t\t%s\t\t%s", top.get(i), top.get(++i), top.get(++i));
		}
		System.out.format("\n%s", top.get(6));
		newcol1.add(top.get(6));

		// MIDDLE -----------------------------------
		System.out.format("\t\t%s\t\t%s", mid.get(0), mid.get(1));
		newcol2.add(mid.get(0));
		newcol3.add(mid.get(1));
		for (int i = 2; i < 4; i++) {
			x = i;
			newcol1.add(mid.get(x));
			newcol2.add(mid.get(++x));
			newcol3.add(mid.get(++x));

			System.out.format("\n%s\t\t%s\t\t%s", mid.get(i), mid.get(++i), mid.get(++i));
		}
		System.out.format("\n%s\t\t%s", mid.get(5), mid.get(6));
		newcol1.add(mid.get(5));
		newcol2.add(mid.get(6));

		// BOTTOM ------------------------------------
		System.out.format("\t\t%s", bottom.get(0));
		newcol3.add(bottom.get(0));
		for (int i = 1; i < 7; i++) {
			x = i;
			newcol1.add(bottom.get(x));
			newcol2.add(bottom.get(++x));
			newcol3.add(bottom.get(++x));

			System.out.format("\n%s\t\t%s\t\t%s", bottom.get(i), bottom.get(++i), bottom.get(++i));
		}
	}
}
