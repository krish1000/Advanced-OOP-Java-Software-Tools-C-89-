package Card1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Magic {
	//could try lists?
	static ArrayList<String> col1 = new ArrayList<>(), col2 = new ArrayList<>(), col3 = new ArrayList<>(), 
			newcol1 = new ArrayList<>(), newcol2 = new ArrayList<>(), newcol3 = new ArrayList<>(), ans1 = new ArrayList<>();
	static String deck[] = new String[52]; //deck has the size of 52 cards

	public static void main(String[] args) {
		createdeck(); //creates the deck
		
		Scanner input = new Scanner(System.in); // Create scanner obj
		System.out.println("What is your name?");
		String name = input.nextLine();
		
		boolean stay = true;
		while (stay) {
			System.out.print("\n" + name + ", choose a card in your mind and remember it");
			
			randomizedeck(); // randomizes deck
			// Using 3 arrayLists
			for (int i = 0; i < col1.size(); i++) {
				System.out.format("\n%s\t\t%s\t\t%s", col1.get(i), col2.get(i), col3.get(i));
			}
			System.out.println("\n*********************************************");

			System.out.println("\n\nIt will take me only 3 simple questions to know which card you chose!");
			System.out.println("Hit Enter to start!");
			input.nextLine();

			System.out.println("Question 1: Which column (1, 2, or 3) does your card locate?");
			int num1 = Integer.parseInt(input.nextLine());
			// SWITCHES COLOUMNS, chosen column is moved to mid section
			colswitch1list(num1);
			System.out.println("\n*********************************************");

			System.out.println("Question 2: Which column (1, 2, or 3) does your card locate?");
			int num2 = Integer.parseInt(input.nextLine());
			// SWITCHES NEW COLOUMNS, chosen column is moved to mid section
			colswitch2list(num2);
			System.out.println("\n*********************************************");

			System.out.println("Question 3: Which column (1, 2, or 3) does your card locate?");
			int num3 = Integer.parseInt(input.nextLine());

			System.out.println(name + ", now I know which card you chose!");

			String magic1 = tadamagic(num3);
			System.out.println(name + ", you chose: " + magic1 + " Ez magic");

			System.out.println("\nWould you like to play again? (Y/N)\0");
			String exit = input.nextLine(); //CANNOT USE NEXTLINE AFTER NEXTINT, doesn't work that way

			// Dont forget to clear all
			col1.clear();
			col2.clear();
			col3.clear();
			newcol1.clear();
			newcol2.clear();
			newcol3.clear();
			ans1.clear(); // *Forgot to add this when shown to jackie

			if (exit.equals("Y")) { // tryed == didn't work idk
				System.out.println("Welcome back, " + name + "!");
			} else if (exit.equals("N")) {
				stay = false;
				System.out.println("Bye!");
			}
		}
	}
	/* had to google for this ngl wasn't sure how to randomize while
	 * keeping the remaining positions */ 
	public static void randomizedeck() {
		Random rand = new Random(); //creates random object
		//createdeck();
		for (int i = 0; i < 52; i++) {
			int next1 = i + rand.nextInt(52 - i); //random remaining positions
			
			String temp = deck[next1];
			deck[next1] = deck[i];
			deck[i] = temp;
		}
		//randomizes columns
		for(int i = 0; i <7; i++) {
			col1.add(deck[i]);
		}
		for(int i = 0; i <7; i++) {
			col2.add(deck[i+7]);
		}
		for(int i = 0; i <7; i++) {
			col3.add(deck[i+14]);
		}
	}
	//Makes the deck of 52 cards, 4 suits
	public static void createdeck() {
		String x[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		int countersuit = 0, counterdeck = 0;
		
		char spade = '♠'; char diamond = '♦'; char clover = '♣'; char heart = '♥';
		char addsuit = '\0';
		while (countersuit < 4) {
			if (countersuit == 0) {addsuit = spade; } 
			else if (countersuit == 1) {addsuit = diamond; }
			else if (countersuit == 2) {addsuit = clover; }
			else if (countersuit == 3) {addsuit = heart; }
			//adds the suit to the string and then adds it to the actual deck
			for (int i = 0; i < 13; i++) {
				deck[counterdeck++] = Character.toString(addsuit)+x[i]; 
			}
			countersuit++;
		}
	}
	/*Returns the answer, user chooses column and it returns 4 values down the col*/
	public static String tadamagic(int num) {
		if (num == 1) {
			return ans1.get(0);
		} else if (num == 2) {
			return ans1.get(1);
		}
		return ans1.get(2);
	}
	/*Does the 2nd columnswitch, organizes the column the user choses puts in mid*/
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
	/*Does the first columnswitch, organizes the column the user choses puts in mid*/
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
